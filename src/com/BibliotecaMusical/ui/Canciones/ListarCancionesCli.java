package com.BibliotecaMusical.ui.Canciones;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ListarCancionesCli {
    
    public Button btnAgregarCancion;
    public TableColumn col_nombre;
    public TableColumn col_artista;
    public TableColumn col_genero;
    public TableColumn col_fechaLanzamiento;
    public TableColumn col_calificacion;
    public TableColumn col_btnAgregar;
    public TableView table_canciones;

    public void registrarLCancionCliente(ActionEvent actionEvent) throws IOException {
        Scene scene = btnAgregarCancion.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Canciones/registroCancionCli.fxml"));
        stage.setScene(new Scene(root));

    }
}
