package Tarea1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        String miIp = args[0];
        int miPuerto = Integer.valueOf(args[1]);
        String msg = (args[2]);
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ipAddress = InetAddress.getByName(miIp); // Dirección del servidor
            byte[] sendData = new byte[1024];
            // String sentence = "Hola desde el cliente"; // Mensaje a enviar
            // sendData = sentence.getBytes();
            sendData = msg.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, miPuerto);
            socket.send(sendPacket); // Envía el paquete al servidor
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}