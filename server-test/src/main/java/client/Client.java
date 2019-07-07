package client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String input = null;
        String output = null;
        try(
                Socket socket = new Socket("127.0.0.1", 1001);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        ){
            input = in.readLine();
            System.out.println(input);
           while (true){
               output = console.readLine();
               out.println(output);
               input = in.readLine();
               System.out.println(input);


           }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
