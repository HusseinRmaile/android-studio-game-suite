package com.example.myapplication;

import android.graphics.Point;

import java.util.Queue;

public class GoBoard {
    private int numRows;
    private int numCols;
    private int board[][];
    //rows and cols corresponds to placeable areas
    //not grid, but rather the corners the stones can go on
    private int surroundLen;
    private int spacesLeft;

    //default 19x19 board with 5 in a row win condition
    public GoBoard() {
        this.numRows = 9;
        this.numCols = 9;
        this.spacesLeft = numRows * numCols;
        this.board = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = 0;
            }
        }
    }

    //customizable board dimensions and win condition
    public GoBoard(int height, int width) {
        this.numRows = height;
        this.numCols = width;
        this.spacesLeft = numRows * numCols;
        this.board = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int placePiece(int row, int col, int playerNumber){
        if(board[row][col] != 0){
            return -1;
            //a playerNumber is already there
        }
        if(checkCan(row, col, playerNumber, true) == 0){
            return -1;
            //illegal move
        }
        board[row][col] = playerNumber;
        spacesLeft--;
        //playerNumber successfully placed

        return 0;
    }

    public int checkCan(int row, int col, int playerNumber, boolean puttingDown) {
        int i = 0;
        if (row < 0 || row == numRows || col < 0 || col == numCols) {
            return 0;
        }
        int color = board[row][col];
        if (color != playerNumber && !puttingDown) {
            if (color == 0) {
                return 1;
            }
            return i;
        }
        board[row][col] += 3;
        i += checkCan(row - 1,col,playerNumber, false);
        i += checkCan(row + 1,col,playerNumber, false);
        i += checkCan(row,col - 1,playerNumber, false);
        i += checkCan(row,col + 1,playerNumber, false);
        board[row][col] -= 3;
        return i;
    }

    public boolean isBoardFull() {
        return (spacesLeft == 0);
    }

    public void printBoard() {

        //Loop through the board printing one character at a time
        for(int i=0; i<numRows; ++i) {
            for(int j=0; j<numCols; ++j) {
                System.out.print('[');
                System.out.print(board[i][j]);
                System.out.print("] ");
            }
            System.out.print('\n');
        }
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }


    public int getSpacesLeft() {
        return spacesLeft;
    }
}