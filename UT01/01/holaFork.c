#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main (void){
    pid_t id_mi_hijo;//declaro variable para alamacenar ids de procesos

    int n=42;
    double pi=3.14;

    //clonacion!
    id_mi_hijo=fork();

    //Hay dos procesos, cual es cual?(padre vs hijo)
    if(id_mi_hijo!=0){//padre?
        printf("Soy el padre, mi id es %d, y mi hijo es %d\n",getpid(),id_mi_hijo);
    }else{//hijo?
        printf("Soy el hijo mi id es %d, y mi hijo es %d\n",getpid(),id_mi_hijo);
    }

    return 0;
}