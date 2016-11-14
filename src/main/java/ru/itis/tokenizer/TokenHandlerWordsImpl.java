package ru.itis.tokenizer;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.tokens.Token;
import ru.itis.tokenizer.tokens.Word;

public class TokenHandlerWordsImpl implements TokenHandler {
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(Word.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm on word! " + token);
        }
    }

    public String getName() {
        return "WordHandler";
    }
}
