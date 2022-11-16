package fi.utu.tech.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        PrintWriter output = null;
        BufferedReader input = null;
        try (Socket s = new Socket(InetAddress.getLocalHost(), 2345)){
            output = new PrintWriter(s.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                output.println("Hello");
                output.flush();
                String serverMessage = "";
                while(!serverMessage.equals("Ack")){
                    serverMessage = input.readLine();
                    if(serverMessage.equals("Ack")){
                        output.println("quit");
                        output.flush();
                        output.close();
                    }
                }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
