package com.BibliotecaMusical.ui.LPCliente;

import com.BibliotecaMusical.tl.Controlador;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.time.LocalDate;

public class RegistroLP {
    public Button btn_registro;
    public TextField txt_calificacion;
    public TextField txt_nombre;
    Controlador controlador = new Controlador();
    public void registrarLista(ActionEvent actionEvent) {
        LocalDate fechaCreacion = LocalDate.now();
        int calificacion = Integer.parseInt(txt_calificacion.getText());
        controlador.registrarLP(txt_nombre.getText(), fechaCreacion, calificacion);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Registro exitoso!");
        alert.setTitle("Registro de lista de reproduccion.");
        alert.setContentText("La lista de reproduccion: "+txt_nombre.getText()+ " ha sido registrada!");
        alert.show();

        Scene scene = btn_registro.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        stage.close();
    }
}
