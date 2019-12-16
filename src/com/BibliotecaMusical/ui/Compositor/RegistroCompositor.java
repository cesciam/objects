package com.BibliotecaMusical.ui.Compositor;

import com.BibliotecaMusical.bl.Genero.Genero;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistroCompositor {
    public TextField txtNombre;
    public TextField txtApellidos;
    public ComboBox cbPaises;
    public TextField txtxId;
    public ComboBox cbgenero;
    Controlador controlador = new Controlador();

    public void registrarCompositor(ActionEvent actionEvent) {
        controlador.registrarCompositor(txtNombre.getText(), txtApellidos.getText(), cbPaises.getValue().toString(), txtxId.getText(), cbgenero.getValue().toString());

        Scene scene = cbPaises.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro correcto");
        alert.setHeaderText("El genero ha sido registrada!");
        alert.setContentText("El genero ha sido registrada de manera exitosa.");
        alert.show();

        stage.close();

    }

    public void listarPaises(MouseEvent mouseEvent) {
        ObservableList<String> countries = Stream.of(Locale.getISOCountries())
                .map(locales -> new Locale("", locales))
                .map(Locale::getDisplayCountry)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        cbPaises.setItems(countries);
    }

    public void listarGenero(MouseEvent mouseEvent) {
        ObservableList<Genero> genresList = controlador.listaGeneros();
        cbgenero.setItems(genresList);
    }
}
