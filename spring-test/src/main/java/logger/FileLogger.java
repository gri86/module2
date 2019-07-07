package logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileLogger implements Loggable{
    @Override
    public void log(String log){
        String path = getClass().getClassLoader().getResource("log.txt").getFile();
        Writer writer = null;
        try {
            writer = new FileWriter(path, true);
            writer.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
