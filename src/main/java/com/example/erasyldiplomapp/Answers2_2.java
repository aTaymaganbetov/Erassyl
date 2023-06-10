package com.example.erasyldiplomapp;

import java.util.ArrayList;
import java.util.List;

public class Answers2_2 {
    private static Answers2_2 instance;
    private Answers2_2() {}

    public static Answers2_2 getInstance() {
        if (instance == null) {
            instance = new Answers2_2();
        }
        return instance;
    }

    public List<Integer> first = new ArrayList<>();
    public List<Integer> second = new ArrayList<>();
    public List<Integer> third = new ArrayList<>();
    public List<Integer> fourth = new ArrayList<>();
    public List<Integer> fifth = new ArrayList<>();
    public List<Integer> sixth = new ArrayList<>();
    double avg = 0;
}
