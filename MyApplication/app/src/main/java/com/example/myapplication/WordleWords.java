package com.example.myapplication;

public class WordleWords {
    private volatile static WordleWords words;
    private WordleWords(){};

    public static WordleWords getInstance(){
        if (words == null){
            synchronized (WordleWords.class) {
                if (words == null) {
                    words = new WordleWords();
                }
            }
        }
        return words;
    }
}