package com.thoughtworks.eot.entity;

public class Player {

    private int points;
    private String name;
    private ChoiceInput input;


    public Player(String name, ChoiceInput input) {
        this.points = 0;
        this.name = name;
        this.input = input;
    }

    public Choice makeChoice(){
        return input.getChoice();
    }

    public void accumulate(int score){
        points += score;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}
