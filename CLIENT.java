package com.Socket_Programming;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Exception {
      try {
          String ip = "localhost";
          int port = 4444;
          Socket socket = new Socket(ip, port);
          OutputStream outputStream = socket.getOutputStream();
          PrintStream printStream = new PrintStream(outputStream);
          BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
          InputStream iputStream = socket.getInputStream();
          BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));

          while (true) {
              String data1 = bufferedReader1.readLine();
              System.out.println(data1);

              String data2 = bufferedReader2.readLine();
              System.out.println(data2);

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