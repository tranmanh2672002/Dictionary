package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    public static void main (String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/main.fxml")));
        primaryStage.setTitle("Dictionary");
        Scene menu = new Scene(rootMenu, 700, 550);
        Image image = new Image("/icon.png");
        primaryStage.getIcons().add(image);
        primaryStage.setScene(menu);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}