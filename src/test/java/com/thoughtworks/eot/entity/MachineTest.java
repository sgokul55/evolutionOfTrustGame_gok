package com.thoughtworks.eot.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MachineTest {

    @Mock
    RuleEngine ruleEngine;

    @Mock
    Player playerOne;

    @Mock
    Player playerTwo;

    @Test
    public void shouldReturnCooperatePointsForBothPlayersWhenChoiceOfBothPlayersIsCooperate() {
        when(playerOne.makeChoice()).thenReturn(Choice.COOPERATE);
        when(playerTwo.makeChoice()).thenReturn(Choice.COOPERATE);
        when(ruleEngine.evaluate(Mockito.any(), Mockito.any())).thenReturn(new int[]{2, 2});
        Machine machine = new Machine(ruleEngine);
        int[] result = machine.evaluate(playerOne.makeChoice(), playerTwo.makeChoice());
        Assert.assertArrayEquals(new int[]{2, 2}, result);
    }

    @Test
    public void shouldReturnCheatPointsForBothPlayersWhenChoiceOfBothPlayersIsCheat() {
        when(playerOne.makeChoice()).thenReturn(Choice.CHEAT);
        when(playerTwo.makeChoice()).thenReturn(Choice.CHEAT);
        when(ruleEngine.evaluate(Mockito.any(), Mockito.any())).thenReturn(new int[]{0, 0});
        Machine machine = new Machine(ruleEngine);
        int[] result = machine.evaluate(playerOne.makeChoice(), playerTwo.makeChoice());
        Assert.assertArrayEquals(new int[]{0, 0}, result);
    }

    @Test
    public void shouldReturnCheatPointsForPlayer1WhenPlayer1CheatsPlayer2() {
        when(playerOne.makeChoice()).thenReturn(Choice.CHEAT);
        when(playerTwo.makeChoice()).thenReturn(Choice.COOPERATE);
        when(ruleEngine.evaluate(Mockito.any(), Mockito.any())).thenReturn(new int[]{3, -1});
        Machine machine = new Machine(ruleEngine);
        int[] result = machine.evaluate(playerOne.makeChoice(), playerTwo.makeChoice());
        Assert.assertArrayEquals(new int[]{3, -1}, result);
    }

    @Test
    public void shouldReturnCheatPointsForPlayer2WhenPlayer2CheatsPlayer1() {
        when(playerOne.makeChoice()).thenReturn(Choice.COOPERATE);
        when(playerTwo.makeChoice()).thenReturn(Choice.CHEAT);
        when(ruleEngine.evaluate(Mockito.any(), Mockito.any())).thenReturn(new int[]{-1, 3});
        Machine machine = new Machine(ruleEngine);
        int[] result = machine.evaluate(playerOne.makeChoice(), playerTwo.makeChoice());
        Assert.assertArrayEquals(new int[]{-1, 3}, result);
    }


}
