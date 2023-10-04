/*Crea un programa que permita hacer lo siguiente: primer parámetro operación suma, resta, multiplicación o división. 
Si es división el segundo operador no puede ser 0.
Ten en cuenta que necesita al menos 3 parámetros, de lo contrario deberá aparecer un mensaje de error.*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define ARG_SUFICIENTES 3

int main(int argc, char *argv[]){
    /*podrias poner un puntero que apunte a la direccion de argv[1],agrv[2] y argv[3] en lugar de argv[1] 
    sin variable para que sea mas claro*/
    const char *operacion = argv[1];
    const char *num1 = argv[2];
    const char *num2 = argv[3];

    int resultado=0;

     if (argc < ARG_SUFICIENTES+1) {  //el +1 para incluir el nombre del proceso
        printf("No se han introducido parametros suficientes");
        return 1;

    } else if (argc > ARG_SUFICIENTES+1) {  
        printf("Se han introducido demasiados parametros");
        return 1;

    }else{
        if (strcmp(operacion, "suma") == 0) {//strcmp compara un array de char (string) 
            resultado = atoi(num1) + atoi(num2);//atoi convierte array char (string) en int
            printf("%d\n",resultado);

        } else if (strcmp(operacion, "resta") == 0) {
            resultado = atoi(num1) - atoi(num2);
            printf("%d\n",resultado);

        } else if (strcmp(operacion, "multiplicacion") == 0) {
            resultado = atoi(num1) * atoi(num2);
            printf("%d\n",resultado);
            
        } else if (strcmp(operacion, "division")==0){
            if(atoi(num2)==0){
                printf("No se puede dividir entre cero\n");
            }else{
                resultado = atoi(num1) / atoi(num2);
                printf("%d\n",resultado);
            }

        }else{
            printf("Operación no válida\n");
            return 1;
        }
    }

    return 0;

}