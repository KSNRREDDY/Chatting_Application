package com.Socket_Programming;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Exception {
    try {
        int port = 4444;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data1 = bufferedReader1.readLine();
            printStream.println(data1);

            String data2 = bufferedReader2.readLine();
            printStream.println(data2);

            if (data1.equals("BYE") && data2.equals("BYE")) {
                System.exit(0);
            }
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }

    }

}