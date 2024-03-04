package Examen2ev_2223.Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class PrimosHttp {
    private static final int RESOURCE_POSITION = 1;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java MultiThreadedServer <port>");
            System.exit(1);
        }
        int puerto = Integer.parseInt(args[0]);

        ServerSocket server = new ServerSocket(puerto);

        while (true) {
            Socket connCliente = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connCliente.getInputStream()));
            String header = reader.readLine();
            System.out.println(header);
            // GET ________ HTTP/1.1
            String info = extraeInformacion(header);
            String html = generaPagina(info);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connCliente.getOutputStream()));
            // Escribir cabecera
            writer.write("HTTP/1.1 200 OK\n");
            // writer.write("HTTP/1.1 418 I`m a teapot\n");
            // writer.write("Content-Type: application/json; charset=utf-8\n"); PARA JSON
            writer.write("\n");
            writer.write(html);
            writer.flush();

            reader.close();
            writer.close();
            connCliente.close();
        }
    }

    private static String generaPagina(String info) {
        StringBuilder hmtlPrimos = new StringBuilder();
        String[] datos = info.split("/");
        // usamos datos[1] y datos[2] porque el split con / nos queda asi:
        // ["","30","6",""] ya que aunque no hay nada antes hace la separcion como si
        // fuera un caracter vacio
        int numInicial = Integer.valueOf(datos[1]);
        int cantPrimos = Integer.valueOf(datos[2]);
        ArrayList<Integer> listaPrimos = generarPrimos(numInicial, cantPrimos);
        hmtlPrimos.append("<head><link rel=\"icon\" href=\"data:,\"></head>");
        hmtlPrimos.append("<ul>\n");
        for (int primo : listaPrimos) {
            hmtlPrimos.append(String.format("<li>%d</li>\n", primo));
            // String.format("{\"cosa\": \"%s\"}", info); PARA JSON
        }
        hmtlPrimos.append("</ul>\n");

        return hmtlPrimos.toString();
    }

    private static String extraeInformacion(String header) {
        return header.split(" ")[RESOURCE_POSITION];
    }

    private static ArrayList<Integer> generarPrimos(int nInicial, int nPrimos) {
        ArrayList<Integer> listaPrimos = new ArrayList<>();
        int contPrimos = 0;
        for (int i = nInicial; contPrimos < nPrimos; i++) {
            if (esPrimo(i)) {
                listaPrimos.add(i);
                contPrimos++;
            }
        }
        return listaPrimos;

    }

    private static boolean esPrimo(int numero) {
        // Si el número es menor o igual a 1, no es primo
        if (numero <= 1)
            return false;
        // Verificar si el número es divisible por algún otro número (no 1 ni el mismo)
        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0)
                return false; // El número no es primo
        }
        return true; // El número es primo
    }
}
