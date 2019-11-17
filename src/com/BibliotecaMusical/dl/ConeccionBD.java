package com.BibliotecaMusical.dl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConeccionBD {
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/escuela";
    private final String dbUser = "root";
    private final String dbPwd = "1234";

    private static ConeccionBD coneccionBD = null;

    private ConeccionBD(){
        try {
            Class.forName(driverClassName);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConeccionBD getInstance() {
        if (coneccionBD == null) {
            coneccionBD = new ConeccionBD();
        }
        return coneccionBD;
    }


}
