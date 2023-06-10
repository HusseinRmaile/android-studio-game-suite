package com.example.myapplication;

public class Board {
    private int rows;
    private int cols;
    private int board[][] = new int[rows][cols];
    //rows and cols corresponds to placeable areas
    //not grid, but rather the corners the stones can go on
    private int winLength;

    //default 20x20 board with 5 in a row win condition
    public Board() {
        this.rows = 20;
        this.cols = 20;
        this.winLength = 5;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = 0;
            }
        }
    }

    //customizable board dimensions and win condition
    public Board(int height, int width, int winLength) {
        this.rows = height;
        this.cols = width;
        this.winLength = winLength;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int placePiece(int x, int y, int color){
        if(x < 0 || x >= cols){
            return -1;
            //out of bounds
        }
        if(y < 0 || y >= rows){
            return -1;
            //out of bounds
        }
        if(board[x][y] != 0){
            return -2;
            //a piece is already there
        }
        board[x][y] = color;

        return 0;
        //piece successfully placed
    }

    public int checkWin(int x, int y, int color){
        int boundCheck = winLength - 1;
        int counter = 0;
        boolean win = false;

        //horizontal check
        for(int i = x-boundCheck; i <= x+boundCheck; i++){
            if(x < 0){
                i = 0;
            }
            if(x >= cols){
                break;
            }
            if(board[i][y] == color){
                counter++;
            } else {
                counter = 0;
            }
            if (counter == winLength){
                win = true;
                break;
            }
        }

        //vertical check
        for(int i = y-boundCheck; i <= y+boundCheck; i++){
            if(win = true){
                break;
            }
            if(y < 0){
                i = 0;
            }
            if(y >= rows){
                break;
            }
            if(board[x][i] == color){
                counter++;
            } else {
                counter = 0;
            }
            if (counter == winLength){
                win = true;
                break;
            }
        }
}
