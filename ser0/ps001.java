package ser0;

import java.net.*;
import java.io.*;

public class ps001 {

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://www.hoxe.vigo.org/?lang=cas");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedReader in = null;
        try {
            InputStream inputStream = url.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



