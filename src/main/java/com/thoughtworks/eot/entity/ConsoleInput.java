package com.thoughtworks.eot.entity;

import java.util.Observable;
import java.util.Scanner;

public class ConsoleInput implements  ChoiceInput {

    private Scanner scanner;

    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Choice getChoice() {
        System.out.println("Please make a choice");
        System.out.println("*******************");
        System.out.println("COOPERATE -> 1");
        System.out.println("CHEAT -> 2");
        return convertIntToChoice(scanner.nextInt());
    }

    private Choice convertIntToChoice(int choiceInt){
        Choice choice;
        switch (choiceInt){
            case 1:
                choice = Choice.COOPERATE;
                break;
            case 2:
                choice = Choice.CHEAT;
                break;

                default:
                    choice = null;
                    break;
        }
        return choice;
    }

}
