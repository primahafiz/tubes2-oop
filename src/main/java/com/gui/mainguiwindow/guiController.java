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

        debugging();

        // initialize health
        lifeBar1.setProgress(1);
        lifeBar2.setProgress(1);
        lifeBar2.setRotate(180);

        // initialize number turn
        turn = 1;
        numTurn.setText(Integer.toString(turn));

        // initialize stage
        idStage = 0;
        activateStageLabel(stageEndLabel, stageDrawLabel);

        player1BoardA.setImage(new Image(getClass().getResourceAsStream("image/alex.jpeg")));
        player2BoardB.setImage(new Image(getClass().getResourceAsStream("image/steve.jpeg")));
        initDragAndDropBoardPlayer1();
        initDragAndDropBoardPlayer2();
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

    public void changeStageClicked(){
        // kalau button untuk pindah stage diclick
        if(idStage==0){
            displayWindowDraw();
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

    public void displayWindowDraw(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("drawPhase.fxml"));

            System.out.println(deckPemain1);

            fxmlLoader.setController(new DrawController(deckPemain1));

            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Draw Phase");
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.setOpacity(0.8);
            stage.show();
        }catch (Exception err){
            err.printStackTrace();
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