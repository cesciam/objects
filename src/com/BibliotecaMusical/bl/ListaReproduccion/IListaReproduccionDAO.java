package com.BibliotecaMusical.bl.ListaReproduccion;

import java.util.ArrayList;

public interface IListaReproduccionDAO<T> {

    void guardar(T t);
    void actualizar(T t);
    void eliminar(T t);
    ArrayList<ListaReproducción> listar();
    void registrarCancionEnLista(ListaReproducción listaReproducción);
}
