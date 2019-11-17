package com.BibliotecaMusical.bl;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String img;
    private String nombreUsuario;
    private String contrasenna;
    private String correo;

    public Usuario(String nombre, String apellidos, String img, String nombreUsuario, String contrasenna, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.img = img;
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.correo = correo;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombreUsuario, usuario.nombreUsuario);
    }
}
