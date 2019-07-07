package app;

//Создать таблицу студенты
//        Id
//        Fio
//        Gender
//        avgMark
//        Заполнить таблицу 10 записями
//        Сделать выборки:
//        Показать студентов со средней оценкой выше 4
//        Фамилии которых начинаются на P
//        Всех мальчиков
//        Всех девочек
//        Удалить одну запись по ID
//        Изменить одну запись


import java.sql.*;
import java.util.Arrays;

public class Student {

    public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        try{
             connection =
                    DriverManager.getConnection("jdbc:sqlite:student");
            System.out.println("Создание таблицы");
             st = connection.createStatement();
             st.execute("CREATE TABLE IF NOT EXISTS STUDENT (ID CHAR PRIMARY KEY, FIO CHAR, GENDER CHAR, MARK NUMBER(2,2));");

             String[] strings = new String[10];
             strings[0] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('1', 'Trunov', 'M', 4.2);";
             strings[1] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('2', 'Alexeev', 'M', 4.2);";
             strings[2] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('3', 'Petrov', 'M', 4.2);";
             strings[3] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('4', 'Petrova', 'F', 4.2);";
             strings[4] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('5', 'Ionova', 'F', 5.0);";
             strings[5] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('6', 'Volkova', 'F', 3.1);";
             strings[6] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('7', 'Ivanov', 'M', 4.1);";
             strings[7] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('8', 'Medvedev', 'M', 3.2);";
             strings[8] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('9', 'Kuznetsova', 'F', 4.7);";
             strings[9] = "INSERT INTO STUDENT (ID, FIO, GENDER, MARK) VALUES ('10', 'Zaycev', 'M', 3.2);";
            System.out.println("Заполнение таблицы");
            for(int i= 0; i<strings.length; i++){
                st.executeUpdate(strings[i]);
            }


             ResultSet rs = st.executeQuery("SELECT * FROM STUDENT WHERE mark > 4");
            System.out.println("показать фио оценка выше 4");
             while (rs.next()){
                 System.out.println(rs.getString("FIO"));
             }
            System.out.println("Фамилии начинаются на Р");
             rs = st.executeQuery("SELECT * FROM STUDENT WHERE fio like 'P%';");
            while (rs.next()){
                System.out.println(rs.getString("FIO"));
            }
            System.out.println("Мальчики");
            rs = st.executeQuery("SELECT * FROM STUDENT WHERE gender = 'M'");
            while (rs.next()){
                System.out.println(rs.getString("FIO"));

            }
            System.out.println("Девочки");
            rs = st.executeQuery("SELECT * FROM STUDENT WHERE gender = 'F'");
            while (rs.next()){
                System.out.println(rs.getString("FIO"));
            }

            System.out.println("Удалить 6-ую запись");
            st.executeUpdate("DELETE FROM STUDENT WHERE ID=6");
            st.executeQuery("SELECT * FROM STUDENT");
            while (rs.next()){
                System.out.println(rs.getString("FIO"));
            }

            System.out.println("Изменить запись номер 5");
            st.executeUpdate("UPDATE STUDENT SET gender='M' WHERE ID=5");
            st.executeQuery("SELECT * FROM STUDENT");
            while (rs.next()){
                System.out.println(rs.getString("FIO")+ " "+rs.getString("GENDER"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                st.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
