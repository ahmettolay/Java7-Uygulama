package com.bilgeadam.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.bilgeadam.utility.Constant.*;

public class DBConnection {






    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Constant.url1, Constant.userName, Constant.userPass);
            System.out.println("Connected to PostgreSQL server successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }



}
