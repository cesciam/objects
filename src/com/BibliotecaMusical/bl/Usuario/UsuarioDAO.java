package com.BibliotecaMusical.bl.Usuario;


import com.BibliotecaMusical.bl.Genero.Genero;
import com.BibliotecaMusical.dl.ConnecionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements IUsuarioDAO<Usuario> {

    private Connection connection = null;
    PreparedStatement ps;
    ResultSet rs;


    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnecionBD.getInstance().getConnection();
        return conn;
    }

    @Override
    public boolean buscarAdmin() throws SQLException {
        boolean existe = false;
        Connection connection = getConnection();
        ResultSet rs = connection.createStatement().executeQuery("select * from usuario ");

        while (rs.next()){
                Usuario usuario = new Usuario(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("imagen"),rs.getString("nombreUsuario"), rs.getString("contrasenna"), rs.getString("correo"), rs.getString("tipo"));
                if (usuario.getTipo().equals("Admin")){
                    return true;
                }
        }

        return existe;
    }

    @Override
    public void guardar(Usuario usuario) {

        if (usuario.getTipo() == "Cliente"){
            Cliente cliente = (Cliente) usuario;
            try {
                connection = getConnection();
                ps = connection.prepareStatement("INSERT INTO usuario(nombre, apellidos, imagen, nombreUsuario, contrasenna, correo, edad, pais, cedula, tipo) VALUES(?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellidos());
                ps.setString(3, cliente.getImg());
                ps.setString(4, cliente.getNombreUsuario());
                ps.setString(5, cliente.getContrasenna());
                ps.setString(6, cliente.getCorreo());
                ps.setInt(7, cliente.getEdad());
                ps.setString(8, cliente.getPais());
                ps.setInt(9, cliente.getIdentificacion());
                ps.setString(10, cliente.getTipo());

                int res = ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            Administrador administrador = (Administrador) usuario;
            try {
                connection = getConnection();
                ps = connection.prepareStatement("INSERT INTO usuario(nombre, apellidos, imagen, nombreUsuario, contrasenna, correo, tipo) VALUES (?,?,?,?,?,?,?)");
                ps.setString(1, administrador.getNombre());
                ps.setString(2, administrador.getApellidos());
                ps.setString(3, administrador.getImg());
                ps.setString(4, administrador.getNombreUsuario());
                ps.setString(5, administrador.getContrasenna());
                ps.setString(6, administrador.getCorreo());
                ps.setString(7, administrador.getTipo());

                int res = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actualizar(Usuario usuario) {

    }

    @Override
    public void eliminar(Usuario usuario) {

    }

    @Override
    public void buscar(Usuario usuario) {

    }

    public boolean login(String usuario, String password){
        try {
            connection = getConnection();
            ResultSet rs;
            ps = connection.prepareStatement("SELECT * FROM usuario WHERE nombreUsuario = ? and contrasenna = ?");
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0){
                 Usuario usuarioActual = Usuario.getInstance();
                 usuarioActual.setApellidos(rs.getString("apellidos"));
                 usuarioActual.setCorreo(rs.getString("correo"));
                 usuarioActual.setImg(rs.getString("imagen"));
                 usuarioActual.setNombre(rs.getString("nombre"));
                 usuarioActual.setNombreUsuario(rs.getString("nombreUsuario"));
                 usuarioActual.setTipo(rs.getString("tipo"));
                 usuarioActual.setContrasenna(rs.getString("contrasenna"));
                 usuarioActual.setIdUsuario(rs.getInt("idusuario"));
                 return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
