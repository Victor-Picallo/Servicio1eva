package ser3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPalo {

    public static void main(String[] args) throws IOException {

        int puerto = 5000;

        ServerSocket ss = new ServerSocket(puerto);

        Socket socket = ss.accept();
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
        boolean sigue = true;

        while (sigue) {
            //Lee
            String mensaje = entrada.readUTF();
            System.out.println("Cliente: " + mensaje);

            //Logica de negocio
            if (mensaje.equalsIgnoreCase("quit")) {
                sigue = false;
                salida.writeUTF("Cerrando servidor...");
            } else {
                //Escribe
                if (esPalindromo(mensaje)) {
                    salida.writeUTF("Es palíndromo");
                } else {
                    salida.writeUTF("No es palíndromo");
                }
            }
        }

        //Cerramos el zocalo y los flujos
        socket.close();
        entrada.close();
        salida.close();

        System.out.println("Cerrando servidor...");
        ss.close();
    }

    private static boolean esPalindromo(String mensaje) {
        mensaje = mensaje.toLowerCase().replaceAll("\\s+", ""); // eliminar espacios y poner minúsculas
        String invertido = new StringBuilder(mensaje).reverse().toString();
        return mensaje.equals(invertido);
    }
}
