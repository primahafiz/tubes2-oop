package com.gui.mainguiwindow;

import com.aetherwars.model.Card;
import com.aetherwars.model.Deck;
import com.aetherwars.model.Hand;
import com.aetherwars.model.Characters.Character;
import com.aetherwars.model.Spells.LvlSpell;
import com.aetherwars.model.Spells.MorphSpell;
import com.aetherwars.model.Spells.PtnSpell;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
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

    public DrawController(Deck deck, Hand hand) throws CloneNotSupportedException {
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
        alignImageCentre(imageDeck1);
        alignImageCentre(imageDeck2);
        alignImageCentre(imageDeck3);
        manaDeck1.setText("MANA "+Integer.toString(c.get(0).getMana()));
        manaDeck2.setText("MANA "+Integer.toString(c.get(1).getMana()));
        manaDeck3.setText("MANA "+Integer.toString(c.get(2).getMana()));
        atkHealthDeck1.setText(getAtkHealth(c.get(0)));
        atkHealthDeck2.setText(getAtkHealth(c.get(1)));
        atkHealthDeck3.setText(getAtkHealth(c.get(2)));
        initHoveredDrawCard();
        initClickedCard();
    }

    void initClickedCard(){
        containerDeck1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    try{
                        hand.addCard((Card)c.get(0).clone());
                        System.out.println(c.get(0).getName());
                        c.remove(0);
                        for(int i=0;i<c.size();i++){
                            deck.addCard((Card)c.get(i).clone());
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
                        hand.addCard((Card)c.get(1).clone());
                        System.out.println(c.get(1).getName());
                        c.remove(1);
                        for(int i=0;i<c.size();i++){
                            deck.addCard((Card)c.get(i).clone());
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
                        hand.addCard((Card)c.get(2).clone());
                        System.out.println(c.get(2).getName());
                        c.remove(2);
                        for(int i=0;i<c.size();i++){
                            deck.addCard((Card)c.get(i).clone());
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


    public void initHoveredDrawCard() {
        containerDeck1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.HAND);
            }
        });

        containerDeck1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });

        containerDeck2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.HAND);
            }
        });

        containerDeck2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });

        containerDeck3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.HAND);
            }
        });

        containerDeck3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.getScene().setCursor(Cursor.DEFAULT);
            }
        });
    }
}
