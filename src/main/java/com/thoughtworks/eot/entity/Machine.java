package com.thoughtworks.eot.entity;

public class Machine {


    private RuleEngine ruleEngine;

    public Machine(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public int[] evaluate(Choice playerOneChoice, Choice playerTwoChoice) {
        return this.ruleEngine.evaluate(playerOneChoice,playerTwoChoice);
    }
}
