package TCP.Tarea1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GestorClientesNum implements Runnable {
    private final String MSG_NO_COMANDO = "\tNo reconozco ese comando";
    private final String COMANDO_N = "N";
    private final String COMANDO_SALIR = "SALIR";
    private Socket miSocket;

    public GestorClientesNum(Socket socket) {
        miSocket = socket;
    }

    @Override
    public void run() {
        System.out.println("\tAtiendo cliente... ");
        try {
            DataInputStream in = new DataInputStream(miSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(miSocket.getOutputStream());

            String s = "";

            do {
                s = in.readUTF();

                s = s.toUpperCase();
                // s = s.replaceAll("\\n\\r", "");

                if (s.equals(COMANDO_N)) {
                    int num = (int) (Math.random() * 1000) + 1;
                    out.writeUTF(String.valueOf(num));
                } else if (s.equals(COMANDO_SALIR)) {
                    System.out.println("\tDesconectando cliente");
                    miSocket.close();
                } else {
                    out.writeUTF(MSG_NO_COMANDO);
                }
            } while (!s.equals(COMANDO_SALIR));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
