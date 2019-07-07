package hello.data;

import hello.entity.Account;

import java.util.LinkedList;

public class Data {
    public static LinkedList<Account> accounts = new LinkedList<>();

    static {
        accounts.add(new Account("001-01", "1987343451324", 10000000.50, "Vladimir"));
        accounts.add(new Account("001-02", "5242342346256", 42362843.00, "Alexey"));
        accounts.add(new Account("001-03", "3243231532532", 47283924.43, "Iliya"));
        accounts.add(new Account("001-04", "4892379498274", 23193717.90, "Viktor"));
        accounts.add(new Account("001-05", "8742897924997", 47894723.34, "Sergey"));
        accounts.add(new Account("001-06", "4872397474294", 42342255.09, "Alexander"));
        accounts.add(new Account("001-07", "0492840832048", 42342252.88, "Ivan"));
        accounts.add(new Account("001-08", "7429792347924", 94298729.87, "Nikolay"));
    }
}
