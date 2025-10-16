package ser0;

import java.net.*;
import java.io.*;

public class ps002 {

    public static void main(String[] args) {

        URL url = null;
        URLConnection urlCon = null;
        try {
            url = new URL("http://www.elaltozano.es");
            urlCon = url.openConnection();

            InputStream inputStream = urlCon.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);

            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//EjemploUrlCon


