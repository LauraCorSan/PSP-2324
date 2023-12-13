import java.util.ArrayList;

public class PrincipalSimiluacion {
    public static final int TOTAL_KM = 408;

    public static void main(String[] args) {
        // Recoger la cantidad de cohetes

        int numCohetes = Integer.parseInt(args[0]);

        // Creamos el array de cohetes
        ArrayList<Thread> arrayCohetes = new ArrayList<>();

        for (int i = 0; i < numCohetes; i++) {
            Thread hilo = new Thread(new Cohete(TOTAL_KM, i + 1));
            arrayCohetes.add(hilo);
            // lanzamos cada cohete
            hilo.start();
        }

        for (Thread thread : arrayCohetes) {
            if (thread.isAlive()) {
                thread.interrupt();
            }
        }
    }
}
