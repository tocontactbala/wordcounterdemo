package com.developerblog.word.counter;

import com.developerblog.word.counter.services.Translator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WordCounterDemoApplicationTests {

	@Test
	void testWordCounter() {
		Translator translator = mock(Translator.class);
		when(translator.translate("flower")).thenReturn("flower");
		when(translator.translate("flor")).thenReturn("flower");
		when(translator.translate("blume")).thenReturn("flower");

		WordCounter wordCounter = new WordCounter(translator);
		wordCounter.addWords("flower", "flor", "blume");

		assertEquals(3, wordCounter.getCount("flower"));
		assertEquals(0, wordCounter.getCount("nonexistent"));
	}

}
