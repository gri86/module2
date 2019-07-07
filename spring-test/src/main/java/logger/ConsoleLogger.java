package logger;

public class ConsoleLogger implements Loggable {
    @Override
    public void log(String log){
        System.out.println("Log - "+log);
    }
}
