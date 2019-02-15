package com.thoughtworks.eot.entity;


import java.util.Observable;

public class Game extends Observable {

    private int noOfTurns;
    private Machine machine;
    private Player playerOne;
    private Player playerTwo;
    private Writer writer;
    private final String MSG = " has scored ";


    public Game(int noOfTurns, Machine machine, Player playerOne, Player playerTwo, Writer writer) {
        this.writer = writer;
        this.noOfTurns = noOfTurns;
        this.machine = machine;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }


    public void play() {
        while (noOfTurns != 0) {
            int[] result = machine.evaluate(playerOne.makeChoice(), playerTwo.makeChoice());
            playerOne.accumulate(result[0]);
            writer.display(playerOne.getName() + MSG + playerOne.getPoints());
            playerTwo.accumulate(result[1]);
            writer.display(playerTwo.getName() + MSG + playerTwo.getPoints());
            noOfTurns--;
        }
    }
}
