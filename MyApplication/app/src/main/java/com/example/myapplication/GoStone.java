package com.example.myapplication;

public class GoStone {
    private boolean chain;
    private boolean surrounded;
    private int color;
    private int row;
    private int col;

    public GoStone(int color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public int getColor() {
        return this.color;
    }

    public boolean getSurrounded() {
        return this.surrounded;
    }

    public void setSurrounded(boolean surrounded) {
        this.surrounded = surrounded;
    }
}
