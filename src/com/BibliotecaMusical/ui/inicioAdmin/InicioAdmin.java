package com.BibliotecaMusical.ui.inicioAdmin;

import com.BibliotecaMusical.bl.Usuario.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class InicioAdmin {
    public Button btn_genero;

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
}
