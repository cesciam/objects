package com.BibliotecaMusical.bl.Artista;

import javafx.scene.control.Button;

import java.time.LocalDate;
import java.util.Objects;

public class Artista {

    private int id;
    private String nombre;
    private String apellidos;
    private String nombreArtisto;
    private LocalDate fechaNacimiento;
    private LocalDate fechaDefuncion;
    private String pais;
    private String genero;
    private int edad;
    private String descripcion;
    private Button eliminar;
    private Button modificar;

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

    public Artista(String nombre) {
        this.nombre = nombre;
    }

    public Artista(String nombre, String apellidos, String nombreArtisto, LocalDate fechaNacimiento, LocalDate fechaDefuncion, String pais, String genero, int edad, String descripcion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreArtisto = nombreArtisto;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
        this.pais = pais;
        this.genero = genero;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    public Artista(int id, String nombre, String apellidos, String nombreArtisto, LocalDate fechaNacimiento, LocalDate fechaDefuncion, String pais, String genero, int edad, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreArtisto = nombreArtisto;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
        this.pais = pais;
        this.genero = genero;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return id == artista.id &&
                edad == artista.edad &&
                Objects.equals(nombre, artista.nombre) &&
                Objects.equals(apellidos, artista.apellidos) &&
                Objects.equals(nombreArtisto, artista.nombreArtisto) &&
                Objects.equals(fechaNacimiento, artista.fechaNacimiento) &&
                Objects.equals(fechaDefuncion, artista.fechaDefuncion) &&
                Objects.equals(pais, artista.pais) &&
                Objects.equals(genero, artista.genero) &&
                Objects.equals(descripcion, artista.descripcion);
    }

    @Override
    public String toString() {
        return nombreArtisto;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreArtisto() {
        return nombreArtisto;
    }

    public void setNombreArtisto(String nombreArtisto) {
        this.nombreArtisto = nombreArtisto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(LocalDate fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
