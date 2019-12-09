package com.BibliotecaMusical.ui.LPCliente;

import com.BibliotecaMusical.bl.ListaReproduccion.ListaReproducción;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PerfilLP implements Initializable {
    public Label txtNombreLP;
    public TableView tb_Canciones;
    public TableColumn col_nombre;
    public TableColumn col_artista;
    public TableColumn col_btnCola;
    public TableColumn col_btnEliminar;
    private ListaReproducción listaReproducción;

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
}
