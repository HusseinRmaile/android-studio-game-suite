package com.example.myapplication;

import android.widget.ImageView;

public class GomokuPlayer {
    private int color;
    private String name;
    private ImageView sprite;
    private int winCounter;

    public GomokuPlayer(int color, String name, ImageView sprite) {
        this.color = color;
        this.name = name;
        this.sprite = sprite;
        this.winCounter = 0;
    }

    public int getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public ImageView getSprite() {
        return this.sprite;
    }

    public int getWinCounter() {
        return this.winCounter;
    }

    public void setColor(int c) {
        this.color = c;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setSprite(ImageView s) {
        this.sprite = s;
    }

    public void setWinCounter(int n) {
        this.winCounter = n;
    }

    public void addWin() {
        this.winCounter += 1;
    }
}
