#include <stdio.h>
#include <string.h>

#define aMin 97//esto es a minuscula empezamos ahi
#define zMin 122//esto es z minuscula terminamos ahi

int main(int arc, char *argv[]) {
    char cadena[4];
    for(int i=aMin ; i<=zMin ; i++){
        cadena[0]=i;
        for(int i=aMin ; i<=zMin ; i++){
            cadena[1]=i;
            for(int i=aMin ; i<=zMin ; i++){
                cadena[2]=i;
                for(int i=aMin ; i<=zMin ; i++){
                    cadena[3]=i;
                    printf("%s\n",cadena);
                }
            }
        }
    }
    return 0;
}