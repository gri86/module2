package mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Account;
import entity.Credentials;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CredentialsMapper {
    static LinkedList<Credentials> list = new LinkedList<>();
    static File credentialsFile = null;


    public static String get(String login, String pw){
        for (Credentials credential: list){
            if(credential.getLogin().equals(login) && credential.getPassword().equals(pw)){
                return credential.getId();
            }
        }
        return null;
    }

    public static void load(){
        credentialsFile = new File(CredentialsMapper.class.getClassLoader().getResource("credentials.json").getFile());
        ObjectMapper mapper = new ObjectMapper();
        try {
            LinkedList<Credentials> credentials = mapper.readValue(credentialsFile, LinkedList.class);
            list = credentials;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void reload(){
        load();
    }
}
