package com.BibliotecaMusical.bl.ListaReproduccion;

import com.BibliotecaMusical.bl.Artista.Artista;
import com.BibliotecaMusical.bl.Cancion.Cancion;
import com.BibliotecaMusical.bl.Compositor.Compositor;
import com.BibliotecaMusical.bl.Genero.Genero;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.*;
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
    public ArrayList<Cancion> getCancionesLista(int idlp) throws SQLException {
        ArrayList<Cancion> cancions = new ArrayList<>();
        Connection connection = getConnection();
        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM listareproduccion_has_cancion as lhc inner join cancion as c where lhc.listareproduccion_idlistareproducciones = "+idlp+" and lhc.cancion_idcancion = c.idcancion and lhc.listareproduccion_usuario_idusuario = "+Usuario.getInstance().getIdUsuario());

        while (rs.next()){
            Cancion cancion = new Cancion(rs.getInt("idcancion"), rs.getString("nombre"), rs.getString("pathCancion"), rs.getDate("fechaLanzamiento").toLocalDate(), rs.getInt("calificacion"), new Genero(rs.getString("genero")), new Compositor(rs.getString("compositor")), new Artista(rs.getString("artista")));
            cancions.add(cancion);
        }

        return cancions;
    }

    @Override
    public void registrarCancionEnLista(ListaReproducción listaReproducción) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO listareproduccion_has_cancion(listareproduccion_idlistareproducciones, listareproduccion_usuario_idusuario, cancion_idcancion) VALUES(?,?,?)");
            ps.setInt(1, listaReproducción.getIdlp());
            ps.setInt(2, Usuario.getInstance().getIdUsuario());
            ps.setInt(3, listaReproducción.getCancionToUpload().getIdCancion());

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
