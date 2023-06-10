package com.example.erasyldiplomapp;

import java.util.ArrayList;
import java.util.List;

public class Answers2_1 {
    private static Answers2_1 instance;
    private Answers2_1() {}

    public static Answers2_1 getInstance() {
        if (instance == null) {
            instance = new Answers2_1();
        }
        return instance;
    }

    public int yesCounter = 0;
    public int noCounter = 0;
    public List<String> answers;
}
