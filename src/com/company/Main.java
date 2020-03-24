package com.company;


public class Main {

    public static void main(String[] args) {

        Connector connection = new Connector("student", "student");

        Delete delete = new Delete("student", "student");
        /*delete.deleteRow(7);
        delete.deleteRow(8);
        delete.deleteRow(9);*/
        delete.deleteRow(4);



        connection.closeConnection();


    }
}
