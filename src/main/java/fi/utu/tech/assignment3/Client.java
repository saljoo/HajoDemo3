package fi.utu.tech.assignment3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        String viesti = "Hello!";
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 2345);
            var output = s.getOutputStream();
            byte[] bytesToSend = viesti.getBytes("utf-8");
            output.write(bytesToSend);
            output.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
