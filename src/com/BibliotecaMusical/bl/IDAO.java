package com.BibliotecaMusical.bl;

public interface IDAO<T> {

    void guardar(T t);
    void actualizar(T t);
    void eliminar(T t);
    void buscar(T t);

}
