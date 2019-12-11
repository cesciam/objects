package com.BibliotecaMusical.ui.RegistroAdmin;

import com.BibliotecaMusical.tl.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class RegistroAdmin {
    public TextField txtNombre;
    public TextField txtApellidos;
    public TextField txtNombreUsuario;
    public TextField txtContrasenna;
    public ImageView imagePreview;
    public TextField txtEmail;
    Image img;
    String pathImg = "";
    Controlador controlador = new Controlador();

    public void subirImgaen(ActionEvent actionEvent) throws IOException {
        Scene scene = txtNombre.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.bmp", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        byte[] btImagen = Files.readAllBytes(selectedFile.toPath());
        ByteArrayInputStream imgByteArray = new ByteArrayInputStream(btImagen);
        img = new Image(imgByteArray, 199, 199, false, false);;
        imagePreview.setImage(img);
        pathImg = selectedFile.toPath().toString();
    }

    public void registrarUsuario(ActionEvent actionEvent) throws IOException {
        String nombre =txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasenna = txtContrasenna.getText();
        String email = txtEmail.getText();

        boolean error = validarDatos(nombre, apellidos, nombreUsuario, contrasenna, email, pathImg);
        error = validarContrasenna(contrasenna);
        if (error){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Problemas con las validaciones.");
            alert.setContentText("Revise los campos marcados en rojo.");
            alert.show();
        }else {
            controlador.registrarAdmin(nombre, apellidos, nombreUsuario, contrasenna, email, pathImg);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro");
            alert.setHeaderText("Registro de cliente");
            alert.setContentText("El usuario ha sido registrado y se envio la informacion al correo.");
            alert.show();
            limpiarCajas();
            Scene scene = txtEmail.getScene();
            Window window = scene.getWindow();
            Stage stage = (Stage) window;
            Parent root = FXMLLoader.load(getClass().getResource("../InicioSesion/inicioSesion.fxml"));
            stage.setScene(new Scene(root));
        }
    }

    public void volverInicio(ActionEvent actionEvent) throws IOException {
        Scene scene = txtNombre.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../InicioSesion/inicioSesion.fxml"));
        stage.setScene(new Scene(root));
    }
    private void limpiarCajas() {
        imagePreview.setImage(null);
        txtNombre.setText(null);
        txtApellidos.setText(null);
        txtNombreUsuario.setText(null);
        txtContrasenna.setText(null);
        txtEmail.setText(null);
    }
    private boolean validarDatos(String nombre, String apellidos, String nombreUsuario, String contrasenna, String email, String imagen) {
        boolean error = false;
        Border redBorder = new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));


        if (nombre.equals("")){
            txtNombre.setBorder(redBorder);
            error = true;
        }else {
            txtNombre.setBorder(null);
        }

        if (apellidos.equals("")){
            error = true;
            txtApellidos.setBorder(redBorder);
        }else {
            txtApellidos.setBorder(null);
        }
        if (nombreUsuario.equals("")){
            error = true;
            txtNombreUsuario.setBorder(redBorder);
        }else{
            txtNombreUsuario.setBorder(null);
        }
        if (contrasenna.equals("")){
            error = true;
            txtContrasenna.setBorder(redBorder);
        }else {
            txtContrasenna.setBorder(null);
        }
        if (imagen.equals("")){
            error= true;
        }
        return error;
    }
    private boolean validarContrasenna(String contrasenna) {


        return false;
    }
}
