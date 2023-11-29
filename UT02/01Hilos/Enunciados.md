# Enunciados ejercicios hilos - Java

### 01 Creación de un Hilo:

Hilos:
- Crea una clase que extienda de Thread y sobrescriba el método run para imprimir "Hola Mundo" en la consola. Luego, instancia y ejecuta el hilo en la clase principal.
- Crea un versión de forma que implementes Runnable.
- Crea una versión con un Lambda.

Haz un método princpial que arranque los 3 threads.

### 02 Implementación de la interfaz Runnable:

Crea una clase que implemente la interfaz Runnable y sobrescriba el método run para imprimir los números del 1 al 10. Luego, instancia y ejecuta el hilo en la clase principal.

Modifica el programa anterior para que cree un array de N Threads y los espere. A cada thread le dará un nombre (Método setName) y escribirá la tabla de un número.

> NOTA: La salida estará desordenada.

Ejecuta el comando en la terminal, y vuelca su salida a un fichero. Utiliza las redirecciones de linux y el comando sort para verificar que has escrito todas las tablas.

### 03 Los elefantes...

```text
Un elefante se balanceaba sobre la tela de una araña
Como veía que resistía, fue a llamar otro elefante
Dos elefantes se balanceaban sobre la tela de una araña
Como veían que resistía, fueron a llamar otro elefante
```

Basándote en esa canción, crea un Thread que reciba el tipo de animal, la acción y el número máximo. Cada vez que escriba una estrofa, el thread generará un número aleatorio entre 100000 y 300000 y verificará si es primo.

Crea un programa principal que gestion 3 canciones infantiles de forma concurrente con distintas prioridades (setPriority). Las canciones serán veriones de los elefantes pero con distinto animal y acción.

> No hace falta que haya 

```text
Un perro ladraba sobre la tela de una araña
Como veía que resistía, fue a llamar otro elefante
Dos perro ladraban sobre la tela de una araña
Como veían que resistía, fueron a llamar otro elefante
```

### 04 Contador

Crea una clase Counter con un método sincronizado increment que incremente una variable count. Crea dos hilos que incrementen el contador y observa el resultado.
Modifica la clase Counter anterior para usar un bloque sincronizado en lugar de un método sincronizado.

#### Modificación 04a 

Modifica el ejercicio para poder incrementar y decrementar, crea 5 hilos que incrementen 1000 veces y 5 que decrementen 1000 veces. Muestra el resultado de hacer esta operación con sincronización y sin sincornización.


### 05 Bancos

Imagina un sistema de banco en línea que maneja las cuentas de los usuarios. Dos usuarios, Alice y Bob, intentan transferir dinero de sus cuentas a una tercera cuenta al mismo tiempo. Necesitas asegurarte de que las operaciones se realicen de manera segura y sin conflictos, utilizando sincronización.

Crea dos threads, uno para cada usuario. Cada thread intentará realizar 1000 transferencia de dinero de 10 euros. Usa un método synchronized para asegurar que las operaciones en las cuentas no se realicen simultáneamente, evitando así condiciones de carrera.

Ejecuciones:
- Haz una ejcución sin sincronización
- Haz una ejecución sincronizada

Posible ejecución sincronizada:
- Alice inicia la transferencia.
- El thread de Alice adquiere el bloqueo del objeto cuenta.
- Bob intenta iniciar su transferencia pero debe esperar.
- Alice completa su transferencia y libera el bloqueo.
- Bob adquiere el bloqueo y realiza su transferencia.


### 06 Carrera

Práctica guiada: introducción a wait, notify y notifyAll.

Crea una carrera de corredores. Los corredores esperan a la salida (notifyAll), cuando un corredor llega notifica al thread principal en la meta. El thread principal interrumpe a los corredores.

