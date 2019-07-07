package MyServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",9901);

            OutputStream os = socket.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(os);

            PrintWriter pr = new PrintWriter(osw, true);

            BufferedReader clientReader =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));

            while (true){
                String str = bufferedReader.readLine();
                System.out.println(clientReader.readLine());
                if(str.equals("exit")){
                    System.exit(-1);
                }
            }



            } catch (IOException e) {
                    e.printStackTrace();
            }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

}
