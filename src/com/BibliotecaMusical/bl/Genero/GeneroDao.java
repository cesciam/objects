package com.BibliotecaMusical.bl.Genero;

import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproducción;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                Genero genero = new Genero(rs.getInt("idgenero"), rs.getString("nombre"), rs.getString("descripcion"));
                listaGenero.add(genero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaGenero;
    }

    @Override
    public void guardar(Genero genero) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO genero(nombre, descripcion) VALUES(?,?)");
            ps.setString(1, genero.getNombre());
            ps.setString(2, genero.getDescripcion());

            int res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from genero where idgenero = (?)");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
