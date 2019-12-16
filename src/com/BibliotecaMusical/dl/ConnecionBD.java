package com.BibliotecaMusical.dl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecionBD {
    String driverClassName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/bibliotecamusical?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";

    private static ConnecionBD connectionFactory = null;

    private ConnecionBD() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnecionBD getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnecionBD();
        }
        return connectionFactory;
    }
}
