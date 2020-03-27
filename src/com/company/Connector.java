package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Connector {

    String password = "student";
    String username = "student";
    Connection con;

    public Connector(String username, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rfb_db?serverTimezone = UTC",username,password);

            System.out.println("Succesfully connected to server");

        }
        catch(Exception e) {
            System.out.println("failed " + e);
        }

    }

    public void closeConnection()
    {
        try {
            con.close();
            System.out.println("Closed connection successfully");
        }

        catch(SQLException e){
            System.out.println("failed to close connection " + e);
        }
    }

    public Connection getCon(){
        return con;
    }
}
