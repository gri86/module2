package app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import da.AtmDAService;
import da.db.CredentialDAService;
import db.ConnectionPool;
import db.SQLQuery;
import entity.Atm;
import entity.AtmVolume;
import entity.Credential;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        CredentialDAService cdas = new CredentialDAService();
//        cdas.insert(new Credential("dasda","login", "pass"));

        cdas.get();



//        ApplicationContext app =
//                new ClassPathXmlApplicationContext("ApplicationContext.xml");
//
//        AtmDAService atmService = app.getBean("jsonAtmDaService", AtmDAService.class);
//        AtmDAService dbAtmService = app.getBean("dataBaseAtmDaService", AtmDAService.class);
//
//        List<Atm> list = atmService.get();
//
//        for (Atm atm: list) {
//            dbAtmService.insert(atm);
//        }
//
//        for(Atm atm: dbAtmService.get()){
//            System.out.println(atm.getId()+ " "+ atm.getName());
//        }

    }

    public static void createTable(String sql){
        try(
                Connection connection = ConnectionPool.getConnection();
                Statement st = connection.createStatement();
        ){
            st.execute(sql);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void showTables(){
        try(
                Connection connection = ConnectionPool.getConnection();
                Statement st = connection.createStatement();
        ){
            ResultSet rs = st.executeQuery(SQLQuery.SHOW_DB_META_DATA);
            while (rs.next()){
                System.out.println(rs.getString("name")+" "+ rs.getString("sql"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
