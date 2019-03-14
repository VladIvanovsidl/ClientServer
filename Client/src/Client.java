import www.WWW;

import java.io.*;


public class Client {
    public static void main(String[] args) {
        try (WWW www = new WWW("127.0.0.1", 8000)) {
            System.out.println("Connected to Server");
            String request = "Welcome";
            System.out.println("Request: "+ request);
            www.writeLine(request);
            String response = www.readLine();
            System.out.println("Request:" + response);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

