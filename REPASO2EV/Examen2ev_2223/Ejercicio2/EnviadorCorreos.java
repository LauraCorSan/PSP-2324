package Examen2ev_2223.Ejercicio2;
// NOTA IMPORTANTE: Esto debe estar en un proyecto maven con las dependencias oportunas

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EnviadorCorreos {

    public static void main(String[] args) throws FileNotFoundException {

        String rutaFMensajes = args[0];
        String rutaFCorreos = args[1];
        int nCifrado = Integer.valueOf(args[2]);
        String usuario = args[3];
        String contrasena = args[4];

        ArrayList<String> listaParCorreoMensaje;
        listaParCorreoMensaje = leerFicheros(rutaFMensajes, rutaFCorreos, nCifrado);
        for (String parDatos : listaParCorreoMensaje) {
            enviarCorreo(parDatos, usuario, contrasena);
        }

    }

    public static ArrayList<String> leerFicheros(String rutaMensajes, String rutaCorreos, int nCifrado) {
        ArrayList<String> listadoParCorreoMensaje = new ArrayList<>();

        // Lectura fichero mensajes
        ArrayList<String> mensajes = new ArrayList<String>();
        try {

            BufferedReader readerMensajes = new BufferedReader(new FileReader(rutaMensajes));
            String lineaMensajes = "";
            String mensaje = "";

            while ((lineaMensajes = readerMensajes.readLine()) != null) {
                mensaje = lineaMensajes;
                mensaje = cifradoCesar(mensaje, nCifrado);
                mensajes.add(mensaje);
            }
            readerMensajes.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lectura ficheros correos
        ArrayList<String> correos = new ArrayList<String>();
        try {

            BufferedReader readerCorreos = new BufferedReader(new FileReader(rutaCorreos));
            String lineaCorreos = "";
            String correo = "";

            while ((lineaCorreos = readerCorreos.readLine()) != null) {
                correo = lineaCorreos;
                correos.add(correo);
            }
            readerCorreos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < mensajes.size(); i++) {
            String correoCorrespondiente = correos.get(i);
            String mensajeCorrepondiente = mensajes.get(i);
            listadoParCorreoMensaje.add(correoCorrespondiente + "-" + mensajeCorrepondiente);
        }

        return listadoParCorreoMensaje;
    }

    public static void enviarCorreo(String parCorreoMensaje, String usuario, String contrasena) {
        String[] informacion = parCorreoMensaje.split("-");
        /*
         * try {
         * Email email = EmailBuilder.startingBlank()
         * .to("Alguien", informacion[0].toString())// posicion 0 es el correo
         * .from("Laura", "laura.cordero6@educa.madrid.org")
         * .withReplyTo("Laura", "laura.cordero6@educa.madrid.org")
         * .withSubject("Proyecto Spamtoso")
         * .withPlainText(informacion[1].toString())// posicion 1 el mensaje
         * .buildEmail();
         * 
         * Mailer mailer = MailerBuilder
         * .withSMTPServer("smtp.educa.madrid.org", 587, usuario, contrasena)
         * .withTransportStrategy(TransportStrategy.SMTP_TLS)
         * .clearEmailValidator() // turns off email validation
         * .buildMailer();
         * mailer.sendMail(email);
         * } catch (Exception e) {
         * System.out.println(e.getMessage());
         * }
         */

    }

    public static String cifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }

}
