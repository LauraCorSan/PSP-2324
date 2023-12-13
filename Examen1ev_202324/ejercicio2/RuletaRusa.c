
#include <sys/types.h>
#include <stdlib.h> //Para poder poner EXIT_FAILURE
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h> //Para incluir wait(NULL)
#include <signal.h>
#include <math.h>
#include <stdbool.h>

#define READ 0
#define WRITE 1

#define N_PROCESOS 10
#define NUMERO_PARAMETROS 2 // 1 argumentos +1 del nombre

int contEliminaciones = 0;

void manejadorSeñal(int signo)
{
    if (signo == SIGUSR1)
    {
        if (contEliminaciones <= 0)
        {
            printf("Soy el hijo %d. He sido eliminado.\n", getpid());
            contEliminaciones++;
        }
        else
        {
            printf("Soy el hijo %d. He vuelto a ser eliminado.\n", getpid());
            contEliminaciones++;
        }
    }
}

void manejadorSeñalFin(int signo)
{
    if (signo == SIGINT)
    {
        if (contEliminaciones <= 0)
        {
            printf("Soy el hijo %d. Nunca fui eliminado :D.\n", getpid());
        }
        else
        {
            printf("Soy el hijo %d. He sido eliminado x_x .\n", getpid());
        }
        // Terminar proceso hijo si o si cuando el padre envia SIGINT
        exit(EXIT_SUCCESS);
    }
}

int main(int argc, char *argv[])
{
    if (argc != NUMERO_PARAMETROS)
    {
        printf("Uso: %s <argumentos insufcientes >\n", argv[0]);
        return 1;
    }

    int cant_señales = atoi(argv[1]);

    if (cant_señales <= 0 || cant_señales > N_PROCESOS)
    {
        printf("La cantidad de señales a mandar debe ser mayor  que 1 y menos que %d.\n", N_PROCESOS);
        return 1;
    }

    pid_t arrayMisHijos[N_PROCESOS];

    // Crear procesos hijos
    for (int indiceHijo = 0; indiceHijo < N_PROCESOS; indiceHijo++)
    {
        arrayMisHijos[indiceHijo] = fork();

        // Verificar si soy el proceso hijo
        if (arrayMisHijos[indiceHijo] == 0)
        {
            // Soy un proceso hijo
            signal(SIGUSR1, manejadorSeñal);
            signal(SIGINT, manejadorSeñalFin);

            while (1)
            {
                sleep(1);
            }
            // Terminar proceso hijo
            exit(EXIT_SUCCESS);
        }
    }

    for (int i = 0; i < cant_señales; i++)
    {
        int indiceHijoAleatorio = rand() % N_PROCESOS; // Números aleatorios de 0 a el numero de procesos que tenga
        kill(arrayMisHijos[indiceHijoAleatorio], SIGUSR1);
    }

    for (int i = 0; i < N_PROCESOS; i++)
    {
        // printf("Soy padre: envio señal a mi hijo %d\n", arrayMisHijos[i]);
        kill(arrayMisHijos[i], SIGINT);
    }

    // Padre educado espera a que todos sus hijos terminen
    for (int i = 0; i < N_PROCESOS; i++)
    {
        wait(NULL);
    }

    return 0;
}