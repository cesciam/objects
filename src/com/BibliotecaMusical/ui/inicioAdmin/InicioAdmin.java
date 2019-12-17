package com.BibliotecaMusical.ui.inicioAdmin;

import com.BibliotecaMusical.bl.Cancion.Cancion;
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
import java.sql.SQLException;

public class InicioAdmin {
    public Button btn_genero;
    public TableView table_canciones;
    public TableColumn col_nombre;
    public TableColumn col_artista;
    public TableColumn col_genero;
    public TableColumn col_fechaLanzamiento;
    public TableColumn col_calificacion;
    public TableColumn col_btnAgregar;
    Controlador controlador = new Controlador();

    public void generoLista(ActionEvent actionEvent) throws IOException {
        Scene scene = btn_genero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Genero/generoAdmin.fxml"));
        stage.setScene(new Scene(root));
    }

    public void compositorLista(ActionEvent actionEvent) throws IOException {
        Scene scene = btn_genero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Compositor/CompositorAdmin.fxml"));
        stage.setScene(new Scene(root));
    }


    public void artistaLista(ActionEvent actionEvent) throws IOException {
        Scene scene = btn_genero.getScene();
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


        Scene scene = btn_genero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("/com/BibliotecaMusical/ui/InicioSesion/inicioSesion.fxml"));
        stage.setScene(new Scene(root));
    }

    public void actualizarTabla(ActionEvent actionEvent) throws SQLException {

       table_canciones.setItems(null);
        ObservableList<Cancion> cancions = controlador.listarCanciones();
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_artista.setCellValueFactory(new PropertyValueFactory<>("artistaName"));
        col_genero.setCellValueFactory(new PropertyValueFactory<>("generoName"));
        col_fechaLanzamiento.setCellValueFactory( new PropertyValueFactory<>("fechaLanzamiento"));
        col_calificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        col_btnAgregar.setCellValueFactory(new PropertyValueFactory<>("eliminar"));

        table_canciones.setItems(cancions);

    }

    public void registrarCancion(ActionEvent actionEvent) throws IOException {
        Scene scene = btn_genero.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Canciones/cancionesAdmin.fxml"));
        stage.setScene(new Scene(root));
    }
}
