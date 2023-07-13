package com.example.myapplication;

public class WordleWords {
    private static WordleWords player;
    private WordleWords(){};

    public static WordleWords getInstance(){
        if (player == null){
            player = new WordleWords();
        }
        return player;
    }
}