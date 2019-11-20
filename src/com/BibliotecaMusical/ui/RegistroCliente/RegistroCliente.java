package com.BibliotecaMusical.ui.RegistroCliente;

import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;

import java.util.Locale;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistroCliente {

    Controlador controlador = new Controlador();

    public ComboBox CBpaises;
    public ImageView imagePreview;
    public TextField txtNombre;
    public TextField txtApellidos;
    public TextField txtNombreUsuario;
    public TextField txtContrasenna;
    public TextField txtEmail;
    public TextField txtIdentifacion;
    public TextField txtEdad;
    Image img;
    String pathImg = "";



    public void listarPaises(MouseEvent mouseEvent) throws IOException {
        ObservableList<String> countries = Stream.of(Locale.getISOCountries())
                .map(locales -> new Locale("", locales))
                .map(Locale::getDisplayCountry)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        CBpaises.setItems(countries);
    }

    public void subirImgaen(ActionEvent actionEvent) throws IOException {
        Scene scene = CBpaises.getScene();
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

    public void registrarUsuario(ActionEvent actionEvent) {
        String nombre =txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasenna = txtContrasenna.getText();
        String edad = txtEdad.getText();
        String pais = (String) CBpaises.getValue();
        String email = txtEmail.getText();
        String identificacion = txtIdentifacion.getText();

        boolean error = validarDatos(nombre, apellidos, nombreUsuario, contrasenna,edad, pais, email, identificacion, pathImg);
        if (error){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Problemas con las validaciones.");
            alert.setContentText("Revise los campos marcados en rojo.");
            alert.show();
        }else {
            controlador.registrarCliente(nombre, apellidos, nombreUsuario, contrasenna,edad, pais, email, identificacion, pathImg);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro");
            alert.setHeaderText("Registro de cliente");
            alert.setContentText("El usuario ha sido registrado y se envio la informacion al correo.");
            alert.show();
            limpiarCajas();
        }

    }

    private void limpiarCajas() {
        CBpaises.setValue(null);
        imagePreview.setImage(null);
        txtNombre.setText(null);
        txtApellidos.setText(null);
        txtNombreUsuario.setText(null);
        txtContrasenna.setText(null);
        txtEmail.setText(null);
        txtIdentifacion.setText(null);
        txtEdad.setText(null);
    }

    private boolean validarDatos(String nombre, String apellidos, String nombreUsuario, String contrasenna, String edad, String pais, String email, String identificacion, String imagen) {
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
        if (edad.equals("")){
            error = true;
            txtEdad.setBorder(redBorder);
        }else {
            txtEdad.setBorder(null);
        }
        if (pais == null){
            error = true;
            CBpaises.setBorder(redBorder);
        }else{
            CBpaises.setBorder(null);
        }
        if (email.equals("")){
            error = true;
            txtEmail.setBorder(redBorder);
        }else {
            txtEmail.setBorder(null);
        }
        if (identificacion.equals("")){
            error = true;
            txtIdentifacion.setBorder(redBorder);
        }
        else {
            txtIdentifacion.setBorder(null);
        }
        if (imagen.equals("")){
            error= true;
        }
        return error;
    }
}
