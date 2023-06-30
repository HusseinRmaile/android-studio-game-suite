package com.example.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class GoBoard {
    private int numRows;
    private int numCols;
    private int board[][];
    //rows and cols corresponds to placeable areas
    //not grid, but rather the corners the stones can go on
    private int surroundLen;
    private int spacesLeft;

    private Stack<Integer> delList = new Stack<>();

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

    public ArrayList<Integer> placePiece(int row, int col, int playerNumber){
        if(board[row][col] != 0){
            return null;
            //a playerNumber is already there
        }
        board[row][col] = playerNumber;
        ArrayList<Integer> ret = capture(row, col, playerNumber % 2 + 1);
        if(libertyCount(row, col, playerNumber, true) == 0){
            board[row][col] = 0;
            unCheck();
            delList.clear();
            return null;
            //illegal move
        }
        unCheck();
        delList.clear();
        spacesLeft--;
        //playerNumber successfully placed

        return ret;
    }

    public int libertyCount(int row, int col, int playerNumber, boolean puttingDown) {
        int liberty = 0;
        if (row < 0 || row == numRows || col < 0 || col == numCols) {
            return 0;
        }
        int color = board[row][col];
        if (color != playerNumber && !puttingDown) {
            if (color == 0) {
                return 1;
            }
            return 0;
        }
        board[row][col] += 3;
        delList.push(row * 9 + col);
        liberty += libertyCount(row - 1,col,playerNumber, false);
        liberty += libertyCount(row + 1,col,playerNumber, false);
        liberty += libertyCount(row,col - 1,playerNumber, false);
        liberty += libertyCount(row,col + 1,playerNumber, false);
        return liberty;
    }

    public ArrayList<Integer> capture(int row, int col, int playerNumber) {
        ArrayList<Integer> trueDel = new ArrayList<>();
        if (libertyCount(row - 1,col,playerNumber, false) == 0) {
            int size = delList.size();
            for (int i = 0; i < size; i++) {
                int index = delList.pop();
                board[index / 9][index % 9] -= 3;
                trueDel.add(index);
            }
        } else {
            unCheck();
        }
        delList.clear();
        if (libertyCount(row + 1,col,playerNumber, false) == 0) {
            int size = delList.size();
            for (int i = 0; i < size; i++) {
                int index = delList.pop();
                board[index / 9][index % 9] -= 3;
                trueDel.add(index);
            }
        } else {
            unCheck();
        }
        delList.clear();
        if (libertyCount(row,col - 1,playerNumber, false) == 0) {
            int size = delList.size();
            for (int i = 0; i < size; i++) {
                int index = delList.pop();
                board[index / 9][index % 9] -= 3;
                trueDel.add(index);
            }
        } else {
            unCheck();
        }
        delList.clear();
        if (libertyCount(row,col + 1,playerNumber, false) == 0) {
            int size = delList.size();
            for (int i = 0; i < size; i++) {
                int index = delList.pop();
                board[index / 9][index % 9] -= 3;
                trueDel.add(index);
            }
        } else {
            unCheck();
        }
        delList.clear();
        for (int i = 0; i < trueDel.size(); i++) {
            int index = trueDel.get(i);
            board[index / 9][index % 9] = 0;
        }
        printBoard();
        return trueDel;
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

    private void unCheck() {
        for (int i:
             delList) {
            board[i / 9][i % 9] -= 3;
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