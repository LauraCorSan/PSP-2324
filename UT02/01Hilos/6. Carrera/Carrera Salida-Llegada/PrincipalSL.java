import java.util.ArrayList;

public class PrincipalSL {

    public static void main(String[] args) {
        Object salida = new Object();
        Object llegada = new Object();
        ArrayList<Thread> lista = new ArrayList<>();
        for (int i = 0; i < CorredorSL.NUM_CORREDORES; i++) {
            Thread thread = new Thread(new CorredorSL(i + 1, salida, llegada));
            lista.add(thread);
            thread.start();
        }
        try {
            Thread.sleep(CorredorSL.TIEMPO_ESPERA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (salida) {
            salida.notifyAll();
        }
        synchronized (llegada) {
            try {
                llegada.wait();
            } catch (InterruptedException e) {
            }
        }
        for (Thread thread : lista) {
            if (thread.isAlive()) {
                thread.interrupt();
            }
        }
    }
}