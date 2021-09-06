package echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoServerThreaded {
    public static final int PORT = 10013;

    // Warnung: throws verhindert, dass Fehler an der richtigen Stelle
    // reportet werden
    // 1. Server soll IP Adresse
    public static void main(String[] args) {
        ServerSocket server = null; Socket socket = null;

        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Fehler beim Erstellen der Server Socket! Exiting."); System.exit(1);
        }

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            //            System.out.println("Server auf IP " + ip + " und Port " + PORT);
            System.out.println("Server auf IP 10.2.130.196 und Port " + PORT);
        } catch (UnknownHostException e) {
            System.err.println("IP konnte nicht bestimmt werden! Exiting."); System.exit(1);
        }

        while (true) {
            try {
                socket = server.accept();
                ClientHandler newClient = new ClientHandler(socket);
                newClient.start();
            } catch (IOException e) {
                System.err.println("Server wurde gestoppt."); break;
            }
        }

        try {
            server.close();
        } catch (IOException e) {
            System.err.println("Fehler beim Schließen des Servers");
        }
    }
}

class ClientHandler extends Thread {
    private Socket client;
    private PrintWriter writer = null;
    private Scanner reader = null;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println("Neuer Client verbunden: " + client.getInetAddress().getHostAddress());
        try {
            writer = new PrintWriter(client.getOutputStream(), true);
            reader = new Scanner(client.getInputStream());
        } catch (IOException e) {
            System.err.println("Fehler beim Kommunizieren mit Client");
            return;
        }

        String response = "dummy";

        while (true) {
            response = reader.nextLine(); if (response == null || response.equalsIgnoreCase("exit")) {
                break;
            }

            writer.println(response);
        }

        try {
            client.close(); System.out.println("Client getrennt.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schließen der Socket");
        }
    }
}
