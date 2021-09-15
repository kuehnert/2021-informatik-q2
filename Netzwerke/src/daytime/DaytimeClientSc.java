package daytime;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DaytimeClientSc {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.2.130.196", 10013);
            Scanner scanner = new Scanner(socket.getInputStream());

            String input = scanner.nextLine();
            System.out.println("Empfangen: " + input);

            socket.close();
        } catch (IOException e) {
            System.err.println("Die Verbindung konnte nicht aufgebaut werden.");
        }
    }
}
