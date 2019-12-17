package com.BibliotecaMusical.bl.Genero;

import java.util.ArrayList;

public interface IGeneroDAO<T> {

    void registrar(T t);
    ArrayList<Genero> listar();
    void guardar(Genero genero);
    void eliminar(int id);
}
