package ObserverExamen2ev_2223.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    private static final int RESOURCE_POSITION = 1;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java MultiThreadedServer <port>");
            System.exit(1);
        }
        int puerto = Integer.parseInt(args[0]);

        ServerSocket server = new ServerSocket(puerto);
        Logger creadorFichero = new Logger();

        while (true) {
            Socket connCliente = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connCliente.getInputStream()));
            String header = reader.readLine();
            System.out.println(header);
            // GET ________ HTTP/1.1

            String info = extraeInformacion(header);

            String[] datos = info.split("/");
            int numInicial = Integer.valueOf(datos[1]);
            int cantPrimos = Integer.valueOf(datos[2]);

            PrimosHTTP creadorHTTP = new PrimosHTTP(connCliente, numInicial, cantPrimos);

            creadorHTTP.addObserver(creadorFichero);
            creadorHTTP.crearPagina();
        }
    }

    private static String extraeInformacion(String header) {
        return header.split(" ")[RESOURCE_POSITION];
    }

}
