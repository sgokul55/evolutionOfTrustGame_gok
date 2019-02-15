package com.thoughtworks.eot.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameTest {

    @Test
    public void shouldPlayOneTurn() {
        Machine machine = mock(Machine.class);
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        Writer writer = mock(ConsoleWriterImpl.class);
        when(machine.evaluate(Mockito.any(), Mockito.any())).thenReturn(new int[]{0, 0});
        Game eot = new Game(1, machine, playerOne, playerTwo,writer);
        eot.play();
        verify(machine, atLeast(1)).evaluate(Mockito.any(), Mockito.any());
    }

    @Test
    public void shouldAfterTheRoundUpdateTheScoreForBothPlayers() {
        Machine machine = mock(Machine.class);
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        when(playerOne.makeChoice()).thenReturn(Choice.CHEAT);
        when(playerTwo.makeChoice()).thenReturn(Choice.CHEAT);
        Writer writer = mock(ConsoleWriterImpl.class);
        when(machine.evaluate(Mockito.any(), Mockito.any())).thenReturn(new int[]{0, 0});
        Game eot = new Game(1, machine, playerOne, playerTwo,writer);
        eot.play();
        verify(playerOne, atLeast(1)).accumulate(Mockito.anyInt());
        verify(playerTwo, atLeast(1)).accumulate(Mockito.anyInt());

    }
    @Test
    public void shouldPrintStatusAfterTheRoundUpdateTheScoreForBothPlayers() {
        Machine machine = mock(Machine.class);
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        Writer writer = mock(ConsoleWriterImpl.class);
        when(playerOne.makeChoice()).thenReturn(Choice.CHEAT);
        when(playerTwo.makeChoice()).thenReturn(Choice.CHEAT);
        when(machine.evaluate(Mockito.any(), Mockito.any())).thenReturn(new int[]{0, 0});
        Game eot = new Game(1, machine, playerOne, playerTwo, writer);
        eot.play();
        verify(writer, atLeast(2)).display(Mockito.anyString());
    }


}
