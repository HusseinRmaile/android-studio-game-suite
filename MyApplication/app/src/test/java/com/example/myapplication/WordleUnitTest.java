package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;


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

    // test the addWords method with String parameter
    // Taiki test 1
    @Test
    public void testAddWordsString() {
        WordleWords words1 = WordleWords.getInstance();
        words1.addWords("three");
        assertSame(words1.getWordList().size(), 1);
        words1.addWords("throw");
        assertSame(words1.getWordList().size(), 2);
        words1.addWords("twirl");
        assertSame(words1.getWordList().size(), 3);
        words1.addWords("trips");
        assertSame(words1.getWordList().size(), 4);
        words1.addWords("tulip");
        assertSame(words1.getWordList().size(), 5);
    }

    // test the addWords method with ArrayList parameter
    // Taiki test 2
    @Test
    public void testAddWordsArrayList() {
        WordleWords words1 = WordleWords.getInstance();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("three");
        list1.add("throw");
        list1.add("twirl");
        words1.addWords(list1);
        assertSame(words1.getWordList().size(), 3);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("trips");
        list2.add("tulip");
        words1.addWords(list2);
        assertSame(words1.getWordList().size(), 5);
    }
}
