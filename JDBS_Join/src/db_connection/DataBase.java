package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private final String driver="org.postgresql.Driver";
    private  final String url1 = "jdbc:postgresql://localhost:5432/jdbs_join";
    private final String userName="postgres";
    private final String userPass="1234";

    public Connection connection= null;
    public DataBase() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url1,userName,userPass);
            if (!connection.isClosed()){
                System.out.println("Connection Success");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
