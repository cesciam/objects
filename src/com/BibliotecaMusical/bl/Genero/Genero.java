package com.BibliotecaMusical.bl.Genero;

import javafx.scene.control.Button;

import java.util.Objects;

public class Genero {

    private int id;
    private String nombre;
    private String descripcion;
    private Button eliminar;
    private Button modificar;

    public Genero(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Button getEliminar() {
        return eliminar;
    }

    public void setEliminar(Button eliminar) {
        this.eliminar = eliminar;
    }

    public Button getModificar() {
        return modificar;
    }

    public void setModificar(Button modificar) {
        this.modificar = modificar;
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Genero(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return id == genero.id &&
                Objects.equals(nombre, genero.nombre) &&
                Objects.equals(descripcion, genero.descripcion);
    }

    @Override
    public String toString() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
