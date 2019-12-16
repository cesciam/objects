package com.BibliotecaMusical.ui.Compositor;

import com.BibliotecaMusical.bl.Compositor.Compositor;
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

import java.io.IOException;

public class CompositorAdmin {
    public TableView tableGCompositores;
    public TableColumn colNombre;
    public TableColumn colEliminar;
    public TableColumn colPais;
    public TableColumn colModificar;
    public Button btn_registraGenero;
    Controlador controlador = new Controlador();

    public void registrarCompositor(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Compositor/registroCompositor.fxml"));
        stage.setTitle("Biblioteca Musical");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void actualizarTabla(ActionEvent actionEvent) {
        ObservableList<Compositor> comList = controlador.listaCompositor();
        tableGCompositores.setItems(null);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colEliminar.setCellValueFactory(new PropertyValueFactory<>("eliminar"));
        colModificar.setCellValueFactory(new PropertyValueFactory<>("modificar"));
        tableGCompositores.setItems(comList);

    }
}
