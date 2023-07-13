package com.example.myapplication;

public class WordlePlayer {
    private static WordlePlayer player;
    private WordlePlayer(){};

    public static WordlePlayer getInstance(){
        if (player == null){
            player = new WordlePlayer();
        }
        return player;
    }
}
