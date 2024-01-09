package com.developerblog.word.counter.services;

import java.util.concurrent.ConcurrentHashMap;

public class WordCounter {
    private ConcurrentHashMap<String, Integer> wordCountMap = new ConcurrentHashMap<>();
    private Translator translator;

    public WordCounter(Translator translator) {
        this.translator = translator;
    }

    public void addWords(String... words) {
        for (String word : words) {
            if (isValidWord(word)) {
                String englishWord = translator.translate(word);
                wordCountMap.merge(englishWord, 1, Integer::sum);
            }
        }
    }

    public int getCount(String word) {
        String englishWord = translator.translate(word);
        return wordCountMap.getOrDefault(englishWord, 0);
    }

    private boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }
}

