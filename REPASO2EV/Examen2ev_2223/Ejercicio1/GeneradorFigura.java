package Examen2ev_2223.Ejercicio1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GeneradorFigura {
    private static final int MAX_LENGTH = 65535;
    private static final String COM_FIN = "fin";
    static int puertoEscucha;
    static int puertoEnvio;

    public static void main(String[] args) {
        puertoEscucha = Integer.valueOf(args[0]);
        puertoEnvio = Integer.valueOf(args[1]);
        String mensaje = "";

        try {
            DatagramSocket socketEscucha = new DatagramSocket(puertoEscucha);
            DatagramSocket socketBroadcast = new DatagramSocket();
            socketBroadcast.setBroadcast(true);

            boolean continuar = true;

            while (continuar) {
                mensaje = recibir(socketEscucha);
                mensaje = mensaje.substring(0, mensaje.length() - 1);
                continuar = !mensaje.equalsIgnoreCase(COM_FIN);
                if (continuar) {
                    String figura = crearFigura(mensaje);
                    enviar(socketBroadcast, figura);
                }
            }
            socketEscucha.close();
            socketBroadcast.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String recibir(DatagramSocket socket) {
        String message = "";

        try {
            System.out.println("Escuchando...");
            // Recibe el mensaje escuchado
            byte[] receivedData = new byte[MAX_LENGTH];
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
            socket.receive(receivedPacket);

            // Extrae la información del paquete
            message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    public static void enviar(DatagramSocket socket, String figura) {
        try {
            byte buffer[] = figura.getBytes();
            // String ip = "255.255.255.255";
            String ip = "192.168.56.255";
            DatagramPacket paquete = new DatagramPacket(
                    buffer,
                    buffer.length,
                    InetAddress.getByName(ip),
                    puertoEnvio);

            socket.send(paquete);
            System.out.println("Figura enviada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String crearFigura(String formato) {
        StringBuilder miFigura = new StringBuilder();
        String[] datos = formato.split(" ");
        int altura = Integer.valueOf(datos[0]);
        int ancho = Integer.valueOf(datos[1]);
        char caracter = datos[2].charAt(0);
        System.out.println("CreandoFigura");
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= ancho; j++) {
                if (i == 1 || i == altura) {
                    miFigura.append(caracter);
                } else {
                    if (j == 1 || j == ancho) {
                        miFigura.append(caracter);
                    } else {
                        miFigura.append(" ");
                    }
                }
            }
            miFigura.append("\n");
        }

        return miFigura.toString();
    }

}