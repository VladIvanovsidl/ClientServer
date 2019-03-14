import www.WWW;

import java.io.*;
import java.net.ServerSocket;


public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {

            System.out.println("Server Started!");
            while (true) {
                WWW www = new WWW(server);
                new Thread(() -> {
                    String request = www.readLine();
                    System.out.println(" Request: " + request);
                    String response = (int) (Math.random() * 30 - 10) + " ";
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    www.writeLine(response);
                    System.out.println("Response:" + response);
                    try {
                        www.close();
                    } catch (IOException e) {
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
