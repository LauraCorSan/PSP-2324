package Tarea1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//TODO Cambiar puerto y mensaje tanto para server como para cliente

public class UDPServer {
    public static void main(String[] args) {
        int miPuerto = Integer.valueOf(args[0]);
        try {
            DatagramSocket socket = new DatagramSocket(miPuerto); // Abre el socket en el puerto 9876
            byte[] receivedData = new byte[1024];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(receivedPacket); // Espera y recibe el paquete

                // Extrae la información del paquete
                String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Mensaje recibido: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
