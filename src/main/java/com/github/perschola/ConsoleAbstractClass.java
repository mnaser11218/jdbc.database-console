package com.github.perschola;

import java.sql.Connection;
import java.sql.ResultSet;

abstract public class ConsoleAbstractClass implements ConsoleInterface {
    MyObject myObject = new MyObject();
    public ConsoleAbstractClass() {
    }

    public ResultSet getExecuteQuery(Connection mysqlDbConnection, String query){
        return myObject.executeQuery(mysqlDbConnection, query);
    };

    public void getPrintResults(ResultSet resultSet){
        myObject.printResults(resultSet);
    };
    public Connection getConnection(String mysql){
        return myObject.getConnection(mysql);
    };


}
