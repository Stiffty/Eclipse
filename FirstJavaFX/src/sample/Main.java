package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");

        button1.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
        button2.setStyle("-fx-background-color: #00ff00");
        button3.setStyle("-fx-font-size: 2em; ");
        button4.setStyle("-fx-text-fill: #0000ff");

        GridPane  root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        button1.setTranslateX(100);
        button1.setTranslateY(50);
        //button1.setScaleX(20);
        //button1.setLayoutX(20);


        root.getChildren().addAll(button1);
        root.getChildren().addAll(button2);


        GridPane hbox = new GridPane();


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 500));
        //primaryStage.setOpacity(0.2);
        primaryStage.show();
       // root.add

    }



    public static void main(String[] args) {
        launch(args);
    }
}
