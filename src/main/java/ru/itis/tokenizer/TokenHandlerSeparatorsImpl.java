package ru.itis.tokenizer;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.tokens.Token;
import ru.itis.tokenizer.tokens.Separator;

public class TokenHandlerSeparatorsImpl implements TokenHandler {
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(Separator.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm on separator! " + token);
        }
    }

    public String getName() {
        return "SeparatorHandler";
    }
}
