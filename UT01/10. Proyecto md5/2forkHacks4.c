#include <stdio.h>
#include <string.h>
#include <openssl/evp.h>

#define A_MINUS 97//esto es a minuscula empezamos ahi
#define M_MINUS 109//la mitad
#define Z_MINUS 122//esto es z minuscula terminamos ahi

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
    cadena[4]='\0';//ya que siempre la ultima debe ser nula
    unsigned char result[MD5_LENGTH];

    pid_t id_hijo1, id_hijo2;

    id_hijo1=fork();

    if (id_hijo1 == 0) { // Primer hijo: de "aaaa" hasta "mzzz"
        for (int i = A_MINUS; i <= M_MINUS; i++) {
            cadena[0] = i;
            for (int j = A_MINUS; j <= Z_MINUS; j++) {
                cadena[1] = j;
                for (int k = A_MINUS; k <= Z_MINUS; k++) {
                    cadena[2] = k;
                    for (int l = A_MINUS; l <= Z_MINUS; l++) {
                        cadena[3] = l;
                        //cadena[4] = '\0';
                        generateMD5(cadena, result);
                        for (int m = 0; m < NUM_HASHES; m++) {
                            if (strcmp(result, hashes[m]) == 0) {
                                printf("Hijo 1 encontró hash %d: %s | valor= %s\n", (m + 1), result, cadena);
                                exit(NULL);
                                //este exit solo funciona por casualidad, ya que las palabras clave estan
                                //justo cada uno en cada rango, sino saldria y jamas encontraria el segundo
                            }
                        }
                    }
                }
            }
        }
    } else { // Proceso padre crea el segundo hijo para el resto
        id_hijo2 = fork();

        if (id_hijo2 == 0) { // Segundo hijo: de "naaa" hasta "zzzz"
            for (int i = M_MINUS+1; i <= Z_MINUS; i++) {
                cadena[0] = i;
                for (int j = A_MINUS; j <= Z_MINUS; j++) {
                    cadena[1] = j;
                    for (int k = A_MINUS; k <= Z_MINUS; k++) {
                        cadena[2] = k;
                        for (int l = A_MINUS; l <= Z_MINUS; l++) {
                            cadena[3] = l;
                            //cadena[4] = '\0';
                            generateMD5(cadena, result);
                            for (int m = 0; m < NUM_HASHES; m++) {
                                if (strcmp(result, hashes[m]) == 0) {
                                    printf("Hijo 2 encontró hash %d: %s | valor= %s\n", (m + 1), result, cadena);
                                    exit(NULL);
                                    //este exit solo funciona por casualidad, ya que las palabras clave estan
                                    //justo cada uno en cada rango, sino saldria y jamas encontraria el segundo
                                }
                            }
                        }
                    }
                }
            }
        } else { // Proceso padre espera a que los hijos terminen
            wait(NULL);
            wait(NULL);
        }
    }

    return 0;
}