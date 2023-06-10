package com.example.erasyldiplomapp;

public class Result {
    private int id;
    private String city;
    private String org;
    private String points;
    private String date;

    public Result(int id, String city, String org, String points, String date) {
        this.id = id;
        this.city = city;
        this.org = org;
        this.points = points;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
