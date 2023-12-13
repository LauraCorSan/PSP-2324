
/*Para hacer sort: 
/PSP/ut01/01Hilos$ java 2.TablasMultiplicar.PrincipalTablas > salida.txt
/PSP/ut01/01Hilos$ sort salida.txt */
public class PrincipalTablas {
    public static void main(String[] args) {
        int N = 5; // Número de hilos

        // Crear un array de N hilos
        Thread[] hilos = new Thread[N];

        // Inicializar y empezar cada hilo
        for (int i = 0; i < N; i++) {
            MiTabla unaTabla = new MiTabla(i + 1);
            hilos[i] = new Thread(unaTabla);
            hilos[i].setName("Tabla del " + (i + 1));
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
