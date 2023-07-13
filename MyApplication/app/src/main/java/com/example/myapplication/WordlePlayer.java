package com.example.myapplication;

public class WordlePlayer {
    private volatile static WordlePlayer player;
    private WordlePlayer(){};

    public static WordlePlayer getInstance(){
        if (player == null){
            synchronized (WordlePlayer.class) {
                if (player == null) {
                    player = new WordlePlayer();
                }
            }
        }
        return player;
    }
}
