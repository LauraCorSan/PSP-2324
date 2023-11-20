public class PrincipalCancion {
    public static void main(String[] args) {
        // Crear instancias de la clase Cancion con distintas prioridades
        Thread elefanteThread = new Thread(new Cancion("Elefante", "se balanceaba", 3));
        Thread monoThread = new Thread(new Cancion("Mono", "brincaba", 4));
        Thread patoThread = new Thread(new Cancion("Pato", "nadaba", 2));

        // Establecer prioridades de los hilos
        elefanteThread.setPriority(Thread.MAX_PRIORITY);
        monoThread.setPriority(Thread.NORM_PRIORITY);
        patoThread.setPriority(Thread.MIN_PRIORITY);

        // Iniciar los hilos
        elefanteThread.start();
        monoThread.start();
        patoThread.start();
    }
}
