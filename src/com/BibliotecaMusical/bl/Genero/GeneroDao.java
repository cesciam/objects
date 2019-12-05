package com.BibliotecaMusical.bl.Genero;

import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproducción;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GeneroDao implements IGeneroDAO {

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnecionBD.getInstance().getConnection();
        return conn;
    }

    @Override
    public void registrar(Object o) {

    }

    @Override
    public ArrayList<Genero> listar() {
        ArrayList<Genero> listaGenero = new ArrayList<>();
        try {
            Connection connection = getConnection();
            ResultSet rs = connection.createStatement().executeQuery("select * from genero ");

            while (rs.next()){
                Genero genero = new Genero(rs.getString("nombre"), rs.getString("descripcion"));
                listaGenero.add(genero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaGenero;
    }
}
