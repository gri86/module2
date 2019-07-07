package services.fg.logger;

import java.io.*;
import java.time.LocalDate;

import static constants.Constants.FILE_LOGGER;

public class FileLogger implements Logger {

    private static final String FILE = FILE_LOGGER;

    @Override
    public void log(String message) {
        File file = new File(FILE);
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException ex){
                System.out.println("Ошибка создания файла: "+ ex.getMessage());
            }
        }
        try(Writer writer = new FileWriter(file, true)){
            writer.write(LocalDate.now()+": "+message+"\n");
        }catch (IOException ex){
            System.out.println("Ошибка логирования в файл: "+ file.getAbsolutePath()+ " Причина: "+ ex.getMessage());
        }
    }
}
