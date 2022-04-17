package com.gui.mainguiwindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class guiController implements Initializable {
    @FXML
    ProgressBar lifeBar1;
    @FXML
    ProgressBar lifeBar2;

    @FXML
    Label numTurn;

    // card image for board player 1
    @FXML
    ImageView player1BoardA;
    @FXML
    ImageView player1BoardB;
    @FXML
    ImageView player1BoardC;
    @FXML
    ImageView player1BoardD;
    @FXML
    ImageView player1BoardE;

    // card image for board player 2
    @FXML
    ImageView player2BoardA;
    @FXML
    ImageView player2BoardB;
    @FXML
    ImageView player2BoardC;
    @FXML
    ImageView player2BoardD;
    @FXML
    ImageView player2BoardE;

    // current stage label
    @FXML
    Label stageDrawLabel=new Label();
    @FXML
    Label stagePlanLabel=new Label();
    @FXML
    Label stageAttackLabel=new Label();
    @FXML
    Label stageEndLabel=new Label();

    // Label A,B,C,D,E board 1
    @FXML
    Label player1BoardALabel;
    @FXML
    Label player1BoardBLabel;
    @FXML
    Label player1BoardCLabel;
    @FXML
    Label player1BoardDLabel;
    @FXML
    Label player1BoardELabel;

    // Label A,B,C,D,E board 1
    @FXML
    Label player2BoardALabel;
    @FXML
    Label player2BoardBLabel;
    @FXML
    Label player2BoardCLabel;
    @FXML
    Label player2BoardDLabel;
    @FXML
    Label player2BoardELabel;

    // hand card
    @FXML
    ImageView handCard1;
    @FXML
    ImageView handCard2;
    @FXML
    ImageView handCard3;
    @FXML
    ImageView handCard4;
    @FXML
    ImageView handCard5;
    @FXML
    ImageView handCard6;

    // hovered card
    @FXML
    ImageView hoveredCard;

    // hovered card attribute
    @FXML
    Label cardAttribute;
    @FXML
    Label cardDescription;
    @FXML
    Label deckNum;
    @FXML
    Label manaNum;


    int idStage;
    int turn;

    public guiController(){
        // ini nanti buat masukin paramater inisialiasi gui
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize health
        lifeBar1.setProgress(1);
        lifeBar2.setProgress(1);
        lifeBar2.setRotate(180);

        // initialize number turn
        turn=1;
        numTurn.setText(Integer.toString(turn));

        // initialize stage
        idStage=0;
        activateStageLabel(stageEndLabel,stageDrawLabel);
    }

    public void changeStageClicked(){
        // kalau button untuk pindah stage diclick
        if(idStage==0){
            activateStageLabel(stageDrawLabel,stagePlanLabel);
        }else if(idStage==1){
            activateStageLabel(stagePlanLabel,stageAttackLabel);
        }else if(idStage==2){
            activateStageLabel(stageAttackLabel,stageEndLabel);
        }else if(idStage==3){
            activateStageLabel(stageEndLabel,stageDrawLabel);
        }
        idStage++;
        idStage%=4;

        if(idStage==0){
            turn++;
            numTurn.setText(Integer.toString(turn));
        }


        // panggil method sesuai dengan apa yang ingin dilakuin di stage itu
    }

    public void activateStageLabel(Label lastStage,Label newStage){
        lastStage.getStyleClass().removeIf(style -> style.equals("backgroundBtnActive"));
        newStage.getStyleClass().addAll("backgroundBtnActive");
    }

    // Drag and Drop Image
    
}