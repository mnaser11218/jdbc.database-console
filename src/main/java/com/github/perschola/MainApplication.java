package com.github.perschola;

public class MainApplication {
    public static void main(String[] args) {
        Runnable myObject = new MyObject();
        ConsoleInterface console = new Console();
        console.start();
       // console.run();
//        myObject.run();
//        console.addRow("19", "mohammed", "3", "4");
//        console.deleteRow("19");
    }
}
