package com.BibliotecaMusical.tl;

import com.BibliotecaMusical.bl.Factory.DAOFactory;
import com.BibliotecaMusical.bl.ListaReproduccion.IListaReproduccionDAO;
import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproducción;
import com.BibliotecaMusical.bl.Usuario.Cliente;
import com.BibliotecaMusical.bl.Usuario.IUsuarioDAO;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador {

    private IUsuarioDAO usuarioDAO;
    private DAOFactory factory;
    private IListaReproduccionDAO listaReproduccionDAO;

    public Controlador() {
        factory = DAOFactory.getDaoFactory(1);
        usuarioDAO = factory.getpersonaDao();
        listaReproduccionDAO = factory.getListaReproduccionDao();
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
        boolean login = false;
        try {
            login = usuarioDAO.login(usuario, contrasenna);
        }catch (Exception e){
            System.out.println(e);
        }
        return login;
    }

    public boolean tipoUsuario() {
        Usuario usuario = Usuario.getInstance();

        if (usuario.getTipo().equals("Cliente")){
            return  true;
        }else {
            return false;

        }
    }

    public ObservableList<ListaReproducción> ListarListasReproduccion() {
        ObservableList<ListaReproducción> lpList = FXCollections.observableArrayList();
        ArrayList<ListaReproducción> listaReproduccións = listaReproduccionDAO.listar();

        for (ListaReproducción listaReproducción: listaReproduccións){
            lpList.add(listaReproducción);
        }

        return lpList;
    }
}
