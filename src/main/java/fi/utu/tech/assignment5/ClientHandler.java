package fi.utu.tech.assignment5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    public void run(){
        BufferedReader input = null;
        String[] splittedString;
        try {
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String receivedMessage = input.readLine();
            splittedString = receivedMessage.split(";");
            switch (splittedString.length){
                case 2:
                    switch (splittedString[1]){
                        case "ON":
                            System.out.println("Kytketään lamppu PÄÄLLE");
                            break;
                        case "OFF":
                            System.out.println("Kytketään lamppu POIS");
                            break;
                        case "QUERY":
                            System.out.println("Kyselykomento vastaanotettu");
                            break;
                    }
                    break;
                case 3:
                    switch (splittedString[1]){
                        case "ON":
                            System.out.println("Kytketään lamppu " + splittedString[2] + " PÄÄLLE");
                            break;
                        case "OFF":
                            System.out.println("Kytketään lamppu " + splittedString[2] + " POIS");
                            break;
                    }
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
