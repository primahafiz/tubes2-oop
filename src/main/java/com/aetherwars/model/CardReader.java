package com.aetherwars.model;

import com.aetherwars.util.CSVReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardReader {
    private ArrayList<Card> cards;
    private static final int PERM = 0;

    public CardReader(){
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> addAllCards() throws IOException{
        cards = new ArrayList<>();
        addCharacterCards();
        addMorphSpellCards();
        addSwapSpellCards();
        addPotionSpellCards();
        addLevelSpellCards();
        return cards;
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
            // int attack, int health,
            // int attackUp, int healthUp)
            Character character = new Character(Integer.parseInt(line[0]), line[1], line[3], line[4],
                                                Integer.parseInt(line[7]), Type.valueOf(line[2]),
                                                Integer.parseInt(line[5]), Integer.parseInt(line[6]),
                                                Integer.parseInt(line[8]), Integer.parseInt(line[9]));
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
            cards.add(morph);
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
            cards.add(swap);
        }
    }

    public void addPotionSpellCards() throws IOException{
        String PTN_FILE_PATH = "src/main/resources/com/aetherwars/card/data/spell_ptn.csv";
        File ptnFile = new File(PTN_FILE_PATH);
        CSVReader ptnReader = new CSVReader(ptnFile, "\t");
        ptnReader.setSkipHeader(true);
        List<String[]> ptnLines = ptnReader.read();
        for (String[] line: ptnLines){
            // PtnSpell(int id, String name, String desc, String path, int mana, int duration, int attack, int hp)
            PtnSpell ptn = new PtnSpell(Integer.parseInt(line[0]), line[1], line[2], line[3], Integer.parseInt(line[6]),
                    Integer.parseInt(line[7]), Integer.parseInt(line[4]), Integer.parseInt(line[5]));
            cards.add(ptn);
        }
    }

    public void addLevelSpellCards(){

    }

}
