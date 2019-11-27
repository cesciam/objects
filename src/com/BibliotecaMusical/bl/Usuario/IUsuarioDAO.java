package com.BibliotecaMusical.bl;

public interface IUsuarioDAO<T> {

    void guardar(T t);
    void actualizar(T t);
    void eliminar(T t);
    void buscar(T t);

}
