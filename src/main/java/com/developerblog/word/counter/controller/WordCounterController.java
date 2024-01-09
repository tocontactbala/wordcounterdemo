package com.developerblog.word.counter.controller;

import com.developerblog.word.counter.services.WordCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wordcounter")
public class WordCounterController {

    @Autowired
    private WordCounter wordCounter;

    @PostMapping("/addwords")
    public void addWords(@RequestBody String[] words) {
        wordCounter.addWords(words);
    }

    @GetMapping("/getcount/{word}")
    public int getCount(@PathVariable String word) {
        return wordCounter.getCount(word);
    }
}
