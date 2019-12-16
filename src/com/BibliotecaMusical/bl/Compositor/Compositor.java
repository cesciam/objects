package com.BibliotecaMusical.bl.Compositor;

import com.BibliotecaMusical.bl.Genero.Genero;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Objects;

public class Compositor {
    private String nombre;
    private String apellidos;
    private String pais;
    private int edad;
    private ArrayList<Genero> generos;
    private String genero;
    private Button eliminar;
    private Button modificar;

    public Compositor(String nombre, String apellidos, String pais, int edad, String genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pais = pais;
        this.edad = edad;
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Button getModificar() {
        return modificar;
    }

    public void setModificar(Button modificar) {
        this.modificar = modificar;
    }

    public Button getEliminar() {
        return eliminar;
    }

    public void setEliminar(Button eliminar) {
        this.eliminar = eliminar;
    }

    public Compositor(String nombre) {
        this.nombre = nombre;
    }

    public Compositor(String nombre, String apellidos, String pais, int edad, ArrayList<Genero> generos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pais = pais;
        this.edad = edad;
        this.generos = generos;
    }

    public Compositor(String nombre, String apellidos, String pais, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pais = pais;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compositor that = (Compositor) o;
        return edad == that.edad &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(apellidos, that.apellidos) &&
                Objects.equals(pais, that.pais) &&
                Objects.equals(generos, that.generos);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }
}
