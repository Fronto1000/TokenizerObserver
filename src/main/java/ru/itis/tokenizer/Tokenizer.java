package ru.itis.tokenizer;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.observer.TokenizerObservable;
import ru.itis.tokenizer.tokens.Number;
import ru.itis.tokenizer.tokens.Token;
import ru.itis.tokenizer.tokens.Word;
import ru.itis.tokenizer.tokens.Separator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tokenizer implements TokenizerObservable {
    private static final String PUNCT = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n\t ";
    // ассоциативный массив, где ключем является название обработчика токенов
    // а значением - сам обработчик
    private Map<String, TokenHandler> handlers;

    public Tokenizer() {
        handlers = new HashMap<String, TokenHandler>();
    }

    public void addTokenHandler(TokenHandler handler) {
        handlers.put(handler.getName(), handler);
    }

    public void removeTokenHandler(String handlerName) {
        handlers.remove(handlerName);
    }

    public void notifyHandlers(Token token) {
        // получаем множество ключей-значений из мапа
        Set<Map.Entry<String, TokenHandler>> entries =
                handlers.entrySet();

        // на каждой итерации цикла мы в entity кладем значение из entries
        for (Map.Entry<String, TokenHandler> entity : entries) {
            // из текущего entity забираем значение - обработчик
            TokenHandler currentHandler = entity.getValue();
            // оповещаем обработчик
            currentHandler.handleToken(token);
        }
    }

    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();

        boolean onNumber = false;
        boolean onWord = false;
        boolean onSeparator = false;
        String currentToken = "";
        for (int i = 0; i < textAsCharArray.length; i++) {
            if (Character.isDigit(textAsCharArray[i])) {
                if (onWord) {
                    Token currentWord = new Word();
                    currentWord.setText(currentToken);
                    onWord = false;
                    currentToken = "";
                    notifyHandlers(currentWord);
                }
                if (onSeparator) {
                    Token currentSeparator = new Separator();
                    currentSeparator.setText(currentToken);
                    onSeparator = false;
                    currentToken = "";
                    notifyHandlers(currentSeparator);
                }
                onNumber = true;
                currentToken += textAsCharArray[i];
            }
            if (Character.isLetter(textAsCharArray[i])) {
                if (onNumber) {
                    Token currentNumber = new Number();
                    currentNumber.setText(currentToken);
                    onNumber = false;
                    currentToken = "";
                    notifyHandlers(currentNumber);
                }
                if (onSeparator) {
                    Token currentSeparator = new Separator();
                    currentSeparator.setText(currentToken);
                    onSeparator = false;
                    currentToken = "";
                    notifyHandlers(currentSeparator);
                }
                onWord = true;
                currentToken += textAsCharArray[i];
            }
            if (PUNCT.contains(String.valueOf(textAsCharArray[i]))) {
                if (onNumber) {
                    Token currentNumber = new Number();
                    currentNumber.setText(currentToken);
                    onNumber = false;
                    currentToken = "";
                    notifyHandlers(currentNumber);
                }
                if (onWord) {
                    Token currentWord = new Word();
                    currentWord.setText(currentToken);
                    onWord = false;
                    currentToken = "";
                    notifyHandlers(currentWord);
                }
                onSeparator = true;
                currentToken += textAsCharArray[i];
            }
            if(i == textAsCharArray.length-1){
                if (onNumber) {
                    Token currentNumber = new Number();
                    currentNumber.setText(currentToken);
                    notifyHandlers(currentNumber);
                }
                if (onWord) {
                    Token currentWord = new Word();
                    currentWord.setText(currentToken);
                    notifyHandlers(currentWord);
                }
                if (onSeparator) {
                    Token currentSeparator = new Separator();
                    currentSeparator.setText(currentToken);
                    notifyHandlers(currentSeparator);
                }
            }
        }
    }
}
























