package com.example.myapplication;

public class WordlePlayer {
    private volatile static WordlePlayer player;
<<<<<<< HEAD
    private int lives = 6;
=======
    private int lives;

    private int wins;

    private int loss;

>>>>>>> 58747b151df77c395f1ab9a4a46caf9ca1b0b65b
    private WordlePlayer(){};

    public static WordlePlayer getInstance() {
        if (player == null) {
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

    public void setWinLoss(int wins, int loss) {
        this.wins = wins;
        this.loss = loss;
    }

    public void addWin() {
        wins++;
    }

    public void addLoss() {
        loss++;
    }
    public int getWins() {
        return wins;
    }
    public int getLoss() {
        return loss;
    }
}
