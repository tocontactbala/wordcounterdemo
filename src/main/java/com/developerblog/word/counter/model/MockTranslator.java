package com.developerblog.word.counter.model;

import com.developerblog.word.counter.services.Translator;

public class MockTranslator implements Translator {
    @Override
    public String translate(String word) {
        return word.toLowerCase();
    }
}
