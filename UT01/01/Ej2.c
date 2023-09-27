/*Conversión de Grados Celsius a Fahrenheit

Enunciado: Escribe un programa que permita al usuario ingresar una temperatura en 
grados Celsius y lo convierta a grados Fahrenheit utilizando la fórmula: 
Fahrenheit = (Celsius * 9/5) + 32.

Posibles Soluciones: 
a. Usa scanf para leer la temperatura en grados Celsius, luego aplica la fórmula 
y muestra el resultado. 
b. Utiliza la función fgets para leer la entrada como cadena, conviértela a 
flotante con atof y realiza la conversión. 
c. Crea una tabla de conversión previamente definida y busca la temperatura 
en grados Fahrenheit correspondiente en la tabla.*/

#include <stdio.h>
#include <stdbool.h>
#include <math.h>


int main(void){
    int celsius;
    int Fahrenheit;

    printf("Introduce una temperatura \n");
    scanf("%d",&celsius);
    Fahrenheit=(celsius* 9/5) + 32;

    printf("La temperatura %d en celsius es %d en Fahrenheit",celsius,Fahrenheit);

    return 0;
}