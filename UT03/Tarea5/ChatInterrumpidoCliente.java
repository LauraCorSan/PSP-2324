package Tarea5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ChatInterrumpidoCliente {
    private static final int MAX_LENGTH = 65535;
    public static int port;
    public static String ipServer;
    public static boolean continuar = true;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Recibimos la IP y el port por argumentos
        ipServer = args[0];
        port = Integer.valueOf(args[1]);
        try {
            DatagramSocket socket = new DatagramSocket();
            Thread hiloEnviador = new Thread(() -> {
                while (continuar) {
                    enviar(socket);
                }
            });
            Thread hiloRecibidor = new Thread(() -> {
                while (continuar) {
                    recibir(socket);
                }
            });
            hiloEnviador.start();
            hiloRecibidor.start();

            hiloEnviador.join();
            hiloRecibidor.join();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void recibir(DatagramSocket socket) {
        try {
            // Recibe la respuesta del servidor
            byte[] receivedData = new byte[MAX_LENGTH];
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
            socket.receive(receivedPacket);

            // Extrae la información del paquete
            String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            // Muestra informacion del servidor
            System.out.println("server: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enviar(DatagramSocket socket) {
        try {
            InetAddress serverAddress = InetAddress.getByName(ipServer); // Dirección del servidor
            byte[] sendData = new byte[MAX_LENGTH];
            // Solicitamos texto al usurio
            System.out.print("cliente: ");
            String sentence = sc.nextLine();// Mensaje a enviar

            sendData = sentence.getBytes();

            // Envía el paquete al servidor
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
            socket.send(sendPacket);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
