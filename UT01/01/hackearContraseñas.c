#include <stdio.h>
#include <string.h>
#include <openssl/evp.h>

#define aMin 97//esto es a minuscula empezamos ahi
#define zMin 122//esto es z minuscula terminamos ahi

#define MD5_LEN 16

#define NUM_HASHES 4
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
        "582fc884d6299814fbd4f12c1f9ae70f",
        "74437fabd7c8e8fd178ae89acbe446f2",
        "28ea19352381b8659df830dd6d5c90a3",
        "90f077d7759d0d4d21e6867727d4b2bd"
    };

    char cadena[5];//4 letras+1 de nulo pa' que sea string
    unsigned char result[EVP_MAX_MD_SIZE];

    for(int i=aMin ; i<=zMin ; i++){
        cadena[0]=i;
        for(int i=aMin ; i<=zMin ; i++){
            cadena[1]=i;
            for(int i=aMin ; i<=zMin ; i++){
                cadena[2]=i;
                for(int i=aMin ; i<=zMin ; i++){
                    cadena[3]=i;
                    cadena[4]='\0';
                    //generamos el hash de la cadena creada por iteracion (ej. aaab)
                    generateMD5(cadena, result);
                    for(int j=0 ; j<=NUM_HASHES ; j++){
                        if(strcmp(result, hashes[j])==0){
                            printf("hash %d: %s | valor= %s", (j+1), result, cadena);
                            printf("\n");
                        }
                    }
                    /* imprimimos
                        printf("MD5(\"%s\") = %s", cadena, result);
                        printf("\n"); */
                    
                }
            }
        }
    }

    return 0;
}