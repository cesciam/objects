package com.BibliotecaMusical.ui.Artista;

import com.BibliotecaMusical.bl.Genero.Genero;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Artista {

    public ComboBox cb_paises;
    public TextField txt_nombre;
    public TextField txt_apellidos;
    public TextField txt_nombreArtistico;
    public DatePicker dp_fachaNac;
    public DatePicker dp_FechaDead;
    public TextField txt_edad;
    public TextArea txt_descripcion;
    public ComboBox cb_generos;

    Controlador controlador = new Controlador();

    public void listarPaises(MouseEvent mouseEvent) throws IOException {
        ObservableList<String> countries = Stream.of(Locale.getISOCountries())
                .map(locales -> new Locale("", locales))
                .map(Locale::getDisplayCountry)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        cb_paises.setItems(countries);
    }



    public void registrarCancion(ActionEvent actionEvent) {
        String nombre = txt_nombre.getText();
        String apellidos = txt_apellidos.getText();
        String nombreArtistico = txt_nombreArtistico.getText();
        LocalDate fechaNac = dp_fachaNac.getValue();
        LocalDate fechaDead = dp_FechaDead.getValue();
        String pais = (String) cb_paises.getValue();
        String genero = cb_generos.getValue().toString();
        String parseEdad = txt_edad.getText();
        int edad = Integer.parseInt(parseEdad);
        String descripcion = txt_descripcion.getText();

        controlador.registrarArtista(nombre, apellidos, nombreArtistico, fechaNac, fechaDead, pais, genero, edad, descripcion);

    }

    public void listarGeneros(MouseEvent mouseEvent) {
        ObservableList<Genero> genresList = controlador.listaGeneros();
        cb_generos.setItems(genresList);
    }
}
