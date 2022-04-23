package com.gui.mainguiwindow;

import com.aetherwars.model.*;
import com.aetherwars.model.Character;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.aetherwars.util.CSVReader;

import com.aetherwars.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    // hand card mana
    @FXML
    Label handCard1Mana;
    @FXML
    Label handCard2Mana;
    @FXML
    Label handCard3Mana;
    @FXML
    Label handCard4Mana;
    @FXML
    Label handCard5Mana;

    @FXML
    Label handCard1AtkHealth;
    @FXML
    Label handCard2AtkHealth;
    @FXML
    Label handCard3AtkHealth;
    @FXML
    Label handCard4AtkHealth;
    @FXML
    Label handCard5AtkHealth;

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

    ImageView currentDrag;

    int idStage;
    int turn;

    Board boardPemain1;
    Board boardPemain2;

    Hand handPemain1;
    Hand handPemain2;

    Deck deckPemain1;
    Deck deckPemain2;



    public guiController(){
        // ini nanti buat masukin paramater inisialiasi gui
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize board, hand,deck
        deckPemain1 = new Deck();
        deckPemain2 = new Deck();

        handPemain1 = new Hand();
        handPemain2 = new Hand();

        debugging();

        // initialize health
        lifeBar1.setProgress(1);
        lifeBar2.setProgress(1);
        lifeBar2.setRotate(180);

        // initialize number turn
        turn = 1;
        numTurn.setText(Integer.toString(turn));

        // initialize stage
        idStage = -1;

        player1BoardA.setImage(new Image(getClass().getResourceAsStream("image/alex.jpeg")));
        player2BoardB.setImage(new Image(getClass().getResourceAsStream("image/steve.jpeg")));

    }

    public void initDragAndDropBoardPlayer1(){
        player1BoardA.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player1BoardA.startDragAndDrop(TransferMode.ANY);
            currentDrag = player1BoardA;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player1BoardA.getImage());
            db.setContent(content);
            event.consume();
        });

        player1BoardA.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player1BoardA.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("1")) {
                    player1BoardA.setImage(db.getImage());
                    player1BoardALabel.setVisible(false);
                }

                event.consume();
            }
        });

        player1BoardB.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player1BoardB.startDragAndDrop(TransferMode.ANY);
            currentDrag = player1BoardB;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player1BoardB.getImage());
            db.setContent(content);
            event.consume();
        });

        player1BoardB.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player1BoardB.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("1")){
                    player1BoardB.setImage(db.getImage());
                    player1BoardBLabel.setVisible(false);
                }

                event.consume();
            }
        });

        player1BoardC.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player1BoardC.startDragAndDrop(TransferMode.ANY);
            currentDrag = player1BoardC;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player1BoardC.getImage());
            db.setContent(content);
            event.consume();
        });

        player1BoardC.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player1BoardC.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("1")){
                    player1BoardC.setImage(db.getImage());
                    player1BoardCLabel.setVisible(false);
                }

                event.consume();
            }
        });

        player1BoardD.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player1BoardD.startDragAndDrop(TransferMode.ANY);
            currentDrag = player1BoardD;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player1BoardD.getImage());
            db.setContent(content);
            event.consume();
        });

        player1BoardD.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player1BoardD.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("1")){
                    player1BoardD.setImage(db.getImage());
                    player1BoardDLabel.setVisible(false);
                }

                event.consume();
            }
        });

        player1BoardE.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player1BoardE.startDragAndDrop(TransferMode.ANY);
            currentDrag = player1BoardE;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player1BoardE.getImage());
            db.setContent(content);
            event.consume();
        });

        player1BoardE.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player1BoardE.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("1")){
                    player1BoardE.setImage(db.getImage());
                    player1BoardELabel.setVisible(false);
                }

                event.consume();
            }
        });
    }

    public void initDragAndDropBoardPlayer2(){
        player2BoardA.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player2BoardA.startDragAndDrop(TransferMode.ANY);
            currentDrag = player2BoardA;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player2BoardA.getImage());
            db.setContent(content);
            event.consume();
        });

        player2BoardA.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player2BoardA.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("2")) {
                    player2BoardA.setImage(db.getImage());
                    player2BoardALabel.setVisible(false);
                }

                event.consume();
            }
        });

        player2BoardB.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player2BoardB.startDragAndDrop(TransferMode.ANY);
            currentDrag = player2BoardB;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player2BoardB.getImage());
            db.setContent(content);
            event.consume();
        });

        player2BoardB.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player2BoardB.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("2")) {
                    player2BoardB.setImage(db.getImage());
                    player2BoardBLabel.setVisible(false);
                }
                event.consume();
            }
        });

        player2BoardC.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player2BoardC.startDragAndDrop(TransferMode.ANY);
            currentDrag = player2BoardC;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player2BoardC.getImage());
            db.setContent(content);
            event.consume();
        });

        player2BoardC.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player2BoardC.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("2")){
                    player2BoardC.setImage(db.getImage());
                    player2BoardCLabel.setVisible(false);
                }
                event.consume();
            }
        });

        player2BoardD.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player2BoardD.startDragAndDrop(TransferMode.ANY);
            currentDrag = player2BoardD;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player2BoardD.getImage());
            db.setContent(content);
            event.consume();
        });

        player2BoardD.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player2BoardD.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("2")) {
                    player2BoardD.setImage(db.getImage());
                    player2BoardDLabel.setVisible(false);
                }
                event.consume();
            }
        });

        player2BoardE.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = player2BoardE.startDragAndDrop(TransferMode.ANY);
            currentDrag = player2BoardE;
            ClipboardContent content = new ClipboardContent();
            content.putImage(player2BoardE.getImage());
            db.setContent(content);
            event.consume();
        });

        player2BoardE.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        player2BoardE.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDrag);
                if(currentDrag.getId().substring(6,7).equals("2")){
                    player2BoardE.setImage(db.getImage());
                    player2BoardELabel.setVisible(false);
                }
                event.consume();
            }
        });
    }

    public void endDragAndDrop1(){
        player1BoardA.setOnDragDetected(null);
        player1BoardA.setOnDragOver(null);
        player1BoardA.setOnDragDropped(null);

        player1BoardB.setOnDragDetected(null);
        player1BoardB.setOnDragOver(null);
        player1BoardB.setOnDragDropped(null);

        player1BoardC.setOnDragDetected(null);
        player1BoardC.setOnDragOver(null);
        player1BoardC.setOnDragDropped(null);

        player1BoardD.setOnDragDetected(null);
        player1BoardD.setOnDragOver(null);
        player1BoardD.setOnDragDropped(null);

        player1BoardE.setOnDragDetected(null);
        player1BoardE.setOnDragOver(null);
        player1BoardE.setOnDragDropped(null);
    }

    public void endDragAndDrop2(){
        player2BoardA.setOnDragDetected(null);
        player2BoardA.setOnDragOver(null);
        player2BoardA.setOnDragDropped(null);

        player2BoardB.setOnDragDetected(null);
        player2BoardB.setOnDragOver(null);
        player2BoardB.setOnDragDropped(null);

        player2BoardC.setOnDragDetected(null);
        player2BoardC.setOnDragOver(null);
        player2BoardC.setOnDragDropped(null);

        player2BoardD.setOnDragDetected(null);
        player2BoardD.setOnDragOver(null);
        player2BoardD.setOnDragDropped(null);

        player2BoardE.setOnDragDetected(null);
        player2BoardE.setOnDragOver(null);
        player2BoardE.setOnDragDropped(null);
    }

    public void changeStageClicked(){
        // kalau button untuk pindah stage diclick
        if(idStage==-1){
            if(turn%2==1) {
                updateHand1();
            }else{
                updateHand2();
            }
            displayWindowDraw();
            if(turn%2==1) {
                updateHand1();
            }else{
                updateHand2();
            }
            activateStageLabel(stageEndLabel,stageDrawLabel);
        } else if(idStage==0){
            if(turn%2==1){
                initDragAndDropBoardPlayer1();
            }else{
                initDragAndDropBoardPlayer2();
            }
            activateStageLabel(stageDrawLabel,stagePlanLabel);
        }else if(idStage==1){
            if(turn%2==1){
                endDragAndDrop1();
            }else{
                endDragAndDrop2();
            }
            activateStageLabel(stagePlanLabel,stageAttackLabel);
        }else if(idStage==2){
            activateStageLabel(stageAttackLabel,stageEndLabel);
        }else if(idStage==3){
            turn++;
            numTurn.setText(Integer.toString(turn));
            if(turn%2==1) {
                updateHand1();
            }else{
                updateHand2();
            }
            displayWindowDraw();
            if(turn%2==1) {
                updateHand1();
            }else{
                updateHand2();
            }
            activateStageLabel(stageEndLabel,stageDrawLabel);
        }
        idStage++;
        idStage%=4;


        // panggil method sesuai dengan apa yang ingin dilakuin di stage itu
    }

    public void activateStageLabel(Label lastStage,Label newStage){
        lastStage.getStyleClass().removeIf(style -> style.equals("backgroundBtnActive"));
        newStage.getStyleClass().addAll("backgroundBtnActive");
    }

    public void displayWindowDraw(){
        Hand currentHand;
        Deck currentDeck;
        if(turn%2==1){
            currentHand=handPemain1;
            currentDeck=deckPemain1;
        }else{
            currentHand=handPemain2;
            currentDeck=deckPemain2;
        }
        if(currentHand.isFull()){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("fullHand.fxml"));

                fxmlLoader.setController(new FullHandController(currentHand));

                Scene scene = new Scene(fxmlLoader.load(), 648, 400);
                Stage stage = new Stage();
                stage.setTitle("Full Hand");
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.TRANSPARENT);
                stage.setOpacity(0.8);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
            }catch (Exception err){
                err.printStackTrace();
            }
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("drawPhase.fxml"));

            fxmlLoader.setController(new DrawController(currentDeck,currentHand));

            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            scene.getStylesheets().add(getClass().getResource("styleDrawPhase.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("Draw Phase");
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.setOpacity(0.8);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    public void updateHand1(){
        System.out.println("Hand 1 = "+handPemain1.numberOfCards());
        for(int i=0;i<handPemain1.numberOfCards();i++){
            System.out.println(handPemain1.getCard(i).getName());
        }
        for(int i=0;i<handPemain1.numberOfCards();i++){
            if(handPemain1.getCard(i)==null)continue;
            if(i==0){
                handCard1.setImage(new Image(getClass().getResourceAsStream(handPemain1.getCard(i).getImagePath())));
                handCard1Mana.setText("MANA "+handPemain1.getCard(i).getMana());
                handCard1AtkHealth.setText(getAtkHealth(handPemain1.getCard(i)));
            }else if(i==1){
                handCard2.setImage(new Image(getClass().getResourceAsStream(handPemain1.getCard(i).getImagePath())));
                handCard2Mana.setText("MANA "+handPemain1.getCard(i).getMana());
                handCard2AtkHealth.setText(getAtkHealth(handPemain1.getCard(i)));
            }else if(i==2){
                handCard3.setImage(new Image(getClass().getResourceAsStream(handPemain1.getCard(i).getImagePath())));
                handCard3Mana.setText("MANA "+handPemain1.getCard(i).getMana());
                handCard3AtkHealth.setText(getAtkHealth(handPemain1.getCard(i)));
            }else if(i==3){
                handCard4.setImage(new Image(getClass().getResourceAsStream(handPemain1.getCard(i).getImagePath())));
                handCard4Mana.setText("MANA "+handPemain1.getCard(i).getMana());
                handCard4AtkHealth.setText(getAtkHealth(handPemain1.getCard(i)));
            }else if(i==4){
                handCard5.setImage(new Image(getClass().getResourceAsStream(handPemain1.getCard(i).getImagePath())));
                handCard5Mana.setText("MANA "+handPemain1.getCard(i).getMana());
                handCard5AtkHealth.setText(getAtkHealth(handPemain1.getCard(i)));
            }
        }
        for(int i=handPemain1.numberOfCards();i<5;i++){
            if(i==0){
                handCard1.setImage(null);
                handCard1Mana.setText(null);
                handCard1AtkHealth.setText(null);
            }else if(i==1){
                handCard2.setImage(null);
                handCard2Mana.setText(null);
                handCard2AtkHealth.setText(null);
            }else if(i==2){
                handCard3.setImage(null);
                handCard3Mana.setText(null);
                handCard3AtkHealth.setText(null);
            }else if(i==3){
                handCard4.setImage(null);
                handCard4Mana.setText(null);
                handCard4AtkHealth.setText(null);
            }else if(i==4){
                handCard5.setImage(null);
                handCard5Mana.setText(null);
                handCard5AtkHealth.setText(null);
            }
        }
    }

    public void updateHand2(){
        System.out.println("Hand 2 = "+handPemain2.numberOfCards());
        for(int i=0;i<handPemain2.numberOfCards();i++){
            System.out.println(handPemain2.getCard(i).getName());
        }
        for(int i=0;i<handPemain2.numberOfCards();i++){
            if(i==0){
                handCard1.setImage(new Image(getClass().getResourceAsStream(handPemain2.getCard(i).getImagePath())));
                handCard1Mana.setText("MANA "+handPemain2.getCard(i).getMana());
                handCard1AtkHealth.setText(getAtkHealth(handPemain2.getCard(i)));
            }else if(i==1){
                handCard2.setImage(new Image(getClass().getResourceAsStream(handPemain2.getCard(i).getImagePath())));
                handCard2Mana.setText("MANA "+handPemain2.getCard(i).getMana());
                handCard2AtkHealth.setText(getAtkHealth(handPemain2.getCard(i)));
            }else if(i==2){
                handCard3.setImage(new Image(getClass().getResourceAsStream(handPemain2.getCard(i).getImagePath())));
                handCard3Mana.setText("MANA "+handPemain2.getCard(i).getMana());
                handCard3AtkHealth.setText(getAtkHealth(handPemain2.getCard(i)));
            }else if(i==3){
                handCard4.setImage(new Image(getClass().getResourceAsStream(handPemain2.getCard(i).getImagePath())));
                handCard4Mana.setText("MANA "+handPemain2.getCard(i).getMana());
                handCard4AtkHealth.setText(getAtkHealth(handPemain2.getCard(i)));
            }else if(i==4){
                handCard5.setImage(new Image(getClass().getResourceAsStream(handPemain2.getCard(i).getImagePath())));
                handCard5Mana.setText("MANA "+handPemain2.getCard(i).getMana());
                handCard5AtkHealth.setText(getAtkHealth(handPemain2.getCard(i)));
            }
        }
        for(int i=handPemain2.numberOfCards();i<5;i++){
            if(i==0){
                handCard1.setImage(null);
                handCard1Mana.setText(null);
                handCard1AtkHealth.setText(null);
            }else if(i==1){
                handCard2.setImage(null);
                handCard2Mana.setText(null);
                handCard2AtkHealth.setText(null);
            }else if(i==2){
                handCard3.setImage(null);
                handCard3Mana.setText(null);
                handCard3AtkHealth.setText(null);
            }else if(i==3){
                handCard4.setImage(null);
                handCard4Mana.setText(null);
                handCard4AtkHealth.setText(null);
            }else if(i==4){
                handCard5.setImage(null);
                handCard5Mana.setText(null);
                handCard5AtkHealth.setText(null);
            }
        }
    }

    public String getAtkHealth(Card c){
        if(c instanceof  Character){
            return "ATK " + ((Character) c).getAttack() + "/HP "+((Character) c).getHealth();
        }else if(c instanceof MorphSpell){
            return "MORPH";
        }else if(c instanceof  PtnSpell){
            return "ATK+" + ((PtnSpell) c).getPtnAttack() + "/HP+"+((PtnSpell) c).getPtnHp();
        }else if(c instanceof LvlSpell){
            return "LEVEL";
        }else{ // swap
            return "ATK <--> HP";
        }
    }

    public static void debugging(){
        try {
            System.out.println("Hello World");
            CardReader c = new CardReader(); // ctor
            c.addAllCards(); // masukin card ke c
            int i = 0;
            for (Card card : c.getCards()){
                i += 1;
                System.out.println("Kartu ke-" + i);
                card.printCardInfo(); // print setiap card
                System.out.println();
            }

            // kalo mau debug di sini

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Finished");
        }
    }
}