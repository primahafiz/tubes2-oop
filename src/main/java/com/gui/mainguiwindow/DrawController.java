package com.gui.mainguiwindow;

import com.aetherwars.model.Card;
import com.aetherwars.model.Deck;
import com.aetherwars.model.Hand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class DrawController implements Initializable {
    @FXML
    BorderPane containerDeck1;
    @FXML
    BorderPane containerDeck2;
    @FXML
    BorderPane containerDeck3;

    @FXML
    ImageView imageDeck1;
    @FXML
    ImageView imageDeck2;
    @FXML
    ImageView imageDeck3;

    @FXML
    Text manaDeck1;
    @FXML
    Text manaDeck2;
    @FXML
    Text manaDeck3;

    @FXML
    Text atkHealthDeck1;
    @FXML
    Text atkHealthDeck2;
    @FXML
    Text atkHealthDeck3;

    Deck deck;
    List<Card> c;
    Hand hand;

    public DrawController(Deck deck, Hand hand){
        c = deck.getCard();
        this.hand=hand;
        this.deck=deck;
    }

    public void initialize(URL location, ResourceBundle resources){
        imageDeck1.setImage(new Image(getClass().getResourceAsStream(c.get(0).getImagePath())));
        imageDeck2.setImage(new Image(getClass().getResourceAsStream(c.get(1).getImagePath())));
        imageDeck3.setImage(new Image(getClass().getResourceAsStream(c.get(2).getImagePath())));
        imageDeck1.setOpacity(1);
        imageDeck2.setOpacity(1);
        imageDeck3.setOpacity(1);
        manaDeck1.setText("MANA "+Integer.toString(c.get(0).getMana()));
        manaDeck2.setText("MANA "+Integer.toString(c.get(1).getMana()));
        manaDeck3.setText("MANA "+Integer.toString(c.get(2).getMana()));
        initClickedCard();
    }

    void initClickedCard(){
        containerDeck1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    try{
                        hand.addCard(c.get(0));
                        System.out.println(c.get(0).getName());
                        c.remove(0);
                        for(int i=0;i<c.size();i++){
                            deck.addCard(c.get(i));
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                Stage stage = (Stage) containerDeck1.getScene().getWindow();
                stage.close();
            }
        });
        containerDeck2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    try{
                        hand.addCard(c.get(1));
                        System.out.println(c.get(1).getName());
                        c.remove(1);
                        for(int i=0;i<c.size();i++){
                            deck.addCard(c.get(i));
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                Stage stage = (Stage) containerDeck2.getScene().getWindow();
                stage.close();
            }
        });
        containerDeck3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    try{
                        hand.addCard(c.get(2));
                        System.out.println(c.get(2).getName());
                        c.remove(2);
                        for(int i=0;i<c.size();i++){
                            deck.addCard(c.get(i));
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(hand);
                Stage stage = (Stage) containerDeck3.getScene().getWindow();
                stage.close();
            }
        });
    }
}
