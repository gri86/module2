package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Deque;
import java.util.LinkedList;

public class ConnectionPool {

    private static final String URL = "jdbc:sqlite:atm";
    private static Deque<Connection> connections = null;

    private ConnectionPool(){
        connections = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            try{
                Connection connection = DriverManager.getConnection(URL);
                connections.push(connection);
            }catch (SQLException ex){
                System.out.println("Ошибка инициализации пула подключений к БД"+ex.getMessage());
            }
        }
    }

    /**
     * Метод возвращает {@link Connection} из очереди подключений.
     * Если возникнет {@link SQLException}, то метод вернет null
     * @return {@link Connection}
     */
    public static Connection getConnection(){
        if (connections == null){
            new ConnectionPool();
            return connections.poll();
        }else {
            try{
                Connection connection = DriverManager.getConnection(URL);
                connections.push(connection);
                return connections.poll();
            }catch (SQLException ex){
                System.out.println("Ошибка создания соединения с БД "+ex.getMessage());
            }
        }
        return null;
    }


}
