package com.BibliotecaMusical.tl;

import com.BibliotecaMusical.bl.Artista.Artista;
import com.BibliotecaMusical.bl.Artista.IArtistaDao;
import com.BibliotecaMusical.bl.Cancion.Cancion;
import com.BibliotecaMusical.bl.Cancion.ICancionDao;
import com.BibliotecaMusical.bl.Compositor.Compositor;
import com.BibliotecaMusical.bl.Compositor.ICompositorDao;
import com.BibliotecaMusical.bl.Factory.DAOFactory;
import com.BibliotecaMusical.bl.Genero.Genero;
import com.BibliotecaMusical.bl.Genero.IGeneroDAO;
import com.BibliotecaMusical.bl.ListaReproduccion.IListaReproduccionDAO;
import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproducción;
import com.BibliotecaMusical.bl.Usuario.Administrador;
import com.BibliotecaMusical.bl.Usuario.Cliente;
import com.BibliotecaMusical.bl.Usuario.IUsuarioDAO;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controlador {

    private IUsuarioDAO usuarioDAO;
    private DAOFactory factory;
    private IListaReproduccionDAO listaReproduccionDAO;
    private IGeneroDAO generoDAO;
    private IArtistaDao artistaDao;
    private ICancionDao cancionDao;
    private ICompositorDao compositorDao;

    public Controlador() {
        factory = DAOFactory.getDaoFactory(1);
        usuarioDAO = factory.getpersonaDao();
        listaReproduccionDAO = factory.getListaReproduccionDao();
        generoDAO = factory.getGeneroDao();
        artistaDao = factory.getArtistaDao();
        cancionDao = factory.getCancionDao();
        compositorDao = factory.getCompositorDao();
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

    public boolean comprobarAdministrador() throws SQLException {
        boolean existe = usuarioDAO.buscarAdmin();
        return existe;
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

    public ObservableList<Genero> listaGeneros() {
        ObservableList<Genero> listaGeneros = FXCollections.observableArrayList();
        ArrayList<Genero> generos = generoDAO.listar();

        for (Genero genero: generos){
            Button eliminar = new Button();
            eliminar.setText("Eliminar");
            eliminar.setOnAction(event -> {
                eliminarGenero(genero.getId());
            });

            Button modificar = new Button();
            modificar.setText("Modificar");

            genero.setEliminar(eliminar);
            genero.setModificar(modificar);

            listaGeneros.add(genero);
        }

        return listaGeneros;
    }

    private void eliminarGenero(int id) {
        generoDAO.eliminar(id);
    }

    public ObservableList<Artista> listaArtistas() {
        ObservableList<Artista> listaArtistas = FXCollections.observableArrayList();
        ArrayList<Artista> artistas = artistaDao.listar();

        for (Artista artista: artistas){

            Button eliminar = new Button();
            eliminar.setText("Eliminar");
            eliminar.setOnAction(event -> {
                eliminarArtista(artista.getId());
            });

            Button modificar = new Button();
            modificar.setText("Modificar");

            artista.setEliminar(eliminar);
            artista.setModificar(modificar);
            listaArtistas.add(artista);
        }

        return listaArtistas;
    }

    private void eliminarArtista(int id) {
        artistaDao.eliminar(id);
    }

    public void registrarCancion(String nombre, String pathCancion, LocalDate fechaLanzamiento, int calificacion, Genero genero, Compositor compositor, Artista artista) {
        Cancion cancion = new Cancion(nombre, pathCancion, fechaLanzamiento,calificacion, genero, compositor, artista);
        cancionDao.registrar(cancion);
        cancionDao.registrarCancionCli(cancion);
    }

    public ObservableList<Compositor> listaCompositor() {
        ObservableList<Compositor> listaCompositor = FXCollections.observableArrayList();
        ArrayList<Compositor> compositors =compositorDao.listar();

        for (Compositor compositor: compositors){
            Button eliminar = new Button();
            eliminar.setText("Eliminar");
            eliminar.setOnAction(event -> {
                eliminarCompositor(compositor.getIdCompositor());
            });

            Button modificar = new Button();
            modificar.setText("Modificar");

            compositor.setEliminar(eliminar);
            compositor.setModificar(modificar);
            listaCompositor.add(compositor);
        }

        return listaCompositor;
    }

    private void eliminarCompositor(int idCompositor) {
        compositorDao.eliminar(idCompositor);
    }


    public void registrarLP(String nombre, LocalDate fechaCreacion, int calificacion) {
        ListaReproducción listaReproducción = new ListaReproducción(nombre, fechaCreacion, calificacion);
        listaReproduccionDAO.guardar(listaReproducción);
    }

    public void registrarCancionLP(ListaReproducción listaReproducción) {
        listaReproduccionDAO.registrarCancionEnLista(listaReproducción);
    }

    public ObservableList<Cancion> listaCancionesUsuarios() throws SQLException {
        ObservableList<Cancion> listaCancionesUsuario = FXCollections.observableArrayList();
        ArrayList<Cancion> canciones = cancionDao.cancionesUsuario();

        for (Cancion cancion: canciones){
            Button button = new Button();
            button.setText("Agregar a cola");
            cancion.setAgregarCola(button);
            listaCancionesUsuario.add(cancion);
        }

        return listaCancionesUsuario;
    }

    public ObservableList<Cancion> ListarCancionesLP(int idlp) throws SQLException {
        ObservableList<Cancion> listaCancionesUsuario = FXCollections.observableArrayList();
        ArrayList<Cancion> cancions = listaReproduccionDAO.getCancionesLista(idlp);

        for (Cancion cancion: cancions){
            Button buttonEliminar = new Button();
            buttonEliminar.setText("Eliminar");

            Button buttonCola = new Button();
            buttonCola.setText("Agregar a cola");

            cancion.setEliminar(buttonEliminar);
            cancion.setAgregarCola(buttonCola);

            listaCancionesUsuario.add(cancion);
        }

        return listaCancionesUsuario;
    }


    public void registrarAdmin(String nombre, String apellidos, String nombreUsuario, String contrasenna, String email, String pathImg) {
        Administrador administrador = new Administrador(nombre, apellidos, pathImg, nombreUsuario, contrasenna, email, "Admin");
        usuarioDAO.guardar(administrador);
    }

    public void registrarGenero(String nombre, String descripcion) {
        Genero genero = new Genero(nombre, descripcion);
        generoDAO.guardar(genero);
    }

    public void registrarArtista(String nombre, String apellidos, String nombreArtistico, LocalDate fechaNac, LocalDate fechaDead, String pais, String genero, int edad, String descripcion) {
        Artista artista = new Artista(nombre, apellidos, nombreArtistico, fechaNac, fechaDead, pais, genero, edad, descripcion);
        artistaDao.registrar(artista);
    }

    public void registrarCompositor(String nombre, String apellidos, String paises, String edad, String genero) {
        int edadint = Integer.valueOf(edad);
        Compositor compositor = new Compositor(nombre, apellidos, paises, edadint, genero);
        compositorDao.registrarCompositor(compositor);

    }

    public ObservableList<Cancion> listarCanciones() throws SQLException {

        ObservableList<Cancion> listaCanciones = FXCollections.observableArrayList();
        ArrayList<Cancion> cancions =cancionDao.listarCanciones();

        for (Cancion cancion: cancions){
            Button buttonEliminar = new Button();
            buttonEliminar.setText("Eliminar");

            Button buttonCola = new Button();
            buttonCola.setText("Agregar a cola");

            cancion.setEliminar(buttonEliminar);
            cancion.setAgregarCola(buttonCola);

            listaCanciones.add(cancion);
        }

        return listaCanciones;
    }
}
