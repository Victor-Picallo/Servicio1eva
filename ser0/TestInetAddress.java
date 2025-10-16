package ser0;


import java.net.*;

public class TestInetAddress {
    public static void main(String[] args) {

        InetAddress dir = null;
        System.out.println("===============================================");
        System.out.println("SALIDA PARA LOCALHOST: ");
        try {
            // LOCALHOST
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);

            // URL www.google.es
            System.out.println("===============================================");
            dir = InetAddress.getByName("www.google.es");
            pruebaMetodos(dir);

            // Array de tipo InetAddress con todas las direcciones IP asignadas a google.es
            System.out.println("\nTODAS LAS DIRECCIONES IP PARA GOOGLE");
            InetAddress[] direcciones = InetAddress.getAllByName("www.google.es");
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


