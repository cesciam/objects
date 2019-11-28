package com.BibliotecaMusical.ui;

        import com.BibliotecaMusical.tl.Controlador;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

public class Main extends Application {

    Controlador controlador = new Controlador();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("InicioSesion/inicioSesion.fxml"));
        primaryStage.setTitle("Biblioteca Musical");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        controlador.comprobarAdministrador();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
