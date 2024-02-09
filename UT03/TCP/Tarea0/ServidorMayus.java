package TCP.Tarea0;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMayus {
    public static void main(String[] args) {

        ServerSocket server;

        try {
            server = new ServerSocket(1234);
            while (true) {
                System.out.println("Espero un cliente...");

                // Espera cliente
                Socket socket = server.accept();

                // Tiene un cliente y lo envia al hilo gestorClientes un cliente
                GestorClientes miGestor = new GestorClientes(socket);
                Thread atencionCliente = new Thread(miGestor);

                atencionCliente.start();
            }
            // socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
