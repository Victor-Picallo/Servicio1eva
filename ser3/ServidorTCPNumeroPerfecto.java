package ser3;

import java.io.*;
import java.net.*;

public class ServidorTCPNumeroPerfecto {

    // Método para comprobar si un número es perfecto
    public static boolean esNumeroPerfecto(int numero) {
        if (numero < 1) {
            return false;
        }
        int suma = 0;
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma == numero;
    }

    public static void main(String[] args) {
        int puerto = 5000; // Puerto del servidor

        //con recursos
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor TCP escuchando en el puerto " + puerto);

            while (true) {
                //try con recursos
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Cliente conectado: " + socket.getInetAddress());

                    BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

                    // Leer el número enviado por el cliente
                    String linea;
                    while ((linea = entrada.readLine()) != null) {
                        int numero = Integer.parseInt(linea);

                        if (numero < 0) {
                            System.out.println("Número negativo detectado. Cerrando conexión.");
                            break; // Sale del ciclo y cierra socket automáticamente
                        }

                        // Comprobar si es número perfecto
                        boolean perfecto = esNumeroPerfecto(numero);

                        // Enviar respuesta al cliente
                        if (perfecto) {
                            salida.println(numero + " es un número perfecto.");
                        } else {
                            salida.println(numero + " no es un número perfecto.");
                        }

                        System.out.println("Procesado el número: " + numero);
                    }

                } catch (IOException | NumberFormatException e) {
                    System.err.println("Error procesando conexión: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error inicializando servidor: " + e.getMessage());
        }
    }
}
