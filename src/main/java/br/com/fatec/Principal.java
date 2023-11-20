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
        scene = new Scene(loadFXML("view/Cinetec_login"));

        stage.setScene(scene);
        //stage.setFullScreen(true);
        //stage.setResizable(false);
  
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
    public static void main(String[] args) throws SQLException, IOException {
        //SendSmsBasic sendSmsBasic = new SendSmsBasic();
        //sendSmsBasic.send("5511974597492", "A15", "Harry Potter: As reliquias da morte parte 1", "20/11/2023 as 20:30");
        
       launch();
    }

}