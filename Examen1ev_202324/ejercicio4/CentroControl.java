
public class CentroControl implements Runnable {
    private static final int TOTAL_KM = 408;
    int contExplotados;
    int contLlegados;
    Cohete miCohete;

    public CentroControl(Cohete miCohete) {
        this.miCohete = miCohete;
    }

    @Override
    public void run() {
        if (miCohete.isPropulsorRoto()) {
            contExplotados++;
        }
        if (miCohete.getKmRecorridos() == TOTAL_KM) {
            contLlegados++;
        }
    }

}
