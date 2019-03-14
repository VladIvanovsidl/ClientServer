import www.WWW;

import java.io.*;
import java.net.ServerSocket;


public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {


            System.out.println("Server Started!");
            while (true)
                try (WWW www = new WWW(server)) {
                    String request = www.readLine();
                    System.out.println(" Request: " + request);
                    String response = (int)(Math.random()*30 -10) + " ";
                    www.writeLine(response);
                    System.out.println("Response:"+ response);

                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
