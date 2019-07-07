package db;

import entity.AtmVolume;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBLoader {

    public static void prepare(){
        createTables();
        enrichTables();
    }

    private static void createTables(){

        createTable(SQLQuery.CREATE_TABLE_ATM);
        createTable(SQLQuery.CREATE_ATM_VOLUME);
        createTable(SQLQuery.CREATE_TABLE_ACCOUNT);
        createTable(SQLQuery.CREATE_TABLE_CREDENTIAL);

    }

    private static void createTable(String sql){
        try(
                Connection connection = ConnectionPool.getConnection();
                Statement statement = connection.createStatement();
        ){
            statement.execute(sql);
        }catch (SQLException ex){
            System.out.println("Ошибка создания таблицы+ "+ex.getMessage());
        }
    }

    private static void enrichTables(){

    }

}
