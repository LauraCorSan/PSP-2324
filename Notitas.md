
## NOTITAS

**Pseudocodigo ordenar numeros**

```
bool ordenado = false;
while(!ordenado) {
   ordenado = true;
   for ( int i = 0;  i < arraySize - 1;  i++) {
      if (array[i] > array[i+1]) {
         intercambiar(array[i], array[i+1])
         ordenado = false;
      }
   }
}
```

*1ºIteracion:* 4, 1, 3, 2
*2ºIteracion:* 1, 4, 3, 2
*3ºIteracion:* 1, 3, 4, 2
*4ºIteracion:* 1, 3, 2, 4
*FIN DE PRIMERA ITERACION (WHILE)*
*1ºIteracion:* 1, 3, 2, 4
*2ºIteracion:* 1, 2, 3, 4
*FIN DE SEGUNDA ITERACION (WHILE)*
*1ºIteracion:* 1, 2, 3, 4
*TERCERA ITERACION (WHILE):* Recorre el for, pero no se mete nunca en el if, asi que ordenado se queda true


**Convertir un unico char en int:**
int comoEntero = caracter - '0';

**Recorrer array en c:**

```
for (int i = 0; i < sizeof(miArray) / sizeof(miArray[0]); i++)
{
    printf("%d ", miArray[i]);
}
```

**Coger valor que dejo el hijo en status:**

Hijo: exit(resultado);

Pdre:
    int statusResultado;
    // Esperar al proceso hijo y coger su estado(resultado de la operacion) desde direccion de memoria
    wait(&statusResultado);

    // Mostrar el resultado 
    printf("Resultado: %d\n", WEXITSTATUS(statusResultado));
    //IMportante porque sino te devuelve un numero no interpretable, y no el valor del exit

**PISTA:**
- Usar dos tuberias Ej7 entrenamientoC