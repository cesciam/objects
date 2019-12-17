package com.BibliotecaMusical.bl.Artista;

import java.util.ArrayList;

public interface IArtistaDao<T> {

    void registrar(T t);
    ArrayList<Artista> listar();

    void eliminar(int id);
}
