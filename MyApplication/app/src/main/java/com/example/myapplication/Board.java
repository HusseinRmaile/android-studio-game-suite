package com.example.myapplication;

public class Board {
    private int numRows;
    private int numCols;
    private int board[][] = new int[numRows][numCols];
    //rows and cols corresponds to placeable areas
    //not grid, but rather the corners the stones can go on
    private int winLength;

    //default 20x20 board with 5 in a row win condition
    public Board() {
        this.numRows = 20;
        this.numCols = 20;
        this.winLength = 5;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = 0;
            }
        }
    }

    //customizable board dimensions and win condition
    public Board(int height, int width, int winLength) {
        this.numRows = height;
        this.numCols = width;
        this.winLength = winLength;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int placePiece(int row, int col, int color){
        if(col < 0 || col >= numCols){
            return -1;
            //out of bounds
        }
        if(row < 0 || row >= numRows){
            return -1;
            //out of bounds
        }
        if(board[row][col] != 0){
            return -2;
            //a piece is already there
        }
        board[row][col] = color;

        return 0;
        //piece successfully placed
    }

    public int checkWin(int row, int col, int color){
        int boundCheck = winLength - 1;
        int colMax = col + boundCheck;
        int colMin = col - boundCheck;
        int rowMax = row + boundCheck;
        int rowMin = row - boundCheck;
        int counter = 0;
        boolean win = false;
        int diff = 0;

        if(colMin < 0){
            diff = -colMin;
            colMin += diff;
            rowMin += diff;
        }
        if(colMax >= numCols){
            diff = colMax - numCols + 1;
            colMax -= diff;
            rowMax -= diff;
        }

        if(rowMin < 0){
            diff = -rowMin;
            colMin += diff;
            rowMin += diff;
        }
        if(rowMax >= numRows){
            diff = rowMax - numRows + 1;
            colMax -= diff;
            rowMax -= diff;
        }

        //vertical check
        for(int i = rowMin; i <= rowMax; i++){
            if(board[i][col] == color){
                counter++;
            } else {
                counter = 0;
            }
            if (counter == winLength){
                win = true;
                break;
            }
        }

        //horizontal check
        for(int i = colMin; i <= colMax; i++){
            if(win = true){
                break;
            }
            if(board[row][i] == color){
                counter++;
            } else {
                counter = 0;
            }
            if (counter == winLength){
                win = true;
            }
        }

        //("\") diagonal check
        for(int i = rowMin; i <= rowMax; i++){
            if(win == true) {
                break;
            }
            for(int j = colMin; j <= colMax; j++){
                if(board[i][j] == color){
                    counter++;
                } else {
                    counter = 0;
                }
                if(counter == winLength){
                    win = true;
                    break;
                }
            }
        }

        //("/") diagonal check
        for(int i = rowMax; i >= rowMin; i--){
            if(win == true) {
                break;
            }
            for(int j = colMin; j <= colMax; j++){
                if(board[i][j] == color){
                    counter++;
                } else {
                    counter = 0;
                }
                if(counter == winLength){
                    win = true;
                    break;
                }
            }
        }
}
