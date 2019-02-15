package com.thoughtworks.eot.entity;

public interface RuleEngine {

    int[] evaluate(Choice playerOne, Choice playerTwo);

}
