package ser0;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EjercicioCambiandoMetodos {
    public static void main(String[] args) {

        InetAddress dir = null;
        System.out.println("===============================================");
        System.out.println("SALIDA PARA LOCALHOST: ");
        try {
            // localhost
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);

            // wikipedia
            System.out.println("===============================================");
            dir = InetAddress.getByName("www.wikipedia.org");
            pruebaMetodos(dir);

            // 8.8.8.8
            System.out.println("===============================================");
            dir = InetAddress.getByName("8.8.8.8");
            pruebaMetodos(dir);

            // red local
            System.out.println("===============================================");
            dir = InetAddress.getByName("mi-servidor-local");
            pruebaMetodos(dir);

            // microsoft
            System.out.println("\nTODAS LAS DIRECCIONES IP PARA MICROSOFT");
            InetAddress[] direcciones = InetAddress.getAllByName("www.microsoft.com");
            for (int i = 0; i < direcciones.length; i++) {
                pruebaMetodos(direcciones[i]);
            }
            System.out.println("===============================================");

        } catch (UnknownHostException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void pruebaMetodos(InetAddress dir) {
        System.out.println("\tMetodo getByName(): " + dir);
        InetAddress dir2 = null;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // USAMOS MÉTODOS DE LA CLASE
        System.out.println("\tMetodo getHostName(): " + dir.getHostName());
        System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\tMetodo toString(): " + dir.toString());
        System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
    }
}