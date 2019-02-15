package com.thoughtworks.eot.entity;

import org.junit.Assert;
import org.junit.Test;

public class CopyCatInputTest {

    @Test
    public void shouldReturnDefaultChoiceWhenPreviousChoiceOfOppositePlayerIsNotAvailable()
    {
        CopyCatInput copyCatInput = new CopyCatInput();
        Assert.assertEquals(Choice.COOPERATE, copyCatInput.getChoice());
    }

    @Test
    public void shouldReturnPreviousChoiceWhenPreviousChoiceOfOppositePlayerIsAvailable()
    {
        CopyCatInput copyCatInput = new CopyCatInput();
        copyCatInput.update(null, Choice.CHEAT);
        Assert.assertEquals(Choice.CHEAT, copyCatInput.getChoice());
    }
}
