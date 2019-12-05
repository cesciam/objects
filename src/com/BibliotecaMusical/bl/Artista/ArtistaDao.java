package com.BibliotecaMusical.bl.Artista;

import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistaDao implements IArtistaDao {

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnecionBD.getInstance().getConnection();
        return conn;
    }

    @Override
    public void registrar(Object o) {

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
}
