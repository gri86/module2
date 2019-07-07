package logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

public class BufferedFileLogger implements Loggable {
    Writer writer;
    List<String> logList;
    private int limit;

    public BufferedFileLogger(int limit){
        this.limit = limit;
        logList = new LinkedList<>();
    }

    @Override
    public void log(String log) {
        if(logList.size() < limit){
            logList.add(log);
        }else {
            try {
                String file = getClass().getClassLoader().getResource("log.txt").getFile();
                writer = new FileWriter(file, true);
                logList.stream().forEach(s -> {
                    try {
                        writer.write(s+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                clear();
                logList.add(log);
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

    private void clear(){
        logList.clear();
    }
}
