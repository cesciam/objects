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
    public void registrarCancionEnLista(ListaReproducción listaReproducción) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO listareproduccion_has_cancion(listareproduccion_idlistareproducciones, listareproduccion_usuario_idusuario, cancion_idcancion) VALUES(?,?,?)");
            ps.setInt(1, listaReproducción.getIdlp());
            ps.setInt(2, Usuario.getInstance().getIdUsuario());
            ps.setInt(3, listaReproducción.getCanciones().get(1).getIdCancion());

            int res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardar(Object o) {
        ListaReproducción listaReproducción = (ListaReproducción) o;
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO listareproduccion(fechaCreacion, nombre, calificacion, usuario_idusuario) VALUES(?,?,?,?)");
            ps.setDate(1, Date.valueOf(listaReproducción.getFechaCreacion()));
            ps.setString(2, listaReproducción.getNombre());
            ps.setInt(3, listaReproducción.getCalificacion());
            ps.setInt(4, Usuario.getInstance().getIdUsuario());


            int res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

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
                ListaReproducción listaReproducción = new ListaReproducción(rs.getInt("idlistareproducciones"),rs.getString("nombre"), rs.getDate("fechaCreacion").toLocalDate(), rs.getInt("calificacion"));
                listaReproduccións.add(listaReproducción);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaReproduccións;
    }
}
