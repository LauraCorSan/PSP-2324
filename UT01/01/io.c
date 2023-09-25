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
    printf("La suma es %d\n",&suma);
    return 0;
}