package ser4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//Servidor de numeros narcicistas SOLO FUNCIONA CON NUMEROS DE 3 CIFRAS, no puede escribir letras ni numeros de mas de 3 cifras ni negativos
public class ServerNarcicista {

    public static void main(String[] args) throws IOException {

        int puerto = 9876;

        DatagramSocket socket = new DatagramSocket(puerto);
        byte[] recibir = new byte[1024];
        byte[] enviar;

        System.out.println("Servidor UDP iniciado en puerto " + puerto);

        boolean corta = false;
        while (!corta) {
            // Prepara el paquete
            DatagramPacket recibirDatos = new DatagramPacket(recibir, recibir.length);
            // Recibir datos
            socket.receive(recibirDatos);
            // Convertir a cadena
            String cadena = new String(recibirDatos.getData(), 0, recibirDatos.getLength());
            System.out.println("Numero recibido: " + cadena);

            if (!cadena.equals("quit")) {
                // Aplica el servicio
                String devolver = comprobarNarcicista(cadena);
                // Preparo el array
                enviar = devolver.getBytes();
                // Preparo el paquete
                DatagramPacket enviarDatos = new DatagramPacket(enviar, enviar.length, recibirDatos.getAddress(),
                        recibirDatos.getPort());
                // Enviar datos
                socket.send(enviarDatos);
            } else {
                corta = !corta;
                System.out.println("Cerrando servidor...");
            }
        }
        socket.close();
        System.out.println("Servidor cerrado.");
    }

    // Metodo para comprobar si un numero es narcicista
    public static String comprobarNarcicista(String cadena) {
        int num = Integer.parseInt(cadena);
        boolean esNarcicista = false;

        if (cadena.length() == 3) {
            int centenas = num / 100;
            int decenas = (num / 10) % 10;
            int unidades = num % 10;

            int sumaCubos = (centenas * centenas * centenas) + (decenas * decenas * decenas)
                    + (unidades * unidades * unidades);

            // Filtro para 3 numeros y que no se puedan escribir letras
            if (sumaCubos == num) {
                esNarcicista = true;
            }
        } else {
            return "Error: Introduce un numero de 3 cifras.";
        }

        if (esNarcicista)
            return cadena + " es un numero narcicista.";
        else
            return cadena + " no es un numero narcicista.";
    }
}
