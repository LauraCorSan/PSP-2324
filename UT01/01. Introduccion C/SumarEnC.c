/*Calculadora de Suma Simple

Enunciado: Crea un programa que solicite al usuario ingresar dos números enteros 
y muestre la suma de esos números en pantalla.

Posibles Soluciones: 
a. Utiliza la función scanf de la biblioteca <stdio.h> para leer los números 
y luego suma los valores. 
b. Usa la función fgets para leer las entradas como cadenas y luego convierte 
las cadenas a enteros utilizando atoi de la  biblioteca <stdlib.h>. 
c. Utiliza la función getchar para leer caracteres y calcula la suma acumulativa 
hasta que se ingrese un carácter especial, como 'q' para salir.*/

#include <stdio.h>

int main(void){
    int num = 42;
    int suma;
    printf("Introduce un numero \n");
    scanf("%d",&num);
    suma=num;
    printf("Introduce el siguiente \n");
    scanf("%d",&num);
    suma+=num;
    printf("La suma es %d\n",suma);
    return 0;
}