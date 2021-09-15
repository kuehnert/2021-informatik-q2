package echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Scanner;

public class EchoServer {
    public static final int PORT = 10013;

    // Warnung: throws verhindert, dass Fehler an der richtigen Stelle
    // reportet werden
    // 1. Server soll IP Adresse
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        PrintWriter writer = null;
        Scanner reader = null;

        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Fehler beim Erstellen der Server Socket! Exiting.");
            System.exit(1);
        }

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
//            System.out.println("Server auf IP " + ip + " und Port " + PORT);
            System.out.println("Server auf IP 10.2.130.196 und Port " + PORT);
        } catch (UnknownHostException e) {
            System.err.println("IP konnte nicht bestimmt werden! Exiting.");
            System.exit(1);
        }

        while (true) {
            try {
                socket = server.accept();
                writer = new PrintWriter(socket.getOutputStream(), true);
                reader = new Scanner(socket.getInputStream());
                System.out.println("Neuer Client verbunden: " + socket.getInetAddress().getHostAddress());
            } catch (IOException e) {
                break;
            }

            String response = "dummy";

            while (true) {
                response = reader.nextLine();
                if (response == null || response.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(response);
            }

            try {
                socket.close();
                System.out.println("Client getrennt.");
            } catch (IOException e) {
                System.err.println("Fehler beim Schließen der Socket");
                return;
            }
        }

        try {
            server.close();
        } catch (IOException e) {
            System.err.println("Fehler beim Schließen des Servers");
        }
    }
}
