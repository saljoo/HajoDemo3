package fi.utu.tech.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    
    private final Socket clientSocket;
    
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    public void run(){
        BufferedReader input = null;
        PrintWriter output = null;
        try {
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            String receivedMessage;
            String response = "Ack";
            while((receivedMessage = input.readLine()) != null){
                if(receivedMessage.equals("Hello")){
                    System.out.println(receivedMessage);
                    output.println(response);
                } else if (receivedMessage.equals("quit")){
                    System.out.println(receivedMessage);
                    clientSocket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
