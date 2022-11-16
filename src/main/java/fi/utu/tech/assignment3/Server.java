package fi.utu.tech.assignment3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(2345);
            while(true){
                Socket socket = server.accept();
                ClientHandler clientSocket = new ClientHandler(socket);
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
