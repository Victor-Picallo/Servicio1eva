package ser1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtoServer {

    public static void main(String[] args) throws IOException {

        int puerto = 6000;

        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en: " + servidor.getLocalPort());

        Socket cliente1 = servidor.accept();
        System.out.println("Se ha conectado el Primer Cliente");
        DataInputStream in = new DataInputStream(cliente1.getInputStream());
        String mensaje = in.readUTF();
        System.out.println("Mensaje recibido: " + mensaje);
        System.out.println("---------------------------------");
        Socket cliente2 = servidor.accept();
        System.out.println("Se ha conectado el Segundo Cliente");
        DataInputStream in2 = new DataInputStream(cliente2.getInputStream());
        String mensaje2 = in2.readUTF();
        System.out.println("Mensaje recibido: " + mensaje2);
        servidor.close();
    }
}
