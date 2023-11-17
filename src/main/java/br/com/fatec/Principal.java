package br.com.fatec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

/**
 * JavaFX Principal
 */
public class Principal extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD
        scene = new Scene(loadFXML("view/Cinetec_cadFilmes"));
=======
        scene = new Scene(loadFXML("view/Cinetec_CadFilmes"));
>>>>>>> 6ad39eb1af38e33b97f0b8ae6420689b74d1fa9e
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
  
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void fechar() {
        stage.close();
    }
    public static void main(String[] args) throws SQLException {
        launch();
    }

}