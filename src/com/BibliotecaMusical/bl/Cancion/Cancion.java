package com.BibliotecaMusical.bl.Cancion;

import com.BibliotecaMusical.bl.Artista.Artista;
import com.BibliotecaMusical.bl.Compositor.Compositor;
import com.BibliotecaMusical.bl.Genero.Genero;

import java.awt.*;
import java.time.LocalDate;
import java.util.Objects;

public class Cancion {
    private int idCancion;
    private String nombre;
    private String pathCancion;
    private LocalDate fechaLanzamiento;
    private int calificacion;
    private Genero genero;
    private Compositor compositor;
    private Artista artista;
    private Button agregarCola;
    private Button eliminar;

    public Button getAgregarCola() {
        return agregarCola;
    }

    public void setAgregarCola(Button agregarCola) {
        this.agregarCola = agregarCola;
    }

    public Button getEliminar() {
        return eliminar;
    }

    public void setEliminar(Button eliminar) {
        this.eliminar = eliminar;
    }

    public Cancion(String nombre, String pathCancion, LocalDate fechaLanzamiento, int calificacion, Genero genero, Compositor compositor, Artista artista) {
        this.nombre = nombre;
        this.pathCancion = pathCancion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.calificacion = calificacion;
        this.genero = genero;
        this.compositor = compositor;
        this.artista = artista;
    }

    public Cancion(int idCancion, String nombre, String pathCancion, LocalDate fechaLanzamiento, int calificacion, Genero genero, Compositor compositor, Artista artista) {
        this.idCancion = idCancion;
        this.nombre = nombre;
        this.pathCancion = pathCancion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.calificacion = calificacion;
        this.genero = genero;
        this.compositor = compositor;
        this.artista = artista;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathCancion() {
        return pathCancion;
    }

    public void setPathCancion(String pathCancion) {
        this.pathCancion = pathCancion;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Compositor getCompositor() {
        return compositor;
    }

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return idCancion == cancion.idCancion &&
                Double.compare(cancion.calificacion, calificacion) == 0 &&
                Objects.equals(nombre, cancion.nombre) &&
                Objects.equals(pathCancion, cancion.pathCancion) &&
                Objects.equals(fechaLanzamiento, cancion.fechaLanzamiento) &&
                Objects.equals(genero, cancion.genero) &&
                Objects.equals(compositor, cancion.compositor) &&
                Objects.equals(artista, cancion.artista);
    }

}
