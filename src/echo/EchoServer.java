package echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class EchoServer {
    public static final int PORT = 10013;

    // Warnung: throws verhindert, dass Fehler an der richtigen Stelle
    // reportet werden
    // 1. Server soll IP Adresse
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        server = new ServerSocket(PORT);
        Socket socket = null;
        PrintWriter writer = null;
        Scanner reader = null;

        // Gibt 0.0.0.0 zurück
        String ip = server.getInetAddress().getHostAddress();
        System.out.println("Server auf " + ip);

        String ip2 = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Server auf " + ip2);

        /*
        while (false) {
            socket = server.accept();
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new Scanner(socket.getInputStream());
            String response = "dummy";

            while (true) {
                response = reader.nextLine();
                if (response == null || response.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(response);
            }

            socket.close();
        }
*/
        server.close();
    }
}
