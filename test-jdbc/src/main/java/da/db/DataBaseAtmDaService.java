package da.db;

import da.AtmDAService;
import db.ConnectionPool;
import db.SQLQuery;
import entity.Atm;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DataBaseAtmDaService implements AtmDAService {


    @Override
    public List<Atm> get() {
        List<Atm> list = new LinkedList<>();
        try(Connection connection = ConnectionPool.getConnection();
            Statement st = connection.createStatement()
        ){
            ResultSet rs = st.executeQuery(SQLQuery.SELECT_ATM_DATA);
            while (rs.next()){
                Atm atm = new Atm(rs.getString("id"), rs.getString("name"));
                list.add(atm);
            }
        }catch (SQLException ex){
            System.out.println("Ошибка получения данных из таблицы ATM");
        }
        return list;
    }

    @Override
    public Atm get(String id) {
        return null;
    }

    @Override
    public void insert(Atm item) {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQuery.INSERT_ATM_DATA);
        ){

            ps.setString(1, item.getId());
            ps.setString(2, item.getName());
            ps.executeUpdate();

        }catch (SQLException ex){
            System.out.println("Ошибка вставки записи в таблицу ATM "+ex.getMessage());
        }
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Atm item) {

    }
}
