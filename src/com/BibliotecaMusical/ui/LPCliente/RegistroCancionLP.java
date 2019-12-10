package com.BibliotecaMusical.ui.LPCliente;

import com.BibliotecaMusical.bl.Cancion.Cancion;
import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproducción;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

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
        listaReproducción.setCancionToUpload(cancion);
        controlador.registrarCancionLP(listaReproducción);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Registro exitoso!");
        alert.setTitle("Registro de cancion en lista.");
        alert.setContentText("La  cancion: "+((Cancion) cb_canciones.getValue()).getNombre()+ " ha sido registrada en la lista!");
        alert.show();

        Scene scene = cb_canciones.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        stage.close();
    }

    public void setListaReproducción(ListaReproducción listaReproducción) {
        this.listaReproducción = listaReproducción;
    }
}
