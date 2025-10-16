package ser1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ProtoCliente {

    public static void main(String[] args) throws IOException {

        String host = "10.101.3.86";
        //String host = "localhost";
        int puerto = 6000;

        try {
            //Crear socket cliente conectado a Host Puerto
            Socket client = new Socket(host, puerto);
            //Contener direccion InetAddress del cliente
            InetAddress inetAddress = client.getInetAddress();
            System.out.println("Datos de conexion propia");
            System.out.println("IP local usada por el cliente: " + inetAddress.toString());

            //No muy util
            System.out.println("Puerto local: " + client.getLocalPort());
            //Muy util
            System.out.println("Datos de conexion externa");
            System.out.println("Puerto remoto: " + client.getPort());
            //Host del servidor al que nos conectamos
            System.out.println("Host remoto: " + client.getInetAddress().getHostName());
            System.out.println("IP Host remoto: " + inetAddress.getHostAddress());

            //Voy a escribir algo
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Hola me llamo Victor");

            client.close();
        } catch (IOException e) {
            System.err.println("Error de conexion " + e.getMessage());
        }
    }
}
