#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#define N 10

int imprimeTabla(int i){
    for(int j=1 ; j<=N ;j++){
        int resultado=i*j;
        printf("%d x %d = %d\n",i,j,resultado);
    }
}

int main (void){
    pid_t id_hijo;
    for(int hijos=1 ; hijos<=N ;hijos++){
        id_hijo=fork();
        if(id_hijo==0){
            imprimeTabla(hijos);
            exit(0);
        }  
    }

    for(int hijos=1 ; hijos<=N ;hijos++){
        wait(NULL);
    }

    return 0;
}