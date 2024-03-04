package ObserverExamen2ev_2223.Ejercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements ObserverPeticiones {
    public static final String RUTA_PRIMOS = "/var/log/primos.txt";

    @Override
    public void notificarPrimo(int primo) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_PRIMOS, true));
            escritor.write(String.valueOf(primo) + "\n");
            escritor.flush();
            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
