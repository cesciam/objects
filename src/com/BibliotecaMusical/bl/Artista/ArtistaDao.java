package com.BibliotecaMusical.bl.Artista;

import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.*;
import java.util.ArrayList;

public class ArtistaDao implements IArtistaDao {

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnecionBD.getInstance().getConnection();
        return conn;
    }

    @Override
    public void registrar(Object o) {
        Artista artista = (Artista) o;
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO artista(nombre, apellidos,nombreArtistico, fechaNacimiento, fechaDefuncion, pais, genero, edad,descripcion) VALUES(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, artista.getNombre());
            ps.setString(2, artista.getApellidos());
            ps.setString(3, artista.getNombreArtisto());
            ps.setDate(4,  Date.valueOf(artista.getFechaNacimiento()));
            ps.setDate(5,  Date.valueOf(artista.getFechaDefuncion()));
            ps.setString(6, artista.getPais());
            ps.setString(7, artista.getGenero());
            ps.setInt(8, artista.getEdad());
            ps.setString(9, artista.getDescripcion());
            int res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Artista> listar() {
        ArrayList<Artista> listaArtistas = new ArrayList<>();
        try {
            Connection connection = getConnection();
            ResultSet rs = connection.createStatement().executeQuery("select * from artista ");

            while (rs.next()){
                Artista artista = new Artista(rs.getInt("idartista"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("nombreArtistico"), rs.getDate("fechaNacimiento").toLocalDate(), rs.getDate("fechaDefuncion").toLocalDate(), rs.getString("pais"), rs.getString("genero"), rs.getInt("edad"), rs.getString("descripcion"));
                listaArtistas.add(artista);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaArtistas;
    }

    @Override
    public void eliminar(int id) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from artista where idartista = (?)");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
