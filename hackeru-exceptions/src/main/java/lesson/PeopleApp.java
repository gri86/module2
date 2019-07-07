package lesson;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PeopleApp {

    static int i = 0;

    public static int fact(int n){
        int x = 1;
        if (n > 0)
           x = fact(n-1) * n;
        return x;
    }

    public static void work(){
        if (i > 10000) return;
        System.out.println(++i);
        work();
    }

    public static void main(String[] args){
        System.out.println(fact(15));
//        PeopleList list = new PeopleList();
//
//        try{
//            list.add(new People("Artem", 20));
//            list.add(new People("Artem", 20));
//            list.add(new People("Artem", 20));
//            list.add(new People("Artem", 20));
//            list.add(new People("Artem", 20));
//
//            System.out.println(list.getList());
//
//        } catch (PeopleListException ex){
//            System.out.println(ex.getMessage());
//        }


//        try(Connection con = DriverManager.getConnection("Udasdad"); Statement st = con.createStatement()){
//            System.out.println();
//        }catch (SQLException ex){
//            ex.printStackTrace();
//        }

//        Connection conn = null;
//        Statement st = null;
//
//        try{
//            conn = DriverManager.getConnection("url");
//        } catch (SQLException ex){
//            System.out.println(ex.getMessage());
//        } finally {
//            try{
//                conn.close();
//            }catch (SQLException ex){
//                ex.printStackTrace();
//            }
//
//        }

//        PeopleList list = new PeopleList();
//        People p1 = null;
//        try{
//           p1 = list.get(100);
//        }catch (ArrayIndexOutOfBoundsException ex){
//            System.out.println(ex.getMessage());
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }finally {
//            p1 = new People("No Name", 0);
//        }
//
//        System.out.println(p1.name);
        System.out.println("End program");

    }
}
