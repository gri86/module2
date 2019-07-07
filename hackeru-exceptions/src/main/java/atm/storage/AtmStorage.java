package atm.storage;

import atm.model.Account;
import atm.model.Credentials;

import java.util.*;

public class AtmStorage {
    public static Set<Account> list;
    public static Map<Credentials, Integer> credentialsAccount;

    static {
        //Список счетов
        list = new HashSet<>();


        //Соответствие пинкодам и аккаунтам
        credentialsAccount = new HashMap<>();


    }
}
