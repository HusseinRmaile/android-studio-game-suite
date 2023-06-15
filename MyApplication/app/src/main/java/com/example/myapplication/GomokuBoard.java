package com.example.myapplication;

public class GomokuBoard {
    private int numRows;
    private int numCols;
    private int board[][];
    //rows and cols corresponds to placeable areas
    //not grid, but rather the corners the stones can go on
    private int winLength;
    private int spacesLeft;

    //default 20x20 board with 5 in a row win condition
    public GomokuBoard() {
        this.numRows = 19;
        this.numCols = 19;
        this.winLength = 5;
        this.spacesLeft = numRows * numCols;
        this.board = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = 0;
            }
        }
    }

    //customizable board dimensions and win condition
    public GomokuBoard(int height, int width, int winLength) {
        this.numRows = height;
        this.numCols = width;
        this.winLength = winLength;
        this.spacesLeft = numRows * numCols;
        this.board = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int placePiece(int row, int col, int piece){
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
        board[row][col] = piece;
        spacesLeft--;
        //piece successfully placed

        return checkWin(row, col, piece);
        //0 = draw, -1 = game continues, any other number means that player won
    }

    public int checkWin(int row, int col, int piece) {
        int boundCheck = winLength - 1;
        int colMax = col + boundCheck;
        int colMin = col - boundCheck;
        int rowMax = row + boundCheck;
        int rowMin = row - boundCheck;
        int counter = 0;
        boolean win = false;
        int diff = 0;

        if (colMin < 0) {
            diff = -colMin;
            colMin += diff;
            rowMin += diff;
        }
        if (colMax >= numCols) {
            diff = colMax - numCols + 1;
            colMax -= diff;
            rowMax -= diff;
        }

        if (rowMin < 0) {
            diff = -rowMin;
            colMin += diff;
            rowMin += diff;
        }
        if (rowMax >= numRows) {
            diff = rowMax - numRows + 1;
            colMax -= diff;
            rowMax -= diff;
        }

        //vertical check
        for (int i = rowMin; i <= rowMax; i++) {
            if (board[i][col] == piece) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == winLength) {
                return piece;
            }
        }

        //horizontal check
        for (int i = colMin; i <= colMax; i++) {
            if (board[row][i] == piece) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == winLength) {
                return piece;
            }
        }

        //("\") diagonal check
        for (int i = rowMin; i <= rowMax; i++) {
            for (int j = colMin; j <= colMax; j++) {
                if (board[i][j] == piece) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == winLength) {
                    return piece;
                }
            }
        }

        //("/") diagonal check
        for (int i = rowMax; i >= rowMin; i--) {
            for (int j = colMin; j <= colMax; j++) {
                if (board[i][j] == piece) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == winLength) {
                    return piece;
                }
            }
        }

        //if code has made it this far, no win was found
        if(spacesLeft == 0){
            //return draw (board is full)
            return 0;
        } else {
            //no win or draw, game continues
            return -1;
        }
    }
}
