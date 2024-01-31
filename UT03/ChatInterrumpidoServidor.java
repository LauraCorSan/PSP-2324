import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ChatInterrumpidoServidor {
    public static final int NUM_USUARIOS = 2;
    private static final int MAX_LENGTH = 65535;
    private static final int PORT = 9876;
    public static boolean continuar = true;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Servidor de Eco esperando conexiones en el puerto " + PORT);

            // Start a new thread for receiving messages
            Thread receiveThread = new Thread(() -> {
                while (continuar) {
                    DatagramPacket packageCliente = recibir(socket);
                    enviar(socket, packageCliente);
                }
            });
            receiveThread.start();

            // Main thread for user input
            while (continuar) {
                // You can add more logic for the server if needed
                // For example, handling special commands from the user
            }

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatagramPacket recibir(DatagramSocket socket) {
        try {
            byte[] receivedData = new byte[MAX_LENGTH];

            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
            socket.receive(receivedPacket); // Espera y recibe el paquete

            // Extrae la información del paquete
            String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            System.out.println("cliente: " + message);

            return receivedPacket;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void enviar(DatagramSocket socket, DatagramPacket receivedPacket) {
        try {
            InetAddress clientAddress = receivedPacket.getAddress();
            int clientPort = receivedPacket.getPort();
            System.out.print("server: ");
            String message = sc.nextLine();// Mensaje a enviar
            // Envia la respuesta de vuelta al cliente
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
