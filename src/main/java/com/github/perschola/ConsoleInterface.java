package com.github.perschola;

import com.github.perschola.utils.IOConsole;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ConsoleInterface {
    //Connection mysqlDbConnection = getConnection("mysql");
    ResultSet getExecuteQuery(String query);
    void getExecuteStatement(String query);
    void getPrintResults(ResultSet resultSet);
    Connection getConnection(String mysql);

    default void getData(){
        String query = "SELECT * FROM databaseName.pokemonTable;";
     ResultSet resultSet= getExecuteQuery(query);
      getPrintResults(resultSet);
    }




    default void getDataById(String id){
        String query = String.format("SELECT * FROM databaseName.pokemonTable where id=%s", id);
        ResultSet resultSet = getExecuteQuery(query);
        getPrintResults(resultSet);
    }
    default void addRow(String id, String name, String primary_type, String secondary_type){
        String values = String.format(" VALUES (%s, '%s', %s, %s);", id, name, primary_type, secondary_type);

        getExecuteStatement(new StringBuilder()
                .append("INSERT INTO databaseName.pokemonTable ")
                .append(values).toString()
        );
        getData();

    }

    default void deleteRow(String id){
        String query = String.format("DELETE FROM databaseName.pokemonTable WHERE id=%s", id);
        getExecuteStatement(query);
        getData();
    }

    default void start(){
        IOConsole console = new IOConsole();
        boolean running = true;
while(running) {

    String userInput = console.getStringInput("Choose one: \n1- add \n2-getUser \n3-delete \n4-update \n5-exit");
    switch (userInput) {
        case "1":
            userInput = console.getStringInput("Enter the id, name, prim, sec (space between)");
            String[] input = userInput.split(" ");
            addRow(input[0], input[1], input[2], input[3]);
            break;
        case "2":
            userInput = console.getStringInput("Enter id of user to delete.");
            deleteRow(userInput);
            break;




        case "5":
            running = false;
    }

}

    };
}
