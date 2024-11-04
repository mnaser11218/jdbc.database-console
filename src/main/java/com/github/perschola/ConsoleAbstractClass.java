package com.github.perschola;

import java.sql.Connection;
import java.sql.ResultSet;

abstract public class ConsoleAbstractClass implements ConsoleInterface {
   private final MyObject myObject;
    public ConsoleAbstractClass() {
        myObject = new MyObject();
        myObject.run();

    }

    public ResultSet getExecuteQuery(String query){
        return myObject.executeQuery(getConnection("mysql"), query);
    };
    public void getExecuteStatement(String query){
        myObject.executeStatement(getConnection("mysql"), query);
    };


    public void getPrintResults(ResultSet resultSet){
        myObject.printResults(resultSet);
    };
    public Connection getConnection(String mysql){
        return myObject.getConnection(mysql);
    };


}
