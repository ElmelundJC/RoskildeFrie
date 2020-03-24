package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connector connection = new Connector("root", "12345678");

        connection.closeConnection();


    }
}
