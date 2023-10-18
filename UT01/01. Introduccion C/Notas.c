/*Los arrays pueden ser de cualquier tipo de dato. Crea un programa que pida al usuario 
las notas que ha sacado en 5 exámenes. Almacena la información en un array. Después mostrá 
una lista con la nota de los exámenes y si ha aprobado o no. La nota media, la nota más alta
y la nota más baja.*/

#include <stdio.h>
#include <string.h>
#define EXAMENES 5 //esto es definir una constante
#define NOTAMAX 10
#define NOTAMIN 0
#define APROBADO 5

int main() {
    int notas[EXAMENES];
    int notaAlta=NOTAMIN;
    int notaBaja=NOTAMAX;
    int notaMedia=0;

    for(int i; i<EXAMENES ; i++){
        printf("Introduce las notas (%d)\n",i);
        scanf("%d",&notas[i]);
        //guardar la mas alta
        if(notas[i]<notaBaja){
            notaBaja=notas[i];
        }
        //guardar la mas baja
        if(notas[i]>notaAlta){
            notaAlta=notas[i];
        }
        //hacer media
        notaMedia+=notas[i];
    }
    //sacar nota media
    notaMedia=notaMedia/EXAMENES;

    for(int j; j<EXAMENES; j++){
        print("Notas examenes: \n");
        printf("Nota:%d ",notas[j]);
        printf("%s\n", notas[j] >=APROBADO ? "Aprobado" : "Suspenso");
    }
    printf("La nota mas alta: %d\n",notaAlta);
    printf("La nota mas baja: %d\n",notaBaja);
    printf("La nota media: %d\n",notaMedia);

   

    return 0;
}