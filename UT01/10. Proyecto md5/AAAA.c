#include <stdio.h>
#include <string.h>

#define A_MINUS 97//esto es a minuscula empezamos ahi
#define Z_MINUS 122//esto es z minuscula terminamos ahi

int main(int arc, char *argv[]) {
    char cadena[4];
    for(int i=A_MINUS ; i<=Z_MINUS ; i++){
        cadena[0]=i;
        for(int i=A_MINUS ; i<=Z_MINUS ; i++){
            cadena[1]=i;
            for(int i=A_MINUS ; i<=Z_MINUS ; i++){
                cadena[2]=i;
                for(int i=A_MINUS ; i<=Z_MINUS ; i++){
                    cadena[3]=i;
                    printf("%s\n",cadena);
                }
            }
        }
    }
    return 0;
}