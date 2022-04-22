package com.aetherwars.model;

public class HandFullExp extends Exception{
    @Override
    public String getMessage(){
        return "Hand telah full";
    }
}
