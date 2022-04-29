package com.gui.mainguiwindow;

import com.aetherwars.model.*;
import com.aetherwars.model.Character;
import com.aetherwars.model.CardReader;
import com.aetherwars.util.InvalidException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static java.lang.Math.min;

import java.io.IOException;

public class guiController implements Initializable {
    // Health Bar Pemain 1 dan Pemain 2
    @FXML
    ProgressBar lifeBar1;
    @FXML
    ProgressBar lifeBar2;
    @FXML
    Label hpPlayer1;
    @FXML
    Label hpPlayer2;

    // Label untuk menampilkan turn saat ini
    @FXML
    Label numTurn;

    // Foto pemain 1 dan pemain 2
    @FXML
    ImageView player1Img;
    @FXML
    ImageView player2Img;
    @FXML
    Rectangle framePlayer1;
    @FXML
    Rectangle framePlayer2;
    @FXML
    Label namaPlayer1;
    @FXML
    Label namaPlayer2;

    // Frame untuk board A-E pemain 1
    @FXML
    AnchorPane player1BoardAFrame;
    @FXML
    AnchorPane player1BoardBFrame;
    @FXML
    AnchorPane player1BoardCFrame;
    @FXML
    AnchorPane player1BoardDFrame;
    @FXML
    AnchorPane player1BoardEFrame;

    // Frame untuk board A-E pemain 2
    @FXML
    AnchorPane player2BoardAFrame;
    @FXML
    AnchorPane player2BoardBFrame;
    @FXML
    AnchorPane player2BoardCFrame;
    @FXML
    AnchorPane player2BoardDFrame;
    @FXML
    AnchorPane player2BoardEFrame;

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

    // Img Attack Board A-E Pemain 1
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

    // Attack Power Board A-E Pemain 1
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

    // Img Health Board A-E Pemain 1
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

    // Health Board A-E Pemain 1
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

    // Lvl Board A-E Pemain 1
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

    // tombol untuk menyerang pemain 2 dan kartu di boardnya
    @FXML
    ImageView P1atkBoardA;
    @FXML
    ImageView P1atkBoardB;
    @FXML
    ImageView P1atkBoardC;
    @FXML
    ImageView P1atkBoardD;
    @FXML
    ImageView P1atkBoardE;
    @FXML
    ImageView P1atkP2;

    // tombol untuk menambah exp dengan mana
    @FXML
    ImageView levelUpBoardAP1;
    @FXML
    ImageView levelUpBoardBP1;
    @FXML
    ImageView levelUpBoardCP1;
    @FXML
    ImageView levelUpBoardDP1;
    @FXML
    ImageView levelUpBoardEP1;

    // label damage
    @FXML
    Label damagetoBoardAP1;
    @FXML
    Label damagetoBoardBP1;
    @FXML
    Label damagetoBoardCP1;
    @FXML
    Label damagetoBoardDP1;
    @FXML
    Label damagetoBoardEP1;

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

    // Img Attack Board A-E Pemain 2
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

    // Attack Power Board A-E Pemain 2
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

    // Img Health Board A-E Pemain 2
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

    // Health Board A-E Pemain 2
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

    // Lvl Board A-E Pemain 2
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

    // tombol untuk menyerang pemain 1 dan kartu di boardnya
    @FXML
    ImageView P2atkBoardA;
    @FXML
    ImageView P2atkBoardB;
    @FXML
    ImageView P2atkBoardC;
    @FXML
    ImageView P2atkBoardD;
    @FXML
    ImageView P2atkBoardE;
    @FXML
    ImageView P2atkP1;

    // tombol untuk menambah exp dengan mana
    @FXML
    ImageView levelUpBoardAP2;
    @FXML
    ImageView levelUpBoardBP2;
    @FXML
    ImageView levelUpBoardCP2;
    @FXML
    ImageView levelUpBoardDP2;
    @FXML
    ImageView levelUpBoardEP2;

    // label damage
    @FXML
    Label damagetoBoardAP2;
    @FXML
    Label damagetoBoardBP2;
    @FXML
    Label damagetoBoardCP2;
    @FXML
    Label damagetoBoardDP2;
    @FXML
    Label damagetoBoardEP2;

    // Gambar hand card
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

    // hand card attack & health
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

    // hovered card attribute & description
    @FXML
    Label cardAttribute;
    @FXML
    Label cardDescription;

    // label mana dan jumlah kartu di deck
    @FXML
    Label deckNum;
    @FXML
    Label manaNum;

    // Tombol delete card di hand
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

    // Tombol delete card di board pemain 1
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

    // Tombol delete card di board pemain 2
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

    // End game
    @FXML
    ImageView EndGameLayer;
    @FXML
    ImageView crownP1;
    @FXML
    ImageView crownP2;
    @FXML
    Label winnerP1;
    @FXML
    Label winnerP2;


    // All types of card

    CardReader cardReader = new CardReader();

    int currentDragHand;

    int idStage;
    int turn;

    Player pemain1;
    Player pemain2;

    int deckCapacityPemain1;
    int deckCapacityPemain2;

    boolean hasAttacked = false;
    int selectedAttCard = -1;
    int selectedDefCard = -1;


