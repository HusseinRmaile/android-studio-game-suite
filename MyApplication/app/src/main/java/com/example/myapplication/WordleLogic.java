package com.example.myapplication;

import android.util.Log;

public class WordleLogic {
    private volatile static WordleLogic logic;
    private String word = WordleWords.getInstance().randomWord();
    private WordleLogic(){};

    public static WordleLogic getInstance(){
        if (logic == null){
            synchronized (WordleLogic.class) {
                if (logic == null) {
                    logic = new WordleLogic();
                }
            }
        }
        return logic;
    }

    //enter/submit button should call this method, it returns the color for each letter
    public int[] checkWord(String guess) {
        int[] color = {0,0,0,0,0,0};
        boolean[] linked = {false,false,false,false,false,false};
        //i is the guess' index
        for (int i = 0; i < guess.length(); i++) {
            //j is the actual word's index
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == guess.charAt(j)) {
                    color[i] = 1;
                    linked[j] = true;
                } else if (!linked[j] && word.charAt(j) == guess.charAt(i)) {
                    color[i] = 2;
                    linked[j] = true;
                }
            }
        }
        return color;
    }
}
