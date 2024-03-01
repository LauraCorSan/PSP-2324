package TCP.Tarea1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorNumero {
    public static final int PORT = 1234;

    public static void main(String[] args) {

        ServerSocket server;

        try {
            server = new ServerSocket(PORT);
            while (!server.isClosed()) {
                System.out.println("Espero un cliente...");

                Socket socket = server.accept();

                GestorClientesNum miGestor = new GestorClientesNum(socket);
                Thread atencionCliente = new Thread(miGestor);

                atencionCliente.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
