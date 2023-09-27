/*Palindromo
Crea un programa en C que determine si una palabra o frase ingresada por el usuario es 
n palíndromo o no. Un palíndromo es una palabra o frase que se lee igual de izquierda a 
derecha y de derecha a izquierda, ignorando espacios y signos de puntuación. El programa 
debe eliminar los espacios y considerar solo las letras en la verificación.*/

#include <stdio.h>
#include <string.h>
#define BUFFER 1024 //esto es definir una constante

int main() {
    char cadena[BUFFER];
    int contVocales=0;
    printf("Introduce una frase\n");
    fgets(cadena, sizeof(cadena),stdin);
    for(int i=0;i<strlen(cadena);i++){
        
    }
    printf("La frase \"%s\" tiene %d vocales ",cadena,contVocales);

    return 0;
}