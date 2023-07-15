package com.example.myapplication;

public class WordlePlayer {
    private volatile static WordlePlayer player;
    private int lives;
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

    // checkWord()'s array gets passed in here
    private void checkLives(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // if any tile is not green, subtract 1 from lives and leave the method
            if (arr[i] != 1) {
                lives -= 1;
                return;
            }
        }
    }
    public int getLives() {
        return lives;
    }
    public void decrementLives() {
        lives -= 1;
    }

    public void resetLives() {
        lives = 6;
    }
}
