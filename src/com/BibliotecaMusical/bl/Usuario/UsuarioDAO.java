package com.BibliotecaMusical.bl.Usuario;

import com.BibliotecaMusical.bl.IUsuarioDAO;

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
        conn = ConeccionBD.getInstance().getConnection();
        return conn;
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

    public ResultSet login(String usuario, String password){
        ResultSet existe = null;
        try {
            connection = getConnection();
            ResultSet rs;
            ps = connection.prepareStatement("SELECT idusuario, nombre, apellidos, imagen, correo, edad, pais, cedula, tipo FROM usuario WHERE nombreUsuario = ? and contrasenna = ?");
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.last();

            System.out.println(rs.getString("correo"));

            if (rs.getRow() > 0){
                existe = rs;
            }else{
                existe = null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return existe;
    }
}
