package com.BibliotecaMusical.bl.Usuario;

public class Cliente extends Usuario {
    private int edad;
    private String pais;
    private int identificacion;

    public Cliente(String nombre, String apellidos, String img, String nombreUsuario, String contrasenna, String correo, String tipo, int edad, String pais, int identificacion) {
        super(nombre, apellidos, img, nombreUsuario, contrasenna, correo, tipo);
        this.edad = edad;
        this.pais = pais;
        this.identificacion = identificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return identificacion == cliente.identificacion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "edad=" + edad +
                ", pais='" + pais + '\'' +
                ", identificacion=" + identificacion +
                '}';
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
}
