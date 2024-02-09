package TCP.Tarea0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GestorClientes implements Runnable {
    Socket miSocket;

    public GestorClientes(Socket socket) {
        miSocket = socket;
    }

    @Override
    public void run() {
        System.out.println("\tAtiendo a un cliente ");
        try {
            DataInputStream in = new DataInputStream(miSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(miSocket.getOutputStream());

            while (true) {
                String s = in.readUTF();

                out.writeUTF(s.toUpperCase());
            }

            // in.close();
            // out.close();
            // no es necesario porque al cerrar el socket se cerrarian de todos modos y con
            // cerrar uno cierra el socket :|

            // System.out.println("\tCliente ha terminado de ser atendido");
            // miSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
