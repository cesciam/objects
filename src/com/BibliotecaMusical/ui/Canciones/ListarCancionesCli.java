package com.BibliotecaMusical.ui.Canciones;

import com.BibliotecaMusical.bl.Cancion.Cancion;
import com.BibliotecaMusical.bl.Usuario.Usuario;
import com.BibliotecaMusical.tl.Controlador;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListarCancionesCli implements Initializable {
    
    public Button btnAgregarCancion;
    public TableColumn col_nombre;
    public TableColumn col_artista;
    public TableColumn col_genero;
    public TableColumn col_fechaLanzamiento;
    public TableColumn col_calificacion;
    public TableColumn col_btnAgregar;
    public TableView table_canciones;

    Controlador controlador = new Controlador();


    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            ObservableList<Cancion> canList = controlador.listaCancionesUsuarios();
            col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            col_artista.setCellValueFactory(new PropertyValueFactory<>("artistaName"));
            col_genero.setCellValueFactory(new PropertyValueFactory<>("generoName"));
            col_fechaLanzamiento.setCellValueFactory(new PropertyValueFactory<>("fechaLanzamiento"));
            col_calificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));
            col_btnAgregar.setCellValueFactory(new PropertyValueFactory<>("agregarCola"));
            table_canciones.setItems(canList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void registrarLCancionCliente(ActionEvent actionEvent) throws IOException {
        Scene scene = btnAgregarCancion.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../Canciones/registroCancionCli.fxml"));
        stage.setScene(new Scene(root));

    }

    public void listasReproduccion(ActionEvent actionEvent) throws IOException {
        Scene scene = btnAgregarCancion.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("../inicioCliente/inicioCliente.fxml"));
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


        Scene scene = btnAgregarCancion.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        Parent root = FXMLLoader.load(getClass().getResource("/com/BibliotecaMusical/ui/InicioSesion/inicioSesion.fxml"));
        stage.setScene(new Scene(root));
    }
}
