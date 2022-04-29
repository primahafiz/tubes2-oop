package com.aetherwars.model;

import com.aetherwars.model.Characters.Character;
import com.aetherwars.model.Spells.LvlSpell;
import com.aetherwars.model.Spells.MorphSpell;
import com.aetherwars.model.Spells.PtnSpell;
import com.aetherwars.model.Spells.SwapSpell;
import com.aetherwars.util.CSVReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardReader {
    private ArrayList<Card> cards;
    private static final int PERM = 0;

    // constructor
    public CardReader(){
        this.cards = new ArrayList<>();
    }

    // read and add all cards from csv
    public void addAllCards() throws IOException{
        addCharacterCards();
        addPotionSpellCards();
        addSwapSpellCards();
        addMorphSpellCards();
        addLevelSpellCards();
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public void addCharacterCards() throws IOException {
        String CHAR_FILE_PATH = "src/main/resources/com/aetherwars/card/data/character.csv";
        File charFile = new File(CHAR_FILE_PATH);
        CSVReader charReader = new CSVReader(charFile, "\t");
        charReader.setSkipHeader(true);
        List<String[]> charLines = charReader.read();
        for (String[] line: charLines){
            // Character(int id, String name, String desc, String path,
            // int mana, Type type,
            // double attack, double health,
            // double attackUp, double healthUp)
            Character character = new Character(Integer.parseInt(line[0]), line[1], line[3], line[4],
                                                Integer.parseInt(line[7]), Type.valueOf(line[2]),
                                                Double.parseDouble(line[5]), Double.parseDouble(line[6]),
                                                Double.parseDouble(line[8]), Double.parseDouble(line[9]));
            cards.add(character);
        }
    }

    public void addMorphSpellCards() throws IOException {
        String MORPH_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_morph.csv";
        File morphFile = new File(MORPH_FILE_PATH);
        CSVReader morphReader = new CSVReader(morphFile, "\t");
        morphReader.setSkipHeader(true);
        List<String[]> morphLines = morphReader.read();
        for (String[] line: morphLines){
            // MorphSpell(int id, String name, String desc, String path, int mana, int duration, int targetId)
            MorphSpell morph = new MorphSpell(Integer.parseInt(line[0]), line[1], line[2], line[3],
                                              Integer.parseInt(line[5]), PERM, Integer.parseInt(line[4]));
            this.cards.add(morph);
        }
    }

    public void addSwapSpellCards() throws IOException {
        String SWAP_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_swap.csv";
        File swapFile = new File(SWAP_FILE_PATH);
        CSVReader swapReader = new CSVReader(swapFile, "\t");
        swapReader.setSkipHeader(true);
        List<String[]> swapLines = swapReader.read();
        for (String[] line: swapLines){
            // SwapSpell(int id, String name, String desc, String path, int mana, int duration)
            SwapSpell swap = new SwapSpell(Integer.parseInt(line[0]), line[1], line[2], line[3], Integer.parseInt(line[5]), Integer.parseInt(line[4]));
            this.cards.add(swap);
        }
    }

    public void addPotionSpellCards() throws IOException{
        String PTN_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_ptn.csv";
        File ptnFile = new File(PTN_FILE_PATH);
        CSVReader ptnReader = new CSVReader(ptnFile, "\t");
        ptnReader.setSkipHeader(true);
        List<String[]> ptnLines = ptnReader.read();
        for (String[] line: ptnLines){
            // PtnSpell(int id, String name, String desc, String path, int mana, int duration, double attack, double hp)
            PtnSpell ptn = new PtnSpell(Integer.parseInt(line[0]), line[1], line[2], line[3], Integer.parseInt(line[6]),
                    Integer.parseInt(line[7]), Double.parseDouble(line[4]), Double.parseDouble(line[5]));
            this.cards.add(ptn);
        }
    }

    public void addLevelSpellCards(){
        LvlSpell lvlUp = new LvlSpell(401, "LvlUp", "Level up by 1","card/image/spell/level/LevelUp.png", 0, PERM, 1);
        LvlSpell lvlDown = new LvlSpell(402, "LvlDown", "Level down by 1","card/image/spell/level/LevelDown.png", 0, PERM, -1);
        this.cards.add(lvlUp);
        this.cards.add(lvlDown);

    }

    // fungsi return card dengan id tertentu
}
