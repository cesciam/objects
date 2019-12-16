package com.BibliotecaMusical.ui.Artista;


import com.BibliotecaMusical.bl.Artista.Artista;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ArtistaAdmin {


    public TableView tableArtista;
    public TableColumn colNombre;
    public TableColumn colGenero;
    public TableColumn colModificar;
    public TableColumn colEliminar;
    public Button btn_registraGenero;
    Controlador controlador = new Controlador();

    public void actualizarTabla(ActionEvent actionEvent) {
        ObservableList<Artista> comList = controlador.listaArtistas();
        tableArtista.setItems(null);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colEliminar.setCellValueFactory(new PropertyValueFactory<>("eliminar"));
        colModificar.setCellValueFactory(new PropertyValueFactory<>("modificar"));
        tableArtista.setItems(comList);
    }

    public void inicioAdmin(ActionEvent actionEvent) throws IOException {
        Scene scene = btn_registraGenero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../inicioAdmin/inicioAdmin.fxml"));
        stage.setScene(new Scene(root));
    }

    public void listaGenero(ActionEvent actionEvent) throws IOException {
        Scene scene = btn_registraGenero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Genero/generoAdmin.fxml"));
        stage.setScene(new Scene(root));
    }

    public void listaCompositor(ActionEvent actionEvent) throws IOException {
        Scene scene = btn_registraGenero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Compositor/CompositorAdmin.fxml"));
        stage.setScene(new Scene(root));
    }

    public void registrarArtista(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Artista/Artista.fxml"));
        stage.setTitle("Biblioteca Musical");
        stage.setScene(new Scene(root));
        stage.show();
    }


}
