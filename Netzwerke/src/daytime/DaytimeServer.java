package daytime;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer {
    public static final int PORT = 10013;

    public static void main(String[] args) {
        System.out.println("Starte Daytime Server auf Port " + PORT);
        ServerSocket server = null;

        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Konnte Server auf Port " + PORT + " nicht starten!");
            System.err.println(e.getMessage());
            System.exit(1);
        }

        System.out.println("Warte auf Verbindungen");
        // Accept macht 2 Dinge:
        // 1. Wartet auf eine Verbindung von einem Client
        // 2. Wenn sich einer Verbindet, erzeugt es eine (normale Client) Socket
        Socket socket = null;
        PrintWriter writer = null;

        while (true) {
            try {
                socket = server.accept();
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.err.println("Fehler bei Verbindung mit Client!");
                System.err.println(e.getMessage());
                System.exit(1);
            }

            // Hier haben wir jetzt eine lebendig1e Verbindung zu einem Client
            System.out.println("Sende Uhrzeit an Client");
            writer.println("Hallo, hier ist Ihr Zeitserver. Es ist Mittag (" + new Date().toString() + "). Guten " +
                    "Appetit!");

            System.out.println("Trenne Verbindung zum Client");
            try {
                socket.close();
            } catch (IOException e) {
                System.exit(1);
            }
        }
    }
}
