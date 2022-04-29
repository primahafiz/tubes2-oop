package com.aetherwars.model;

abstract public class Card implements Cloneable{
    protected int id;
    protected String name;
    protected String desc;
    protected String imagePath;
    protected int mana;

    // user-defined constructor
    public Card (int id, String name, String desc, String path, int mana){
        this.id = id;
        this.name =name;
        this.desc = desc;
        this.imagePath = path;
        this.mana = mana;
    }

    // getter
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDesc(){
        return this.desc;
    }

    public String getImagePath(){
        return this.imagePath;
    }

    public int getMana(){
        return this.mana;
    }

    public void printCardInfo(){
        System.out.println(this.toString());
    }

    public Object clone() throws CloneNotSupportedException {
        return (Card) super.clone();
    }

    public abstract Type getCardType();

    @Override

    public String toString(){
       return "Id: " + getId()+ "\n" + "Name: " + getName() + "\n" + "Desc: " + getDesc() + "\n" + "Image Path: " + getImagePath() + "\n" + "Mana: " + getMana();
    }
}
