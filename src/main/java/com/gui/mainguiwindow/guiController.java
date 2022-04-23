package com.gui.mainguiwindow;

import com.aetherwars.model.*;
import com.aetherwars.model.Character;
import com.aetherwars.util.InvalidException;
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

    // Img Attack
    @FXML
    ImageView player1BoardAAttackImg;
    @FXML
    ImageView player1BoardBAttackImg;
    @FXML
    ImageView player1BoardCAttackImg;
    @FXML
    ImageView player1BoardDAttackImg;
    @FXML
    ImageView player1BoardEAttackImg;

    // Attack
    @FXML
    Label player1BoardAAttack;
    @FXML
    Label player1BoardBAttack;
    @FXML
    Label player1BoardCAttack;
    @FXML
    Label player1BoardDAttack;
    @FXML
    Label player1BoardEAttack;

    // Img Health
    @FXML
    ImageView player1BoardAHealthImg;
    @FXML
    ImageView player1BoardBHealthImg;
    @FXML
    ImageView player1BoardCHealthImg;
    @FXML
    ImageView player1BoardDHealthImg;
    @FXML
    ImageView player1BoardEHealthImg;

    // Health
    @FXML
    Label player1BoardAHealth;
    @FXML
    Label player1BoardBHealth;
    @FXML
    Label player1BoardCHealth;
    @FXML
    Label player1BoardDHealth;
    @FXML
    Label player1BoardEHealth;

    // Lvl
    @FXML
    Label player1BoardALvl;
    @FXML
    Label player1BoardBLvl;
    @FXML
    Label player1BoardCLvl;
    @FXML
    Label player1BoardDLvl;
    @FXML
    Label player1BoardELvl;

    // Label A,B,C,D,E board 2
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

    // Img Attack
    @FXML
    ImageView player2BoardAAttackImg;
    @FXML
    ImageView player2BoardBAttackImg;
    @FXML
    ImageView player2BoardCAttackImg;
    @FXML
    ImageView player2BoardDAttackImg;
    @FXML
    ImageView player2BoardEAttackImg;

    // Attack
    @FXML
    Label player2BoardAAttack;
    @FXML
    Label player2BoardBAttack;
    @FXML
    Label player2BoardCAttack;
    @FXML
    Label player2BoardDAttack;
    @FXML
    Label player2BoardEAttack;

    // Img Health
    @FXML
    ImageView player2BoardAHealthImg;
    @FXML
    ImageView player2BoardBHealthImg;
    @FXML
    ImageView player2BoardCHealthImg;
    @FXML
    ImageView player2BoardDHealthImg;
    @FXML
    ImageView player2BoardEHealthImg;

    // Health
    @FXML
    Label player2BoardAHealth;
    @FXML
    Label player2BoardBHealth;
    @FXML
    Label player2BoardCHealth;
    @FXML
    Label player2BoardDHealth;
    @FXML
    Label player2BoardEHealth;

    // Lvl
    @FXML
    Label player2BoardALvl;
    @FXML
    Label player2BoardBLvl;
    @FXML
    Label player2BoardCLvl;
    @FXML
    Label player2BoardDLvl;
    @FXML
    Label player2BoardELvl;

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

    @FXML
    ImageView hand1Delete;
    @FXML
    ImageView hand2Delete;
    @FXML
    ImageView hand3Delete;
    @FXML
    ImageView hand4Delete;
    @FXML
    ImageView hand5Delete;

    @FXML
    ImageView player1BoardADelete;
    @FXML
    ImageView player1BoardBDelete;
    @FXML
    ImageView player1BoardCDelete;
    @FXML
    ImageView player1BoardDDelete;
    @FXML
    ImageView player1BoardEDelete;

    @FXML
    ImageView player2BoardADelete;
    @FXML
    ImageView player2BoardBDelete;
    @FXML
    ImageView player2BoardCDelete;
    @FXML
    ImageView player2BoardDDelete;
    @FXML
    ImageView player2BoardEDelete;


    int currentDragHand;

    int idStage;
    int turn;

    Player pemain1;
    Player pemain2;




    public guiController(){
        // ini nanti buat masukin paramater inisialiasi gui
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize board, hand,deck

        pemain1 = new Player("Steve",1);
        pemain2 = new Player("Alex",1);

        List<Card> c1 = pemain1.getDeck().getCard();
        for(int i=0;i<3;i++){
            try{
                (pemain1.getHand()).addCard(c1.get(i));
            }catch (HandFullExp e){
                e.getMessage();
            }
        }

        List<Card> c2 = pemain2.getDeck().getCard();
        for(int i=0;i<3;i++){
            try{
                (pemain2.getHand()).addCard(c2.get(i));
            }catch (HandFullExp e){
                e.getMessage();
            }
        }

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

        updateHand();

    }

    public void initDragAndDropBoardPlayer1(){
        Hand currentHand=pemain1.getHand();
        Board currentBoard=pemain1.getBoard();

        player1BoardA.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDragHand);
                if(currentBoard.isCharacterAvailable(0) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                }else if(!currentBoard.isCharacterAvailable(0) && currentHand.getCard(currentDragHand) instanceof Character){
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand),0);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                event.consume();
            }
        });

        player1BoardA.setOnDragOver(new EventHandler<DragEvent>() {
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
                System.out.println(currentDragHand);
                if(currentBoard.isCharacterAvailable(1) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                }else if(!currentBoard.isCharacterAvailable(1) && currentHand.getCard(currentDragHand) instanceof Character){
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand),1);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                event.consume();
            }
        });

        player1BoardB.setOnDragOver(new EventHandler<DragEvent>() {
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
                System.out.println(currentDragHand);
                if(currentBoard.isCharacterAvailable(2) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                }else if(!currentBoard.isCharacterAvailable(2) && currentHand.getCard(currentDragHand) instanceof Character){
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand),2);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                event.consume();
            }
        });

        player1BoardC.setOnDragOver(new EventHandler<DragEvent>() {
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
                System.out.println(currentDragHand);
                if(currentBoard.isCharacterAvailable(3) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                }else if(!currentBoard.isCharacterAvailable(3) && currentHand.getCard(currentDragHand) instanceof Character){
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand),3);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                event.consume();
            }
        });

        player1BoardD.setOnDragOver(new EventHandler<DragEvent>() {
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
                System.out.println(currentDragHand);
                if (currentBoard.isCharacterAvailable(4) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                } else if (!currentBoard.isCharacterAvailable(4) && currentHand.getCard(currentDragHand) instanceof Character) {
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand), 4);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                event.consume();
            }
        });

        player1BoardE.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
    }

    public void initDragAndDropBoardPlayer2(){
        Hand currentHand=pemain2.getHand();
        Board currentBoard=pemain2.getBoard();

        player2BoardA.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println("dropped");
                System.out.println(event.getSource());
                System.out.println(event.getTarget());
                System.out.println(currentDragHand);
                if(currentBoard.isCharacterAvailable(0) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                }else if(!currentBoard.isCharacterAvailable(0) && currentHand.getCard(currentDragHand) instanceof Character){
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand),0);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                event.consume();
            }
        });

        player2BoardA.setOnDragOver(new EventHandler<DragEvent>() {
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
                System.out.println(currentDragHand);
                if(currentBoard.isCharacterAvailable(1) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                }else if(!currentBoard.isCharacterAvailable(1) && currentHand.getCard(currentDragHand) instanceof Character){
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand),1);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                event.consume();
            }
        });

        player2BoardB.setOnDragOver(new EventHandler<DragEvent>() {
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
                System.out.println(currentDragHand);
                if(currentBoard.isCharacterAvailable(2) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                }else if(!currentBoard.isCharacterAvailable(2) && currentHand.getCard(currentDragHand) instanceof Character){
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand),2);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                event.consume();
            }
        });

        player2BoardC.setOnDragOver(new EventHandler<DragEvent>() {
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
                System.out.println(currentDragHand);
                if(currentBoard.isCharacterAvailable(3) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                }else if(!currentBoard.isCharacterAvailable(3) && currentHand.getCard(currentDragHand) instanceof Character){
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand),3);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                event.consume();
            }
        });

        player2BoardD.setOnDragOver(new EventHandler<DragEvent>() {
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
                System.out.println(currentDragHand);
                if (currentBoard.isCharacterAvailable(4) && currentHand.getCard(currentDragHand) instanceof Spell) {
                    Spell s = (Spell) currentHand.getCard(currentDragHand);
                    currentHand.removeCardfromHand(currentDragHand);

                    // tambah spell ke character
                } else if (!currentBoard.isCharacterAvailable(4) && currentHand.getCard(currentDragHand) instanceof Character) {
                    currentBoard.addCardtoBoard(currentHand.getCard(currentDragHand), 4);
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                event.consume();
            }
        });

        player2BoardE.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
    }

    public void initDelete(){
        Hand currentHand;

        if(turn%2==1){
            currentHand=pemain1.getHand();
        }else{
            currentHand=pemain2.getHand();
        }

        hand1Delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    currentHand.removeCardfromHand(0);
                    updateHand();
                    updateDeleteHand();
                }
            }
        });

        hand2Delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    currentHand.removeCardfromHand(1);
                    updateHand();
                    updateDeleteHand();
                }
            }
        });

        hand3Delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    currentHand.removeCardfromHand(2);
                    updateHand();
                    updateDeleteHand();
                }
            }
        });

        hand4Delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    currentHand.removeCardfromHand(3);
                    updateHand();
                    updateDeleteHand();
                }
            }
        });

        hand5Delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    currentHand.removeCardfromHand(4);
                    updateHand();
                    updateDeleteHand();
                }
            }
        });

        player1BoardADelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain1.getBoard().removeCardfromBoard(0);
                    updateBoard1();
                    updateDeleteBoard1();
                }
            }
        });

        player1BoardBDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain1.getBoard().removeCardfromBoard(1);
                    updateBoard1();
                    updateDeleteBoard1();
                }
            }
        });

        player1BoardCDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain1.getBoard().removeCardfromBoard(2);
                    updateBoard1();
                    updateDeleteBoard1();
                }
            }
        });

        player1BoardDDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain1.getBoard().removeCardfromBoard(3);
                    updateBoard1();
                    updateDeleteBoard1();
                }
            }
        });

        player1BoardEDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain1.getBoard().removeCardfromBoard(4);
                    updateBoard1();
                    updateDeleteBoard1();
                }
            }
        });

        player2BoardADelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain2.getBoard().removeCardfromBoard(0);
                    updateBoard2();
                    updateDeleteBoard2();
                }
            }
        });

        player2BoardBDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain2.getBoard().removeCardfromBoard(1);
                    updateBoard2();
                    updateDeleteBoard2();
                }
            }
        });

        player2BoardCDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain2.getBoard().removeCardfromBoard(2);
                    updateBoard2();
                    updateDeleteBoard2();
                }
            }
        });

        player2BoardDDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain2.getBoard().removeCardfromBoard(3);
                    updateBoard2();
                    updateDeleteBoard2();
                }
            }
        });

        player2BoardEDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    pemain2.getBoard().removeCardfromBoard(4);
                    updateBoard2();
                    updateDeleteBoard2();
                }
            }
        });
    }

    public void endDelete(){
        hand1Delete.setVisible(false);
        hand2Delete.setVisible(false);
        hand3Delete.setVisible(false);
        hand4Delete.setVisible(false);
        hand5Delete.setVisible(false);

        player1BoardADelete.setVisible(false);
        player1BoardBDelete.setVisible(false);
        player1BoardCDelete.setVisible(false);
        player1BoardDDelete.setVisible(false);
        player1BoardEDelete.setVisible(false);

        player2BoardADelete.setVisible(false);
        player2BoardBDelete.setVisible(false);
        player2BoardCDelete.setVisible(false);
        player2BoardDDelete.setVisible(false);
        player2BoardEDelete.setVisible(false);
    }

    public void updateDeleteHand(){
        Hand currentHand;
        if(turn%2==1){
            currentHand=pemain1.getHand();
        }else{
            currentHand=pemain2.getHand();
        }
        for(int i=0;i<currentHand.numberOfCards();i++){
            if(i==0){
                hand1Delete.setVisible(true);
            }else if(i==1){
                hand2Delete.setVisible(true);
            }else if(i==2){
                hand3Delete.setVisible(true);
            }else if(i==3){
                hand4Delete.setVisible(true);
            }else if(i==4){
                hand5Delete.setVisible(true);
            }
        }
        for(int i=currentHand.numberOfCards();i<5;i++){
            if(i==0){
                hand1Delete.setVisible(false);
            }else if(i==1){
                hand2Delete.setVisible(false);
            }else if(i==2){
                hand3Delete.setVisible(false);
            }else if(i==3){
                hand4Delete.setVisible(false);
            }else if(i==4){
                hand5Delete.setVisible(false);
            }
        }
    }

    public void updateDeleteBoard1(){
        Board currentBoard = pemain1.getBoard();
        for(int i=0;i<5;i++){
            if(currentBoard.isValidIdx(i)){
                if(i==0){
                    player1BoardADelete.setVisible(false);
                }else if(i==1){
                    player1BoardBDelete.setVisible(false);
                }else if(i==2){
                    player1BoardCDelete.setVisible(false);
                }else if(i==3){
                    player1BoardDDelete.setVisible(false);
                }else if(i==4){
                    player1BoardEDelete.setVisible(false);
                }
            }else{
                if(i==0){
                    player1BoardADelete.setVisible(true);
                }else if(i==1){
                    player1BoardBDelete.setVisible(true);
                }else if(i==2){
                    player1BoardCDelete.setVisible(true);
                }else if(i==3){
                    player1BoardDDelete.setVisible(true);
                }else if(i==4){
                    player1BoardEDelete.setVisible(true);
                }
            }
        }
    }

    public void updateDeleteBoard2(){
        Board currentBoard = pemain2.getBoard();
        for(int i=0;i<5;i++){
            if(currentBoard.isValidIdx(i)){
                if(i==0){
                    player2BoardADelete.setVisible(false);
                }else if(i==1){
                    player2BoardBDelete.setVisible(false);
                }else if(i==2){
                    player2BoardCDelete.setVisible(false);
                }else if(i==3){
                    player2BoardDDelete.setVisible(false);
                }else if(i==4){
                    player2BoardEDelete.setVisible(false);
                }
            }else{
                if(i==0){
                    player2BoardADelete.setVisible(true);
                }else if(i==1){
                    player2BoardBDelete.setVisible(true);
                }else if(i==2){
                    player2BoardCDelete.setVisible(true);
                }else if(i==3){
                    player2BoardDDelete.setVisible(true);
                }else if(i==4){
                    player2BoardEDelete.setVisible(true);
                }
            }
        }
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

    public void initDragAndDropHand(){
        handCard1.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = handCard1.startDragAndDrop(TransferMode.ANY);
            currentDragHand = 0;
            ClipboardContent content = new ClipboardContent();
            content.putImage(handCard1.getImage());
            db.setContent(content);
            event.consume();
        });

        handCard1.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        handCard2.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = handCard2.startDragAndDrop(TransferMode.ANY);
            currentDragHand = 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(handCard2.getImage());
            db.setContent(content);
            event.consume();
        });

        handCard2.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        handCard3.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = handCard3.startDragAndDrop(TransferMode.ANY);
            currentDragHand = 2;
            ClipboardContent content = new ClipboardContent();
            content.putImage(handCard3.getImage());
            db.setContent(content);
            event.consume();
        });

        handCard3.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        handCard4.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = handCard4.startDragAndDrop(TransferMode.ANY);
            currentDragHand = 3;
            ClipboardContent content = new ClipboardContent();
            content.putImage(handCard4.getImage());
            db.setContent(content);
            event.consume();
        });

        handCard4.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        handCard5.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = handCard5.startDragAndDrop(TransferMode.ANY);
            currentDragHand = 4;
            ClipboardContent content = new ClipboardContent();
            content.putImage(handCard5.getImage());
            db.setContent(content);
            event.consume();
        });

        handCard5.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
    }

    public void changeStageClicked(){
        // kalau button untuk pindah stage diclick
        if(idStage==-1){
            System.out.println(1);
            if(turn%2==1) {
                updateHand1();
            }else{
                updateHand2();
            }
            System.out.println(2);
            displayWindowDraw();
            if(turn%2==1) {
                updateHand1();
            }else{
                updateHand2();
            }
            activateStageLabel(stageEndLabel,stageDrawLabel);
        } else if(idStage==0){
            initDragAndDropHand();
            initDelete();
            updateHand();
            updateDeleteHand();
            System.out.println("Hand 1 besar : "+pemain1.getHand().numberOfCards());
            if(turn%2==1){
                initDragAndDropBoardPlayer1();
                updateDeleteBoard1();
            }else{
                updateDeleteBoard2();
                initDragAndDropBoardPlayer2();
            }
            activateStageLabel(stageDrawLabel,stagePlanLabel);
        }else if(idStage==1){
            endDelete();
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
            currentHand=pemain1.getHand();
            currentDeck=pemain1.getDeck();
        }else{
            currentHand=pemain2.getHand();
            currentDeck=pemain2.getDeck();
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

    public void updateHand(){
        if(turn%2==1){
            updateHand1();
        }else{
            updateHand2();
        }
    }

    public void updateHand1(){
        System.out.println(3);
        Hand pemainx=pemain1.getHand();
        System.out.println(3.5);
        Hand handPemain1 = pemain1.getHand();
        System.out.println(4);
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
        Hand handPemain2=pemain2.getHand();
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

    public void updateBoard1(){
        Board currentBoard = pemain1.getBoard();
        for(int i=0;i<5;i++){
            if(!currentBoard.isValidIdx(i)){
                if(i==0){
                    player1BoardAAttack.setVisible(true);
                    player1BoardAAttackImg.setVisible(true);
                    player1BoardAHealth.setVisible(true);
                    player1BoardAHealthImg.setVisible(true);
                    player1BoardALvl.setVisible(true);
                    player1BoardALabel.setVisible(false);

                    System.out.println("Board 1");
                    System.out.println(currentBoard.getCard(i).getImagePath());

                    player1BoardA.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player1BoardAAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardAHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardALvl.setText("Level");

                }else if(i==1){
                    player1BoardBAttack.setVisible(true);
                    player1BoardBAttackImg.setVisible(true);
                    player1BoardBHealth.setVisible(true);
                    player1BoardBHealthImg.setVisible(true);
                    player1BoardBLvl.setVisible(true);
                    player1BoardBLabel.setVisible(false);

                    player1BoardB.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player1BoardBAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardBHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardBLvl.setText("Level");

                }else if(i==2){
                    player1BoardCAttack.setVisible(true);
                    player1BoardCAttackImg.setVisible(true);
                    player1BoardCHealth.setVisible(true);
                    player1BoardCHealthImg.setVisible(true);
                    player1BoardCLvl.setVisible(true);
                    player1BoardCLabel.setVisible(false);

                    player1BoardC.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player1BoardCAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardCHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardCLvl.setText("Level");
                }else if(i==3){
                    player1BoardDAttack.setVisible(true);
                    player1BoardDAttackImg.setVisible(true);
                    player1BoardDHealth.setVisible(true);
                    player1BoardDHealthImg.setVisible(true);
                    player1BoardDLvl.setVisible(true);
                    player1BoardDLabel.setVisible(false);

                    player1BoardD.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player1BoardDAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardDHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardDLvl.setText("Level");
                }else if(i==4){
                    player1BoardEAttack.setVisible(true);
                    player1BoardEAttackImg.setVisible(true);
                    player1BoardEHealth.setVisible(true);
                    player1BoardEHealthImg.setVisible(true);
                    player1BoardELvl.setVisible(true);
                    player1BoardELabel.setVisible(false);

                    player1BoardE.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player1BoardEAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardEHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardELvl.setText("Level");
                }

            }else{
                if(i==0){
                    player1BoardA.setImage(null);
                    player1BoardAAttack.setVisible(false);
                    player1BoardAAttackImg.setVisible(false);
                    player1BoardAHealth.setVisible(false);
                    player1BoardAHealthImg.setVisible(false);
                    player1BoardALvl.setVisible(false);
                    player1BoardALabel.setVisible(true);
                }else if(i==1){
                    player1BoardB.setImage(null);
                    player1BoardBAttack.setVisible(false);
                    player1BoardBAttackImg.setVisible(false);
                    player1BoardBHealth.setVisible(false);
                    player1BoardBHealthImg.setVisible(false);
                    player1BoardBLvl.setVisible(false);
                    player1BoardBLabel.setVisible(true);
                }else if(i==2){
                    player1BoardC.setImage(null);
                    player1BoardCAttack.setVisible(false);
                    player1BoardCAttackImg.setVisible(false);
                    player1BoardCHealth.setVisible(false);
                    player1BoardCHealthImg.setVisible(false);
                    player1BoardCLvl.setVisible(false);
                    player1BoardCLabel.setVisible(true);
                }else if(i==3){
                    player1BoardD.setImage(null);
                    player1BoardDAttack.setVisible(false);
                    player1BoardDAttackImg.setVisible(false);
                    player1BoardDHealth.setVisible(false);
                    player1BoardDHealthImg.setVisible(false);
                    player1BoardDLvl.setVisible(false);
                    player1BoardDLabel.setVisible(true);
                }else if(i==4){
                    player1BoardE.setImage(null);
                    player1BoardEAttack.setVisible(false);
                    player1BoardEAttackImg.setVisible(false);
                    player1BoardEHealth.setVisible(false);
                    player1BoardEHealthImg.setVisible(false);
                    player1BoardELvl.setVisible(false);
                    player1BoardELabel.setVisible(true);
                }
            }
        }
    }

    public void updateBoard2(){
        Board currentBoard = pemain2.getBoard();
        for(int i=0;i<5;i++){
            if(!currentBoard.isValidIdx(i)){
                if(i==0){
                    player2BoardAAttack.setVisible(true);
                    player2BoardAAttackImg.setVisible(true);
                    player2BoardAHealth.setVisible(true);
                    player2BoardAHealthImg.setVisible(true);
                    player2BoardALvl.setVisible(true);
                    player2BoardALabel.setVisible(false);

                    player2BoardA.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player2BoardAAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardAHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardALvl.setText("Level");

                }else if(i==1){
                    player2BoardBAttack.setVisible(true);
                    player2BoardBAttackImg.setVisible(true);
                    player2BoardBHealth.setVisible(true);
                    player2BoardBHealthImg.setVisible(true);
                    player2BoardBLvl.setVisible(true);
                    player2BoardBLabel.setVisible(false);

                    player2BoardB.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player2BoardBAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardBHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardBLvl.setText("Level");

                }else if(i==2){
                    player2BoardCAttack.setVisible(true);
                    player2BoardCAttackImg.setVisible(true);
                    player2BoardCHealth.setVisible(true);
                    player2BoardCHealthImg.setVisible(true);
                    player2BoardCLvl.setVisible(true);
                    player2BoardCLabel.setVisible(false);

                    player2BoardC.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player2BoardCAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardCHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardCLvl.setText("Level");
                }else if(i==3){
                    player2BoardDAttack.setVisible(true);
                    player2BoardDAttackImg.setVisible(true);
                    player2BoardDHealth.setVisible(true);
                    player2BoardDHealthImg.setVisible(true);
                    player2BoardDLvl.setVisible(true);
                    player2BoardDLabel.setVisible(false);

                    player2BoardD.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player2BoardDAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardDHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardDLvl.setText("Level");
                }else if(i==4){
                    player2BoardEAttack.setVisible(true);
                    player2BoardEAttackImg.setVisible(true);
                    player2BoardEHealth.setVisible(true);
                    player2BoardEHealthImg.setVisible(true);
                    player2BoardELvl.setVisible(true);
                    player2BoardELabel.setVisible(false);

                    player2BoardE.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    player2BoardEAttack.setText(Integer.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardEHealth.setText(Integer.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardELvl.setText("Level");
                }

            }else{
                if(i==0){
                    player2BoardA.setImage(null);
                    player2BoardAAttack.setVisible(false);
                    player2BoardAAttackImg.setVisible(false);
                    player2BoardAHealth.setVisible(false);
                    player2BoardAHealthImg.setVisible(false);
                    player2BoardALvl.setVisible(false);
                    player2BoardALabel.setVisible(true);
                }else if(i==1){
                    player2BoardB.setImage(null);
                    player2BoardBAttack.setVisible(false);
                    player2BoardBAttackImg.setVisible(false);
                    player2BoardBHealth.setVisible(false);
                    player2BoardBHealthImg.setVisible(false);
                    player2BoardBLvl.setVisible(false);
                    player2BoardBLabel.setVisible(true);
                }else if(i==2){
                    player2BoardC.setImage(null);
                    player2BoardCAttack.setVisible(false);
                    player2BoardCAttackImg.setVisible(false);
                    player2BoardCHealth.setVisible(false);
                    player2BoardCHealthImg.setVisible(false);
                    player2BoardCLvl.setVisible(false);
                    player2BoardCLabel.setVisible(true);
                }else if(i==3){
                    player2BoardD.setImage(null);
                    player2BoardDAttack.setVisible(false);
                    player2BoardDAttackImg.setVisible(false);
                    player2BoardDHealth.setVisible(false);
                    player2BoardDHealthImg.setVisible(false);
                    player2BoardDLvl.setVisible(false);
                    player2BoardDLabel.setVisible(true);
                }else if(i==4){
                    player2BoardE.setImage(null);
                    player2BoardEAttack.setVisible(false);
                    player2BoardEAttackImg.setVisible(false);
                    player2BoardEHealth.setVisible(false);
                    player2BoardEHealthImg.setVisible(false);
                    player2BoardELvl.setVisible(false);
                    player2BoardELabel.setVisible(true);
                }
            }
        }
    }

    public void updateBoard(){
        if(turn%2==1){
            updateBoard1();
        }else{
            updateBoard2();
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