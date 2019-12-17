package com.BibliotecaMusical.ui.Genero;

import com.BibliotecaMusical.bl.Genero.Genero;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class GeneroAdmin {
    public Button btn_registraGenero;
    public TableView tableGeneros;
    public TableColumn colNombre;
    public TableColumn colDescripcion;
    public TableColumn colEliminar;
    public TableColumn colModificar;
    Controlador controlador = new Controlador();

    public void registrarGenero(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Genero/Genero.fxml"));
        stage.setTitle("Biblioteca Musical");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void actualizarTabla(ActionEvent actionEvent) {
        ObservableList<Genero> genList = controlador.listaGeneros();
        tableGeneros.setItems(null);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colEliminar.setCellValueFactory(new PropertyValueFactory<>("eliminar"));
        colModificar.setCellValueFactory(new PropertyValueFactory<>("modificar"));

        tableGeneros.setItems(genList);

    }

    public void iniciioAdmin(ActionEvent actionEvent) throws IOException {

        Scene scene = btn_registraGenero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../inicioAdmin/inicioAdmin.fxml"));
        stage.setScene(new Scene(root));
    }

    public void cerrarSesion(ActionEvent actionEvent) throws IOException {
        Usuario.getInstance().setTipo(null);
        Usuario.getInstance().setNombreUsuario(null);
        Usuario.getInstance().setNombre(null);
        Usuario.getInstance().setTipo(null);
        Usuario.getInstance().setImg(null);
        Usuario.getInstance().setCorreo(null);
        Usuario.getInstance().setContrasenna(null);
        Usuario.getInstance().setIdUsuario(-1);


        Scene scene = btn_registraGenero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("/com/BibliotecaMusical/ui/InicioSesion/inicioSesion.fxml"));
        stage.setScene(new Scene(root));
    }

    public void generos(ActionEvent actionEvent) throws IOException {
        Scene scene = btn_registraGenero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Genero/generoAdmin.fxml"));
        stage.setScene(new Scene(root));
    }

    public void compositores(ActionEvent actionEvent) throws IOException {

        Scene scene = btn_registraGenero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Compositor/CompositorAdmin.fxml"));
        stage.setScene(new Scene(root));
    }

    public void artistas(ActionEvent actionEvent) throws IOException {
        Scene scene = btn_registraGenero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Artista/ArtistaAdmin.fxml"));
        stage.setScene(new Scene(root));
    }
}
