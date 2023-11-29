/*Crea un programa que reciba por parámetro dos números grandes. El programa creará dos procesos hijos.
Cada hijo gestionará un número primo y verificará si es primo o no. Cada hijo al finalizar indica en su estado si
el número era primo o no y el proceso padre al recoger el estado del hijo cuenta si era primo o no, el padre
escribe el total de números primos.*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#include <sys/wait.h>
#include <stdbool.h>

#define N_PROCESOS 2

bool esPrimo(int numero)
{
    // Si el número es menor o igual a 1, no es primo
    if (numero <= 1)
    {
        return false;
    }

    // Verificar si el número es divisible por algún otro número diferente de 1 y él mismo
    for (int i = 2; i <= numero / 2; i++)
    {
        if (numero % i == 0)
        {
            return false; // El número no es primo
        }
    }
    return true; // El número es primo
}

int main(int argc, char *argv[])
{
    if (argc < 3)
    {
        fprintf(stderr, "ERROR. Introduce: %s num1 num2\n", argv[0]);
        return 1;
    }

    long num1 = atol(argv[1]);
    long num2 = atol(argv[2]);

    int contadorPrimos = 0;

    for (int i = 0; i < N_PROCESOS; i++)
    {
        pid_t hijo = fork();

        if (hijo < 0)
        {
            perror("Error al crear el proceso hijo");
            return 1;
        }

        if (hijo == 0)
        {
            // Código del hijo
            // i es el iterador del for
            // si i==0 true-> el hijo1, asi que usa num1 (mete num1 en num)
            // si i==0 false-> el hijo2, asi que usa num2 (mete num2 en num)
            int num = (i == 0) ? num1 : num2;
            if (esPrimo(num))
            {
                exit(true);
            }
            else
            {
                exit(false);
            }
        }
    }

    for (int i = 0; i < N_PROCESOS; i++)
    {
        // Soy padre
        int status;
        wait(&status);

        if (WIFEXITED(status) && WEXITSTATUS(status) == true)
        {
            contadorPrimos++;
        }
    }

    printf("Total de números primos: %d\n", contadorPrimos);

    return 0;
}