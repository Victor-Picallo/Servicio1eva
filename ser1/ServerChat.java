package ser1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {

    public static void main(String[] args) throws IOException {

        int puerto = 6000;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Escuchando en: " + servidor.getLocalPort());
            System.out.println("Servicio de chat....");

            Socket cliente1 = servidor.accept();
            DataInputStream in = new DataInputStream(cliente1.getInputStream());
            DataOutputStream out = new DataOutputStream(cliente1.getOutputStream());
            System.out.println("Se ha conectado el Primer Cliente");
            String msg;
            while (true) {
                msg = in.readUTF();
                System.out.println("Cliente: " + msg);
                if (msg.equalsIgnoreCase("salir")) {
                    out.writeUTF("salir");
                    break;
                }
                out.writeUTF(msg);
            }
            System.out.println("Cerrando conexion...");
            servidor.close();
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
