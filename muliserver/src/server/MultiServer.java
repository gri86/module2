package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(9909);
        System.out.println("Мультипоточный сервер стартовал");
        try {
            while (true) {
                Socket socket = s.accept();
                try {
                    System.out.println("Новое соединение установлено");
                    new Server(socket);
                }
                catch (IOException e) {
                    socket.close();
                }
            }
        }
        finally {
            s.close();
        }
    }
}

class Server extends Thread{
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;


    public Server(Socket s) throws IOException {
        socket = s;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    public void run(){
        try {
            while (true) {
                String str = bufferedReader.readLine();
                if (str.equals("END"))
                    break;
                System.out.println("Получено: " + str+" "+socket.getInetAddress().getHostName());
                printWriter.println(str);
            }
            System.out.println("Соединение закрыто");
        }
        catch (IOException e) {
            System.err.println("Ошибка чтения/записи");
        }
        finally {
            try {
                socket.close();
            }
            catch (IOException e) {
                System.err.println("Сокет не закрыт");
            }
        }
    }
}
