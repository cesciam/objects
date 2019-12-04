package com.BibliotecaMusical.ui.inicioCliente;

import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproducción;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioCliente implements  Initializable{

    Controlador controlador = new Controlador();

    public TableView<ListaReproducción> tableLlistas;
    public TableColumn<ListaReproducción, String> table_nombre;
    public TableColumn<ListaReproducción, String> table_fecha;
    public TableColumn<ListaReproducción, String> table_calificacion;
    public TableColumn<ListaReproducción, Button> table_ver;

    ObservableList<ListaReproducción>  lpList = controlador.ListarListasReproduccion();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controlador.ListarListasReproduccion();
        table_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        table_fecha.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        table_calificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));

        tableLlistas.setItems(lpList);
    }

    public void registrarListaDeReproduccion(ActionEvent actionEvent) {
    }

    public void listarCanciones(ActionEvent actionEvent) throws IOException {
        Scene scene = tableLlistas.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Canciones/listarCancionesCli.fxml"));
        stage.setScene(new Scene(root));
    }
}
