package com.BibliotecaMusical.ui.RegistroCliente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistroCliente {

    public ComboBox CBpaises;


    public void listarPaises(MouseEvent mouseEvent) {
        ObservableList<String> countries = Stream.of(Locale.getISOCountries())
                .map(locales -> new Locale("", locales))
                .map(Locale::getDisplayCountry)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        CBpaises.setItems(countries);
    }
}
