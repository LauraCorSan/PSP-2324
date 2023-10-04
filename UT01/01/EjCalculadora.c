/*Crea un programa que permita hacer lo siguiente: primer parámetro operación suma, resta, multiplicación o división. 
Si es división el segundo operador no puede ser 0.
Ten en cuenta que necesita al menos 3 parámetros, de lo contrario deberá aparecer un mensaje de error.*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define ARG_SUFICIENTES 3

int main(int argc, char *argv[]){
    int resultado=0;

     if (argc < ARG_SUFICIENTES+1) {  //el +1 para incluir el nombre del proceso
        printf("No se han introducido parametros suficientes");
        return 1;

    } else if (argc > ARG_SUFICIENTES+1) {  
        printf("Se han introducido demasiados parametros");
        return 1;

    }else{
        if (strcmp(argv[1], "suma") == 0) {//strcmp compara un array de char (string) 
            resultado = atoi(argv[2]) + atoi(argv[3]);//atoi convierte array char (string) en int
            printf("%d\n",resultado);

        } else if (strcmp(argv[1], "resta") == 0) {
            resultado = atoi(argv[2]) - atoi(argv[3]);
            printf("%d\n",resultado);

        } else if (strcmp(argv[1], "multiplicacion") == 0) {
            resultado = atoi(argv[2]) * atoi(argv[3]);
            printf("%d\n",resultado);
            
        } else if (strcmp(argv[1], "division")==0){
            if(atoi(argv[3])==0){
                printf("No se puede dividir entre cero\n");
            }else{
                resultado = atoi(argv[2]) / atoi(argv[3]);
                printf("%d\n",resultado);
            }

        }else{
            printf("Operación no válida\n");
            return 1;
        }
    }

    return 0;

}