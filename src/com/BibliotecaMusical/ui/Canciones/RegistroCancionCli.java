package com.BibliotecaMusical.ui.Canciones;

import com.BibliotecaMusical.bl.Artista.Artista;
import com.BibliotecaMusical.bl.Genero.Genero;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class RegistroCancionCli {

    public DatePicker dp_fecha;
    public TextField txt_nombre;
    public TextField txt_Calificacion;
    public TextField txt_pathCancion;
    Controlador controlador = new Controlador();
    public ComboBox cb_generos;
    public ComboBox cb_artista;
    Image img;
    String pathSong = "";


    public void listarGeneros(MouseEvent mouseEvent) {
        ObservableList<Genero> genresList = controlador.listaGeneros();
        cb_generos.setItems(genresList);
    }

    public void listarArtista(MouseEvent mouseEvent) {
        ObservableList<Artista> artistList = controlador.listaArtistas();
        cb_artista.setItems(artistList);
    }

    public void subirCancion(ActionEvent actionEvent) throws IOException {
        Scene scene = cb_generos.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        byte[] btSong = Files.readAllBytes(selectedFile.toPath());
        ByteArrayInputStream imgByteArray = new ByteArrayInputStream(btSong);
        pathSong = selectedFile.toPath().toString();
        txt_pathCancion.setText(pathSong);
    }

    
}
