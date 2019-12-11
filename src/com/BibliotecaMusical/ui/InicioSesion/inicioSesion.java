package com.BibliotecaMusical.ui.InicioSesion;

import com.BibliotecaMusical.tl.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class inicioSesion implements Initializable {

    public TextField txtUserName;
    public TextField txtPass;
    public Button btnRegistro;
    public Button btn_iniciarSesion;
    public Button btnRegistroAdmin;


    Controlador controlador = new Controlador();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        boolean existe = false;
        try {
            existe = controlador.comprobarAdministrador();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!existe){
            txtUserName.setDisable(true);
            txtPass.setDisable(true);
            btnRegistro.setDisable(true);
            btn_iniciarSesion.setDisable(true);
            btnRegistroAdmin.setVisible(true);
        }
    }


    public void registroCliente(ActionEvent actionEvent) throws IOException {
        Scene scene = btnRegistro.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../RegistroCliente/registroCliente.fxml"));
        stage.setScene(new Scene(root));
    }


    public void iniciarSesion(ActionEvent actionEvent) throws SQLException, IOException {

        if (!datosLlenos()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Error en el inicio de sesión");
            alert.setTitle("Error");
            alert.setContentText("Debe ingresar todos los datos.");
            alert.show();
            limpiarCajas();
        }else {
            if(controlador.iniciarSesion(txtUserName.getText(), txtPass.getText())){
                boolean cliente = controlador.tipoUsuario();

                if(cliente){
                    Scene scene = btnRegistro.getScene();
                    Window window = scene.getWindow();
                    Stage stage = (Stage) window;
                    Parent root = FXMLLoader.load(getClass().getResource("../inicioCliente/inicioCliente.fxml"));
                    stage.setScene(new Scene(root));
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Error en el inicio de sesión");
                alert.setTitle("Error");
                alert.setContentText("El usuario no existe, revise los datos que ingresó.");
                alert.show();
                limpiarCajas();
            }
        }
    }


    private boolean datosLlenos() {
        boolean datosLlenos = false;
        if (txtUserName.getText().equals("") ||txtUserName.equals(null)){
            datosLlenos = false;
        }else{
            datosLlenos = true;
        }

        if (txtPass.getText().equals("") ||txtPass.equals(null)){
            datosLlenos = false;
        }else{
            datosLlenos = true;
        }
        return datosLlenos;
    }

    private void limpiarCajas() {
        txtUserName.setText(null);
        txtPass.setText(null);
    }

    public void registrarAdministrador(ActionEvent actionEvent) throws IOException {
        Scene scene = btnRegistro.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../RegistroAdmin/registroAdmin.fxml"));
        stage.setScene(new Scene(root));
    }
}