    public guiController(){
        // ini nanti buat masukin paramater inisialiasi gui
        try {
            cardReader.addAllCards();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hoveredCard.setImage(null);
        // initialize board, hand, deck

        pemain1 = new Player("Steve",1);
        pemain2 = new Player("Alex",1);

        deckCapacityPemain1=pemain1.getDeck().getSize();
        deckCapacityPemain2=pemain2.getDeck().getSize();

        List<Card> c1 = null;
        try {
            c1 = pemain1.getDeck().getCard();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<3;i++){
            try{
                (pemain1.getHand()).addCard(c1.get(i));
            }catch (HandFullExp e){
                e.getMessage();
            }
        }

        List<Card> c2 = null;
        try {
            c2 = pemain2.getDeck().getCard();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
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
        turn = 0;
        numTurn.setText(Integer.toString(turn));

        // initialize stage
        idStage = -1;

        // initialize hover card
        updateHand();
        initHoveredCardBoard();
        initHoveredCardHand();
        hideHand();
        for (int i = 0; i < pemain1.getDeck().getSize(); i++) {
            //System.out.println(pemain1.getDeck().getAll().get(0));
            for (int j = 0; j < pemain1.getDeck().getSize(); j++) {
                if (i != j && !pemain1.getDeck().getAll().get(i).getName().equals(pemain1.getDeck().getAll().get(j).getName())) {
                    if (System.identityHashCode(pemain1.getDeck().getAll().get(i)) ==  System.identityHashCode(pemain1.getDeck().getAll().get(j))) {
                        System.out.println("samaa");
                        break;
                    }
                    else {
                        System.out.println(System.identityHashCode(pemain1.getDeck().getAll().get(i)));
                        System.out.println(System.identityHashCode(pemain1.getDeck().getAll().get(j)));
                        System.out.println();
                        //System.out.println("beda");
                    }
                }
            }
        }
        debug();
    }



    /* 
     *  HOVER CARD 
     *  - Melakukan hover card di board dan hand
     */

    public void initHoveredCardBoard() {
        // Untuk hover card di board dan menampilkan informasi kartu yang di-hover
        Board board1 = pemain1.getBoard();
        Board board2 = pemain2.getBoard();
        player1BoardA.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board1.isCharacterAvailable(0)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player1BoardA.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board1.getCard(0)));
                    cardDescription.setText("\"" + board1.getCard(0).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board1.getCard(0)).getListSpell().isEmpty()) {
                        markHasSpell(0);
                    }
                }
            }
        });
        player1BoardA.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });         

        player1BoardB.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board1.isCharacterAvailable(1)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player1BoardB.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board1.getCard(1)));
                    cardDescription.setText("\"" + board1.getCard(1).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board1.getCard(1)).getListSpell().isEmpty()) {
                        markHasSpell(1);
                    }
                }
            }
        });
        player1BoardB.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });

        player1BoardC.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board1.isCharacterAvailable(2)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player1BoardC.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board1.getCard(2)));
                    cardDescription.setText("\"" + board1.getCard(2).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board1.getCard(2)).getListSpell().isEmpty()) {
                        markHasSpell(2);
                    }
                }
            }
        }); 
        player1BoardC.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });

        player1BoardD.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board1.isCharacterAvailable(3)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player1BoardD.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board1.getCard(3)));
                    cardDescription.setText("\"" + board1.getCard(3).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board1.getCard(3)).getListSpell().isEmpty()) {
                        markHasSpell(3);
                    }
                }
            }
        });
        player1BoardD.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });

        player1BoardE.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board1.isCharacterAvailable(4)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player1BoardE.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board1.getCard(4)));
                    cardDescription.setText("\"" + board1.getCard(4).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board1.getCard(4)).getListSpell().isEmpty()) {
                        markHasSpell(4);
                    }
                }
            }
        });
        player1BoardE.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });

        player2BoardA.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board2.isCharacterAvailable(0)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player2BoardA.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board2.getCard(0)));
                    cardDescription.setText("\"" + board2.getCard(0).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board2.getCard(0)).getListSpell().isEmpty()) {
                        markHasSpell(5);
                    }
                }
            }
        });
        player2BoardA.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });

        player2BoardB.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board2.isCharacterAvailable(1)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player2BoardB.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board2.getCard(1)));
                    cardDescription.setText("\"" + board2.getCard(1).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board2.getCard(1)).getListSpell().isEmpty()) {
                        markHasSpell(6);
                    }
                }
            }
        });
        player2BoardB.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });

        player2BoardC.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board2.isCharacterAvailable(2)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player2BoardC.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board2.getCard(2)));
                    cardDescription.setText("\"" + board2.getCard(2).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board2.getCard(2)).getListSpell().isEmpty()) {
                        markHasSpell(7);
                    }
                }
            }
        });
        player2BoardC.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });

        player2BoardD.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board2.isCharacterAvailable(3)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player2BoardD.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board2.getCard(3)));
                    cardDescription.setText("\"" + board2.getCard(3).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board2.getCard(3)).getListSpell().isEmpty()) {
                        markHasSpell(8);
                    }
                }
            }
        });
        player2BoardD.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });

        player2BoardE.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board2.isCharacterAvailable(4)) {
                    if (idStage == 2) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.HAND);
                    }
                    hoveredCard.setImage(player2BoardE.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(board2.getCard(4)));
                    cardDescription.setText("\"" + board2.getCard(4).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                    if (!((Character) board2.getCard(4)).getListSpell().isEmpty()) {
                        markHasSpell(9);
                    }
                }
            }
        });
        player2BoardE.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
                unmarkHasSpell();
            }
        });
    }


    public void initHoveredCardHand() {
        // untuk hover card di hand
        Hand currHand;
        
        if (turn % 2 == 1) {
            currHand = pemain1.getHand();
        } else {
            currHand = pemain2.getHand();
        }

        handCard1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currHand.numberOfCards() > 0 && currHand.getCard(0) != null) {
                    if (idStage == 1) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.OPEN_HAND);
                    }
                    hoveredCard.setImage(handCard1.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(currHand.getCard(0)));
                    cardDescription.setText("\"" + currHand.getCard(0).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                }
            }
        });
        handCard1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
            }
        });

        handCard2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currHand.numberOfCards() > 1 && currHand.getCard(1) != null) {
                    if (idStage == 1) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.OPEN_HAND);
                    }
                    hoveredCard.setImage(handCard2.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(currHand.getCard(1)));
                    cardDescription.setText("\"" + currHand.getCard(1).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                }
            }
        });
        handCard2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
            }
        });

        handCard3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currHand.numberOfCards() > 2 && currHand.getCard(2) != null) {
                    if (idStage == 1) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.OPEN_HAND);
                    }
                    hoveredCard.setImage(handCard3.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(currHand.getCard(2)));
                    cardDescription.setText("\"" + currHand.getCard(2).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                }
            }
        });
        handCard3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
            }
        });

        handCard4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currHand.numberOfCards() > 3 && currHand.getCard(3) != null) {
                    if (idStage == 1) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.OPEN_HAND);
                    }
                    hoveredCard.setImage(handCard4.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(currHand.getCard(3)));
                    cardDescription.setText("\"" + currHand.getCard(3).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                }
            }
        });
        handCard4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
            }
        });

        handCard5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currHand.numberOfCards() > 4 && currHand.getCard(4) != null) {
                    if (idStage == 1) {
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.getScene().setCursor(Cursor.OPEN_HAND);
                    }
                    hoveredCard.setImage(handCard5.getImage());
                    alignImageCentre(hoveredCard);
                    cardAttribute.setText(getCardAttributes(currHand.getCard(4)));
                    cardDescription.setText("\"" + currHand.getCard(4).getDesc() + "\"");
                    cardDescription.setStyle("-fx-font-style: italic;");
                }
            }
        });
        handCard5.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
                hoveredCard.setImage(null);
                cardAttribute.setText("");
                cardDescription.setText("");
            }
        });
    }


    public void initHoveredPlayerImg() {
        player1Img.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (idStage == 2 && (turn % 2 == 0)) {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.getScene().setCursor(Cursor.HAND);
                }
            }
        });

        player1Img.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });

        player2Img.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (idStage == 2 && (turn % 2 == 1)) {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.getScene().setCursor(Cursor.HAND);
                }
            }
        });

        player2Img.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });
    }


    
    /* 
     *  DRAG AND DROP 
     */

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
                //System.out.println("Set mana, mana = "+pemain1.getMana()+" card = "+currentHand.getCard(currentDragHand).getMana()+" size hand = "+currentHand.numberOfCards());
                if(currentBoard.isCharacterAvailable(0) && currentHand.getCard(currentDragHand) instanceof Spell && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain1.useSpell(currentDragHand, 0, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                }else if(!currentBoard.isCharacterAvailable(0) && currentHand.getCard(currentDragHand) instanceof Character && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()){
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(),0);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                updateLevelUpButtonP1();
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
                if(currentBoard.isCharacterAvailable(1) && currentHand.getCard(currentDragHand) instanceof Spell && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain1.useSpell(currentDragHand, 1, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                }else if(!currentBoard.isCharacterAvailable(1) && currentHand.getCard(currentDragHand) instanceof Character && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()){
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(),1);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                updateLevelUpButtonP1();
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
                if(currentBoard.isCharacterAvailable(2) && currentHand.getCard(currentDragHand) instanceof Spell && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain1.useSpell(currentDragHand, 2, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                }else if(!currentBoard.isCharacterAvailable(2) && currentHand.getCard(currentDragHand) instanceof Character && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()){
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(),2);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                updateLevelUpButtonP1();
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
                if(currentBoard.isCharacterAvailable(3) && currentHand.getCard(currentDragHand) instanceof Spell && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain1.useSpell(currentDragHand, 3, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                }else if(!currentBoard.isCharacterAvailable(3) && currentHand.getCard(currentDragHand) instanceof Character && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()){
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(),3);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                updateLevelUpButtonP1();
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
                if (currentBoard.isCharacterAvailable(4) && currentHand.getCard(currentDragHand) instanceof Spell && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain1.useSpell(currentDragHand, 4, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                } else if (!currentBoard.isCharacterAvailable(4) && currentHand.getCard(currentDragHand) instanceof Character && pemain1.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(), 4);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain1.setMana(pemain1.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard1();
                updateLevelUpButtonP1();
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
                if(currentBoard.isCharacterAvailable(0) && currentHand.getCard(currentDragHand) instanceof Spell && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain2.useSpell(currentDragHand, 0, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                }else if(!currentBoard.isCharacterAvailable(0) && currentHand.getCard(currentDragHand) instanceof Character && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()){
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(),0);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                updateLevelUpButtonP2();
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
                if(currentBoard.isCharacterAvailable(1) && currentHand.getCard(currentDragHand) instanceof Spell && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain2.useSpell(currentDragHand, 1, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                }else if(!currentBoard.isCharacterAvailable(1) && currentHand.getCard(currentDragHand) instanceof Character && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()){
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(),1);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                updateLevelUpButtonP2();
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
                if(currentBoard.isCharacterAvailable(2) && currentHand.getCard(currentDragHand) instanceof Spell && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain2.useSpell(currentDragHand, 2, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                }else if(!currentBoard.isCharacterAvailable(2) && currentHand.getCard(currentDragHand) instanceof Character && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()){
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(),2);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                updateLevelUpButtonP2();
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
                if(currentBoard.isCharacterAvailable(3) && currentHand.getCard(currentDragHand) instanceof Spell && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain2.useSpell(currentDragHand, 3, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                }else if(!currentBoard.isCharacterAvailable(3) && currentHand.getCard(currentDragHand) instanceof Character && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()){
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(),3);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                updateLevelUpButtonP2();
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
                if (currentBoard.isCharacterAvailable(4) && currentHand.getCard(currentDragHand) instanceof Spell && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    // Spell s = (Spell) currentHand.getCard(currentDragHand);
                    // pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    // currentHand.removeCardfromHand(currentDragHand);
                    // tambah spell ke character
                    try {
                        pemain2.useSpell(currentDragHand, 4, cardReader.getCards());
                    } catch (InvalidException e) {
                        e.printStackTrace();
                    }
                } else if (!currentBoard.isCharacterAvailable(4) && currentHand.getCard(currentDragHand) instanceof Character && pemain2.getMana()>=currentHand.getCard(currentDragHand).getMana()) {
                    try {
                        currentBoard.addCardtoBoard((Card)currentHand.getCard(currentDragHand).clone(), 4);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    pemain2.setMana(pemain2.getMana()-currentHand.getCard(currentDragHand).getMana());
                    currentHand.removeCardfromHand(currentDragHand);
                }
                updateDisplayMana();
                updateBoard();
                updateHand();
                updateDeleteHand();
                updateDeleteBoard2();
                updateLevelUpButtonP2();
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

        handCard2.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = handCard2.startDragAndDrop(TransferMode.ANY);
            currentDragHand = 1;
            ClipboardContent content = new ClipboardContent();
            content.putImage(handCard2.getImage());
            db.setContent(content);
            event.consume();
        });

        handCard3.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = handCard3.startDragAndDrop(TransferMode.ANY);
            currentDragHand = 2;
            ClipboardContent content = new ClipboardContent();
            content.putImage(handCard3.getImage());
            db.setContent(content);
            event.consume();
        });

        handCard4.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = handCard4.startDragAndDrop(TransferMode.ANY);
            currentDragHand = 3;
            ClipboardContent content = new ClipboardContent();
            content.putImage(handCard4.getImage());
            db.setContent(content);
            event.consume();
        });

        handCard5.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = handCard5.startDragAndDrop(TransferMode.ANY);
            currentDragHand = 4;
            ClipboardContent content = new ClipboardContent();
            content.putImage(handCard5.getImage());
            db.setContent(content);
            event.consume();
        });
    }
    

    public void endDragAndDropHand(){
        handCard1.setOnDragDetected(null);
        handCard2.setOnDragDetected(null);
        handCard3.setOnDragDetected(null);
        handCard4.setOnDragDetected(null);
        handCard5.setOnDragDetected(null);
    }


    public void markHasSpell(int id) {
        // cardAttribute.getStyleClass().add("backgroundHasSpell");
        // cardDescription.getStyleClass().add("backgroundHasSpell");
        switch (id) {
            case 0:
                player1BoardA.getStyleClass().add("backgroundHasSpell");
                break;
            case 1:
                player1BoardB.getStyleClass().add("backgroundHasSpell");
                break;
            case 2:
                player1BoardC.getStyleClass().add("backgroundHasSpell");
                break;
            case 3:
                player1BoardD.getStyleClass().add("backgroundHasSpell");
                break;
            case 4:
                player1BoardE.getStyleClass().add("backgroundHasSpell");
                break;
            case 5:
                player2BoardA.getStyleClass().add("backgroundHasSpell");
                break;
            case 6:
                player2BoardB.getStyleClass().add("backgroundHasSpell");
                break;
            case 7:
                player2BoardC.getStyleClass().add("backgroundHasSpell");
                break;
            case 8:
                player2BoardD.getStyleClass().add("backgroundHasSpell");
                break;
            case 9:
                player2BoardE.getStyleClass().add("backgroundHasSpell");
                break;
            default:
                break;
        }
    }


    public void unmarkHasSpell() {
        // cardAttribute.getStyleClass().removeIf(style -> style.equals("backgroundHasPotion"));
        // cardDescription.getStyleClass().removeIf(style -> style.equals("backgroundHasPotion"));
        player1BoardA.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
        player1BoardB.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
        player1BoardC.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
        player1BoardD.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
        player1BoardE.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
        player2BoardA.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
        player2BoardB.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
        player2BoardC.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
        player2BoardD.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
        player2BoardE.getStyleClass().removeIf(style -> style.equals("backgroundHasSpell"));
    }



    /* 
     *  ATTACK 
     */

    public void initSelectAttack() {
        // mekanisme pada stage attack
        if (turn % 2 == 1) {
            initSelectP1AttackP2();
        } else {
            initSelectP2AttackP1();
        }
    }

    
    public void initSelectP1AttackP2() {
        // mekanisme attack pemain 1 kepada pemain 2
        Board attackerBoard = pemain1.getBoard();
        Board defenderBoard = pemain2.getBoard();

        player1BoardA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(0) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(0);
                        selectedAttCard = 0;
                    } else if (selectedAttCard == 0) {
                        unselectBoardCard(0);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard);
                        selectBoardCard(0);
                        selectedAttCard = 0;   
                    }
                }
            }
        });

        player1BoardB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(1) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(1);
                        selectedAttCard = 1;
                    } else if (selectedAttCard == 1) {
                        unselectBoardCard(1);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard);
                        selectBoardCard(1);
                        selectedAttCard = 1;   
                    }
                }
            }
        });

        player1BoardC.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(2) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(2);
                        selectedAttCard = 2;
                    } else if (selectedAttCard == 2) {
                        unselectBoardCard(2);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard);
                        selectBoardCard(2);
                        selectedAttCard = 2;   
                    }
                }
            }
        });

        player1BoardD.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(3) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(3);
                        selectedAttCard = 3;
                    } else if (selectedAttCard == 3) {
                        unselectBoardCard(3);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard);
                        selectBoardCard(3);
                        selectedAttCard = 3;   
                    }
                }
            }
        });

        player1BoardE.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(4) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(4);
                        selectedAttCard = 4;
                    } else if (selectedAttCard == 4) {
                        unselectBoardCard(4);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard);
                        selectBoardCard(4);
                        selectedAttCard = 4;   
                    }
                }
            }
        });

        player2BoardA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(0) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 0) {
                        unselectBoardCard(selectedDefCard + 5);
                        selectBoardCard(5);
                        selectedDefCard = 0;
                        disableAttackButton();
                        P1atkBoardA.setVisible(true);
                        P1atkBoardA.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard + 5, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain1.attack(selectedAttCard, selectedDefCard, pemain2);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard);
                                }
                            }
                        });
                    } else if (selectedDefCard == 0) {
                        unselectBoardCard(5);
                        selectedDefCard = -1;
                        disableAttackButton();
                    }
                }
            }
        });

        player2BoardB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(1) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 1) {
                        unselectBoardCard(selectedDefCard + 5);
                        selectBoardCard(6);
                        selectedDefCard = 1;
                        disableAttackButton();
                        P1atkBoardB.setVisible(true);
                        P1atkBoardB.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard + 5, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain1.attack(selectedAttCard, selectedDefCard, pemain2);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard);
                                }
                            }
                        });
                    } else if (selectedDefCard == 1) {
                        unselectBoardCard(6);
                        selectedDefCard = -1;
                        disableAttackButton();
                    }
                }
            }
        });

        player2BoardC.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(2) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 2) {
                        unselectBoardCard(selectedDefCard + 5);
                        selectBoardCard(7);
                        selectedDefCard = 2;
                        disableAttackButton();
                        P1atkBoardC.setVisible(true);
                        P1atkBoardC.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard + 5, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain1.attack(selectedAttCard, selectedDefCard, pemain2);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard);
                                }
                            }
                        });
                    } else if (selectedDefCard == 2) {
                        unselectBoardCard(7);
                        selectedDefCard = -1;
                        disableAttackButton();
                    }
                }
            }
        });

        player2BoardD.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(3) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 3) {
                        unselectBoardCard(selectedDefCard + 5);
                        selectBoardCard(8);
                        selectedDefCard = 3;
                        disableAttackButton();
                        P1atkBoardD.setVisible(true);
                        P1atkBoardD.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard + 5, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain1.attack(selectedAttCard, selectedDefCard, pemain2);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard);
                                }
                            }
                        });
                    } else if (selectedDefCard == 3) {
                        unselectBoardCard(8);
                        selectedDefCard = -1;
                        disableAttackButton();
                    }
                }
            }
        });

        player2BoardE.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(4) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 4) {
                        unselectBoardCard(selectedDefCard + 5);
                        selectBoardCard(9);
                        selectedDefCard = 4;
                        disableAttackButton();
                        P1atkBoardE.setVisible(true);
                        P1atkBoardE.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard + 5, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain1.attack(selectedAttCard, selectedDefCard, pemain2);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard);
                                }
                            }
                        });
                    } else if (selectedDefCard == 4) {
                        unselectBoardCard(9);
                        selectedDefCard = -1;
                        disableAttackButton();
                    }
                }
            }
        });

        player2Img.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (selectedAttCard != -1 && !hasAttacked && defenderBoard.isEmpty()) {
                    if (selectedDefCard == -1) {
                        selectBoardCard(11);
                        selectedDefCard = 11;
                        disableAttackButton();
                        P1atkP2.setVisible(true);
                        P1atkP2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    try {
                                        pemain1.attackEnemy(selectedAttCard, pemain2);
                                        hasAttacked = true;
                                        lifeBar1.setProgress(((double) pemain1.getHp()) / 80.0);
                                        lifeBar2.setProgress(((double) pemain2.getHp()) / 80.0);
                                        hpPlayer1.setText("HP  " + pemain1.getHp() + "/80");
                                        hpPlayer2.setText(pemain2.getHp() + "/80" + "  HP");
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                        });
                    } else if (selectedDefCard == 11) {
                        unselectBoardCard(11);
                        selectedDefCard = -1;
                        disableAttackButton();
                    } 
                }
            }
        });
    }
    
    
    public void initSelectP2AttackP1() {
        // mekanisme attack pemain 2 kepada pemain 1
        Board attackerBoard = pemain2.getBoard();
        Board defenderBoard = pemain1.getBoard();
        
        player2BoardA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(0) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(5);
                        selectedAttCard = 0;
                    } else if (selectedAttCard == 0) {
                        unselectBoardCard(5);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard + 5);
                        selectBoardCard(5);
                        selectedAttCard = 0;   
                    }
                }
            }
        });

        player2BoardB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(1) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(6);
                        selectedAttCard = 1;
                    } else if (selectedAttCard == 1) {
                        unselectBoardCard(6);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard + 5);
                        selectBoardCard(6);
                        selectedAttCard = 1;   
                    }
                }
            }
        });

        player2BoardC.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(2) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(7);
                        selectedAttCard = 2;
                    } else if (selectedAttCard == 2) {
                        unselectBoardCard(7);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard + 5);
                        selectBoardCard(7);
                        selectedAttCard = 2;   
                    }
                }
            }
        });

        player2BoardD.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(3) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(8);
                        selectedAttCard = 3;
                    } else if (selectedAttCard == 3) {
                        unselectBoardCard(8);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard + 5);
                        selectBoardCard(8);
                        selectedAttCard = 3;   
                    }
                }
            }
        });

        player2BoardE.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (attackerBoard.isCharacterAvailable(4) && !hasAttacked && idStage == 2) {
                    if (selectedAttCard == -1) {
                        selectBoardCard(9);
                        selectedAttCard = 4;
                    } else if (selectedAttCard == 4) {
                        unselectBoardCard(9);
                        selectedAttCard = -1;
                    } else {
                        unselectBoardCard(selectedAttCard + 5);
                        selectBoardCard(9);
                        selectedAttCard = 4;   
                    }
                }
            }
        });

        player1BoardA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(0) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 0) {
                        unselectBoardCard(selectedDefCard);
                        selectBoardCard(0);
                        selectedDefCard = 0;
                        disableAttackButton();
                        P2atkBoardA.setVisible(true);
                        P2atkBoardA.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard + 5, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain2.attack(selectedAttCard, selectedDefCard, pemain1);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard + 5);
                                }
                            }
                        });
                    } else if (selectedDefCard == 0) {
                        unselectBoardCard(0);
                        selectedDefCard = -1;
                        disableAttackButton();
                    }
                }
            }
        });

        player1BoardB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(1) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 1) {
                        unselectBoardCard(selectedDefCard);
                        selectBoardCard(1);
                        selectedDefCard = 1;
                        disableAttackButton();
                        P2atkBoardB.setVisible(true);
                        P2atkBoardB.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard + 5, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain2.attack(selectedAttCard, selectedDefCard, pemain1);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard + 5);
                                }
                            }
                        });
                    } else if (selectedDefCard == 1) {
                        unselectBoardCard(1);
                        selectedDefCard = -1;
                        disableAttackButton();
                    } 
                }
            }
        });

        player1BoardC.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(2) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 2) {
                        unselectBoardCard(selectedDefCard);
                        selectBoardCard(2);
                        selectedDefCard = 2;
                        disableAttackButton();
                        P2atkBoardC.setVisible(true);
                        P2atkBoardC.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard + 5, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain2.attack(selectedAttCard, selectedDefCard, pemain1);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard + 5);
                                }
                            }
                        });
                    } else if (selectedDefCard == 2) {
                        unselectBoardCard(2);
                        selectedDefCard = -1;
                        disableAttackButton();
                    }
                }
            }
        });

        player1BoardD.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(3) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 3) {
                        unselectBoardCard(selectedDefCard);
                        selectBoardCard(3);
                        selectedDefCard = 3;
                        disableAttackButton();
                        P2atkBoardD.setVisible(true);
                        P2atkBoardD.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard + 5, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain2.attack(selectedAttCard, selectedDefCard, pemain1);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard + 5);
                                }
                            }
                        });
                    } else if (selectedDefCard == 3) {
                        unselectBoardCard(3);
                        selectedDefCard = -1;
                        disableAttackButton();
                    }
                }
            }
        });

        player1BoardE.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (defenderBoard.isCharacterAvailable(4) && selectedAttCard != -1 && !hasAttacked && !((Character) attackerBoard.getCard(selectedAttCard)).hasAttacked()) {
                    if (selectedDefCard == -1 || selectedDefCard != 4) {
                        unselectBoardCard(selectedDefCard);
                        selectBoardCard(4);
                        selectedDefCard = 4;
                        disableAttackButton();
                        P2atkBoardE.setVisible(true);
                        P2atkBoardE.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    displayDamage(selectedAttCard + 5, ((Character) defenderBoard.getCard(selectedDefCard)).getDamage((Character) attackerBoard.getCard(selectedAttCard)));
                                    displayDamage(selectedDefCard, ((Character) attackerBoard.getCard(selectedAttCard)).getDamage((Character) defenderBoard.getCard(selectedDefCard)));
                                    pemain2.attack(selectedAttCard, selectedDefCard, pemain1);
                                    hasAttacked = true;
                                    markHasAttacked(selectedAttCard + 5);
                                }
                            }
                        });
                    } else if (selectedDefCard == 4) {
                        unselectBoardCard(4);
                        selectedDefCard = -1;
                        disableAttackButton();
                    }
                }
            }
        });

        player1Img.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (selectedAttCard != -1 && !hasAttacked && defenderBoard.isEmpty()) {
                    if (selectedDefCard == -1) {
                        selectBoardCard(10);
                        selectedDefCard = 10;
                        disableAttackButton();
                        P2atkP1.setVisible(true);
                        P2atkP1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (!hasAttacked) {
                                    try {
                                        pemain2.attackEnemy(selectedAttCard, pemain1);
                                        hasAttacked = true;
                                        lifeBar1.setProgress(((double) pemain1.getHp()) / 80.0);
                                        lifeBar2.setProgress(((double) pemain2.getHp()) / 80.0);
                                        hpPlayer1.setText("HP  " + pemain1.getHp() + "/80");
                                        hpPlayer2.setText(pemain2.getHp() + "/80" + "  HP");
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                        });
                    } else if (selectedDefCard == 10) {
                        unselectBoardCard(10);
                        selectedDefCard = -1;
                        disableAttackButton();
                    } 
                }
            }
        });
    }
    

    public void selectBoardCard(int id) {
        // meng-highlight kartu yang dipilih
        switch (id) {
            case 0:
                player1BoardAFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 1:
                player1BoardBFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 2:
                player1BoardCFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 3:
                player1BoardDFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 4:
                player1BoardEFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 5:
                player2BoardAFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 6:
                player2BoardBFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 7:
                player2BoardCFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 8:
                player2BoardDFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 9:
                player2BoardEFrame.getStyleClass().add("backgroundSelectedCard");
                break;
            case 10:
                player1Img.getStyleClass().add("backgroundSelectedCard");
                break;
            case 11:
                player2Img.getStyleClass().add("backgroundSelectedCard");
                break;
            default:
                break;
        }

    }


    public void unselectBoardCard(int id) {
        // menghilangkan highlight kartu yang dipilih
        switch (id) {
            case 0:
                player1BoardAFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 1:
                player1BoardBFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 2:
                player1BoardCFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 3:
                player1BoardDFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 4:
                player1BoardEFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 5:
                player2BoardAFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 6:
                player2BoardBFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 7:
                player2BoardCFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 8:
                player2BoardDFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 9:
                player2BoardEFrame.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 10:
                player1Img.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            case 11:
                player2Img.getStyleClass().removeIf(style -> style.equals("backgroundSelectedCard"));
                break;
            default:
                break;
        }
    }


    public void markHasAttacked(int id) {
        switch (id) {
            case 0:
                player1BoardAFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            case 1:
                player1BoardBFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            case 2:
                player1BoardCFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            case 3:
                player1BoardDFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            case 4:
                player1BoardEFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            case 5:
                player2BoardAFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            case 6:
                player2BoardBFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            case 7:
                player2BoardCFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            case 8:
                player2BoardDFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            case 9:
                player2BoardEFrame.getStyleClass().add("backgroundHasAttacked");
                break;
            default:
                break;
        }
    }


    public void unmarkHasAttacked(int id) {
        switch (id) {
            case 0:
                player1BoardAFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            case 1:
                player1BoardBFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            case 2:
                player1BoardCFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            case 3:
                player1BoardDFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            case 4:
                player1BoardEFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            case 5:
                player2BoardAFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            case 6:
                player2BoardBFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            case 7:
                player2BoardCFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            case 8:
                player2BoardDFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            case 9:
                player2BoardEFrame.getStyleClass().removeIf(style -> style.equals("backgroundHasAttacked"));
                break;
            default:
                break;
        }
    }


    public void clearAttack() {
        // set variabel yang akan digunakan saat stage attack
        unselectBoardCard(selectedAttCard);
        unselectBoardCard(selectedAttCard+5);
        unselectBoardCard(selectedDefCard);
        unselectBoardCard(selectedDefCard+5);
        selectedAttCard = -1;
        selectedDefCard = -1;
        hasAttacked = false;
        disableAttackButton();
        hideDamage();
    }


    public void endMouseClickAttack() {
        player1BoardA.setOnMouseClicked(null);
        player1BoardB.setOnMouseClicked(null);
        player1BoardC.setOnMouseClicked(null);
        player1BoardD.setOnMouseClicked(null);
        player1BoardE.setOnMouseClicked(null);
        player1Img.setOnMouseClicked(null);

        player2BoardA.setOnMouseClicked(null);
        player2BoardB.setOnMouseClicked(null);
        player2BoardC.setOnMouseClicked(null);
        player2BoardD.setOnMouseClicked(null);
        player2BoardE.setOnMouseClicked(null);
        player2Img.setOnMouseClicked(null);

        P1atkBoardA.setOnMouseClicked(null);
        P1atkBoardB.setOnMouseClicked(null);
        P1atkBoardC.setOnMouseClicked(null);
        P1atkBoardD.setOnMouseClicked(null);
        P1atkBoardE.setOnMouseClicked(null);
        P1atkP2.setOnMouseClicked(null);

        P2atkBoardA.setOnMouseClicked(null);
        P2atkBoardB.setOnMouseClicked(null);
        P2atkBoardC.setOnMouseClicked(null);
        P2atkBoardD.setOnMouseClicked(null);
        P2atkBoardE.setOnMouseClicked(null);
        P2atkP1.setOnMouseClicked(null);
    }


    public void disableAttackButton() {
        // menonaktifkan tombol attack
        P1atkBoardA.setVisible(false);
        P1atkBoardB.setVisible(false);
        P1atkBoardC.setVisible(false);
        P1atkBoardD.setVisible(false);
        P1atkBoardE.setVisible(false);
        P1atkP2.setVisible(false);
        P2atkBoardA.setVisible(false);
        P2atkBoardB.setVisible(false);
        P2atkBoardC.setVisible(false);
        P2atkBoardD.setVisible(false);
        P2atkBoardE.setVisible(false);
        P2atkP1.setVisible(false);
    }


    public void displayDamage(int id, double damage) {
        // menampilkan damage yang didapat
        switch (id) {
            case 0:
                damagetoBoardAP1.setText(Double.toString(damage));
                damagetoBoardAP1.setVisible(true);
                break;
            case 1:
                damagetoBoardBP1.setText(Double.toString(damage));
                damagetoBoardBP1.setVisible(true);
                break;
            case 2:
                damagetoBoardCP1.setText(Double.toString(damage));
                damagetoBoardCP1.setVisible(true);
                break;
            case 3:
                damagetoBoardDP1.setText(Double.toString(damage));
                damagetoBoardDP1.setVisible(true);
                break;
            case 4:
                damagetoBoardEP1.setText(Double.toString(damage));
                damagetoBoardEP1.setVisible(true);
                break;
            case 5:
                damagetoBoardAP2.setText(Double.toString(damage));
                damagetoBoardAP2.setVisible(true);
                break;
            case 6:
                damagetoBoardBP2.setText(Double.toString(damage));
                damagetoBoardBP2.setVisible(true);
                break;
            case 7:
                damagetoBoardCP2.setText(Double.toString(damage));
                damagetoBoardCP2.setVisible(true);
                break;
            case 8:
                damagetoBoardDP2.setText(Double.toString(damage));
                damagetoBoardDP2.setVisible(true);
                break;
            case 9:
                damagetoBoardEP2.setText(Double.toString(damage));
                damagetoBoardEP2.setVisible(true);
                break;
            default:
                break;
        }
    }


    public void hideDamage() {
        // menyembunyikan damage yang didapat
        damagetoBoardAP1.setVisible(false);
        damagetoBoardBP1.setVisible(false);
        damagetoBoardCP1.setVisible(false);
        damagetoBoardDP1.setVisible(false);
        damagetoBoardEP1.setVisible(false);
        damagetoBoardAP2.setVisible(false);
        damagetoBoardBP2.setVisible(false);
        damagetoBoardCP2.setVisible(false);
        damagetoBoardDP2.setVisible(false);
        damagetoBoardEP2.setVisible(false);
    }



    /*
     *  LEVEL UP USING MANA
     */

    public void initLevelUpUseMana() {
        if (turn % 2 == 1) {
            initLevelUpUseManaP1();
        } else {
            initLevelUpUseManaP2();
        }
    }


    public void initLevelUpUseManaP1() {
        Board P1board = pemain1.getBoard();

        levelUpBoardAP1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain1.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P1board.getCard(0)).addExp(1);
                    pemain1.setMana(pemain1.getMana() - 1);
                    if ((((Character) P1board.getCard(0)).getExp() >= ((Character) P1board.getCard(0)).getLevel() * 2 - 1) && (((Character) P1board.getCard(0)).getLevel() < 10)) {
                        ((Character) P1board.getCard(0)).addExp(-((Character) P1board.getCard(0)).getLevel() * 2 + 1);
                        ((Character) P1board.getCard(0)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard1();
            }
        });

        levelUpBoardBP1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain1.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P1board.getCard(1)).addExp(1);
                    pemain1.setMana(pemain1.getMana() - 1);
                    if ((((Character) P1board.getCard(1)).getExp() >= ((Character) P1board.getCard(1)).getLevel() * 2 - 1) && (((Character) P1board.getCard(1)).getLevel() < 10)) {
                        ((Character) P1board.getCard(1)).addExp(-((Character) P1board.getCard(1)).getLevel() * 2 + 1);
                        ((Character) P1board.getCard(1)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard1();
            }
        });

        levelUpBoardCP1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain1.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P1board.getCard(2)).addExp(1);
                    pemain1.setMana(pemain1.getMana() - 1);
                    if ((((Character) P1board.getCard(2)).getExp() >= ((Character) P1board.getCard(2)).getLevel() * 2 - 1) && (((Character) P1board.getCard(2)).getLevel() < 10)) {
                        ((Character) P1board.getCard(2)).addExp(-((Character) P1board.getCard(2)).getLevel() * 2 + 1);
                        ((Character) P1board.getCard(2)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard1();
            }
        });

        levelUpBoardDP1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain1.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P1board.getCard(3)).addExp(1);
                    pemain1.setMana(pemain1.getMana() - 1);
                    if ((((Character) P1board.getCard(3)).getExp() >= ((Character) P1board.getCard(3)).getLevel() * 2 - 1) && (((Character) P1board.getCard(3)).getLevel() < 10)) {
                        ((Character) P1board.getCard(3)).addExp(-((Character) P1board.getCard(3)).getLevel() * 2 + 1);
                        ((Character) P1board.getCard(3)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard1();
            }
        });

        levelUpBoardEP1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain1.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P1board.getCard(4)).addExp(1);
                    pemain1.setMana(pemain1.getMana() - 1);
                    if ((((Character) P1board.getCard(4)).getExp() >= ((Character) P1board.getCard(4)).getLevel() * 2 - 1) && (((Character) P1board.getCard(4)).getLevel() < 10)) {
                        ((Character) P1board.getCard(4)).addExp(-((Character) P1board.getCard(4)).getLevel() * 2 + 1);
                        ((Character) P1board.getCard(4)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard1();
            }
        });
    }


    public void initLevelUpUseManaP2() {
        Board P2board = pemain2.getBoard();

        levelUpBoardAP2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain2.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P2board.getCard(0)).addExp(1);
                    pemain2.setMana(pemain2.getMana() - 1);
                    if ((((Character) P2board.getCard(0)).getExp() >= ((Character) P2board.getCard(0)).getLevel() * 2 - 1) && (((Character) P2board.getCard(0)).getLevel() < 10)) {
                        ((Character) P2board.getCard(0)).addExp(-((Character) P2board.getCard(0)).getLevel() * 2 + 1);
                        ((Character) P2board.getCard(0)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard2();
            }
        });

        levelUpBoardBP2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain2.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P2board.getCard(1)).addExp(1);
                    pemain2.setMana(pemain2.getMana() - 1);
                    if ((((Character) P2board.getCard(1)).getExp() >= ((Character) P2board.getCard(1)).getLevel() * 2 - 1) && (((Character) P2board.getCard(1)).getLevel() < 10)) {
                        ((Character) P2board.getCard(1)).addExp((-((Character) P2board.getCard(1)).getLevel() * 2 + 1));
                        ((Character) P2board.getCard(1)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard2();
            }
        });

        levelUpBoardCP2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain2.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P2board.getCard(2)).addExp(1);
                    pemain2.setMana(pemain2.getMana() - 1);
                    if ((((Character) P2board.getCard(2)).getExp() >= ((Character) P2board.getCard(2)).getLevel() * 2 - 1) && (((Character) P2board.getCard(2)).getLevel() < 10)) {
                        ((Character) P2board.getCard(2)).addExp(-((Character) P2board.getCard(2)).getLevel() * 2 + 1);
                        ((Character) P2board.getCard(2)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard2();
            }
        });

        levelUpBoardDP2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain2.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P2board.getCard(3)).addExp(1);
                    pemain2.setMana(pemain2.getMana() - 1);
                    if ((((Character) P2board.getCard(3)).getExp() >= ((Character) P2board.getCard(3)).getLevel() * 2 - 1) && (((Character) P2board.getCard(3)).getLevel() < 10)) {
                        ((Character) P2board.getCard(3)).addExp(-((Character) P2board.getCard(3)).getLevel() * 2 + 1);
                        ((Character) P2board.getCard(3)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard2();
            }
        });

        levelUpBoardEP2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && pemain2.getMana() > 0) {
                    System.out.println("Level Up");
                    ((Character) P2board.getCard(4)).addExp(1);
                    pemain2.setMana(pemain2.getMana() - 1);
                    if ((((Character) P2board.getCard(4)).getExp() >= ((Character) P2board.getCard(4)).getLevel() * 2 - 1) && (((Character) P2board.getCard(4)).getLevel() < 10)) {
                        ((Character) P2board.getCard(4)).addExp(-((Character) P2board.getCard(4)).getLevel() * 2 + 1);
                        ((Character) P2board.getCard(4)).levelUp(1);
                    }
                }
                updateDisplayMana();
                updateBoard2();
            }
        });
    }


    public void updateLevelUpButton() {
        if (turn % 2 == 1) {
            updateLevelUpButtonP1();
        } else {
            updateLevelUpButtonP2();
        }
    }


    public void updateLevelUpButtonP1(){
        Board currentBoard = pemain1.getBoard();
        for(int i = 0; i < 5; i++){
            if(!currentBoard.isValidIdx(i) && pemain1.getMana() > 0){
                if ( i == 0 ) {
                    levelUpBoardAP1.setVisible(true);
                } else if (i == 1) {
                    levelUpBoardBP1.setVisible(true);
                } else if (i == 2) {
                    levelUpBoardCP1.setVisible(true);
                } else if (i == 3) {
                    levelUpBoardDP1.setVisible(true);
                } else if (i == 4) {
                    levelUpBoardEP1.setVisible(true);
                }
            } else {
                if (i == 0) {
                    levelUpBoardAP1.setVisible(false);
                } else if (i == 1) {
                    levelUpBoardBP1.setVisible(false);
                } else if (i == 2) {
                    levelUpBoardCP1.setVisible(false);
                } else if (i == 3) {
                    levelUpBoardDP1.setVisible(false);
                } else if (i == 4) {
                    levelUpBoardEP1.setVisible(false);
                }
            }
        }
    }


    public void updateLevelUpButtonP2(){
        Board currentBoard = pemain2.getBoard();
        for(int i = 0; i < 5; i++){
            if(!currentBoard.isValidIdx(i) && pemain2.getMana() > 0){
                if ( i == 0 ) {
                    levelUpBoardAP2.setVisible(true);
                } else if (i == 1) {
                    levelUpBoardBP2.setVisible(true);
                } else if (i == 2) {
                    levelUpBoardCP2.setVisible(true);
                } else if (i == 3) {
                    levelUpBoardDP2.setVisible(true);
                } else if (i == 4) {
                    levelUpBoardEP2.setVisible(true);
                }
            } else {
                if (i == 0) {
                    levelUpBoardAP2.setVisible(false);
                } else if (i == 1) {
                    levelUpBoardBP2.setVisible(false);
                } else if (i == 2) {
                    levelUpBoardCP2.setVisible(false);
                } else if (i == 3) {
                    levelUpBoardDP2.setVisible(false);
                } else if (i == 4) {
                    levelUpBoardEP2.setVisible(false);
                }
            }
        }
    }

    
    public void endLevelUpButton () {
        levelUpBoardAP1.setVisible(false);
        levelUpBoardBP1.setVisible(false);
        levelUpBoardCP1.setVisible(false);
        levelUpBoardDP1.setVisible(false);
        levelUpBoardEP1.setVisible(false);
        levelUpBoardAP2.setVisible(false);
        levelUpBoardBP2.setVisible(false);
        levelUpBoardCP2.setVisible(false);
        levelUpBoardDP2.setVisible(false);
        levelUpBoardEP2.setVisible(false);
    }


    /* 
     *  END GAME
     */
    public boolean endGame() {
        if (pemain1.getHp() <= 0) {
            System.out.println("Player 2 Win");
            EndGameLayer.setVisible(true);
            crownP2.setVisible(true);
            winnerP2.setVisible(true);
            return true;
        } else if (pemain2.getHp() <= 0) {
            System.out.println("Player 1 Win");
            EndGameLayer.setVisible(true);
            crownP1.setVisible(true);
            winnerP1.setVisible(true);
            return true;
        } else if (noMoreCards(pemain1) || noMoreCards(pemain2)) {
            EndGameLayer.setVisible(true);
            if (pemain1.getHp() > pemain2.getHp()) {
                System.out.println("Player 1 Win");
                crownP1.setVisible(true);
                winnerP1.setVisible(true);
            } else if (pemain1.getHp() < pemain2.getHp()) {
                System.out.println("Player 2 Win");
                crownP2.setVisible(true);
                winnerP2.setVisible(true);
            } else {
                System.out.println("Draw");
                crownP1.setVisible(true);
                crownP2.setVisible(true);
                winnerP1.setText("Draw");
                winnerP1.setVisible(true);
                winnerP2.setText("Draw");
                winnerP2.setVisible(true);
            }
            return true;
        }
        return false;
    }


    public boolean noMoreCards(Player p) {
        return (p.getDeck().getSize() == 0) && (p.getHand().isEmpty()) && (p.getBoard().isEmpty() || allBoardCardsHasAttacked(p));
    }


    public boolean allBoardCardsHasAttacked(Player p) {
        boolean result = true;
        for (int i = 0; i < 5; i++) {
            if (p.getBoard().isCharacterAvailable(i)) {
                result = result && ((Character) p.getBoard().getCard(i)).hasAttacked();
            }
        }
        return result;
    }

    

    /* 
     * CHANGE STAGE
     */

    public void changeStageClicked(){
        // kalau button untuk pindah stage diclick
        if(idStage==-1){    // stage saat baru start program
            viewHand();
            turn++;
            numTurn.setText(Integer.toString((turn+1)/2));
            // menampilkan penanda giliran saat ini
            if (turn % 2 == 1) {
                framePlayer1.setVisible(true);
                framePlayer2.setVisible(false);
            }
            else {
                framePlayer1.setVisible(false);
                framePlayer2.setVisible(true);
            }
            // menampilkan jumlah kartu di deck
            setDisplayDeckNum();
            // mengupdate tampilan hand sesuai giliran saat ini
            if(turn%2==1) {
                updateHand1();
            }else{
                updateHand2();
            }
            // menampilkan layar draw dan update tampilan hand
            displayWindowDraw();
            // update hand, mana, decknum setelah draw
            if(turn%2==1) {
                updateHand1();
            }else{
                updateHand2();
            }
            setDisplayMana();
            setDisplayDeckNum();
            // inisiasi hover hand setelah draw
            initHoveredCardHand();
            // inisiasi ganti stage
            activateStageLabel(stageEndLabel,stageDrawLabel);
        } else if(idStage==0){  // fase planning
            initDragAndDropHand();              // inisiasi drag and drop                       
            initDelete();                       // inisiasi tombol delete hand dan board  
            initLevelUpUseMana();               // inisiasi tombol level up pakai mana              
            updateHand();                       // update hand jika ada yang didelete               
            updateDeleteHand();                 // update display tombol delete jika ada yang didelete      
            updateLevelUpButton();
            System.out.println("Hand 1 besar : "+pemain1.getHand().numberOfCards());
            if(turn%2==1){
                initDragAndDropBoardPlayer1();  // inisiasi drag and drop board player 1
                updateDeleteBoard1();           // update display tombol delete board player 1
                updateLevelUpButtonP1();        // update display tombol level up board player 1
            }else{
                initDragAndDropBoardPlayer2();  // inisiasi drag and drop board player 2
                updateDeleteBoard2();           // update display tombol delete board player 2
                updateLevelUpButtonP2();        // update display tombol level up board player 2
            }
            initHoveredCardBoard();             // inisiasi hover board
            setDisplayDeckNum();                // update tampilan decknum
            activateStageLabel(stageDrawLabel,stagePlanLabel);
        }else if(idStage==1){ // fase attack
            updateBoard1();                     // update board player 1
            updateBoard2();                     // update board player 2
            endLevelUpButton();                 // akhiri display tombol level up
            endDelete();                        // akhiri display tombol delete hand dan board
            endDragAndDropHand();               // akhiri proses drag and drop hand
            if(turn%2==1){
                endDragAndDrop1();              // akhiri proses drag and drop board player 1
            }else{
                endDragAndDrop2();              // akhiri proses drag and drop board player 2
            }
            initSelectAttack();                 // inisiasi attack
            activateStageLabel(stagePlanLabel,stageAttackLabel);
        }else if(idStage==2){ // fase end
            initHoveredPlayerImg();             // inisiasi hover player img
            updateBoard1();                     // update board player 1 setelah attack
            updateBoard2();                     // update board player 2 setelah attack
            clearAttack();                      // akhiri attack
            endMouseClickAttack();              // akhiri attack
            activateStageLabel(stageAttackLabel,stageEndLabel);
        }else if(idStage==3){ // fase draw
            turn++;
            numTurn.setText(Integer.toString((turn+1)/2));
            if (turn % 2 == 1) {
                framePlayer1.setVisible(true);  
                framePlayer2.setVisible(false);
                updateSpellBoard1();            // update durasi spell board player 1
                updateBoard1();                 // update board player 1
            }
            else {
                framePlayer1.setVisible(false);
                framePlayer2.setVisible(true);
                updateSpellBoard2();            // update durasi spell board player 2
                updateBoard2();                 // update board player 2
            }
            setDisplayDeckNum();                // update tampilan decknum
            setDisplayMana();                   // update mana
            if(turn%2==1) {                     // update tampilan hand
                updateHand1();
            }else{
                updateHand2();
            }
            if (!endGame()) {                   // tampilkan draw phase jika belum end game
                displayWindowDraw();
            }
            if(turn%2==1) {                     // update tampilan hand setelah draw
                updateHand1();
            }else{
                updateHand2();
            }
            setDisplayDeckNum();                // update tampilan decknum
            initHoveredCardHand();              // inisiasi hover hand setelah draw
            activateStageLabel(stageEndLabel,stageDrawLabel);
        }
        debugOnGoing();
        idStage++;
        idStage%=4;

        // panggil method sesuai dengan apa yang ingin dilakuin di stage itu
    }



    /* 
     * FUNGSI PEMBANTU 
     */

    public String getCardAttributes(Card c) {
        // Menampilkan informasi kartu
        String attribute = "";
        attribute += c.getName().toUpperCase();
        if (c instanceof Character){
            // Kartu karakter
            attribute += "\nATK   : " + ((Character) c).getAttack();
            attribute += "\nHP     : " + ((Character) c).getHealth();
            attribute += "\nEXP    : " + ((Character) c).getExp();
            attribute += "\nLVL    : " + ((Character) c).getLevel();
            attribute += "\nTYPE  : " + ((Character) c).getType();
            attribute += getAllSpell((Character) c);
        } else {
            // Kartu spell
            if (((Spell) c).getDuration() != 0) {
                attribute += "\nDURATION  : " + ((Spell) c).getDuration();
            } else {
                attribute += "\nDURATION  : PERMANENT";
            }
            if (c instanceof PtnSpell) {
                // spell Potion
                attribute += "\nTYPE      : " + ((PtnSpell) c).getCardType();
                attribute += "\nATK+      : " + ((PtnSpell) c).getPtnAttack();
                attribute += "\nHP+       : " + ((PtnSpell) c).getPtnHp();
            } else if (c instanceof SwapSpell) {
                // spell Swap
                attribute += "\nTYPE      : " + ((SwapSpell) c).getCardType();
            } else if (c instanceof MorphSpell){
                // spell Morph
                attribute += "\nTYPE      : " + ((MorphSpell) c).getCardType();
            } else {
                // spell Level
                attribute += "\nTYPE      : LVL";
            }
        }
        return attribute;
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


    public String getExpLevel(Character c) {
        String info = "";
        int expNeeded = c.getLevel() * 2 - 1;
        info += c.getExp() + "/" + expNeeded + " [" + c.getLevel() + "]";
        return info;
    }


    public String getAllSpell(Character c) {
        String info = "";
        if (!c.getListSpell().isEmpty()) {
            info += "\nPTN SPELL : ";
        }
        for (int i = 0; i < c.getListSpell().size(); i++) {
            info += c.getListSpell().get(i).getName();
            info += "(" + c.getListSpell().get(i).getDuration() + ")";
            if (i != c.getListSpell().size() - 1) {
                info += ", ";
            }
        }
        if (c.getSwapDur() > 0) {
            info += "\nSWAP DURATION : " + c.getSwapDur();
        }
        return info;
    }
    

    public void alignImageCentre(ImageView imageView) {
        // Mengatur posisi imageView agar posisinya di tengah
        Image img = imageView.getImage();
        if (img != null) {
            double w = 0;
            double h = 0;

            double ratioX = imageView.getFitWidth() / img.getWidth();
            double ratioY = imageView.getFitHeight() / img.getHeight();

            double reducCoeff = 0;
            if (ratioX >= ratioY) {
                reducCoeff = ratioY;
            } else {
                reducCoeff = ratioX;
            }

            w = img.getWidth() * reducCoeff;
            h = img.getHeight() * reducCoeff;

            imageView.setX((imageView.getFitWidth() - w) / 2);
            imageView.setY((imageView.getFitHeight() - h) / 2);
        }
    }


    public void removeDeadCard() {
        // menghapus kartu yang sudah mati dari board
        System.out.println("removeDeadCard");
        for (int i = 0; i < 5; i++) {
            if (pemain1.getBoard().isCharacterAvailable(i) && ((Character) pemain1.getBoard().getCard(i)).getHealth() <= 0) {
                unmarkHasAttacked(i);
                System.out.println("Kartu " + i + " dihapus");
                pemain1.getBoard().removeCardfromBoard(i);
            }
            if (pemain1.getBoard().isValidIdx(i)) {
                unmarkHasAttacked(i);
            }
        }
        for (int i = 0; i < 5; i++) {
            if (pemain2.getBoard().isCharacterAvailable(i) && ((Character) pemain2.getBoard().getCard(i)).getHealth() <= 0) {
                unmarkHasAttacked(i + 5);
                System.out.println("Kartu " + i + " dihapus");
                pemain2.getBoard().removeCardfromBoard(i);
            }
            if (pemain2.getBoard().isValidIdx(i)) {
                unmarkHasAttacked(i + 5);
            }
        }
    }


    public void updateSpellBoard1() {
        System.out.println("updateSpell");
        for (int i = 0; i < 5; i++) {
            if (pemain1.getBoard().isCharacterAvailable(i)) {
                ((Character) pemain1.getBoard().getCard(i)).updateDur((turn+1)/2);
            }
        }
    }


    public void updateSpellBoard2() {
        System.out.println("updateSpell");
        for (int i = 0; i < 5; i++) {
            if (pemain2.getBoard().isCharacterAvailable(i)) {
                ((Character) pemain2.getBoard().getCard(i)).updateDur((turn+1)/2);
            }
        }
    }

    public void hideHand() {
        System.out.println("Hide Hand");
        handCard1.setVisible(false);
        handCard1Mana.setVisible(false);
        handCard1AtkHealth.setVisible(false);
        handCard2.setVisible(false);
        handCard2Mana.setVisible(false);
        handCard2AtkHealth.setVisible(false);
        handCard3.setVisible(false);
        handCard3Mana.setVisible(false);
        handCard3AtkHealth.setVisible(false);
        handCard4.setVisible(false);
        handCard4Mana.setVisible(false);
        handCard4AtkHealth.setVisible(false);
        handCard5.setVisible(false);
        handCard5Mana.setVisible(false);
        handCard5AtkHealth.setVisible(false);
    }

    public void viewHand() {
        System.out.println("View Hand");
        handCard1.setVisible(true);
        handCard1Mana.setVisible(true);
        handCard1AtkHealth.setVisible(true);
        handCard2.setVisible(true);
        handCard2Mana.setVisible(true);
        handCard2AtkHealth.setVisible(true);
        handCard3.setVisible(true);
        handCard3Mana.setVisible(true);
        handCard3AtkHealth.setVisible(true);
        handCard4.setVisible(true);
        handCard4Mana.setVisible(true);
        handCard4AtkHealth.setVisible(true);
        handCard5.setVisible(true);
        handCard5Mana.setVisible(true);
        handCard5AtkHealth.setVisible(true);
    }



    /* 
     *  Fungsi fungsi set display 
     */

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


    public void setDisplayMana(){
        System.out.println("Set mana");
        if(turn%2==1){
            pemain1.setMana(min((turn+1)/2,10));
            manaNum.setText("Mana\n"+pemain1.getMana()+"/"+min((turn+1)/2,10));
        }else{
            pemain2.setMana(min((turn+1)/2,10));
            manaNum.setText("Mana\n"+pemain2.getMana()+"/"+min((turn+1)/2,10));
        }
    }


    public void updateDisplayMana(){
        if(turn%2==1){
            manaNum.setText("Mana\n"+pemain1.getMana()+"/"+min((turn+1)/2,10));
        }else{
            manaNum.setText("Mana\n"+pemain2.getMana()+"/"+min((turn+1)/2,10));
        }
    }


    public void setDisplayDeckNum(){
        System.out.println("Set mana");
        if(turn%2==1){
            deckNum.setText("Deck\n"+pemain1.getDeck().getSize()+"/"+deckCapacityPemain1);
        }else{
            deckNum.setText("Deck\n"+pemain2.getDeck().getSize()+"/"+deckCapacityPemain2);
        }
    }



    /*  
     *  UPDATE HAND, BOARD
     *  Melakukan update tampilan kartu yang ada di board dan hand
     */

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
                alignImageCentre(handCard1);
                handCard1Mana.setText("MANA "+handPemain1.getCard(i).getMana());
                handCard1AtkHealth.setText(getAtkHealth(handPemain1.getCard(i)));
            }else if(i==1){
                handCard2.setImage(new Image(getClass().getResourceAsStream(handPemain1.getCard(i).getImagePath())));
                alignImageCentre(handCard2);
                handCard2Mana.setText("MANA "+handPemain1.getCard(i).getMana());
                handCard2AtkHealth.setText(getAtkHealth(handPemain1.getCard(i)));
            }else if(i==2){
                handCard3.setImage(new Image(getClass().getResourceAsStream(handPemain1.getCard(i).getImagePath())));
                alignImageCentre(handCard3);
                handCard3Mana.setText("MANA "+handPemain1.getCard(i).getMana());
                handCard3AtkHealth.setText(getAtkHealth(handPemain1.getCard(i)));
            }else if(i==3){
                handCard4.setImage(new Image(getClass().getResourceAsStream(handPemain1.getCard(i).getImagePath())));
                alignImageCentre(handCard4);
                handCard4Mana.setText("MANA "+handPemain1.getCard(i).getMana());
                handCard4AtkHealth.setText(getAtkHealth(handPemain1.getCard(i)));
            }else if(i==4){
                handCard5.setImage(new Image(getClass().getResourceAsStream(handPemain1.getCard(i).getImagePath())));
                alignImageCentre(handCard5);
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
        for (int i=0;i<handPemain1.numberOfCards();i++){
            System.out.println( System.identityHashCode(handPemain1.getCard(i)));
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
                alignImageCentre(handCard1);
                handCard1Mana.setText("MANA "+handPemain2.getCard(i).getMana());
                handCard1AtkHealth.setText(getAtkHealth(handPemain2.getCard(i)));
            }else if(i==1){
                handCard2.setImage(new Image(getClass().getResourceAsStream(handPemain2.getCard(i).getImagePath())));
                alignImageCentre(handCard2);
                handCard2Mana.setText("MANA "+handPemain2.getCard(i).getMana());
                handCard2AtkHealth.setText(getAtkHealth(handPemain2.getCard(i)));
            }else if(i==2){
                handCard3.setImage(new Image(getClass().getResourceAsStream(handPemain2.getCard(i).getImagePath())));
                alignImageCentre(handCard3);
                handCard3Mana.setText("MANA "+handPemain2.getCard(i).getMana());
                handCard3AtkHealth.setText(getAtkHealth(handPemain2.getCard(i)));
            }else if(i==3){
                handCard4.setImage(new Image(getClass().getResourceAsStream(handPemain2.getCard(i).getImagePath())));
                alignImageCentre(handCard4);
                handCard4Mana.setText("MANA "+handPemain2.getCard(i).getMana());
                handCard4AtkHealth.setText(getAtkHealth(handPemain2.getCard(i)));
            }else if(i==4){
                handCard5.setImage(new Image(getClass().getResourceAsStream(handPemain2.getCard(i).getImagePath())));
                alignImageCentre(handCard5);
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
        for (int i=0;i<handPemain2.numberOfCards();i++){
            System.out.println( System.identityHashCode(handPemain2.getCard(i)));
        }
    }
    

    public void updateBoard(){
        if(turn%2==1){
            updateBoard1();
        }else{
            updateBoard2();
        }
    }


    public void updateBoard1(){
        Board currentBoard = pemain1.getBoard();
        removeDeadCard();
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
                    alignImageCentre(player1BoardA);
                    player1BoardAAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardAHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardALvl.setText(getExpLevel((Character)currentBoard.getCard(i)));

                }else if(i==1){
                    player1BoardBAttack.setVisible(true);
                    player1BoardBAttackImg.setVisible(true);
                    player1BoardBHealth.setVisible(true);
                    player1BoardBHealthImg.setVisible(true);
                    player1BoardBLvl.setVisible(true);
                    player1BoardBLabel.setVisible(false);

                    player1BoardB.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    alignImageCentre(player1BoardB);
                    player1BoardBAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardBHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardBLvl.setText(getExpLevel((Character)currentBoard.getCard(i)));

                }else if(i==2){
                    player1BoardCAttack.setVisible(true);
                    player1BoardCAttackImg.setVisible(true);
                    player1BoardCHealth.setVisible(true);
                    player1BoardCHealthImg.setVisible(true);
                    player1BoardCLvl.setVisible(true);
                    player1BoardCLabel.setVisible(false);

                    player1BoardC.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    alignImageCentre(player1BoardC);
                    player1BoardCAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardCHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardCLvl.setText(getExpLevel((Character)currentBoard.getCard(i)));

                }else if(i==3){
                    player1BoardDAttack.setVisible(true);
                    player1BoardDAttackImg.setVisible(true);
                    player1BoardDHealth.setVisible(true);
                    player1BoardDHealthImg.setVisible(true);
                    player1BoardDLvl.setVisible(true);
                    player1BoardDLabel.setVisible(false);

                    player1BoardD.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    alignImageCentre(player1BoardD);
                    player1BoardDAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardDHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardDLvl.setText(getExpLevel((Character)currentBoard.getCard(i)));

                }else if(i==4){
                    player1BoardEAttack.setVisible(true);
                    player1BoardEAttackImg.setVisible(true);
                    player1BoardEHealth.setVisible(true);
                    player1BoardEHealthImg.setVisible(true);
                    player1BoardELvl.setVisible(true);
                    player1BoardELabel.setVisible(false);

                    player1BoardE.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    alignImageCentre(player1BoardE);
                    player1BoardEAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player1BoardEHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player1BoardELvl.setText(getExpLevel((Character)currentBoard.getCard(i)));
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
        removeDeadCard();
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
                    alignImageCentre(player2BoardA);
                    player2BoardAAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardAHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardALvl.setText(getExpLevel((Character)currentBoard.getCard(i)));

                }else if(i==1){
                    player2BoardBAttack.setVisible(true);
                    player2BoardBAttackImg.setVisible(true);
                    player2BoardBHealth.setVisible(true);
                    player2BoardBHealthImg.setVisible(true);
                    player2BoardBLvl.setVisible(true);
                    player2BoardBLabel.setVisible(false);

                    player2BoardB.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    alignImageCentre(player2BoardB);
                    player2BoardBAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardBHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardBLvl.setText(getExpLevel((Character)currentBoard.getCard(i)));

                }else if(i==2){
                    player2BoardCAttack.setVisible(true);
                    player2BoardCAttackImg.setVisible(true);
                    player2BoardCHealth.setVisible(true);
                    player2BoardCHealthImg.setVisible(true);
                    player2BoardCLvl.setVisible(true);
                    player2BoardCLabel.setVisible(false);

                    player2BoardC.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    alignImageCentre(player2BoardC);
                    player2BoardCAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardCHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardCLvl.setText(getExpLevel((Character)currentBoard.getCard(i)));

                }else if(i==3){
                    player2BoardDAttack.setVisible(true);
                    player2BoardDAttackImg.setVisible(true);
                    player2BoardDHealth.setVisible(true);
                    player2BoardDHealthImg.setVisible(true);
                    player2BoardDLvl.setVisible(true);
                    player2BoardDLabel.setVisible(false);

                    player2BoardD.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    alignImageCentre(player2BoardD);
                    player2BoardDAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardDHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardDLvl.setText(getExpLevel((Character)currentBoard.getCard(i)));

                }else if(i==4){
                    player2BoardEAttack.setVisible(true);
                    player2BoardEAttackImg.setVisible(true);
                    player2BoardEHealth.setVisible(true);
                    player2BoardEHealthImg.setVisible(true);
                    player2BoardELvl.setVisible(true);
                    player2BoardELabel.setVisible(false);

                    player2BoardE.setImage(new Image(getClass().getResourceAsStream(currentBoard.getCard(i).getImagePath())));
                    alignImageCentre(player2BoardE);
                    player2BoardEAttack.setText(Double.toString(((Character)currentBoard.getCard(i)).getAttack()));
                    player2BoardEHealth.setText(Double.toString(((Character)currentBoard.getCard(i)).getHealth()));
                    player2BoardELvl.setText(getExpLevel((Character)currentBoard.getCard(i)));
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



    /* 
     *  Debugging
     */

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

    public void debug(){
        for(int i=0;i<pemain1.getDeck().getSize();i++){
            System.out.println(pemain1.getDeck().getAll().get(i).getName()+" = "+pemain1.getDeck().getAll().get(i));
        }
    }

    public void debugOnGoing(){
        System.out.println("Pemain 1:");
        System.out.println("Hand 1:");
        for(int i=0;i<pemain1.getHand().numberOfCards();i++){
            if(pemain1.getHand().getCard(i)==null){
                System.out.println("null card");
                continue;
            }
            System.out.println(pemain1.getHand().getCard(i).getName()+" = "+pemain1.getHand().getCard(i));
        }
        System.out.println("Board 1 :");
        for(int i=0;i<5;i++){
            if(pemain1.getBoard().getCard(i)==null){
                System.out.println("null card");
                continue;
            }
            System.out.println(pemain1.getBoard().getCard(i).getName()+" = "+pemain1.getBoard().getCard(i));
        }
        System.out.println("Pemain 2:");
        System.out.println("Hand 2:");
        for(int i=0;i<pemain2.getHand().numberOfCards();i++){
            if(pemain2.getHand().getCard(i)==null){
                System.out.println("null card");
                continue;
            }
            System.out.println(pemain2.getHand().getCard(i).getName()+" = "+pemain2.getHand().getCard(i));
        }
        System.out.println("Board 2 :");
        for(int i=0;i<5;i++){
            if(pemain2.getBoard().getCard(i)==null){
                System.out.println("null card");
                continue;
            }
            System.out.println(pemain2.getBoard().getCard(i).getName()+" = "+pemain2.getBoard().getCard(i));
        }
    }
}