package com.BibliotecaMusical.bl.ListaReproduccion;

import com.BibliotecaMusical.bl.Cancion.Cancion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ListaReproducción {
    private String nombre;
    private LocalDate fechaCreacion;
    private double calificacion;
    private ArrayList<Cancion> canciones;

    public ListaReproducción() {
    }

    public ListaReproducción(String nombre, LocalDate fechaCreacion, double calificacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaReproducción that = (ListaReproducción) o;
        return Double.compare(that.calificacion, calificacion) == 0 &&
                nombre.equals(that.nombre) &&
                fechaCreacion.equals(that.fechaCreacion) &&
                canciones.equals(that.canciones);
    }

    @Override
    public String toString() {
        return "ListaReproducción{" +
                "nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", calificacion=" + calificacion +
                ", canciones=" + canciones +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }
}
