/*Números Primos

Enunciado: Crea un programa que solicite al usuario ingresar un número entero positivo
 y determine si es un número primo o no.

Posibles Soluciones: 
a. Utiliza un bucle for para verificar si el número es divisible por algún número 
entre 2 y la raíz cuadrada del número. 
b. Implementa una función que verifique la primalidad y llámala desde el programa 
principal. 
c. Utiliza la criba de Eratóstenes para generar una lista de números primos y 
verifica si el número dado está en la lista.*/

#include <stdio.h>
#include <stdbool.h>
#include <math.h>


int main(void){
    int num;
    int contador=0;

    printf("Introduce un numero \n");
    scanf("%d",&num);

    for(int i=1;i<=num; i++){
        if(num%i==0){
            contador++;
        }
    }
    if(contador==2){
        printf("El numero %d es un numero primo",num);
    }else{
        printf("El numero %d NO es un numero primo",num);
    }

    /* if (num <= 0) {
        printf("Por favor, ingresa un número entero positivo.\n");
    } else if (esPrimo(num)) {
        printf("%d es un número primo.\n", num);
    } else {
        printf("%d no es un número primo.\n", num);
    } */
    return 0;
}

/* bool esPrimo(int numero) {
    if (numero <= 1) {
        return false;
    }
    if (numero == 2) {
        return true;
    }
    if (numero % 2 == 0) {
        return false;
    }
    for (int i = 3; i <= sqrt(numero); i += 2) {
        if (numero % i == 0) {
            return false;
        }
    }
    return true;
} */