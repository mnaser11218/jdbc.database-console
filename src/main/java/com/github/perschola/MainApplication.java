package com.github.perschola;

public class MainApplication {
    public static void main(String[] args) {
        Runnable myObject = new MyObject();
        Console console = new Console();
        console.run();
//        myObject.run();
        console.addRow("19", "mohammed", "3", "4");

    }
}
