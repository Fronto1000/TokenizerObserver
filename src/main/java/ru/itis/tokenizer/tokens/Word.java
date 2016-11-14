package ru.itis.tokenizer.tokens;

public class Word extends Token{
    private String value;
    private boolean isUpperFirst;

    public Word() {
        super();
    }
    public Word(int begin, int end, String text, String value) {
        super(begin, end, text);
        this.value = value;
        char[] valueAsCharArray = this.value.toCharArray();
        for ( int i = 0;i < valueAsCharArray.length; i++)
        if(Character.isUpperCase(valueAsCharArray[i])){
            this.isUpperFirst = true;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isUpperFirst() {
        return isUpperFirst;
    }

    public void setUpperFirst(boolean upperFirst) {
        isUpperFirst = upperFirst;
    }
}
