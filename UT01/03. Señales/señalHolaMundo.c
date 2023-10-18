#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

// Función de controlador de señal para SIGINT
void sigint_handler1(int signo) {
    
    printf("HOLA\n");
    // Aquí puedes realizar acciones adicionales antes de salir si lo deseas
    exit(0);
}

void sigint_handler2(int signo) {
    
    printf("MUNDO\n");
    // Aquí puedes realizar acciones adicionales antes de salir si lo deseas
    exit(0);
}

int main() {
    // Registrar un manejador de señales para SIGINT usando la función signal
    signal(SIGUSR1, sigint_handler1);//-11
    signal(SIGUSR2, sigint_handler2);//-12
    
    // Mantén el programa en ejecución para recibir la señal
    while (1) {
        printf(".");
        fflush(stdout);//sirve para decirle que imprima nada mas lo tenga, sin esperar cambios
        sleep(1);
    }

    return 0;
}