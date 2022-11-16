package fi.utu.tech.assignment1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2345);
            Socket socket = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
