package mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Account;
import entity.Credentials;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMapper {
    static Map<String, Account> map = new HashMap<>();
    static File accountFile = null;





    public static Account getAccount(String id){
        Account acc = map.get(id);
        return  acc;
    }

    public static void load(){
        accountFile = new File(AccountMapper.class.getClassLoader().getResource("accounts.json").getFile());
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Account> accounts = mapper.readValue(accountFile, new TypeReference<List<Account>>(){});
            for (Account account : accounts){
                map.put(account.getId(), account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void reload(){
        load();
    }
}
