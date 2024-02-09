package UDP.Tarea2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EcoCliente {
    private static final int MAX_LENGTH = 65535;
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Dirección del servidor
            byte[] sendData = new byte[MAX_LENGTH];
            String sentence = "Hola desde el cliente"; // Mensaje a enviar
            sendData = sentence.getBytes();

            // Envía el paquete al servidor
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PORT);
            socket.send(sendPacket);

            // Recibe la respuesta del servidor
            byte[] receivedData = new byte[MAX_LENGTH];
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
            socket.receive(receivedPacket);

            // Extrae la información del paquete
            String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            System.out.println("Respuesta del servidor: " + message);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
