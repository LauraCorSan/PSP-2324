package ObserverExamen2ev_2223.Ejercicio1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Enviador implements IObserverDatagrama {
    int puertoEnvio;
    DatagramSocket socketBroadcast;

    public Enviador(int puertoEnvio) {
        // En su constructor creamos el socket que usaremos para enviar
        try {
            socketBroadcast = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.puertoEnvio = puertoEnvio;
    }

    @Override
    public void indicarCambioDatagram(String datosFigura) {
        String cuadrado = GeneradorCuadrado.generar(datosFigura);// generamos cuadrado
        enviar(cuadrado);

    }

    public void enviar(String cuadrado) {
        // enviamos mediante nuestro socket los datos
        try {
            socketBroadcast.setBroadcast(true);// avisar broadcast
            byte buffer[] = cuadrado.getBytes();
            String ip = "192.168.56.255";
            DatagramPacket paquete = new DatagramPacket(
                    buffer,
                    buffer.length,
                    InetAddress.getByName(ip),
                    puertoEnvio);

            socketBroadcast.send(paquete);
            System.out.println("Figura enviada");
            // socketBroadcast.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
