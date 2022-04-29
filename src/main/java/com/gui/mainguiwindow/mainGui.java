package com.gui.mainguiwindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
// import com.aetherwars.model.Type;
// import com.aetherwars.model.Character;
// import com.aetherwars.model.Card;
// import com.aetherwars.util.CSVReader;
// import com.aetherwars.model.CardReader;

public class mainGui extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(mainGui.class.getResource("gui.fxml"));

        fxmlLoader.setController(new guiController()); //kalau mau tambahin params

        Scene scene = new Scene(fxmlLoader.load(), 960, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}