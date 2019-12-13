package com.BibliotecaMusical.ui.Genero;

import com.BibliotecaMusical.tl.Controlador;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Genero {
    public TextField txtNombre;
    public TextArea txtDescripcion;
    public Button btn_registrar;

    Controlador controlador = new Controlador();

    public void registrarGenero(ActionEvent actionEvent) {
        String nombre = txtNombre.getText();
        String descripcion = txtDescripcion.getText();

        controlador.registrarGenero(nombre, descripcion);

        Scene scene = btn_registrar.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro correcto");
        alert.setHeaderText("El genero ha sido registrada!");
        alert.setContentText("El genero ha sido registrada de manera exitosa.");
        alert.show();

        stage.close();
    }
}
