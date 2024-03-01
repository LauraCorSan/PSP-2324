package ObserverExamen2ev_2223.Ejercicio1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

public class Receptor {
    private static final int MAX_LENGTH = 65535;
    private static final String COM_FIN = "fin";
    ArrayList<IObserverDatagrama> misObservers;
    DatagramSocket socketEscuchador;

    public Receptor(int puertoEscucha) {
        try {
            socketEscuchador = new DatagramSocket(puertoEscucha);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public boolean recibir() {
        try {
            System.out.println("Escuchando...");
            byte[] receivedData = new byte[MAX_LENGTH];
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
            socketEscuchador.receive(receivedPacket);
            String datosFigura = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            if (!datosFigura.equalsIgnoreCase(COM_FIN)) {
                notificar(datosFigura);
                return true;
            } else {
                socketEscuchador.close();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;// es mas preventivo que nada
    }

    public void setCambioDatagramaListener(IObserverDatagrama unSuscriptor) {
        misObservers.add(unSuscriptor);
    }

    public void notificar(String datosFigura) {
        for (IObserverDatagrama unObserver : misObservers) {
            unObserver.indicarCambioDatagram(datosFigura);
        }
    }

}
