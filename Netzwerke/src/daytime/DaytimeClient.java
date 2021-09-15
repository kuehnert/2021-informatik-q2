package daytime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.2.130.196", 10013);
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String input = reader.readLine();
            System.out.println("Empfangen: " + input);

            socket.close();
        } catch (IOException e) {
            System.err.println("Die Verbindung konnte nicht aufgebaut werden.");
        }
    }
}
