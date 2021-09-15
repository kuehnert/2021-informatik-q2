package echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = null, tastatur = new Scanner(System.in);
        PrintWriter writer = null;

        try {
            socket = new Socket("10.2.130.196", 10007);
            System.out.println("Verbunden mit 10.2.130.196.");
            scanner = new Scanner(socket.getInputStream());
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Die Verbindung konnte nicht aufgebaut werden.");
            System.exit(1);
        }

        System.out.println(scanner.nextLine());
        scanner.nextLine();

        while (true) {
            // Lies Eingabe über Tastatur & schicke sie an Server
            String userInput = tastatur.nextLine();

            // Wenn "exit" dann beende das Programm
            if (userInput.toLowerCase().equals("exit")) {
                break;
            }

            writer.println(userInput);

            // Lies Ausgabe vom Server und drucke sie auf der Konsole
            try {
                String serverInput = scanner.nextLine();
                System.out.println("Empfangen: " + serverInput);
            } catch (NoSuchElementException e) {
                System.out.println("Server hat die Verbindung beendet.");
                break;
            }
        }

        try {
            socket.close();
        } catch (IOException e) {}
    }
}
