package ser4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

//Cliente de numeros narcicistas
public class ClientNarcicista {

    public static void main(String[] args) throws IOException {

        String servidorHost = "localhost";
        int puertoServidor = 9876;
        boolean corta = false;
        Scanner sc = new Scanner(System.in);

        DatagramSocket client = new DatagramSocket();
        InetAddress adress = InetAddress.getByName(servidorHost);

        while (!corta) {
            System.out.println("Escribe un numero de 3 cifras (o 'quit' para salir): ");
            String cadena = sc.nextLine();
            byte[] enviarBuffer = cadena.getBytes();
            byte[] recibirBuffer = new byte[1024];
            DatagramPacket enviarPaquete = new DatagramPacket(enviarBuffer, enviarBuffer.length, adress,
                    puertoServidor);
            client.send(enviarPaquete);
            if (!cadena.equalsIgnoreCase("quit")) {

                DatagramPacket recibirPaquete = new DatagramPacket(recibirBuffer, recibirBuffer.length);
                client.receive(recibirPaquete);

                String respuesta = new String(recibirPaquete.getData(), 0, recibirPaquete.getLength());
                System.out.println("Respuesta del servidor: " + respuesta);
            } else
                corta = true;
        }
        client.close();
        sc.close();
        System.out.println("Cliente cerrado.");
    }

}
