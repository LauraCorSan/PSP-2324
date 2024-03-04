package ObserverExamen2ev_2223.Ejercicio1;

public class FiguraMain {
    public static void main(String[] args) {
        // recogemos los puertos
        int puertoEscucha = Integer.valueOf(args[0]);
        int puertoEnvio = Integer.valueOf(args[1]);

        Receptor miReceptor = new Receptor(puertoEscucha);
        Enviador miEnviador = new Enviador(puertoEnvio);
        miReceptor.setCambioDatagramaListener(miEnviador);// añadimos enviador a lista de observer de receptor
        while (miReceptor.recibir())
            ;// recibimos siempre que se pueda
    }
}
