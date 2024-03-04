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
# SPLITS UTILES -----------------------------------------------------------------------------------------

Dividir por espacio:
String texto = "Hola Mundo Java";
String[] partes = texto.split(" ");

Dividir por punto:
String texto = "www.google.com";
String[] partes = texto.split("\\.");
Nota: En este caso se utiliza \\. porque el punto en sí mismo es un carácter especial en las expresiones regulares y debe ser escapado.

Dividir por varios delimitadores:
String texto = "Perro-gato;loro,pato";
String[] partes = texto.split("[-;,]");
En este ejemplo, se usa [-;,] para indicar que el delimitador puede ser un guión, punto y coma o coma.

Dividir por un número variable de espacios en blanco:
String texto = "Hola     mundo     Java";
String[] partes = texto.split("\\s+");
En este caso, \\s+ representa uno o más espacios en blanco como delimitador.

Dividir por un número fijo de caracteres:
String texto = "1234567890";
String[] partes = texto.split("(?<=\\G.{2})");
Aquí se divide la cadena en partes de dos caracteres cada una.

Dividir por un patrón de expresión regular para eliminar espacios en blanco:
String texto = "   Hola   Mundo   ";
String[] partes = texto.split("\\s+");
Esto elimina los espacios en blanco alrededor de las palabras.

Dividir con límite (solo las primeras 2 divisiones):
String texto = "uno dos tres cuatro cinco";
String[] resultado = texto.split(" ", 3);
// Salida: [uno, dos, tres cuatro cinco]




# REGEX UTILES ------------------------------------------------------------------------------------------

Validar un correo electrónico:
String regexCorreo = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
Este regex valida direcciones de correo electrónico estándar, como "usuario@dominio.com".

Buscar números enteros en un texto:
String regexNumeros = "\\b\\d+\\b";
Este regex encuentra todos los números enteros en un texto.

Validar un número de teléfono en formato específico (por ejemplo, 123-456-7890):
String regexTelefono = "\\d{3}-\\d{3}-\\d{4}";
Este regex valida números de teléfono en el formato xxx-xxx-xxxx.

Buscar palabras que comiencen con una letra en particular (por ejemplo, palabras que comiencen con "a"):
String letraInicio = "\\ba\\w*\\b";
Este regex encuentra palabras que comiencen con "a" seguidas de cualquier número de caracteres alfanuméricos.

Validar un código postal de 5 dígitos:
String regexCP = "\\b\\d{5}\\b";
Este regex valida códigos postales de 5 dígitos.

Extraer palabras en mayúsculas:
String regexMayusculas = "\\b[A-Z]+\\b";
Este regex encuentra todas las palabras que están en mayúsculas en un texto.

Validar una fecha en formato dd/mm/aaaa:
String regexFecha = "\\b(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}\\b";


# METODOS UTILES -----------------------------------------------------------------------------------------

* Calcular el factorial de un número:
public static int factorial(int n) {
    if (n == 0) {
        return 1;
    }
    return n * factorial(n - 1);
}
Este método calcula el factorial de un número n. El factorial de un número entero no negativo n se define como el producto de todos los enteros positivos menores o iguales a n.

* Convertir un número binario a decimal:
public static int binarioADecimal(String binario) {
    return Integer.parseInt(binario, 2);
}
Este método convierte un número binario representado como una cadena de texto en su equivalente decimal.

* Encontrar el máximo común divisor (MCD) de dos números:
public static int mcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return mcd(b, a % b);
}
Este método utiliza el algoritmo de Euclides para encontrar el máximo común divisor (MCD) de dos números enteros a y b.

* Verificar si un año es bisiesto:
public static boolean esBisiesto(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}
Este método determina si un año dado es bisiesto. Un año bisiesto es aquel que es divisible por 4 pero no por 100, o es divisible por 400.

* Calcular la potencia de un número:
public static double potencia(double base, int exponente) {
    return Math.pow(base, exponente);
}
Este método calcula la potencia de un número base elevado a un exponente dado.

* Generar un número aleatorio en un rango dado:
public static int generarNumeroAleatorio(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
}
Este método genera un número aleatorio en un rango dado, incluyendo los límites min y max.

* Contar la cantidad de palabras en una cadena:
public static int contarPalabras(String texto) {
    String[] palabras = texto.split("\\s+");
    return palabras.length;
}
Este método cuenta la cantidad de palabras en una cadena de texto. Divide la cadena en palabras utilizando el espacio en blanco como delimitador y luego cuenta el número de elementos en el arreglo resultante.

* Invertir una cadena de texto:
public static String invertirCadena(String texto) {
    StringBuilder resultado = new StringBuilder();
    for (int i = texto.length() - 1; i >= 0; i--) {
        resultado.append(texto.charAt(i));
    }
    return resultado.toString();
}
Este método invierte una cadena de texto, recorriendo la cadena de derecha a izquierda y construyendo la cadena invertida.

* Calcular el promedio de una lista de números:
public static double calcularPromedio(double[] numeros) {
    double suma = 0;
    for (double num : numeros) {
        suma += num;
    }
    return suma / numeros.length;
}
Este método calcula el promedio de una lista de números.

* Verificar si una cadena es un palíndromo:
public static boolean esPalindromo(String texto) {
    String limpio = texto.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    String invertido = invertirCadena(limpio);
    return limpio.equals(invertido);
}
Este método verifica si una cadena es un palíndromo, es decir, si se lee igual de izquierda a derecha que de derecha a izquierda.

* Obtener el día de la semana de una fecha específica:
public static String obtenerDiaSemana(int year, int mes, int dia) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, mes - 1, dia); // Meses en Calendar van de 0 a 11
    int numeroDiaSemana = calendar.get(Calendar.DAY_OF_WEEK);
    
    String[] diasSemana = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
    
    return diasSemana[numeroDiaSemana - 1];
}
Este método utiliza la clase Calendar para obtener el día de la semana correspondiente a una fecha específica.

* Sumar los dígitos de un número entero:
public static int sumarDigitos(int numero) {
    int suma = 0;
    while (numero != 0) {
        suma += numero % 10;
        numero /= 10;
    }
    return suma;
}
Este método suma todos los dígitos de un número entero dado.

* Contar vocales, consonantes y el resto
public static void contarCaracteres(String texto) {
    int consonantes = 0;
    int vocales = 0;
    int otros = 0;

    // Convertir el texto a minúsculas para simplificar la comparación
    texto = texto.toLowerCase();

    for (int i = 0; i < texto.length(); i++) {
        char ch = texto.charAt(i);

        if (ch >= 'a' && ch <= 'z') {
            // Si es una letra
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                // Si es vocal
                vocales++;
            } else {
                // Si es consonante
                consonantes++;
            }
        } else {
            // Si no es una letra, se considera otro tipo de caracter
            otros++;
        }
    }

    System.out.println("Consonantes: " + consonantes);
    System.out.println("Vocales: " + vocales);
    System.out.println("Otros: " + otros);
}

# MAVEN --------------------------------------------------------------------------------------------------
mvn exec:java -Dexec.mainClass=com.example.App.Main -Dexec.args=" '/home/javier/EjerciciosAntesExamen2EvaluacionPSP/correos/src/main/java/com/example/mensajes.txt' '/home/javier/EjerciciosAntesExamen2EvaluacionPSP/correos/src/main/java/com/example/correos.txt' 'laura.cordero6' 'contrasena' "

# UDP ----------------------------------------------------------------------------------------------------


# TCP ----------------------------------------------------------------------------------------------------



# MAIL ---------------------------------------------------------------------------------------------------



# HTTP ---------------------------------------------------------------------------------------------------