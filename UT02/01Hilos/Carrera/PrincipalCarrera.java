import java.util.ArrayList;

public class PrincipalCarrera {
    private static final int TOTAL_CARRERA = 100;
    private static final int TOTAL_CORREDORES = 5;

    public static void main(String[] args) {
        ArrayList<Corredor> listCorredores = new ArrayList<>();
        ArrayList<Thread> listaHilos = new ArrayList<>();

        for (int i = 0; i <= TOTAL_CORREDORES; i++) {
            listCorredores.add(new Corredor(TOTAL_CARRERA, i + 1));
            listaHilos.add(new Thread(listCorredores.get(i)));
        }

        for (int j = 0; j <= TOTAL_CORREDORES; j++) {
            listaHilos.get(j).start();
        }

        for (int m = 0; m <= TOTAL_CORREDORES; m++) {
            try {
                listaHilos.get(m).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("¡FIN CARRERA!");

    }

}
