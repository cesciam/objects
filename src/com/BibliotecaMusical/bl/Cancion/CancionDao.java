package com.BibliotecaMusical.bl.Cancion;

import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancionDao implements ICancionDao {

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnecionBD.getInstance().getConnection();
        return conn;
    }

    @Override
    public void registrar(Object o) {
        Cancion cancion = (Cancion) o;
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cancion(nombre, pathCancion, fechaLanzamiento, calificacion, genero, compositor, artista) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, cancion.getNombre());
            ps.setString(2, cancion.getPathCancion());
            ps.setDate(3, Date.valueOf(cancion.getFechaLanzamiento()));
            ps.setInt(4, cancion.getCalificacion());
            ps.setString(5, cancion.getGenero().toString());
            ps.setString(6, "DEBO LISTAR COMPOSITORES");
            ps.setString(7, cancion.getArtista().toString());

            //ps.setString(6, cancion.getCompositor().toString());

            int res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
