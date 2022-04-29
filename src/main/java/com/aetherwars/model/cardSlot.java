package com.aetherwars.model;

public interface cardSlot {
    public boolean isFull();
    public boolean isEmpty();
    public Card getCard(int id);
}
