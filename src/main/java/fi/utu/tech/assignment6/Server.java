package fi.utu.tech.assignment6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Hub h = new Hub();
        ServerSocket server = null;
        try {
            server = new ServerSocket(2345);
            while(true){
                Socket socket = server.accept();
                ClientHandler clientSocket = new ClientHandler(socket, h);
                new Thread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
