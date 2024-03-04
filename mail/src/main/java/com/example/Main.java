package com.example;

import java.io.IOException;

public class Main {
        public static void main(String[] args) throws IOException {
                /*
                 * String rutaMensajes = args[0];
                 * String rutaCorreos = args[1];
                 * String correo = args[2];
                 * String password = args[3];
                 */
                String rutaMensajes = "/home/laura/Documents/PSP/mail/src/main/java/com/example/mensajes.txt";
                String rutaCorreos = "/home/laura/Documents/PSP/mail/src/main/java/com/example/correos.txt";
                String correo = "laura.cordero6";
                String password = "tuPassw0rd";
                LectorParaSpam lector1 = new LectorParaSpam(rutaMensajes, rutaCorreos);
                EnviadorSpam enviador1 = new EnviadorSpam(correo, password);
                // EnviadorSpam enviador2 = new EnviadorSpam(correo, password);

                lector1.addObservadores(enviador1);

                lector1.comenzarLectura();
        }
}
