package services.fg.loader;

import com.sun.tools.internal.jxc.ap.Const;
import constants.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileLoader {

    public static Map loadStartATM(){
        Map<Integer, Integer> map = new HashMap<>();

        File dir = new File("resources");
        if (!dir.exists() && !dir.isDirectory()){
            throw new RuntimeException("Ошибка инициализации банкомата. Не загружены данные о банкомате");
        }
        File file = new File(dir.getAbsolutePath()+"/"+ Constants.ATM_INFO);
        if (!file.exists()){
            throw  new RuntimeException("Ошибка чтения файла о банкомате");
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = null;
            while((line = br.readLine())!= null){
                String[] arr = line.split("\\|");
                map.put(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
            }

            if(map == null){
                throw new NullPointerException("Не подгружена информация о количестве денег в банкомате");
            }

        }catch (IOException ex){
            throw new RuntimeException("Ошибка чтения файла "+ Constants.ATM_INFO);
        }

        return map;
    }

}
