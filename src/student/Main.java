package student;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import student.values.Values;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Values values = new Values();

        Parent root = FXMLLoader.load(getClass().getResource("layouts/main.fxml"));
        primaryStage.setTitle(values.appName);
        primaryStage.setScene(new Scene(root, values.windowWidth, values.windowHeight));
        primaryStage.getIcons().add(new Image("student/images/student.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
