package com.BibliotecaMusical.bl.ListaReproduccion;

import com.BibliotecaMusical.bl.Cancion.Cancion;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaReproducción {
    private String nombre;
    private LocalDate fechaCreacion;
    private int calificacion;
    private ArrayList<Cancion> canciones;
    private Button buttonPerfil;
    private int idlp;
    private  Cancion cancionToUpload;

    public Cancion getCancionToUpload() {
        return cancionToUpload;
    }

    public void setCancionToUpload(Cancion cancionToUpload) {
        this.cancionToUpload = cancionToUpload;
    }

    public Button getButtonPerfil() {
        return buttonPerfil;
    }

    public void setButtonPerfil(Button buttonPerfil) {
        this.buttonPerfil = buttonPerfil;
    }

    public ListaReproducción() {
    }

    public int getIdlp() {
        return idlp;
    }

    public void setIdlp(int idlp) {
        this.idlp = idlp;
    }

    public ListaReproducción(String nombre, LocalDate fechaCreacion, int calificacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
    }

    public ListaReproducción(int idlp, String nombre, LocalDate fechaCreacion, int calificacion) {
        this.idlp = idlp;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public void addCancion(Cancion cancion){
        canciones.add(cancion);
    }
}
