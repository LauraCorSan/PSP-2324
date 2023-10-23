#include <stdio.h>
#include <string.h>
#include <openssl/evp.h>

#define A_MAYUS 65//esto es A mayuscula empezamos ahi
#define MITAD 94
#define Z_MINUS 122//esto es z minuscula terminamos ahi

#define MD5_LEN 16

#define NUM_HASHES 2
#define MD5_LENGTH 33 // Longitud de un hash MD5 (32 caracteres + cararcter nulo

void generateMD5(const char *string, unsigned char *str_result) {
    EVP_MD_CTX *ctx;
    const EVP_MD *md;
    unsigned char result[EVP_MAX_MD_SIZE];

    ctx = EVP_MD_CTX_new();
    md = EVP_md5();

    EVP_DigestInit_ex(ctx, md, NULL);
    EVP_DigestUpdate(ctx, string, strlen(string));
    EVP_DigestFinal_ex(ctx, result, NULL);

    EVP_MD_CTX_free(ctx);

    for(int i = 0; i < MD5_LEN; i++){   // MD5 result is always 16 bytes
        sprintf(str_result+(i*2),"%02x", result[i]);
    }
}

int main(void) {
    char hashes[NUM_HASHES][MD5_LENGTH] = {
        "f4a1c8901a3d406f17af67144a3ec71a",
        "d66e29062829e8ae0313adc5a673f863"
    };

    char cadena[6];//5 letras+1 de nulo pa' que sea string(???)
    cadena[5]='\0';//siempre sera nulo
    unsigned char result[MD5_LENGTH];
    
    pid_t id_hijo1, id_hijo2;

    id_hijo1=fork();//creo primer hijo

    if(id_hijo1==0){//soy hijo1
        for(int i=A_MAYUS ; i<=MITAD ; i++){
            cadena[0]=i;
            for(int i=A_MAYUS ; i<=Z_MINUS ; i++){
                cadena[1]=i;
                for(int i=A_MAYUS ; i<=Z_MINUS ; i++){
                    cadena[2]=i;
                    for(int i=A_MAYUS ; i<=Z_MINUS ; i++){
                        cadena[3]=i;
                        for(int i=A_MAYUS ; i<=Z_MINUS ; i++){
                            cadena[4]=i;
                            //generamos el hash de la cadena creada por iteracion (ej. aaab)
                            generateMD5(cadena, result);
                            for (int m = 0; m < NUM_HASHES; m++) {
                                //comprobamos si soincide con alguna del array, si es asi, se imrpime y sale
                                if (strcmp(result, hashes[m]) == 0) {
                                    printf("Hijo 1 encontró hash %d: %s | valor= %s\n", (m + 1), result, cadena);
                                    //no poner exit, sino una vez encuentra uno se muere y si el otro estaba en su rango 
                                    //de busqueda, jamas lo encontrara
                                }
                            } 
                        }
                    }
                }
            }
        }
    }else{//padre
        id_hijo2=fork();//creo segundo hijo

        if(id_hijo2==0){//soy hijo2
            for(int i=MITAD ; i<=Z_MINUS ; i++){
                cadena[0]=i;
                for(int i=A_MAYUS ; i<=Z_MINUS ; i++){
                    cadena[1]=i;
                    for(int i=A_MAYUS ; i<=Z_MINUS ; i++){
                        cadena[2]=i;
                        for(int i=A_MAYUS ; i<=Z_MINUS ; i++){
                            cadena[3]=i;
                            for(int i=A_MAYUS ; i<=Z_MINUS ; i++){
                                cadena[4]=i;
                                //generamos el hash de la cadena creada por iteracion (ej. aaab)
                                generateMD5(cadena, result);
                                for (int m = 0; m < NUM_HASHES; m++) {
                                    //comprobamos si soincide con alguna del array, si es asi, se imrpime y sale
                                    if (strcmp(result, hashes[m]) == 0) {
                                        printf("Hijo 2 encontró hash %d: %s | valor= %s\n", (m + 1), result, cadena);
                                        //no poner exit, sino una vez encuentra uno se muere y si el otro estaba en su rango 
                                        //de busqueda, jamas lo encontrara
                                    }
                                } 
                            }
                        }
                    }
                }
            }
        }else{
            //soy padre y espero
            wait(NULL);
            wait(NULL);
        }
    }

    return 0;
}