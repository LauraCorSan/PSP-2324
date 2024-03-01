package ObserverExamen2ev_2223.Ejercicio1;

public class FiguraMain {
    public static void main(String[] args) {
        int puertoEscucha = Integer.valueOf(args[0]);
        int puertoEnvio = Integer.valueOf(args[1]);

        Receptor miReceptor = new Receptor(puertoEscucha);
        Enviador miEnviador = new Enviador(puertoEnvio);
        miReceptor.setCambioDatagramaListener(miEnviador);
        while (miReceptor.recibir())
            ;
    }
}
