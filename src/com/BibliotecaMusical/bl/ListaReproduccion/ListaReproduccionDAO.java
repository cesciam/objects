package com.BibliotecaMusical.bl.ListaReproduccion;

import com.BibliotecaMusical.bl.Usuario.Usuario;
import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaReproduccionDAO implements IListaReproduccionDAO {

    private Connection connection = null;
    PreparedStatement ps;
    ResultSet rs;


    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnecionBD.getInstance().getConnection();
        return conn;
    }

    @Override
    public void guardar(Object o) {

    }

    @Override
    public void actualizar(Object o) {

    }

    @Override
    public void eliminar(Object o) {

    }

    @Override
    public ArrayList<ListaReproducción> listar() {
        ArrayList<ListaReproducción> listaReproduccións = new ArrayList<>();
        try {
            connection = getConnection();
            rs = connection.createStatement().executeQuery("select * from listareproduccion WHERE usuario_idusuario = "+Usuario.getInstance().getIdUsuario());

            while (rs.next()){
                ListaReproducción listaReproducción = new ListaReproducción(rs.getString("nombre"), rs.getDate("fechaCreacion").toLocalDate(), rs.getDouble("calificacion"));
                listaReproduccións.add(listaReproducción);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaReproduccións;
    }
}
