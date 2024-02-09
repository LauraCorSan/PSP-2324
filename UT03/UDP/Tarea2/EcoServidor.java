package UDP.Tarea2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EcoServidor {
    private static final int MAX_LENGTH = 65535;
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT); // Abre el socket en el puerto 9876
            byte[] receivedData = new byte[MAX_LENGTH];

            System.out.println("Servidor de Eco esperando conexiones en el puerto " + PORT);

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(receivedPacket); // Espera y recibe el paquete

                // Extrae la información del paquete
                String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Mensaje recibido del cliente: " + message);

                InetAddress clientAddress = receivedPacket.getAddress();
                int clientPort = receivedPacket.getPort();
                message = "Hola desde el servidor";
                // Envia la respuesta de vuelta al cliente
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
