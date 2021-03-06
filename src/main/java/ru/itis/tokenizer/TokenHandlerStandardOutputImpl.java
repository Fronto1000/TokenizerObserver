package ru.itis.tokenizer;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.tokens.Token;

public class TokenHandlerStandardOutputImpl implements TokenHandler {
    public void handleToken(Token token) {
        System.out.println("from: " + " " + getName() + " " + token);
    }

    public String getName() {
        return "StandardIOHandler";
    }
}
