package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    //Hussein unit test 1
    public void boardInitialization() {
        //checking if default constructor sets board properly
        GomokuBoard board1 = new GomokuBoard();

        assertEquals(board1.getNumRows(),19);
        assertEquals(board1.getNumCols(),19);
        assertEquals(board1.getSpacesLeft(),19*19);
        assertEquals(board1.getWinLength(),5);

        //checking if customizable constructor sets board properly
        GomokuBoard board2 = new GomokuBoard(4, 8, 7);

        assertEquals(board2.getNumRows(),4);
        assertEquals(board2.getNumCols(),8);
        assertEquals(board2.getSpacesLeft(),4*8);
        assertEquals(board2.getWinLength(),7);

        GomokuBoard board3 = new GomokuBoard(30, 21, 2);

        assertEquals(board3.getNumRows(),30);
        assertEquals(board3.getNumCols(),21);
        assertEquals(board3.getSpacesLeft(),30*21);
        assertEquals(board3.getWinLength(),2);

        GomokuBoard board4 = new GomokuBoard(15, 15, 6);

        assertEquals(board4.getNumRows(),15);
        assertEquals(board4.getNumCols(),15);
        assertEquals(board4.getSpacesLeft(),15*15);
        assertEquals(board4.getWinLength(),6);
    }

    @Test
    //Hussein unit test 2
    public void test_checkWin() {
        GomokuBoard board1 = new GomokuBoard(2,2,3);
        //checking that out of bounds properly doesn't place pieces
        assertEquals(board1.placePiece(2,0,1),-1);
        assertEquals(board1.placePiece(1,2,1),-1);
        assertEquals(board1.getSpacesLeft(),2*2);

        //checking that pieces are not placed on occupied spaces
        assertEquals(board1.placePiece(0,0,1),0);
        assertEquals(board1.getSpacesLeft(), 3);
        assertEquals(board1.placePiece(0,0,1),-1);
        assertEquals(board1.getSpacesLeft(), 3);
        assertEquals(board1.placePiece(0,0,2),-1);
        assertEquals(board1.getSpacesLeft(), 3);

        //checking that draw works properly
        assertEquals(board1.placePiece(1,1,1),0);
        assertEquals(board1.getSpacesLeft(), 2);
        assertEquals(board1.placePiece(1,0,1),0);
        assertEquals(board1.getSpacesLeft(), 1);
        assertEquals(board1.placePiece(0,1,1),-2);
        assertEquals(board1.getSpacesLeft(), 0);

        //checking that a draw is not registered when a win is available but the board is also full
        GomokuBoard board2 = new GomokuBoard(1,1,1);
        assertEquals(board2.placePiece(0,0,2),2);

        //checking more general cases for win
        GomokuBoard board3 = new GomokuBoard();
        //vertical check
        assertEquals(board3.placePiece(0,0,2),0);
        assertEquals(board3.placePiece(1,0,2),0);
        assertEquals(board3.placePiece(2,0,2),0);
        assertEquals(board3.placePiece(3,0,2),0);
        assertEquals(board3.placePiece(4,0,2),2);
        //horizontal check
        assertEquals(board3.placePiece(18,14,1),0);
        assertEquals(board3.placePiece(18,15,1),0);
        assertEquals(board3.placePiece(18,16,1),0);
        assertEquals(board3.placePiece(18,17,2),0);
        assertEquals(board3.placePiece(18,18,1),0);
        assertEquals(board3.placePiece(18,12,1),0);
        assertEquals(board3.placePiece(18,11,2),0);
        assertEquals(board3.placePiece(18,13,1),1);
        //("/") diagonal check
        assertEquals(board3.placePiece(10,9,1),0);
        assertEquals(board3.placePiece(9,10,1),0);
        assertEquals(board3.placePiece(12,7,1),0);
        assertEquals(board3.placePiece(11,8,2),0);
        assertEquals(board3.placePiece(13,6,1),0);
        assertEquals(board3.placePiece(14,5,1),0);
        assertEquals(board3.placePiece(15,4,1),0);
        assertEquals(board3.placePiece(16,3,1),1);
        //("\") diagonal check
        assertEquals(board3.placePiece(10,10,2),0);
        assertEquals(board3.placePiece(11,11,2),0);
        assertEquals(board3.placePiece(7,7,2),0);
        assertEquals(board3.placePiece(8,8,1),0);
        assertEquals(board3.placePiece(12,12,2),0);
        assertEquals(board3.placePiece(13,13,2),0);
        assertEquals(board3.placePiece(9,9,2),2);
        assertEquals(board3.placePiece(3,3,2),0);
    }

    @Test
    //Zaid unit test 1
    //Checks player initialization
    public void playerInitialization() {
        //checking if  constructor sets player properly
        GomokuPlayer player1 = new GomokuPlayer(1);

        assertEquals(player1.getColor(),1);
        assertEquals(player1.getWinCounter(),0);
    }

    @Test
    //Zaid unit test 2
    //Checks win incrementer
    public void playerAddWin() {
        //checking if  constructor sets player properly
        GomokuPlayer player1 = new GomokuPlayer(1);
        assertEquals(player1.getWinCounter(),0);
        player1.addWin();
        assertEquals(player1.getWinCounter(),1);
        player1.addWin();
        assertEquals(player1.getWinCounter(),2);
    }

    @Test
    //Taiki unit test 1
    public void test_placePiece() {
        GomokuBoard board = new GomokuBoard(2,2,3);
        assertEquals(board.placePiece(0,2,1), -1);
        assertEquals(board.placePiece(0,-1,1), -1);
        assertEquals(board.placePiece(0,0,1), 0);
        assertEquals(board.placePiece(0,0,1), -1);
        assertEquals(board.getSpacesLeft(), 3);
    }

    @Test
    //Taiki unit test 2
    public void test_isBoardFull() {
        GomokuBoard board1 = new GomokuBoard(2, 2, 10);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals(board1.isBoardFull(), false);
                board1.placePiece(i,j,1);
                assertEquals(board1.placePiece(i, j, 1), -1);
            }
        }
        assertEquals(board1.getSpacesLeft(), 0);
        assertEquals(board1.isBoardFull(), true);

        GomokuBoard board2 = new GomokuBoard(8, 8, 10);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                assertEquals(board2.isBoardFull(), false);
                board2.placePiece(i,j,1);
                assertEquals(board2.placePiece(i, j, 1), -1);
            }
        }
        assertEquals(board2.getSpacesLeft(), 0);
        assertEquals(board2.isBoardFull(), true);
    }
}