package com.BibliotecaMusical.bl.Compositor;

import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompositorDao implements ICompositorDao{

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnecionBD.getInstance().getConnection();
        return conn;
    }

    @Override
    public ArrayList<Compositor> listar() {
        ArrayList<Compositor> listaCompositor = new ArrayList<>();
        try {
            Connection connection = getConnection();
            ResultSet rs = connection.createStatement().executeQuery("select * from compositor ");

            while (rs.next()){
                Compositor compositor = new Compositor(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("pais"), rs.getInt("edad"));
                listaCompositor.add(compositor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCompositor;
    }
}
