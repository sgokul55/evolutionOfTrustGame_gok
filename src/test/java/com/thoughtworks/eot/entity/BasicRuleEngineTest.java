package com.thoughtworks.eot.entity;

import org.junit.Assert;
import org.junit.Test;

public class BasicRuleEngineTest {

    @Test
    public void shouldReturnCheatPointsForBothPlayersWhenChoiceOfBothPlayersIsCheat(){
        RuleEngine engine = new BasicRuleEngine();
        Assert.assertArrayEquals("Should return 0, 0", engine.evaluate(Choice.CHEAT,Choice.CHEAT),new int[]{0,0});
    }

    @Test
    public void shouldReturnCooperatePointsForBothPlayersWhenChoiceOfBothPlayersIsCooperate(){
        RuleEngine engine = new BasicRuleEngine();
        Assert.assertArrayEquals("Should return 2, 2", engine.evaluate(Choice.COOPERATE,Choice.COOPERATE),new int[]{2,2});
    }

    @Test
    public void shouldReturnCheatPointsForPlayer1WhenPlayer1CheatsPlayer2() {
        RuleEngine engine = new BasicRuleEngine();
        Assert.assertArrayEquals("Should return 3, -1", engine.evaluate(Choice.CHEAT,Choice.COOPERATE),new int[]{3,-1});
    }

    @Test
    public void shouldReturnCheatPointsForPlayer2WhenPlayer2CheatsPlayer1() {
        RuleEngine engine = new BasicRuleEngine();
        Assert.assertArrayEquals("Should return -1, 3", engine.evaluate(Choice.COOPERATE,Choice.CHEAT),new int[]{-1,3});
    }
}
