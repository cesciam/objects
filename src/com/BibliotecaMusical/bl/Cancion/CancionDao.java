package com.BibliotecaMusical.bl.Cancion;

import com.BibliotecaMusical.bl.Artista.Artista;
import com.BibliotecaMusical.bl.Compositor.Compositor;
import com.BibliotecaMusical.bl.Genero.Genero;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import com.BibliotecaMusical.dl.ConnecionBD;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao implements ICancionDao {

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnecionBD.getInstance().getConnection();
        return conn;
    }

    @Override
    public ArrayList<Cancion> cancionesUsuario() throws SQLException {
        ArrayList<Cancion> cancions = new ArrayList<>();
        Connection connection = getConnection();
        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM usuario_has_cancion as uhc inner join cancion as c where uhc.usuario_idusuario = "+ Usuario.getInstance().getIdUsuario() +" and c.idcancion = uhc.cancion_idcancion");

        while (rs.next()){
                Cancion cancion = new Cancion(rs.getInt("idcancion"), rs.getString("nombre"), rs.getString("pathCancion"), rs.getDate("fechaLanzamiento").toLocalDate(), rs.getInt("calificacion"), new Genero(rs.getString("genero")), new Compositor(rs.getString("compositor")), new Artista(rs.getString("artista")));
                cancions.add(cancion);
        }

        return cancions;

    }

    @Override
    public void registrarCancionCli(Cancion cancion) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into usuario_has_cancion(usuario_idusuario, cancion_idcancion) values (?,?)");
            ps.setInt(1, Usuario.getInstance().getIdUsuario());
            ResultSet rs = connection.createStatement().executeQuery("select * from cancion as c where c.nombre = '"+cancion.getNombre()+"'");
            rs.next();
            cancion.setIdCancion(rs.getInt("idcancion"));

            ps.setInt(2, cancion.getIdCancion());
            int res = ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
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
            ps.setString(6, cancion.getCompositor().getNombre());
            ps.setString(7, cancion.getArtista().toString());

            int res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
