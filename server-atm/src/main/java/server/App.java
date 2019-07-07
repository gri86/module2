package server;


import mapper.AccountMapper;
import mapper.CredentialsMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class App {



    public static void main(String[] args) throws IOException {



        loading();
//        ServerSocket serverSocket;
//
//        System.out.println("Создаем подключение");
//
//        serverSocket = new ServerSocket(1000);
//
//        System.out.println("Сервер запущен и ожидает подключений");
//
//        Socket client = serverSocket.accept();
//
//        System.out.println("Соединение с сервером установлено");
//
//        ServerThread thread = new ServerThread(client);


    }

    private static void loading() {
        System.out.println("Загрузка данных");
        AccountMapper.load();
        CredentialsMapper.load();
    }


}

class ServerThread extends Thread{
    PrintWriter out;
    BufferedReader in;
    Socket client;
    String input;
    String session;
    boolean stop = false;

    public ServerThread(Socket client) throws IOException {
        this.client = client;
        out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        start();
    }

    @Override
    public void run() {
        auth();
        try {
            while ((input = in.readLine()) != null) {
                parseInput(input);
                if(session == null){
                    auth();
                }
                if(stop == true){
                    break;
                }
            }
            out.close();
            in.close();
            client.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void parseInput(String input) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(input.split("\\s")));
        if (list.getFirst().equals("exit")) {
            stop = true;
            out.println("Клиент завершает сессию");
        }

    }

    private void authentificate(String login) {



    }

    private void auth() {
        out.println("Сервер: Для работы с банкоматом необходимо пройти процедуру авторизации. Для авторизации введите команду auth логин и пароль через пробел");
    }
}
