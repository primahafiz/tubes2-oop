package com.gui.mainguiwindow;

import com.aetherwars.model.*;
import com.aetherwars.model.Characters.Character;
import com.aetherwars.model.Spells.LvlSpell;
import com.aetherwars.model.Spells.MorphSpell;
import com.aetherwars.model.Spells.PtnSpell;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FullHandController implements Initializable {
    @FXML
    BorderPane containerFullHand1;
    @FXML
    BorderPane containerFullHand2;
    @FXML
    BorderPane containerFullHand3;
    @FXML
    BorderPane containerFullHand4;
    @FXML
    BorderPane containerFullHand5;

    @FXML
    ImageView fullHand1;
    @FXML
    ImageView fullHand2;
    @FXML
    ImageView fullHand3;
    @FXML
    ImageView fullHand4;
    @FXML
    ImageView fullHand5;

    @FXML
    Label fullHand1Mana;
    @FXML
    Label fullHand2Mana;
    @FXML
    Label fullHand3Mana;
    @FXML
    Label fullHand4Mana;
    @FXML
    Label fullHand5Mana;

    @FXML
    Label fullHand1AtkHealth;
    @FXML
    Label fullHand2AtkHealth;
    @FXML
    Label fullHand3AtkHealth;
    @FXML
    Label fullHand4AtkHealth;
    @FXML
    Label fullHand5AtkHealth;

    Hand hand;

    public FullHandController(Hand hand){
        this.hand=hand;
    }

    public void initialize(URL location, ResourceBundle resources){
        fullHand1.setImage(new Image(getClass().getResourceAsStream(hand.getCard(0).getImagePath())));
        fullHand2.setImage(new Image(getClass().getResourceAsStream(hand.getCard(1).getImagePath())));
        fullHand3.setImage(new Image(getClass().getResourceAsStream(hand.getCard(2).getImagePath())));
        fullHand4.setImage(new Image(getClass().getResourceAsStream(hand.getCard(3).getImagePath())));
        fullHand5.setImage(new Image(getClass().getResourceAsStream(hand.getCard(4).getImagePath())));

        fullHand1.setOpacity(1);
        fullHand2.setOpacity(1);
        fullHand3.setOpacity(1);
        fullHand4.setOpacity(1);
        fullHand5.setOpacity(1);
        
        alignImageCentre(fullHand1);
        alignImageCentre(fullHand2);
        alignImageCentre(fullHand3);
        alignImageCentre(fullHand4);
        alignImageCentre(fullHand5);
        
        fullHand1Mana.setText("MANA "+hand.getCard(0).getMana());
        fullHand2Mana.setText("MANA "+hand.getCard(1).getMana());
        fullHand3Mana.setText("MANA "+hand.getCard(2).getMana());
        fullHand4Mana.setText("MANA "+hand.getCard(3).getMana());
        fullHand5Mana.setText("MANA "+hand.getCard(4).getMana());

        fullHand1AtkHealth.setText(getAtkHealth(hand.getCard(0)));
        fullHand2AtkHealth.setText(getAtkHealth(hand.getCard(1)));
        fullHand3AtkHealth.setText(getAtkHealth(hand.getCard(2)));
        fullHand4AtkHealth.setText(getAtkHealth(hand.getCard(3)));
        fullHand5AtkHealth.setText(getAtkHealth(hand.getCard(4)));

        initHoveredFullHand();
        initClickedCard();

    }

    public String getAtkHealth(Card c) {
        if (c instanceof Character) {
            return "ATK " + ((Character) c).getAttack() + "/HP " + ((Character) c).getHealth();
        } else if (c instanceof MorphSpell) {
            return "MORPH";
        } else if (c instanceof PtnSpell) {
            return "ATK+" + ((PtnSpell) c).getPtnAttack() + "/HP+" + ((PtnSpell) c).getPtnHp();
        } else if (c instanceof LvlSpell) {
            return "LEVEL";
        } else { // swap
            return "ATK <--> HP";
        }
    }

    void initClickedCard() {
        containerFullHand1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    hand.removeCardfromHand(0);
                }
                Stage stage = (Stage) containerFullHand1.getScene().getWindow();
                stage.close();
            }
        });

        containerFullHand2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    hand.removeCardfromHand(1);
                }
                Stage stage = (Stage) containerFullHand1.getScene().getWindow();
                stage.close();
            }
        });

        containerFullHand3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    hand.removeCardfromHand(2);
                }
                Stage stage = (Stage) containerFullHand1.getScene().getWindow();
                stage.close();
            }
        });

        containerFullHand4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    hand.removeCardfromHand(3);
                }
                Stage stage = (Stage) containerFullHand1.getScene().getWindow();
                stage.close();
            }
        });

        containerFullHand5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    hand.removeCardfromHand(4);
                }
                Stage stage = (Stage) containerFullHand1.getScene().getWindow();
                stage.close();
            }
        });
    }

    public void alignImageCentre(ImageView imageView) {
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

    public void initHoveredFullHand() {
        containerFullHand1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.HAND);
            }
        });

        containerFullHand1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });

        containerFullHand2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.HAND);
            }
        });

        containerFullHand2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });

        containerFullHand3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.HAND);
            }
        });

        containerFullHand3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });

        containerFullHand4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.HAND);
            }
        });

        containerFullHand4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });

        containerFullHand5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.HAND);
            }
        });

        containerFullHand5.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });
    }
}
