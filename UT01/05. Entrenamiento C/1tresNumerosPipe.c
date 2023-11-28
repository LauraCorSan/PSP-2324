/*1. Crea un proceso que cree un proceso hijo, el envíe 3 números enteros aleatorios a través de un pipe.
El proceso hijo los ordenará y los escribirá en el fichero salida.txt.*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define CANT_NUMEROS 3
#define READ 0
#define WRITE 1

int main()
{
    // te creas array de dos posiciones de enteros
    int pipe_fd[2];

    // Crear la tubería
    if (pipe(pipe_fd) == -1)
    { // llamada a sistema
        perror("Error al crear la tubería");
        exit(EXIT_FAILURE);
    }

    // Crear el proceso hijo
    pid_t id_hijo = fork();

    /*if (id_hijo == -1) {
        perror("Error al crear el proceso hijo");
        exit(EXIT_FAILURE);
    }comprobacion de errores*/

    if (id_hijo == 0)
    {                          // soy hijo
        close(pipe_fd[WRITE]); // Cerrar el extremo de escritura de la tubería en el proceso hijo (1)

        // Leer los números desde la tubería
        int numeros[CANT_NUMEROS];
        read(pipe_fd[READ], numeros, sizeof(numeros));
        close(pipe_fd[READ]); // Cerrar lectura del pipe del hijo al terminar

        // Ordenar los números
        for (int i = 0; i < CANT_NUMEROS; i++)
        {
            for (int j = 0; j < CANT_NUMEROS - i - 1; j++)
            {
                if (numeros[j] > numeros[j + 1])
                {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Escribir los números ordenados en el archivo salida.txt

        // int miFicherito = open("salida.txt",0);

        FILE *miFichero = fopen("salida.txt", "a"); // a = escribe, crea y append
        if (miFichero == NULL)
        {
            perror("Error al abrir el archivo salida.txt");
            exit(EXIT_FAILURE);
        }

        for (int i = 0; i < CANT_NUMEROS; i++)
        {
            fprintf(miFichero, "%d, ", numeros[i]);
            if (i == CANT_NUMEROS - 1)
            {
                fprintf(miFichero, "\n");
            }
        }

        // write(miFicherito, numeros, sizeof(numeros));
        fclose(miFichero);

        exit(EXIT_SUCCESS);
    }
    else
    { // soy padre

        close(pipe_fd[READ]); // Cerrar el extremo de lectura de la tubería en el proceso padre

        srand(time(NULL)); // esto es para que sea otra semilla y asi los numeros cambien en cada ejecucion
        // Generar 3 números aleatorios
        int random_numbers[CANT_NUMEROS];
        for (int i = 0; i < 3; i++)
        {
            random_numbers[i] = rand() % 100; // Números aleatorios entre 0 y 99
        }

        // Escribir los números en la tubería
        write(pipe_fd[WRITE], random_numbers, sizeof(random_numbers));
        close(pipe_fd[WRITE]); // Cerrar el extremo de escritura de la tubería en el proceso padre

        // Esperar a que el proceso hijo termine
        wait(NULL);
    }

    return 0;
}
