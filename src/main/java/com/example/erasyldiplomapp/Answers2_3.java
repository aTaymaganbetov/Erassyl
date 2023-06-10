package com.example.erasyldiplomapp;

import java.util.List;

public class Answers2_3 {
    private static Answers2_3 instance;
    private Answers2_3() {}

    public static Answers2_3 getInstance() {
        if (instance == null) {
            instance = new Answers2_3();
        }
        return instance;
    }

    public int yesCounter = 0;
    public int noCounter = 0;
    public List<String> answers;
}
