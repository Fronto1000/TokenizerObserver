package ru.itis.tokenizer;

import ru.itis.tokenizer.observer.TokenizerObservable;

public class Program {
    public static void main(String[] args) {
        String text = "aaa,fff!111///.34";
        TokenizerObservable tokenizer = new Tokenizer();
        tokenizer.addTokenHandler(new TokenHandlerNumbersImpl());
        //tokenizer.addTokenHandler(new TokenHandlerStandardOutputImpl());
        tokenizer.addTokenHandler(new TokenHandlerWordsImpl());
        tokenizer.addTokenHandler(new TokenHandlerSeparatorsImpl());
        TokenHandlerAddToArray array = new TokenHandlerAddToArray();
        tokenizer.addTokenHandler(array);
        tokenizer.tokenize(text);
        array.showTokensArrayList();

    }


}
