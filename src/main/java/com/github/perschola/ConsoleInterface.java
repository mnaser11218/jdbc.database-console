package com.github.perschola;

import com.github.perschola.utils.IOConsole;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ConsoleInterface {
    //Connection mysqlDbConnection = getConnection("mysql");
    ResultSet getExecuteQuery(Connection mysqlDbConnection, String query);
    void getPrintResults(ResultSet resultSet);
    Connection getConnection(String mysql);

    default void getData(){
        String query = "SELECT * FROM databaseName.pokemonTable;";
        ResultSet resultSet = getExecuteQuery(getConnection("mysql"), query);
        getPrintResults(resultSet);
    }




    default void getDataById(String id){
        String query = String.format("SELECT * FROM databaseName.pokemonTable where id=%s", id);
        ResultSet resultSet = getExecuteQuery(getConnection("mysql"), query);
        getPrintResults(resultSet);
    }
    default void addRow(String id, String name, String primary_type, String secondary_type){
        String values = String.format(" VALUES (%s, '%s', %s, %s);", id, name, primary_type, secondary_type);

        getExecuteQuery(getConnection("mysql"), new StringBuilder()
                .append("INSERT INTO databaseName.pokemonTable ")
                .append("(id, name, primary_type, secondary_type)")
                .append(values).toString()
        );
        getData();

    }

    default void deleteRow(String id){
        String query = String.format("DELETE FROM databaseName.pokemonTable WHERE id=%s", id);
        getExecuteQuery(getConnection("mysql"), query);
        getData();
    }

    default void start(){
        IOConsole console = new IOConsole();
       String userInput = console.getStringInput("Choose one: \n1- add \n2- \ndelete, \n3-update");

    };
}
