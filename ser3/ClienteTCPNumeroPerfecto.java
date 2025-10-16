package ser3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCPNumeroPerfecto {

    public static void main(String[] args) {

        String servidor = "localhost";
        int puerto = 5000;

        try (Socket socket = new Socket(servidor, puerto);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)
        ){
            System.out.println("Conectado al servidor " + servidor + " en el puerto " + puerto);


            while (true) {
                System.out.println("Introduce un número entero (o negativo para salir):");
                int numero = Integer.parseInt(scanner.nextLine());

                if(numero < 0) {
                    System.out.println("Numero negativo detectado, cerrando cliente...");
                    break;
                }

                salida.println(numero);
                String respuesta = entrada.readLine();
                System.out.println("Respues del servidor: " + respuesta);
            }
        } catch (IOException e) {
            System.err.println("Error al conectar el servidor: " + e.getMessage());
        }
    }
}
