
## PSEUDO CODIGO ORDENACION NUMEROS:
bool ordenado = false;
while(!ordenado) {
   ordenado = true;
   for ( int i = 0;  i < array.length - 1;  i++) {
      if (array[i] > array[i+1]) {
         intercambiar(array[i], array[i+1])
         ordenado = false;
      }
   }
} 

**1ºIteracion:** 4, 1, 3, 2
**2ºIteracion:** 1, 4, 3, 2
**3ºIteracion:** 1, 3, 4, 2
**4ºIteracion:** 1, 3, 2, 4
**FIN DE PRIMERA ITERACION (WHILE)** 
**1ºIteracion:** 1, 3, 2, 4
**2ºIteracion:** 1, 2, 3, 4
**FIN DE SEGUNDA ITERACION (WHILE)** 
**1ºIteracion:** 1, 2, 3, 4
**TERCERA ITERACION (WHILE):** Recorre el for, pero no se mete nunca en el if, asi que ordenado se queda true