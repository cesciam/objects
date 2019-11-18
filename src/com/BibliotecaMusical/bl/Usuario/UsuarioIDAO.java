package com.BibliotecaMusical.bl.Usuario;

import com.BibliotecaMusical.bl.IDAO;
import com.BibliotecaMusical.dl.ConeccionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioIDAO{

    private Connection connection = null;
    PreparedStatement ps;
    ResultSet rs;


    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConeccionBD.getInstance().getConnection();
        return conn;
    }


    public void guardar(Object object) {
        Usuario usuario = (Usuario) object;

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


    public void actualizar(Object usuario) {

    }


    public void eliminar(Object usuario) {

    }


    public void buscar(Object object) {

    }
}
