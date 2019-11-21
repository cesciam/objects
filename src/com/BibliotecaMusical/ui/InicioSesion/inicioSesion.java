package com.BibliotecaMusical.ui.InicioSesion;

import com.BibliotecaMusical.tl.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class inicioSesion {

    public TextField txtUserName;
    public TextField txtPass;
    public Button btnRegistro;

    Controlador controlador = new Controlador();

    public void registroCliente(ActionEvent actionEvent) throws IOException {

        Scene scene = btnRegistro.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../RegistroCliente/registroCliente.fxml"));
        stage.setScene(new Scene(root));
    }


    public void iniciarSesion(ActionEvent actionEvent) throws SQLException {
        boolean datosCorrectos = controlador.iniciarSesion(txtUserName.getText(), txtPass.getText());

    }
}
