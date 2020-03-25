package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connector connection = new Connector("root", "12345678");



        CreateData creater = new CreateData(connection.getCon());

        creater.insertChild("0210921743", "Kristian", "Bramstedvej 4", 1);

        connection.closeConnection();


    }
}
