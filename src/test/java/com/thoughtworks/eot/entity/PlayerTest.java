package com.thoughtworks.eot.entity;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {


    @Test
    public void shouldReturnChoiceAsCooperateWhenCoolPlayerMakesChoice() {
        ChoiceInput input = mock(CoolChoiceInput.class);
        when(input.getChoice()).thenReturn(Choice.COOPERATE);
        Player playerOne = new Player("Player One", input);
        Assert.assertEquals("Player one should choose Cooperate Choice!", Choice.COOPERATE, playerOne.makeChoice());
    }

    @Test
    public void shouldReturnChoiceAsCheatWhenCheatPlayerMakesChoice() {
        ChoiceInput input = mock(CoolChoiceInput.class);
        when(input.getChoice()).thenReturn(Choice.CHEAT);
        Player playerOne = new Player("Player One", input);
        Assert.assertEquals("Player one should choose Cheat Choice!", Choice.CHEAT, playerOne.makeChoice());
    }


    @Test
    public void shouldAccumulateTheScore() {
        Player playerOne = new Player("Player One", null);
        playerOne.accumulate(3);
        Assert.assertEquals("Score should be 3", 3, playerOne.getPoints());
        playerOne.accumulate(2);
        Assert.assertEquals("Score should be 5", 5, playerOne.getPoints());

    }
}
