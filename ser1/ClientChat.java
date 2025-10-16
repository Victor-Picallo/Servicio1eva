package ser1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {

    public static void main(String[] args) {

        //String host = "10.101.3.86";
        String host = "localhost";
        int puerto = 6000;

        try {
            //Crear socket cliente conectado a Host Puerto
            Socket client = new Socket(host, puerto);
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());

            //Muy util
            System.out.println("Datos de conexion externa");
            System.out.println("Puerto remoto: " + client.getPort());
            //Host del servidor al que nos conectamos
            System.out.println("Host remoto: " + client.getInetAddress().getHostName());
            System.out.println("IP Host remoto: " + client.getInetAddress().toString());

            Scanner sc = new Scanner(System.in);
            System.out.println("Conectado al servidor");
            System.out.println("Para salir el cualquier momento escribe 'salir'");
            String msg;

            while (true) {
                System.out.print("Tu: ");
                msg = sc.nextLine();
                out.writeUTF(msg);
                if (msg.equalsIgnoreCase("salir")) {
                    break;
                }
                String respuesta = in.readUTF();
                System.out.println("Servidor: " + respuesta);

            }
            client.close();
        } catch (IOException e) {
            System.err.println("Error de conexion " + e.getMessage());
        }

    }
}
