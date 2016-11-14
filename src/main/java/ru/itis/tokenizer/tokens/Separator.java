package ru.itis.tokenizer.tokens;

public class Separator extends Token{
    private String value;

    public Separator() {
        super();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
