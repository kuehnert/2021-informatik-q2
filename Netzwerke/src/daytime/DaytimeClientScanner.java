package daytime;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DaytimeClientScanner {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = null;

        try {
            socket = new Socket("10.2.130.196", 10013);
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            System.err.println("Die Verbindung konnte nicht aufgebaut werden.");
            System.exit(1);
        }

        String input = scanner.nextLine();
        System.out.println("Empfangen: " + input);

        try {
            socket.close();
        } catch (IOException e) {
        }
    }
}
