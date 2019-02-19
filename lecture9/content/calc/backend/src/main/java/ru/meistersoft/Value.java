package ru.meistersoft;

public class Value {
    public String value;

    public Value(String value) {
        this.setValue(value);
    }

    public Value() {
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
