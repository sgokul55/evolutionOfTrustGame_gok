package com.thoughtworks.eot.entity;

import java.util.Observable;

public class CheatChoiceInput implements ChoiceInput {
    @Override
    public Choice getChoice() {
        return Choice.CHEAT;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
