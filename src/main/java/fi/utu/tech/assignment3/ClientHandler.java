package fi.utu.tech.assignment3;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{

    private final Socket clientSocket;
    
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    public void run(){
        try {
            var input = clientSocket.getInputStream();
            byte[] receivedBytes = input.readAllBytes();
            String receivedMessage = new String(receivedBytes, "utf-8");
            System.out.println(receivedMessage);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
