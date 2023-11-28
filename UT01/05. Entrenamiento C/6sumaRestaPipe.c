/*6. Crea un programa que cree un hijo y le mande a través de un pipe un carácter y dos números.
El carácter representa una operación matemática: suma o resta. El proceso hijo devolverá en su estado
el resultado de la operación.*/

// DATAZA: int comoEntero = caracter - '0';

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

#define READ 0
#define WRITE 1

int main()
{
    // Crear el pipe
    int pipe_fd[2];
    if (pipe(pipe_fd) == -1)
    {
        perror("Error al crear el pipe");
        exit(EXIT_FAILURE);
    }

    // Crear el proceso hijo
    pid_t pid_hijo = fork();

    if (pid_hijo == -1)
    {
        perror("Error al crear el proceso hijo");
        exit(EXIT_FAILURE);
    }

    if (pid_hijo == 0)
    {
        // Soy hijo
        close(pipe_fd[WRITE]); // Cerrar escritura porque el hijo solo va leer los dos numeros y el char

        // Leer datos del pipe
        char operacion;
        int num1, num2, resultado;

        read(pipe_fd[READ], &operacion, sizeof(char));
        read(pipe_fd[READ], &num1, sizeof(int));
        read(pipe_fd[READ], &num2, sizeof(int));

        // Realizar la operación matemática
        if (operacion == '+')
        {
            resultado = num1 + num2;
        }
        else if (operacion == '-')
        {
            resultado = num1 - num2;
        }
        else
        {
            fprintf(stderr, "Operación no válida\n");
            exit(EXIT_FAILURE);
        }

        // Cerrar el extremo de lectura del pipe en el proceso hijo
        close(pipe_fd[READ]);

        // Dejar el resultado en su propio estado al padre
        exit(resultado);
    }
    else
    {
        // Soy padre
        close(pipe_fd[READ]); // Cerrar el extremo de lectura del pipe en el proceso padre

        // Enviar datos al proceso hijo
        char operacion = '+';
        int num1 = 10, num2 = 5;

        write(pipe_fd[WRITE], &operacion, sizeof(char));
        write(pipe_fd[WRITE], &num1, sizeof(int));
        write(pipe_fd[WRITE], &num2, sizeof(int));

        int statusResultado;
        // Esperar al proceso hijo y coger su estado(resultado de la operacion) desde direccion de memoria
        wait(&statusResultado);

        // Mostrar el resultado
        printf("Resultado: %d\n", WEXITSTATUS(statusResultado));

        // Cerrar el extremo de escritura del pipe en el proceso padre
        close(pipe_fd[WRITE]);

        exit(EXIT_SUCCESS);
    }

    return 0;
}
