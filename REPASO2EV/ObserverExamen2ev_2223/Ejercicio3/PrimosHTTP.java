package ObserverExamen2ev_2223.Ejercicio3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class PrimosHTTP {
    ArrayList<ObserverPeticiones> misObservers;
    Socket socket;
    int numInicio;
    int cantPrimos;

    public PrimosHTTP(Socket socket, int numInicio, int cantPrimos) {
        this.socket = socket;
        this.numInicio = numInicio;
        this.cantPrimos = cantPrimos;
        misObservers = new ArrayList<>();
    }

    public void crearPagina() {
        String html = generarListaHtml();
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // Escribir cabecera
            writer.write("HTTP/1.1 200 OK\n");
            writer.write("\n");
            // Escribir body
            writer.write(html);
            writer.flush();
            // cerramos
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addObserver(ObserverPeticiones observer) {
        misObservers.add(observer);
    }

    public void notifyAllObservers(int primo) {
        for (ObserverPeticiones unObserver : misObservers) {
            unObserver.notificarPrimo(primo);
        }
    }

    private String generarListaHtml() {
        StringBuilder hmtlPrimos = new StringBuilder();
        ArrayList<Integer> listaPrimos = generarPrimos(numInicio, cantPrimos);
        hmtlPrimos.append("<head><link rel=\"icon\" href=\"data:,\"></head>");// icono
        hmtlPrimos.append("<ul>\n");
        for (int primo : listaPrimos) {
            hmtlPrimos.append(String.format("<li>%d</li>\n", primo));
            // String.format("{\"cosa\": \"%s\"}", info); PARA JSON
        }
        hmtlPrimos.append("</ul>\n");
        return hmtlPrimos.toString();
    }

    private ArrayList<Integer> generarPrimos(int nInicial, int nPrimos) {
        ArrayList<Integer> listaPrimos = new ArrayList<>();
        int contPrimos = 0;
        for (int i = nInicial; contPrimos < nPrimos; i++) {
            if (esPrimo(i)) {
                listaPrimos.add(i);
                notifyAllObservers(i);
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
