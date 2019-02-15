package com.thoughtworks.eot.entity;

import java.util.Observable;

public class CoolChoiceInput implements ChoiceInput {
    @Override
    public Choice getChoice() {
        return Choice.COOPERATE;
    }

}
