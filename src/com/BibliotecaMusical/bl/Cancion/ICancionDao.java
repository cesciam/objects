package com.BibliotecaMusical.bl.Cancion;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICancionDao<T> {
    void registrar(T t);

    ArrayList<Cancion> cancionesUsuario() throws SQLException;

    void registrarCancionCli(Cancion cancion);

    ArrayList<Cancion> listarCanciones() throws SQLException;

    void eliminar(int idCancion);
}
