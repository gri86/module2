package singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Configuration {

    private static Configuration instance;
    private Properties props = null;

    private Configuration(){
        props = new Properties();

        try(FileInputStream fis =
                    new FileInputStream("props.txt")){
            props.load(fis);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Configuration getInstance(){
        if(instance == null){
            instance = new Configuration();
        }

        return instance;
    }

    public String getProperty(String key){
        String value = null;
        if(props.containsKey(key)){
           value = (String) props.get(key);
        }else {
            System.out.println("Ключ отсутсвует в файле свойст");
        }
        return value;
    }

}
