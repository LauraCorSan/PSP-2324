/*Contar vocales
Escribe un programa en C que le pida al usuario ingresar una cadena de caracteres y luego 
cuente y muestre en pantalla el número de vocales (mayúsculas y minúsculas) presentes en la 
cadena. El programa debe ser sensible a mayúsculas y minúsculas.*/

#include <stdio.h>
#include <string.h>
#define BUFFER 1024 //esto es definir una constante

int main() {
    char cadena[BUFFER];
    int contVocales=0;
    printf("Introduce una frase\n");
    fgets(cadena, sizeof(cadena),stdin);
    for(int i=0;i<strlen(cadena);i++){
        switch (cadena[i]){
            case'a': case'A': 
            case'e': case'E':
            case'i': case'I':
            case'o': case'O':
            case'u': case'U':
                contVocales++;
                break;
            default:
                break;
        }
    }
    printf("La frase \"%s\" tiene %d vocales ",cadena,contVocales);

    return 0;
}