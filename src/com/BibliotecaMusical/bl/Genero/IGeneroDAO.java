package com.BibliotecaMusical.bl.Genero;

import java.util.ArrayList;

public interface IGeneroDAO<T> {

    void registrar(T t);
    ArrayList<Genero> listar();
}
