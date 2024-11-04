package com.github.perschola;

import java.sql.Connection;
import java.sql.ResultSet;

public class Console extends MyObject{
    Connection mysqlDbConnection = getConnection("mysql");


    public void getData(){
        String query = "SELECT * FROM databaseName.pokemonTable;";
        ResultSet resultSet = executeQuery(mysqlDbConnection, query);
        printResults(resultSet);
    }
    public void addRow(String id, String name, String primary_type, String secondary_type){
        String values = String.format(" VALUES (%s, '%s', %s, %s);", id, name, primary_type, secondary_type);

        executeStatement(mysqlDbConnection, new StringBuilder()
                .append("INSERT INTO databaseName.pokemonTable ")
                .append("(id, name, primary_type, secondary_type)")
                .append(values).toString()
        );
        getData();

    }

    public void deleteRow(String id){
       String query = String.format("DELETE FROM databaseName.pokemonTable WHERE id=%s", id);
       executeStatement(mysqlDbConnection, query);
       getData();
    }

}
