/*Cálculo de Factorial

Enunciado: Desarrolla un programa que permita al usuario ingresar un número entero 
no negativo y calcule su factorial. Asegúrate de manejar adecuadamente los casos de 
entrada inválida.

Posibles Soluciones: 
a. Utiliza un bucle for para calcular el factorial. 
b. Implementa una función recursiva para calcular el factorial. 
c. Utiliza una matriz de factoriales precalculados para los números del 0 al N y
busca el valor en la matriz.*/
#include <stdio.h>

int main(void){
    int num;
    int resultado=1;

    printf("Introduce un numero \n");
    scanf("%d",&num);
    if(num==0){
        resultado=1;
    }else if(num<0){
        printf("No se puede hacer el factorial de un numero negativo");
    }else{
        for(int i=num; i>1; i--){
            resultado*=i;
        }
        printf("El factorial de %d es %d\n", num, resultado);
    }
    return 0;
}