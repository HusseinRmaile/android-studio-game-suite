package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class WordleUnitTest {
    @Test
    public void correctWordComparison() {
        WordleLogic logic = WordleLogic.getInstance();
        logic.setWord("Arrow");
        int[] colors = logic.checkWord("rarer");
        assert (colors[0] == 2);
        assert (colors[1] == 2);
        assert (colors[2] == 1);
        assert (colors[3] == 0);
        assert (colors[4] == 0);
    }

    // test the singleton method, making sure that they are actually creating only 1 instance
    @Test
    public void testPlayerSingletonInstance() {
        WordlePlayer player1 = WordlePlayer.getInstance();
        WordlePlayer player2 = WordlePlayer.getInstance();

        // Assert that both player1 and player2 refer to the same instance
        assertSame(player1, player2);
    }

    @Test
    public void testLogicSingletonInstance() {
        WordleLogic logic1 = WordleLogic.getInstance();
        WordleLogic logic2 = WordleLogic.getInstance();

        // Assert that both player1 and player2 refer to the same instance
        assertSame(logic1, logic2);
    }
}
