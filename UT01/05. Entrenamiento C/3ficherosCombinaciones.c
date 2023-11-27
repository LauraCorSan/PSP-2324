/*3. Crea un programa que reciba por parámetro un número entero positivo n. Este número indicará el número de hijos.
Cada hijo generará un fichero con la posibles combinación de caracteres de esa longitud. El hijo 1 una letra,
el hijo 2 dos letras 'aa' a la 'zz', etc. Los nombres serán datos1.txt, datos2.txt, etc.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// TO DO: ESTA MAL, NO HACE LO QUE DEBE. CREO QUE DEBE SER LA CONDICION DEL WHILE O ALGO ASI YA QUE IMPRIME:
// Datos1: bien de la a a la z, unico caracter
// datos2: mal solo una linea "aa"
// datos3: mal solo una linea "aaa"

#define A_MINUS 97  // esto es a minuscula empezamos ahi
#define Z_MINUS 122 // esto es z minuscula terminamos ahi
#define LONG_ALPHABET 26

void generateCombinations(int length, FILE *file)
{
    char combination[length + 1]; // +1 para el carácter nulo al final de la cadena

    for (int i = 0; i < length; i++)
    {
        combination[i] = 'a'; // Inicializar con 'a'
    }
    combination[length] = '\0'; // Añadir el carácter nulo al final

    do
    {
        fprintf(file, "%s\n", combination); // Escribir la combinación en el archivo
        int carry = 1;

        // Incrementar la combinación
        for (int i = length - 1; i >= 0; i--)
        {
            combination[i] += carry;
            carry = (combination[i] > 'z');

            if (carry)
            {
                combination[i] = 'a';
            }
            else
            {
                break;
            }
        }

    } while (combination[0] != 'a'); // Detenerse cuando se alcance 'z' en la primera posición
}

int main(int argc, char *argv[])
{
    if (argc != 2)
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

    for (int i = 1; i <= num_hijos; i++)
    {
        char filename[20];
        snprintf(filename, sizeof(filename), "datos%d.txt", i);

        FILE *file = fopen(filename, "w");
        if (file == NULL)
        {
            perror("Error al abrir el archivo");
            return 1;
        }

        generateCombinations(i, file);

        fclose(file);
    }

    printf("Se han generado los archivos con las combinaciones.\n");

    return 0;
}
