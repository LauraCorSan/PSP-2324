package TCP.Tarea0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1234);

            while (true) {
                enviar(socket);
                recibir(socket);
            }

            // socket.close();// tambien cierra los Streams asociados a el

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enviar(Socket socket) throws IOException {

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String texto = sc.nextLine();
        out.writeUTF(texto);

        // out.close();
        // OJO: el .close() de in o de out cierra tambien el socket asociado
        // (documentacion socket.getOutputStream())

    }

    public static void recibir(Socket socket) throws IOException {

        DataInputStream in = new DataInputStream(socket.getInputStream());

        String s = in.readUTF();
        System.out.println(s);

        // in.close();
        // OJO: el .close() de in o de out cierra tambien el socket asociado
        // (documentacion socket.getInputStream())
    }
}
