package Examen2ev_2223.Ejercicio3;

public class PrimosHttp {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java MultiThreadedServer <port>");
            System.exit(1);
        }
        int puerto = Integer.parseInt(args[0]);
    }
}
