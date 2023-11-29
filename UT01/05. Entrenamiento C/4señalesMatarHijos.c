/*4. Crea un programa que reciba un número n por parámetro. El programa creará n hijos y les enviará
una señal a cada uno de ellos para matarlos.*/

#include <sys/types.h>
#include <stdlib.h> //Para poder poner EXIT_FAILURE
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h> //Para incluir wait(NULL)
#include <signal.h>   //Para trabajar con señales

#define SEGS 1
#define NUMERO_PARAMETROS 2 // 1+1 del nombre
#define MAX_PROCESOS 50

void manejadorSeñal(int signo)
{
    printf("Proceso %d eliminado.\n", getpid());
    exit(0);
}

int main(int argc, char *argv[])
{
    if (argc != NUMERO_PARAMETROS)
    {
        printf("Uso: %s <numero_hijos>\n", argv[0]);
        return 1;
    }

    int num_hijos = atoi(argv[1]);

    if (num_hijos <= 0)
    {
        printf("El número de hijos debe ser un entero positivo.\n");
        return 1;
    }

    pid_t id_hijo;
    pid_t arrayHijos[num_hijos];

    for (int i = 0; i < num_hijos; i++)
    {
        id_hijo = fork();
        arrayHijos[i] = id_hijo;

        if (id_hijo == 0)
        { // soy hijo
            printf("Soy el hijo con id: %d\n", getpid());

            printf("Voy a lo mio en lo que mis hermanos se crean y espero a morir :(\n");
            signal(SIGUSR1, manejadorSeñal); // simplemente registramos el manejador de señales

            // pause();
            while (1)
            {
                sleep(SEGS); // El proceso hijo espera y no hace nada.
                // Esto es para que no muera y espere a recibir la señal
            }
        }
    }

    // sleep(3); en caso de signint ya que interrumpe y no les deja ni crear su manejador,
    // asi el padre espera un poco pa seguir ejecutandose

    if (id_hijo != 0)
    { // soy padre
        for (int i = 0; i < num_hijos; i++)
        { // enviamos la señal a todos los hijos
            printf("Soy padre: envio señal a mi hijo %d\n", arrayHijos[i]);
            kill(arrayHijos[i], SIGUSR1);
        }

        for (int i = 0; i < num_hijos; i++)
        { // esperamos a que todos los hijos terminen
            wait(NULL);
        }
    }
    return 0;
}