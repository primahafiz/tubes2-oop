package com.gui.mainguiwindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    ProgressBar progressBar1;
    @FXML
    ProgressBar progressBar2;
    @FXML
    Label numTurn;
    @FXML
    BorderPane player1Img;
    @FXML
    BorderPane player2Img;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressBar1.setProgress(0.8);
        progressBar2.setProgress(0.7);
        progressBar2.setRotate(180);

        progressBar1.setStyle("-fx-accent: #00bb00");
        progressBar2.setStyle("-fx-accent: #00bb00");

//        Image img1= new Image(getClass().getResourceAsStream("img/alex.jpeg"));
//        player1Img.getChildren().add(new ImageView(img1));

        numTurn.setText("1");
    }
}