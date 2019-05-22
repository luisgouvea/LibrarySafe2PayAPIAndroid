package com.librarysafe2payapiandroid.librarysafe2payapi;

public class Safe2PayConfig {
    private static String Key = "";

    public static void setKey(String key) {
        Safe2PayConfig.Key = key;
    }

    protected static String getKey() {
        return Safe2PayConfig.Key;
    }
}