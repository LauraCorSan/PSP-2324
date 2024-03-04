package TCP.Tarea3;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int DATABYTE = 1024;// No tiene por que ser igual

    public static void main(String[] args) {
        String nombrePdfRecibido = "archivo_recibido.pdf";
        int puerto = 1234;

        try {
            ServerSocket server = new ServerSocket(puerto);
            byte[] porcionPdfRecibida = new byte[DATABYTE];
            int bytesLeidos;
            Socket socket = server.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Creamos un archivo en el servidor donde guardaremos el contenido del PDF
            FileOutputStream escritor = new FileOutputStream(nombrePdfRecibido);

            while ((bytesLeidos = in.read(porcionPdfRecibida)) != -1) {
                escritor.write(porcionPdfRecibida, 0, bytesLeidos);
            }

            System.out.println("Soy servidor. He recibido el pdf, esta guardado como: " + nombrePdfRecibido);

            in.close();
            escritor.close();
            socket.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * private static void mostrarBytesPDF(String rutaArchivoPDF) {
     * try (FileInputStream inputStream = new FileInputStream(rutaArchivoPDF)) {
     * int data;
     * while ((data = inputStream.read()) != -1) {
     * System.out.print((char) data);
     * }
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     */
}
