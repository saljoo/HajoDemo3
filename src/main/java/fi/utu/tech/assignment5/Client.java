package fi.utu.tech.assignment5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        PrintWriter output = null;
        try (Socket s = new Socket(InetAddress.getLocalHost(), 2345)){
            output = new PrintWriter(s.getOutputStream(), true);
            output.print("LIGHT;QUERY\n");
            output.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
