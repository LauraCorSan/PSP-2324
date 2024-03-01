## NOTITAS 

## HILOS -----------------------------------------------------------------------------------------------

**CREAR HILO NORMAL**
- Hacer hilo extendiendo de Thread (clase de la API de Java)
```java
public class MiHilo extends Thread{
    public void run() {
        System.out.println("Hilo ejecutándose");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```

- Hacer hilo implementando Runnable (interfaz de la API de Java)
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Hilo ejecutándose");
    }
}
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```

**CREAR HILO CON LAMBDA**
```java
public class CrearHiloLambda {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Hola mundo");
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}
```

# OBSERVER -----------------------------------------------------------------------------------------------
1. Crea la Interfaz Observer que unicamente tendra la declaracion del metodo de indicarCambio(Value newValue), el cual recibira o no el nuevo valor de la Variable de interes.
2. Encontrar la clase Notificador (es la clase que tiene una variable de interes para otra clase, es decir quiere saber si cambia en algun momento, y puede que le interese su nuevo valor).
Cuando identificamos la clase Notificador, este debe tener varias cositas:
    - Un ArrayList de suscriptores, observers o listener  (noombres validos todos)
    ```java 
    ArrayList<InterfazObserver> misSuscriptores; 
    ```
    - Un metodo setListeners() que lo que hara sera añadir a su array los suscriptores, recibira un objeto InterfazObserver para poder añadirlo al array del mismo tipo;
    - Un metodo notificar() que recorrera el array de suscriptores y utilizara el metodo indicarCambio(newValue) por cada suscriptor. Este metodo se utilizara cada vez que la variable de interes sea cambiada, en un setter por ejemplo, aunque no siempre es el caso.
3. Tendremos una clase Listener (es una clase que por x razones esta interesada en una variable de la clase notificador) la cual implementara InterfazObserver para implementar su version del metodo cuando esa variable cambie.
Esta clase sera instanciada y añadida a la lista de suscriptores del notificador con el metodo mencionado anteriormente.
    ```java 
    objetoNotificador.setListener(objetoListener); 
    ```

# UDP ----------------------------------------------------------------------------------------------------



# TCP ----------------------------------------------------------------------------------------------------



# MAIL ---------------------------------------------------------------------------------------------------



# HTTP ---------------------------------------------------------------------------------------------------