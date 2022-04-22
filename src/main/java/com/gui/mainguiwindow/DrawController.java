package com.gui.mainguiwindow;

import com.aetherwars.model.Card;
import com.aetherwars.model.Deck;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

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

    List<Card> c;

    public DrawController(Deck deck){
        c = deck.getCard();
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
    }
}
