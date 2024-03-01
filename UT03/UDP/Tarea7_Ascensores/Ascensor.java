package UDP.Tarea7_Ascensores;

public class Ascensor implements Runnable {
    public static final int UN_SEG = 1000;

    int codAscensor;
    String piso;
    Character direccion;

    public Ascensor(int codAscensor, String piso) {
        this.codAscensor = codAscensor;
        // sustituimos PB por 0 para poder usarlos como enteros
        if (piso.equals("PB")) {
            piso = "0";
        }
        this.piso = piso;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(UN_SEG);
            int pisoInt = Integer.parseInt(piso);
            if (direccion == 'U') {
                pisoInt++;
                if (pisoInt != 0) {
                    piso = String.valueOf(pisoInt);
                } else {
                    piso = "PB";
                }
            } else if (direccion == 'D') {
                pisoInt--;
                if (pisoInt != 0) {
                    piso = String.valueOf(pisoInt);
                } else {
                    piso = "PB";
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}