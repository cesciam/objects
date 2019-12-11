package com.BibliotecaMusical.bl.Usuario;

import java.sql.SQLException;

public interface IUsuarioDAO<T> {

    void guardar(T t);
    void actualizar(T t);
    void eliminar(T t);
    void buscar(T t);
    boolean login(String usuario, String contrasenna);

    boolean buscarAdmin() throws SQLException;
}
