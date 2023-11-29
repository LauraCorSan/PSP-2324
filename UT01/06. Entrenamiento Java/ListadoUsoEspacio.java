import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Para mostrar la salida ordenada en un fichero
/*java ut01.EntrenamientoJava.ListadoUsoEspacio /home/alberto /home > salida.txt
sort salida.txt*/

public class ListadoUsoEspacio {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.exit(1);
        }

        for (int i = 0; i < args.length; i++) {
            String[] commands = { "du", "-h", args[i] };
            try {
                System.out.println("Uso de espacio para el directorio: " + args[i]);

                ProcessBuilder pb = new ProcessBuilder(commands);
                Process process = pb.start();
                process.waitFor();

                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String salida = null;
                while ((salida = stdInput.readLine()) != null) {
                    System.out.println(salida);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
