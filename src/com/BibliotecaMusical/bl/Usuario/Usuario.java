package com.BibliotecaMusical.bl.Usuario;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String img;
    private String nombreUsuario;
    private String contrasenna;
    private String correo;
    private String tipo;

    private static Usuario instance;

    public Usuario(String nombre, String apellidos, String img, String nombreUsuario, String contrasenna, String correo, String tipo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.img = img;
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.correo = correo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", img='" + img + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenna='" + contrasenna + '\'' +
                ", correo='" + correo + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public Usuario() {

    }

    public static Usuario getInstance() {
        if (instance == null)
            instance = new Usuario();
        return instance;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombreUsuario, usuario.nombreUsuario);
    }
}
