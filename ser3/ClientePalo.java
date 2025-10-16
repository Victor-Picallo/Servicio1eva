package ser3;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientePalo {

    public static void main(String[] args) {

        String servidor = "localhost";
        int puerto = 5000;

        try (Socket socket = new Socket(servidor, puerto)) {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            String mensaje;

            System.out.println("Conectado al servidor. Escribe una texto (o 'quit' para salir): ");

            while (true) {
                mensaje = sc.nextLine();
                salida.writeUTF(mensaje);

                if (mensaje.equalsIgnoreCase("quit")) {
                    System.out.println("Cerrando cliente...");
                    break;
                }

                String respuesta = entrada.readUTF();
                System.out.println("Servidor: " + respuesta);
            }

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
