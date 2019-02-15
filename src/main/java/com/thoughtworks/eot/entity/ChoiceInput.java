package com.thoughtworks.eot.entity;

import java.util.Observable;
import java.util.Observer;

public interface ChoiceInput extends Observer {

    Choice getChoice();

    @Override
    default void update(Observable o, Object arg) {

    }

}
