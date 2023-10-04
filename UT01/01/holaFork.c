#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int esPrimo(int n){
    int primo = 1;
    int i = 2;
    while(primo && i<n/2){
        if(n%i==0){
            primo=0;
        }
        i++;
    }
    return primo; 
}

int main (void){
    pid_t id_mi_hijo; //declaro variable para alamacenar ids de procesos

    unsigned int n = 25;

    //clonacion!
    id_mi_hijo = fork();

    //Hay dos procesos
    if(id_mi_hijo != 0){//padre
        //descansar hasta que el hijo finalice
        int status;
        wait(&status);
        fprintf(stdout, "El hijo ha finalizado, el numero...  %s\n", (WEXITSTATUS(status) == 1) ? "es primo" : "NO es primo");
    
    }else{//hijo
        fprintf(stdout, "Me pondre a ver si el numero es primo\n");
        int primo = esPrimo(n);
        fprintf(stdout, "¡Termine! Te dejo en mi estado si era primo *se muere* \n");
        exit(primo);//se usa para terminar el proceso del todo (como este es el hijo, se sigue ejecutando la parte del padre)
        //tambien sirve return solo porque esta en el main, porque si usas return en un metodo por ejemplo, solo se sale del metodo, pero
        //ai usas el exit si puedes, estes donde estes, terminar el proceso
    }
    return 0;
}