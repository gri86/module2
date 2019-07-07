import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientApp3 {

    public static void main(String[] args) {
        try {
            System.out.println("Соединяемся с сервером 127.0.0.1");
            Socket socket = new Socket("127.0.0.1", 9909);
            BufferedReader in  = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(),true);
            BufferedReader inu =
                    new BufferedReader(new InputStreamReader(System.in));

            String fuser,fserver;

            while ((fuser = inu.readLine())!=null) {
                out.println(fuser);
                fserver = in.readLine();
                System.out.println(fserver);
                if (fuser.equalsIgnoreCase("close"))
                    break;
                if (fuser.equalsIgnoreCase("exit"))
                    break;
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
