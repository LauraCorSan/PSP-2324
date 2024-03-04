package TCP.Tarea3;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Cliente {
    public static final int DATABYTE = 1024; // mientras mas pesado mas peligroso, podria perderse

    public static void main(String[] args) {
        String ip = "192.168.56.101";
        int puerto = 1234;
        try {
            Socket socket = new Socket(ip, puerto);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Cogemos el file de una ruta en concreto
            String ruta = "/home/laura/Desktop/Trimestre2PSP.pdf";
            File miPdf = new File(ruta);

            // Debemos procesar el pdf
            FileInputStream lector = new FileInputStream(miPdf);

            byte[] porcionPdf = new byte[DATABYTE];
            int bytesLeidos;

            while ((bytesLeidos = lector.read(porcionPdf)) != -1) {
                // escribimos 1024 byte en 1024 byte
                out.write(porcionPdf, 0, bytesLeidos);
                // array byte (vaso), desde donde empezar, cuanto (hasta donde llego a llenarse
                // el vasito)
            }

            out.close();
            lector.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
