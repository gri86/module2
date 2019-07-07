package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        BufferedReader in = null;
        PrintWriter out = null;


        try {
            System.out.println("Запуск сервера");
            server = new ServerSocket(1001);
            System.out.println("Ожидание клиента");
            Socket client = server.accept();

            String input = null;

            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(
                    new OutputStreamWriter(client.getOutputStream()), true);
            out.println("Ты подключился, можешь писать");

            while ((input = in.readLine()) != null){
                if(input.equals("exit")) break;
                out.println("Server answer: "+input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                in.close();
                out.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
