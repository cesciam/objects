package com.BibliotecaMusical.bl.Compositor;

import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.*;
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

    @Override
    public void registrarCompositor(Compositor compositor) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO compositor(nombre, apellidos,pais, edad, generos) VALUES(?,?,?,?,?)");
            ps.setString(1, compositor.getNombre());
            ps.setString(2, compositor.getApellidos());
            ps.setString(3, compositor.getPais());
            ps.setInt(4, compositor.getEdad());
            ps.setString(5, compositor.getGenero());

            int res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
