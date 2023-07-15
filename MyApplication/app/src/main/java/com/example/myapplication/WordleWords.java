package com.example.myapplication;
import java.util.ArrayList;
public class WordleWords {
    private volatile static WordleWords words;
    private ArrayList<String> wordList;
    private boolean defaultInitialized;
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

    public void addWords(String words){
        defaultWords();
        wordList.add(wordList.size(), words);
    }
    public void addWords(ArrayList<String> words) {
        defaultWords();
        for (int i = 0; i < words.size(); i++) {
            wordList.add(wordList.size(), words.get(i));
        }
    }

    private void defaultWords() {
        if (defaultInitialized) {
            return;
        }
        ArrayList<String> words = new ArrayList<String>();
        words.add("Phone");
        words.add("Lunch");
        words.add("Arrow");
        words.add("Whirl");

        wordList = words;
    }

    public String randomWord() {
        int idx = (int) (Math.random() * wordList.size());
        return wordList.get(idx);
    }
}