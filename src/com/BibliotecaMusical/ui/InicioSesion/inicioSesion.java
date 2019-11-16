package com.BibliotecaMusical.ui.InicioSesion;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class inicioSesion {

    public TextField txtUserName;
    public TextField txtPass;
    public Button btnRegistro;


    public void registroCliente(ActionEvent actionEvent) throws IOException {

        Scene scene = btnRegistro.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../RegistroCliente/registroCliente.fxml"));
        stage.setScene(new Scene(root));

    }
}
