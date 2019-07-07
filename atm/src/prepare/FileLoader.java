package prepare;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileLoader implements Initializer {

    private File dir;
    private boolean loaded;

    {
         dir = new File("resources");
         if (!dir.exists() && !dir.isDirectory()){
            createFolder();
        }
    }

    @Override
    public void prepare() {
        createFolder();
        this.loaded = true;
    }

    @Override
    public boolean isLoad(){
        return this.loaded;
    }

    private void createFolder() {
        File file = new File("resources");
        if(!file.exists()){
            file.mkdir();
        }
        loadCredentials();
        loadATMData();
        loadAccounts();
    }

    private void loadCredentials(){
        File file = new File(dir.getAbsolutePath()+"/credentials.data");
        try(BufferedWriter fw = new BufferedWriter(new FileWriter(file))){
            fw.write("1|Artem|1234|user\n");
            fw.write("2|Vova|1234|user\n");
            fw.write("3|Dima|1234|user\n");
        }catch (IOException ex){
            System.out.println("Ошибка инициализации данных. Не запианы данные о пользователях: "+ ex.getMessage());
            throw new RuntimeException();
        }

    }

    private void loadATMData(){
        File file = new File(dir.getAbsolutePath()+"/atm.data");
        try(BufferedWriter fw = new BufferedWriter(new FileWriter(file))){
            fw.write("5000|200\n");
            fw.write("2000|500\n");
            fw.write("1000|1000\n");
            fw.write("500|3000\n");
            fw.write("200|4000\n");
            fw.write("100|10000\n");
        }catch (IOException ex){
            System.out.println("Ошибка инициализации данных. Не запианы данные количестве купюр в банкомате: "+ ex.getMessage());
            throw new RuntimeException();
        }
    }

    private void loadAccounts(){
        File file = new File(dir.getAbsolutePath()+"/accounts.data");
        try(BufferedWriter fw = new BufferedWriter(new FileWriter(file))){
            fw.write("1|Trunov|456545|10000.00\n");
            fw.write("2|Putin|434563|400000.00\n");
            fw.write("3|Medvedev|123234|300000.00\n");
        }catch (IOException ex){
            System.out.println("Ошибка инициализации данных. Не запианы данные о пользователях: "+ ex.getMessage());
            throw new RuntimeException();
        }
    }

}
