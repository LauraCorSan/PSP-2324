/*Palindromo
Crea un programa en C que determine si una palabra o frase ingresada por el usuario es 
n palíndromo o no. Un palíndromo es una palabra o frase que se lee igual de izquierda a 
derecha y de derecha a izquierda, ignorando espacios y signos de puntuación. El programa 
debe eliminar los espacios y considerar solo las letras en la verificación.*/

#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#define BUFFER 1024 //esto es definir una constante

int main() {
    char cadena[BUFFER];
    bool esPalindromo=false;
    
    printf("Introduce una frase\n");
    //scanf(" %[^\n]",cadena);
    fgets(cadena, sizeof(cadena),stdin);//aqui con el fgets coge el intro del final**
    int longitud=strlen(cadena);

    for(int i=0; i<longitud ;i++){
        cadena[i]=tolower(cadena[i]);
    }

//**aqui eliminamos esa \n de la frase restandole a longitud
    if(cadena[longitud-1]=='\n'){
        //cadena[longitud-1]='\0'; 
        //no es necesario, pero el \0 lo pone cuando se ha acabado la frase
        longitud--;
    } 

    for(int i=0; i<longitud; i++){
        if(cadena[i]!=cadena[longitud-1-i]){//aqui se resta 1 porque los array empiezan en 0 recuerdalo
            esPalindromo=false;
        }else{
            esPalindromo=true;
        }
    }

    if(esPalindromo){
        printf("La frase \"%s\" es palindromo\n",cadena);
    }else{
        printf("La frase \"%s\" NO es palindromo\n",cadena);
    }

    return 0;
}