package com.thoughtworks.eot.entity;

import java.util.HashMap;

public class BasicRuleEngine implements RuleEngine {

    private HashMap<String, int[]> scores = new HashMap<>();

    public BasicRuleEngine() {
        this.scores.put("CHEATCHEAT", new int[]{0, 0});
        this.scores.put("COOPERATECOOPERATE", new int[]{2, 2});
        this.scores.put("CHEATCOOPERATE", new int[]{3, -1});
        this.scores.put("COOPERATECHEAT", new int[]{-1, 3});
    }

    @Override
    public int[] evaluate(Choice playerOne, Choice playerTwo) {
        return this.scores.get(playerOne.name() + playerTwo.name());
    }
}
