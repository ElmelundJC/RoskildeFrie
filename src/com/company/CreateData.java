package com.company;


import java.sql.*;

public class CreateData {

    Connection con;

    public CreateData(Connection con){
        this.con = con;
    }

    public PreparedStatement prepStatement(String SQL_INSERT){
        try{
            return con.prepareStatement(SQL_INSERT);

        }
        catch(SQLException e){
            System.out.println("Failed to create statement for server");

        }
        return null;
    }



    public void insertChild(String cpr, String name, String address, int Stuenr){

        final String SQL_INSERT = "INSERT INTO BØRN (id_barn, cpr_nummer, navn, adresse, Stue_stuenr) VALUES (default, ?,?,?,?)";

        PreparedStatement preparedStatement = prepStatement(SQL_INSERT);

        try {

            preparedStatement.setString(1, cpr);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, address);
            preparedStatement.setInt(4, Stuenr);

            preparedStatement.executeUpdate();

            System.out.println("Succesfully added Child");


        }

        catch (SQLException e){
            System.out.println("Failed to insert data " + e);
        }



    }

    public void insertParent(){

    }

    public void insertStue(){


    }
}
