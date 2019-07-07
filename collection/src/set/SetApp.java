package set;

import java.util.*;

public class SetApp {

    public static void main(String[] args) {

          Account acc = new Account(1, 10, "Vova");
          Account acc1 = new Account(2, 11, "Artem");
          Account acc2 = new Account(1, 10, "Vova");
          Account acc3 = new Account(3, 12, "Vasya");
          Account acc4 = new Account(4, 13, "Vitya");

          Set<Account> set2 = new TreeSet<>(((o1, o2) ->
                  o1.holder.compareTo(o2.holder)));

          Set<Account> set = new TreeSet<>(new Comparator<Account>() {
              @Override
              public int compare(Account o1, Account o2) {
                  return o1.holder.compareTo(o2.holder);
              }
          });
          set.add(acc);
          set.add(acc1);
          set.add(acc2);
          set.add(acc3);
          set.add(acc4);

          for (Account ac: set){
              System.out.println(ac);
          }

//        Set<String> set = new HashSet<>();
//        set.add("Putin");
//        set.add("Trunov");
//        set.add("Volkov");
//        set.add("Putin");
//        set.add("Ivanov");
//
//        for (String s: set){
//            System.out.println(s);
//        }
//        System.out.println("");
//        Set<String> set1 = new TreeSet<>();
//        set1.add("Putin");
//        set1.add("Trunov");
//        set1.add("Volkov");
//        set1.add("Putin");
//        set1.add("Ivanov");
//
//        for (String s: set1){
//            System.out.println(s);
//        }
//
//        System.out.println("");
//
//        Set<String> set2 = new LinkedHashSet<>();
//        set2.add("Putin");
//        set2.add("Trunov");
//        set2.add("Volkov");
//        set2.add("Putin");
//        set2.add("Ivanov");
//
//        for (String s: set2){
//            System.out.println(s);
//        }
    }
}

class Account{
    int id;
    int number;
    String holder;

    public Account(int id, int number, String holder) {
        this.id = id;
        this.number = number;
        this.holder = holder;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (number != account.number) return false;
        return holder != null ? holder.equals(account.holder) : account.holder == null;

    }

    @Override
    public int hashCode() {

        return Objects.hash(id,number,holder);

//        int result = id;
//        result = 31 * result + number;
//        result = 31 * result + (holder != null ? holder.hashCode() : 0);
//        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number=" + number +
                ", holder='" + holder + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(Object o) {
//        Account acc = (Account) o;
//        return this.holder.compareTo(acc.holder);
//    }
}


//class AccountComparator implements Comparator<Account>{
//
//    @Override
//    public int compare(Account o1, Account o2) {
//        return o1.holder.compareTo(o2.holder);
//    }
//}
