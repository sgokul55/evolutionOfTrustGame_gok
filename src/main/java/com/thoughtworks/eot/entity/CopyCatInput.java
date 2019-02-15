package com.thoughtworks.eot.entity;

import java.util.Observable;

public class CopyCatInput implements ChoiceInput  {

    Choice choice;
    Observable observable;

    public CopyCatInput() {

    }

    public CopyCatInput(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public Choice getChoice() {
        if(choice == null)
            return Choice.COOPERATE;
        return choice;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.choice = (Choice) arg;
    }
}
