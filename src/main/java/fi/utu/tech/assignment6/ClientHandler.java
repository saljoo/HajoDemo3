package fi.utu.tech.assignment6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread {

    Socket clientSocket;
    Hub hub;

    // Pieni vinkki
    public ClientHandler(Socket cs, Hub h) {
        this.hub = h;
        this.clientSocket = cs;
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
                    Object[] lights = hub.getLights().toArray();
                    String[] status = {"", "", "", "", ""};
                    for(int i = 0; i < lights.length; i++){
                        if(lights[i].toString().contains("OFF")){
                            status[i] = "OFF";
                        } else {
                            status[i] = "ON";
                        }
                    }
                    System.out.printf("0:" + status[0] + ";1:" + status[1] + ";2:" + status[2] + ";3:" + status[3] + ";4:" + status[4]);
                    break;
                case 3:
                    switch (splittedString[1]){
                        case "ON":
                            hub.turnOnLight(Integer.parseInt(splittedString[2]));
                            break;
                        case "OFF":
                            hub.turnOffLight(Integer.parseInt(splittedString[2]));
                            break;
                    }
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
