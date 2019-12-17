package com.BibliotecaMusical.ui.Compositor;

import com.BibliotecaMusical.bl.Compositor.Compositor;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import com.BibliotecaMusical.tl.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class CompositorAdmin {
    public TableView tableGCompositores;
    public TableColumn colNombre;
    public TableColumn colEliminar;
    public TableColumn colPais;
    public TableColumn colModificar;
    public Button btn_registraGenero;
    Controlador controlador = new Controlador();

    public void registrarCompositor(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Compositor/registroCompositor.fxml"));
        stage.setTitle("Biblioteca Musical");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void actualizarTabla(ActionEvent actionEvent) {
        ObservableList<Compositor> comList = controlador.listaCompositor();
        tableGCompositores.setItems(null);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colEliminar.setCellValueFactory(new PropertyValueFactory<>("eliminar"));
        colModificar.setCellValueFactory(new PropertyValueFactory<>("modificar"));
        tableGCompositores.setItems(comList);

    }

    public void inicioCliente(ActionEvent actionEvent) throws IOException {
        Scene scene = tableGCompositores.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../inicioCliente/inicioCliente.fxml"));
        stage.setScene(new Scene(root));
    }

    public void generos(ActionEvent actionEvent) throws IOException {
        Scene scene = tableGCompositores.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Genero/generoAdmin.fxml"));
        stage.setScene(new Scene(root));
    }

    public void artistas(ActionEvent actionEvent) throws IOException {
        Scene scene = tableGCompositores.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Artista/ArtistaAdmin.fxml"));
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


        Scene scene = tableGCompositores.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("/com/BibliotecaMusical/ui/InicioSesion/inicioSesion.fxml"));
        stage.setScene(new Scene(root));

    }
}
