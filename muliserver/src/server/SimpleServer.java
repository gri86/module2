package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {
        System.out.println("Старт сервера");
        ServerSocket server = null;
        Socket client = null;
        BufferedReader bf = null;
        PrintWriter pr = null;
        try{
            server = new ServerSocket(9909);
        }catch (IOException ex){
            System.out.println("Ошибка при работе с портом 9909");
        }

        try {
            System.out.println("Ждем соединения с клиентом");
            client = server.accept();
            System.out.println("Клиент подключился");
            try {
                bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
                pr = new PrintWriter(client.getOutputStream(), true);
                String input, output;

                System.out.println("Ожидаем сообщения");
                while ((input = bf.readLine()) != null) {
                    if (input.equalsIgnoreCase("exit"))
                        break;
                    pr.println("Сервер: "+input);
                    System.out.println(input);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (IOException ex){
            System.out.println("Не могу установить соединение");
            System.exit(-1);
        }finally {
            try {
                server.close();
                client.close();
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pr.close();
        }


    }

}
