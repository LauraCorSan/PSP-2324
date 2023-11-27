/*2. Crea un proceso que cree dos procesos hijos, luego generará N (20) números aleatorios. Enviará los pares al
primer hijo, los impares al segundo. Los hijos escribirán por pantalla "Soy el hijo 1|2, he recibido ". Por cada
número que mande el padre.*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define CANT_NUMEROS 20

#define READ 0
#define WRITE 1

int main()
{
    // te creas array de dos posiciones de enteros
    int pipe_fd1[2], pipe_fd2[2];

    // Crear la tubería
    if (pipe(pipe_fd1) == -1)
    { // llamada a sistema
        perror("Error al crear la primera tubería ");
        exit(EXIT_FAILURE);
    }

    if (pipe(pipe_fd2) == -1)
    { // llamada a sistema
        perror("Error al crear la segunda tubería");
        exit(EXIT_FAILURE);
    }

    // Crear el proceso hijo
    pid_t id_hijo1 = fork();
    pid_t id_hijo2 = fork();

    if (id_hijo1 == -1)
    {
        perror("Error al crear el primer hijo");
        exit(EXIT_FAILURE);
    }

    if (id_hijo2 == -1)
    {
        perror("Error al crear el segundo hijo");
        exit(EXIT_FAILURE);
    }

    // CODIGO HIJOS Y PADRE --------------------------------------------------------------------------

    if (id_hijo1 == 0)
    {                           // soy primer hijo
        close(pipe_fd1[WRITE]); // Cerrar el extremo de escritura del proceso hijo1

        // Cerramos por completo el pipe que no estamos usando en este hijo
        close(pipe_fd2[WRITE]);
        close(pipe_fd2[READ]);

        // Leer los números desde la tubería, uno a uno e imprimir inmediatamente
        int numeroPar;
        while (read(pipe_fd1[READ], &numeroPar, sizeof(numeroPar)) > 0)
        { // mientras pueda seguir leyendo
            printf("Soy el hijo 1, he recibido: %d\n", numeroPar);
        }

        exit(EXIT_SUCCESS);
    }
    else if (id_hijo2 == 0)
    { // soy el segundo hijo

        close(pipe_fd2[WRITE]); // Cerrar el extremo de escritura del proceso hijo2

        // Cerramos por completo el pipe que no estamos usando en este hijo
        close(pipe_fd1[READ]);
        close(pipe_fd1[WRITE]);

        int numeroImpar;
        while (read(pipe_fd2[READ], &numeroImpar, sizeof(numeroImpar)) > 0)
        { // mientras pueda seguir leyendo
            printf("Soy el hijo 2, he recibido: %d\n", numeroImpar);
        }

        exit(EXIT_SUCCESS);
    }
    else
    { // soy padre

        // Cerrar los extremos de lectura de la tubería en el proceso padre, en ambos hijos
        close(pipe_fd1[READ]);
        close(pipe_fd2[READ]);

        srand(time(NULL)); // esto es para que sea otra semilla y asi los numeros cambien en cada ejecucion
        int random_numbers[CANT_NUMEROS];

        for (int i = 0; i < CANT_NUMEROS; i++)
        {
            random_numbers[i] = rand() % 100; // Números aleatorios entre 0 y 99
            if (random_numbers[i] % 2 == 0)
            {
                // enviamos los pares al hijo 1
                write(pipe_fd1[WRITE], &random_numbers[i], sizeof(int));
            }
            else
            {
                // enviamos los impares al hijo 2
                write(pipe_fd2[WRITE], &random_numbers[i], sizeof(int));
            }
        }
        // Cerrar las tuberias al fin
        close(pipe_fd1[WRITE]);
        close(pipe_fd2[WRITE]);

        // Esperar a que el proceso hijo termine
        wait(NULL);
        wait(NULL);
    }

    return 0;
}
