package com.example.myapplication;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GoUnitTest {
    //Jeongyeop Han Test1
    //Test goStone Initialization
    @Test
    public void goStoneInitialization() {
        GoStone stone = new GoStone(1, 2, 3);

        assertEquals(stone.getColor(), 1);
        assertEquals(stone.getRow(), 2);
        assertEquals(stone.getCol(), 3);
    }
    //Jeongyeop Han Test2
    //Test libertyCount method in GoBoard class
    public void Test_libertyCount() {
        GoBoard board = new GoBoard();
        //Test libertyCount method without placing pieces.
        assertEquals(board.libertyCount(3, 4 , 2, false), 4);
        //Test libertyCount method after placing pieces
        board.placePiece(3, 3, 1);
        assertEquals(board.libertyCount(3, 4 , 2, false), 3);

        board.placePiece(3, 5, 1);
        assertEquals(board.libertyCount(3, 4 , 2, false), 2);

        board.placePiece(2, 4, 1);
        assertEquals(board.libertyCount(3, 4 , 2, false), 1);

    }
}