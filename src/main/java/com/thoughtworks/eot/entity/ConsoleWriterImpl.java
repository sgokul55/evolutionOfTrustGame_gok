package com.thoughtworks.eot.entity;

public class ConsoleWriterImpl implements Writer{

    @Override
    public void display(String message) {
        System.out.println(message);
    }
}
