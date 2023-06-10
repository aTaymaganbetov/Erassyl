package com.example.erasyldiplomapp;


import java.util.ArrayList;
import java.util.List;

public class Answers {
    private static Answers instance;
    private Answers(){}

    public static Answers getInstance() {
        if (instance == null) {
            instance = new Answers();
        }
        return instance;
    }

    public List<Integer> leftAnswers = new ArrayList<>();

    public List<Integer> rightAnswers = new ArrayList<>();

    public List<String> recommendList = new ArrayList<>();

    public String city = "Karaganda";
    public String org = "KSTU";
}
