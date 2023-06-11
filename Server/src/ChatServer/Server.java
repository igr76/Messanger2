package ChatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server implements  TCPConnectionListener{
    public static void main(String[] args) {
        new Server();
    }
    private final ArrayList<TCPConnection> connections = new ArrayList<>();
    private Server() {
        System.out.println("Server running...");
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            while (true) {
                try {
                    new TCPConnection(this, serverSocket.accept());
                } catch (IOException e) {
                    System.out.println("TCPconnection Exception");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {

    }

    @Override
    public synchronized void onReseiveString(TCPConnection tcpConnection, String value) {

    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {

    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {

    }
}