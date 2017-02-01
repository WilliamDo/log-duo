package com.ultimaspin.logging;

public class Duo {

    private final String key;
    private final String value;

    private final String duoString;

    private Duo(String key, String value) {
        this.key = key;
        this.value = value;
        this.duoString = key + "=\"" + value +"\"";
    }

    public static Duo duo(String key, String value) {
        return new Duo(key, value);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getDuoString() {
        return duoString;
    }

}
