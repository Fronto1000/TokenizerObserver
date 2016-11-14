package ru.itis.tokenizer;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.tokens.Token;

import java.util.ArrayList;

public class TokenHandlerAddToArray implements TokenHandler{

    private ArrayList<Token> tokenArrayList;

    public TokenHandlerAddToArray() {
        this.tokenArrayList = new ArrayList<Token>();
    }

    public void handleToken(Token token) {
        this.tokenArrayList.add(token);
    }

    public String getName() {
        return "AddToArray";
    }

    public ArrayList<Token> getTokenArrayList() {
        return tokenArrayList;
    }
    public void showTokensArrayList(){
        for (Token token:this.tokenArrayList) {
            System.out.println(token.getText());
        }
    }
}
