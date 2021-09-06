package scanner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class PortScanner {
    public static void scanIPs() {
        try {
            InetAddress.getByName("10.2.130.65").isReachable(200);
            System.out.println("Kann xcxx erreichen!");
        } catch (IOException e) {
            // Fail silently
        }
    }

    public static void scanPorts() {
        int MIN_PORT = 10_000;
        int MAX_PORT = 10_050;
        int TIME_OUT = 200;
        var portList = new ArrayList<Integer>();

        for (int port = MIN_PORT; port < MAX_PORT; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("127.0.0.1", port), TIME_OUT);
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
