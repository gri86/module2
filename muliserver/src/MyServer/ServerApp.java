package MyServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(9901)){
            System.out.println("Жду соединения с пользователем");
            Socket client = server.accept();
            String str;

            PrintWriter serverWriter =
                    new PrintWriter(
                            new OutputStreamWriter(client.getOutputStream()), true);

            BufferedReader bf = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            while ((str = bf.readLine()) != null){
                String[] argss = str.split("\\s");

                if(argss[0].equals("exit")){
                    System.exit(-1);
                }
                if(argss[0].equals("sum")){
                    if(argss.length > 2){
                        ProxyCalculator proxy = new ProxyCalculator();
                        int result = proxy.sum(argss[1], argss[2]);
                        serverWriter.println(result);

                    }
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}


class ProxyCalculator{
    Calculator calculator;

    public ProxyCalculator(){
       this.calculator = new Calculator();
    }

    public int sum(String a, String b){
        int inta = Integer.parseInt(a);
        int intb = Integer.parseInt(b);
        return calculator.sum(inta, intb);
    }
}

class Calculator{
    public int sum(int a, int b){
        return a+b;
    }
}


