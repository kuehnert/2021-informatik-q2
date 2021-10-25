package scanner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

public class NetzScanner {
    public static void scanIPs() {
        String netzwerkAnteil = "10.2.130.";

        for (int i = 1; i < 255; i++) {
            try {
                String ip = netzwerkAnteil + i;
                InetAddress.getByName(ip).isReachable(200);
                System.out.println("Kann ip erreichen!");
                scanPorts(ip);
            } catch (IOException e) {
                // Fail silently
                System.out.print(".");
            }
        }
    }

    public static void scanPorts() {
        scanPorts("127.0.0.1");
    }

    public static void scanPorts(String ip) {
        int MIN_PORT = 1;
        int MAX_PORT = 80;
        int TIME_OUT = 200;
        var portList = new ArrayList<Integer>();

        for (int port = MIN_PORT; port < MAX_PORT; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ip, port), TIME_OUT);
                System.out.print("X");
                portList.add(port);
                socket.close();
            } catch (IOException e) {
                System.out.print(".");
            }
        }

        System.out.print("\nFolgende Ports sind geöffnet: ");
        System.out.println(portList.toString());
    }

    public static void main(String[] args) {
        scanIPs();
    }
}
