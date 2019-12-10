package com.BibliotecaMusical.ui.LPCliente;

import com.BibliotecaMusical.bl.Cancion.Cancion;
import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproducción;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PerfilLP implements Initializable {
    public Label txtNombreLP;
    public TableView tb_Canciones;
    public TableColumn col_nombre;
    public TableColumn col_btnCola;
    public TableColumn col_btnEliminar;
    private ListaReproducción listaReproducción;

    Controlador controlador = new Controlador();

    @Override
    public void initialize(URL location, ResourceBundle resources){
    }

    public ListaReproducción getListaReproducción() {
        return listaReproducción;
    }

    public void setListaReproducción(ListaReproducción listaReproducción) {
        this.listaReproducción = listaReproducción;
        //Aqui va el metodo que carga las canciones en el table view
        txtNombreLP.setText(listaReproducción.getNombre());
    }


    public void actualizarTabla(ActionEvent actionEvent) {
        ObservableList<Cancion> lpCancionsList = null;
        try {
            lpCancionsList = controlador.ListarCancionesLP(listaReproducción.getIdlp());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_btnCola.setCellValueFactory(new PropertyValueFactory<>("agregarCola"));
        col_btnEliminar.setCellValueFactory(new PropertyValueFactory<>("eliminar"));
        tb_Canciones.setItems(lpCancionsList);
    }

    public void agregarCancion(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Biblioteca Musical");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../LPCliente/RegistroCancionLP.fxml"));
        Parent root = loader.load();
        RegistroCancionLP RegistroCancionLP = loader.getController();
        RegistroCancionLP.setListaReproducción(listaReproducción);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void canciones(ActionEvent actionEvent) throws IOException {
        Scene scene = tb_Canciones.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Canciones/listarCancionesCli.fxml"));
        stage.setScene(new Scene(root));
    }

    public void listaReproduccion(ActionEvent actionEvent) throws IOException {
        Scene scene = tb_Canciones.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../inicioCliente/inicioCliente.fxml"));
        stage.setScene(new Scene(root));
    }
}
