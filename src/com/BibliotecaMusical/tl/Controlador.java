package com.BibliotecaMusical.tl;

import com.BibliotecaMusical.bl.IDAO;
import com.BibliotecaMusical.bl.Usuario.Cliente;
import com.BibliotecaMusical.bl.Usuario.UsuarioIDAO;
import javafx.scene.control.Alert;

public class Controlador {

    public void registrarCliente(String nombre, String apellidos, String nombreUsuario, String contrasenna, String edad, String pais, String email, String identificacion, String pathImg) {
        UsuarioIDAO usuarioIDAO = new UsuarioIDAO();
        int edadCliente = Integer.parseInt(edad);
        int identificacionCliente = Integer.parseInt(identificacion);
        Cliente cliente = new Cliente(nombre,apellidos, pathImg, nombreUsuario, contrasenna, email, "Cliente", edadCliente, pais, identificacionCliente);

        usuarioIDAO.guardar(cliente);

    }

    public void comprobarAdministrador(){

        //Aqui va la comprobacion de la existencia de un administrador para poder ejecutar la app

    }

}
