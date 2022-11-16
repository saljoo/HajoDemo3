package fi.utu.tech.assignment2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2345);
            Socket socket = server.accept();
            var input = socket.getInputStream();
            byte[] receivedBytes = input.readAllBytes();
            String receivedMessage = new String(receivedBytes, "utf-8");
            System.out.println(receivedMessage);
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}