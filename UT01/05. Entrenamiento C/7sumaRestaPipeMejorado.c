/*Modifica el anterior programa para que el hijo devuelva el resultado a través de un pipe.
NOTA: debes crear dos pipes.*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

#define READ 0
#define WRITE 1

int main()
{
    // Crear el pipe
    int pipePadreHijo[2], pipeHijoPadre[2];

    if (pipe(pipePadreHijo) == -1)
    {
        perror("Error al crear el pipe");
        exit(EXIT_FAILURE);
    }

    if (pipe(pipeHijoPadre) == -1)
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

        // CIERRO LOS QUE NO USO
        //  Cierro escritura en el pipe en el que escribe el padre
        close(pipePadreHijo[WRITE]);
        // Cierro lectura en el pipe en el que lee el padre
        close(pipeHijoPadre[READ]);

        // Leer datos del pipe
        char operacion;
        int num1, num2, resultado;

        read(pipePadreHijo[READ], &operacion, sizeof(char));
        read(pipePadreHijo[READ], &num1, sizeof(int));
        read(pipePadreHijo[READ], &num2, sizeof(int));

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

        write(pipeHijoPadre[WRITE], &resultado, sizeof(int));

        // Cerrar el extremo de lectura del pipe en el proceso hijo
        close(pipePadreHijo[READ]);
        close(pipeHijoPadre[WRITE]);

        exit(EXIT_SUCCESS);
    }
    else
    {                               // Código del proceso padre
        close(pipePadreHijo[READ]); // Cerrar el extremo de lectura del pipe en el proceso padre
        close(pipeHijoPadre[WRITE]);

        // Enviar datos al proceso hijo
        char operacion = '-';
        int num1 = 20, num2 = 16;

        write(pipePadreHijo[WRITE], &operacion, sizeof(char));
        write(pipePadreHijo[WRITE], &num1, sizeof(int));
        write(pipePadreHijo[WRITE], &num2, sizeof(int));

        // Leer lo que escrbio el hijo (resultado de la operacion)
        int resultado;
        read(pipeHijoPadre[READ], &resultado, sizeof(int));

        // Mostrar el resultado
        printf("Resultado: %d\n", resultado);

        // Cerrar el extremo de escritura del pipe en el proceso padre
        close(pipePadreHijo[WRITE]);
        close(pipeHijoPadre[READ]);

        exit(EXIT_SUCCESS);
    }

    return 0;
}
