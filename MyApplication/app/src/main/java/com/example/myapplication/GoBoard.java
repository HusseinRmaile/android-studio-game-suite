package com.example.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class GoBoard {
    private int numRows;
    private int numCols;
    private GoStone board[][];
    //rows and cols corresponds to placeable areas
    //not grid, but rather the corners the stones can go on
    private int surroundLen;
    private int spacesLeft;

    private Stack<GoStone> delList = new Stack<>();

    //default 19x19 board with 5 in a row win condition
    public GoBoard() {
        this.numRows = 9;
        this.numCols = 9;
        this.spacesLeft = numRows * numCols;
        this.board = new GoStone[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = null;
            }
        }
    }

    //customizable board dimensions and win condition
    public GoBoard(int height, int width) {
        this.numRows = height;
        this.numCols = width;
        this.spacesLeft = numRows * numCols;
        this.board = new GoStone[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                board[i][j] = null;
            }
        }
    }

    public ArrayList<Integer> placePiece(int row, int col, int playerNumber){
        if(board[row][col] != null){
            return null;
            //a playerNumber is already there
        }
        GoStone Cur;
        if (playerNumber == 1) {
            Cur = new GoBlackStone(row,col);
        } else {
            Cur = new GoWhiteStone(row,col);
        }
        board[row][col] = Cur;
        ArrayList<Integer> ret = capture(row, col, playerNumber % 2 + 1);
        if(libertyCount(row, col, playerNumber, true) == 0){
            board[row][col] = null;
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
        if (board[row][col] == null && !puttingDown) {
            return 1;
        }
        GoStone marked = board[row][col];
        int color = marked.getColor();
        if (color != playerNumber || marked.isChain()) {
            return 0;
        }
        marked.setChain(true);
        delList.push(marked);
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
                GoStone Cur = delList.pop();
                Cur.setChain(false);
                trueDel.add(Cur.getIndex());
            }
        } else {
            unCheck();
        }
        delList.clear();
        if (libertyCount(row + 1,col,playerNumber, false) == 0) {
            int size = delList.size();
            for (int i = 0; i < size; i++) {
                GoStone Cur = delList.pop();
                Cur.setChain(false);
                trueDel.add(Cur.getIndex());
            }
        } else {
            unCheck();
        }
        delList.clear();
        if (libertyCount(row,col - 1,playerNumber, false) == 0) {
            int size = delList.size();
            for (int i = 0; i < size; i++) {
                GoStone Cur = delList.pop();
                Cur.setChain(false);
                trueDel.add(Cur.getIndex());
            }
        } else {
            unCheck();
        }
        delList.clear();
        if (libertyCount(row,col + 1,playerNumber, false) == 0) {
            int size = delList.size();
            for (int i = 0; i < size; i++) {
                GoStone Cur = delList.pop();
                Cur.setChain(false);
                trueDel.add(Cur.getIndex());
            }
        } else {
            unCheck();
        }
        delList.clear();
        for (int i = 0; i < trueDel.size(); i++) {
            int index = trueDel.get(i);
            board[index / 9][index % 9] = null;
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
                GoStone a = board[i][j];
                System.out.print('[');
                if (a == null) {
                    System.out.print(0);
                } else {
                    System.out.print(board[i][j].getColor());
                }
                System.out.print("] ");
            }
            System.out.print('\n');
        }
    }

    private void unCheck() {
        for (GoStone i:
             delList) {
            i.setChain(false);
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