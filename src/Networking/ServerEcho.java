package Networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEcho {

    public static void main(String[] args) throws IOException {

        System.out.println("Server started and waiting for request....");

        while (true){
            try (ServerSocket serverSocket = new ServerSocket(4567)){
                    new Thread(new echoThread(serverSocket.accept())).start();
            }
        }
    }
}

record echoThread(Socket socket) implements Runnable{
    @Override
    public void run() {

        try{
            while (true){
                try (socket;
                     InputStream inputStream = socket.getInputStream();
                     OutputStream outputStream = socket.getOutputStream();
                     PrintWriter printWriter = new PrintWriter(outputStream);
                     InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                     BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                ) {

                    System.out.println("Connected to: " + socket.getRemoteSocketAddress());


                    String request;

                    while ((request = bufferedReader.readLine()) != null){

                        System.out.println("Request: " + request);

                        printWriter.println(request);
                        printWriter.flush();

                        System.out.println("Send response!");

                    }

                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
