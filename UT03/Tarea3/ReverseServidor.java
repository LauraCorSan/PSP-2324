package Tarea3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReverseServidor {
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
                message = revertirString(message);
                // Envia la respuesta de vuelta al cliente
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String revertirString(String palabra) {
        char[] charArray = palabra.toCharArray();
        int start = 0;
        int end = palabra.length() - 1;

        while (start < end) {
            // Intercambia los caracteres en las posiciones start y end
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            // Mueve los índices hacia el centro de la cadena
            start++;
            end--;
        }

        // Crea una nueva cadena a partir del arreglo de caracteres invertido
        return new String(charArray);
    }
}
