package client;

import java.io.*;
import java.net.Socket;

import static java.lang.System.in;
import static java.lang.System.setOut;

public class ClientApp {

    public static void main(String[] args) throws IOException {

        PrintWriter out;
        BufferedReader console;
        String userInput;


        System.out.println("Создаем подключение к серверу");

        Socket socket = new Socket("127.0.0.1", 1000);

        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        console = new BufferedReader(new InputStreamReader(in));
        System.out.println("Создана нить для чтения сообщений");
        ReadMsg msgThread = new ReadMsg(socket);
        System.out.println("Создана нить для отправки сообщений");
        while ((userInput = console.readLine()) != null){
            out.println(userInput);

            if (userInput.equals("exit")){
                msgThread.interrupt();
                break;
            }

        }
        in.close();
        out.close();
        console.close();
        socket.close();

    }

}

class ReadMsg extends Thread{
    Socket server;
    BufferedReader in;
    String serverOut;

    public ReadMsg(Socket socket){
        this.server = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }

    @Override
    public void run() {
       while (!Thread.currentThread().isInterrupted()){
           try {
               if (!((serverOut = in.readLine()) !=null)) break;
               System.out.println(serverOut);
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
        try {
            server.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
