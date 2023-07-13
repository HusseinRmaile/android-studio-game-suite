package com.example.myapplication;

public class WordleLogic {
    private volatile static WordleLogic logic;
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
}
