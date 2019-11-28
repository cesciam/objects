package com.BibliotecaMusical.tl;

import com.BibliotecaMusical.bl.Factory.DAOFactory;
import com.BibliotecaMusical.bl.IUsuarioDAO;
import com.BibliotecaMusical.bl.Usuario.Cliente;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import javafx.scene.control.Alert;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador {

    private IUsuarioDAO usuarioDAO;
    private DAOFactory factory;

    public Controlador() {
        factory = DAOFactory.getDaoFactory(1);
        usuarioDAO = factory.getpersonaDao();
    }

    public void registrarCliente(String nombre, String apellidos, String nombreUsuario, String contrasenna, String edad, String pais, String email, String identificacion, String pathImg) {
        try {
            int edadCliente = Integer.parseInt(edad);
            int identificacionCliente = Integer.parseInt(identificacion);
            Cliente cliente = new Cliente(nombre,apellidos, pathImg, nombreUsuario, contrasenna, email, "Cliente", edadCliente, pais, identificacionCliente);
            usuarioDAO.guardar(cliente);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void comprobarAdministrador(){

        //Aqui va la comprobacion de la existencia de un administrador para poder ejecutar la app

    }

    public boolean iniciarSesion(String usuario, String contrasenna) throws SQLException {

        try {
            usuarioDAO.login(usuario, contrasenna);
        }catch (Exception e){
            System.out.println(e);
        }


        return true;
    }
}
