package com.example.myapplication;

public class WordleLogic {
    private static WordleLogic player;
    private WordleLogic(){};

    public static WordleLogic getInstance(){
        if (player == null){
            player = new WordleLogic();
        }
        return player;
    }
}
