public class Cohete implements Runnable {
    private static final double POSIBILIDAD_ROTURA = 0.1;
    private static final int AVNCE_KM = 50;
    private static final int TIEMPO_MIN_DESCANSO = 500;
    private static final long TIEMPO_MAX_DESCANSO = 1000;
    int kmRecorridos;
    int kmTotales;
    int identificador;
    boolean propulsorRoto;

    public Cohete(int kmTotales, int identificador) {
        this.kmRecorridos = 0;
        this.kmTotales = kmTotales;
        this.identificador = identificador;
        this.propulsorRoto = false;
    }

    public boolean isPropulsorRoto() {
        return propulsorRoto;
    }

    public int getKmRecorridos() {
        return kmRecorridos;
    }

    @Override
    public void run() {
        while (kmRecorridos < kmTotales && !propulsorRoto) {
            try {
                Thread.sleep((long) (Math.random() * TIEMPO_MAX_DESCANSO) + TIEMPO_MIN_DESCANSO);
                System.out.printf("Soy %d | %d/%d km recorridos\n", identificador, kmRecorridos, kmTotales);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (Math.random() > POSIBILIDAD_ROTURA) {
                propulsorRoto = true;
            } else {
                kmRecorridos += AVNCE_KM;
            }

        }
    }

}
