package Networking;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("Try to connect");
        try (Socket socket = new Socket("127.0.0.1", 4567);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter printWriter = new PrintWriter(outputStream);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected!");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                printWriter.println(userInput);
                printWriter.flush();
                System.out.println("echo: " + bufferedReader.readLine());
            }
        }

    }
}
