package pop3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class POP3Client {
    private static final String HOST = "10.2.130.196";
    private static final int PORT = 10119;
    private static final String USER = "anna";
    private static final String PASSWORD = "geheim";
    private String host;
    private int port;
    private int mailCount = -1;
    private Socket socket = null;
    private BufferedReader reader = null;
    private PrintWriter writer = null;

    public POP3Client(String host, int port) {
        this.host = host;
        this.port = port;
        connect();
    }

    public static void main(String[] args) {
        String host = (args.length > 0 && args[0] != null) ? args[0] : HOST;
        int port = (args.length > 1 && args[1] != null) ? Integer.parseInt(args[1]) : PORT;

        var client = new POP3Client(host, port);
        client.login();
        client.getMailCount();
        client.checkMails();
    }

    private String myReadLine() {
        String res = "";
        do {
            try {
                res = reader.readLine();
                System.out.println("myReadLine: " + res);
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        } while (res.equals(""));

        return res;
    }

    private String readMail(int i) {
        System.out.println("Lade E-Mail Nr " +i+ " herunter.");
        writer.printf("RETR 1%n");
        String res;

        do {
            res = myReadLine();
            System.out.println("Empfangen: '" + res + "'");
        } while (!res.equals("."));

        return "Die ganze Mail";
    }

    private void connect() {
        // 1. Verbinde mit Server
        try {
            socket = new Socket(host, port);
            System.out.printf("Verbunden mit %s auf Port %d%n", host, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            String in = reader.readLine();
            if (in.startsWith("+OK")) {
                System.out.println("Mit Server verbunden");
            } else {
                System.err.println("Verbindung mit Server fehlgeschlagen: " + in);
                socket.close();
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.printf("Die Verbindung mit %s auf Port %d konnte nicht aufgebaut werden.", host, port);
            System.exit(1);
        }
    }

    private void login() {
        // 2. Sende Benutzernamen
        String res = null;
        writer.printf("USER %s%n", USER);
        res = myReadLine();
        // System.out.println("Empfangen: '" + res + "'");

        // 3. Sende Passwort
        writer.printf("PASS %s%n", PASSWORD);
        res = myReadLine();
        // System.out.println("Empfangen: '" + res + "'");

        if (res.startsWith("-")) {
            System.out.println("Fehler beim Anmelden.");
            System.exit(0);
        }

        System.out.println("Beim Server authentiziert.");
    }

    private void getMailCount() {
        // 4. Hole Liste mit Mails
        //   1. Instanzvariable mailCount
        //   2. Methode getMailCount
        //   3. die Methode aufrufen
        writer.printf("LIST%n");
        String res = myReadLine();
        if (res.startsWith("+")) {
            var regex = Pattern.compile("\\+OK mailbox has (\\d+) messages");
            Matcher m = regex.matcher(res);
            if (m.find()) {
                String mailCountStr = m.group(1);
                mailCount = Integer.parseInt(mailCountStr);
            }
        } else {
            System.out.println("Fehler beim Abrufen der E-Mailliste");
            System.exit(0);
        }


        int lastIndex = -1;
        while (true) {
            res = myReadLine();
            if (res.equals(".")) {
                break;
            }

            String[] werte = res.split(" ");
            String ersteZahl = werte[0];
            lastIndex = Integer.parseInt(ersteZahl);
        }

        // mailCount = lastIndex;


        System.out.printf("Sie haben %d neue E-Mails%n", mailCount);
    }

    /*
    HA:
    1. Rufen Sie alle E-Mails nacheinander ab und formatieren Sie sie sinnvoll
    2. Verbesserungen:
        a) Stellen Sie den Header hübsch auf Deutsch dar
        b) Löschen Sie jede Nachricht nach Abruf
        c) Vor Beenden User fragen, ob alle Mails gelöscht werden soll
     */

    public void checkMails() {
        // 5. Rufe Mails nacheinander ab
        for (int i = 1; i <= mailCount; i++) {
            readMail(i);
        }

        // 6. Schließe die Verbindung
        System.out.println("Trenne die Verbindung zum Server.");
        try {
            socket.close();
        } catch (IOException e) {}
    }
}
