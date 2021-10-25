package wahlserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WahlServer {
    public static final int PORT = 10013;

    public static void main(String[] args) {
        Stimmenliste stimmenliste = new Stimmenliste();
        ServerSocket server = null;

        System.out.println("Starte MSO-Wahl-Server auf Port " + PORT);

        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Konnte Server auf Port " + PORT + " nicht starten!");
            System.err.println(e.getMessage());
            System.exit(1);
        }

        System.out.println("Warte auf Verbindungen");
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        while (true) {
            try {
                socket = server.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.err.println("Fehler bei Verbindung mit Client!");
                System.err.println(e.getMessage());
                System.exit(1);
            }

            System.out.println("Client verbunden");
            // Hier haben wir jetzt eine lebendige Verbindung zu einem Client
            String response;
            try {
                response = reader.readLine();
                System.out.printf("Empfangen: '%s'%n", response);
            } catch (Exception e) {
                // Unterbrich die Schleife
                try {
                    socket.close();
                } catch (IOException ioe) {
                    // nothing to do
                }

                break;
            }

            if (response.equalsIgnoreCase("ERGEBNIS")) {
                int[] wahl1 = stimmenliste.holeWahlergebnis();
                String out = "";
                for (int i = 0; i < Parteiliste.PARTEIEN.length; i++) {
                    out += Parteiliste.PARTEIEN[i] + ": " + wahl1[i] + " Stimmen\n";
                }
                writer.println(out);
            } else {
                // System.out.println("Interpretieren der Eingabe");
                // System.out.println("Protokoll: Ist die Eingabe 'ERGEBNIS', sende das Wahlergebnis");
                // System.out.println("Sonst erwarte die Zahlen in Form von '<id>:<stufe>:<wahl1>:<wahl2>");
                int[] zahlen;

                try {
                    // Trenne Eingabe String an ":"-Zeichen
                    String[] zahlenStrings = response.split(":");
                    zahlen = new int[zahlenStrings.length];

                    // Wandle die einzelnen Zahlen in Strings um
                    for (int i = 0; i < zahlenStrings.length; i++) {
                        zahlen[i] = Integer.parseInt(zahlenStrings[i]);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Fehler beim Umwandeln in Zahlen");
                    writer.println("-Fehler beim Umwandeln in Zahlen");
                    zahlen = null;
                }

                if (zahlen != null) {
                    boolean success = stimmenliste.stimmeAbgeben(zahlen[0], zahlen[1], zahlen[2], zahlen[3]);
                    if (success) {
                        writer.println("+Deine Stimme wurde gezählt");
                    } else {
                        writer.println("-Fehler in der Eingabe");
                    }
                }
            }

            System.out.println("Trenne Verbindung zum Client");
            try {
                socket.close();
            } catch (IOException e) {
                System.exit(1);
            }
        }
    }
}
