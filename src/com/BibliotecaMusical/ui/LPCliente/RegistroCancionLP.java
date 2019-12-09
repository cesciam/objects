package com.BibliotecaMusical.ui.LPCliente;

import com.BibliotecaMusical.bl.Cancion.Cancion;
import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproducción;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class RegistroCancionLP {
    public ComboBox cb_canciones;
    Controlador controlador = new Controlador();
    private ListaReproducción listaReproducción;

    public void listarCanciones(MouseEvent mouseEvent) throws SQLException {
        ObservableList<Cancion> cancions = controlador.listaCancionesUsuarios();
        cb_canciones.setItems(cancions);
    }

    public void registrarCancionLista(ActionEvent actionEvent) {
        Cancion cancion = (Cancion) cb_canciones.getValue();
        listaReproducción.addCancion(cancion);
        controlador.registrarCancionLP(listaReproducción);
    }

    public void setListaReproducción(ListaReproducción listaReproducción) {
        this.listaReproducción = listaReproducción;
    }
}
