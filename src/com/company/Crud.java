package com.company;


import java.sql.*;
import java.util.Scanner;

public class Crud {

    Connection con;

    public Crud(Connection con){
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

    //CREATE
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

    //READ

    public void reader() {
        int i = 0;
        String[] temp = new String[20];


        try {



            String url = "jdbc:mysql://localhost:3306/rfb_db";
            String name = "root";
            String password = "12345678";
            con = DriverManager.getConnection(url, name, password);
            Statement test = con.createStatement();

            System.out.println("what table would you like to be viewed?");

            ResultSet query1 = test.executeQuery("use rfb_db;");

            DatabaseMetaData rfbdb = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rst = rfbdb.getTables(null, null, "%", types);
            while (rst.next()) {
                //System.out.println(rst.getString("TABLE_NAME"));
                temp[i] = rst.getString("TABLE_NAME");
                i++;
            }

            System.out.println("press 1 for " + temp[0]);
            System.out.println("press 2 for " + temp[1]);
            System.out.println("press 3 for " + temp[2]);

            Scanner s = new Scanner(System.in);

            int picker = s.nextInt();
            switch (picker) {
                case 1:
                    ResultSet query4 = test.executeQuery("select * from " + temp[0]);
                    while (query4.next()) {
                        System.out.println(query4.getString("navn"));
                    }
                    break;
                case 2:
                    ResultSet query5 = test.executeQuery("select * from " + temp[1]);
                    while (query5.next()) {
                        System.out.println(query5.getString("navn") + " \nNummer = " + query5.getString("mobilnummmer"));
                    }
                    break;
                case 3:
                    ResultSet query6 = test.executeQuery("select * from " + temp[2]);
                    while (query6.next()) {
                        System.out.println(query6.getString("stuenr.") + " " + query6.getString("farve"));
                    }
                    break;
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }

    //UPDATE

    public void Update(String url, String user, String password) {
        Connection con = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Prompting user for information");
        System.out.println("Rediger Cpr-nummer");
        String cpr_nummer = scan.nextLine();
        System.out.println("Rediger navn");
        String navn = scan.nextLine();
        System.out.println("Rediger Adresse");
        String adresse = scan.nextLine();
        System.out.println("Rediger Stuenummer");
        String stuenr = scan.next();
        System.out.println("Vælg barnets ID nummer");
        String barnId = scan.next();

        try {
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement myStmt = con.prepareStatement("UPDATE BØRN SET cpr_nummer = ?, navn = ?, adresse = ?, Stue_stuenr = ? WHERE id_barn =?;");

            myStmt.setString(1, cpr_nummer);
            myStmt.setString(2, navn);
            myStmt.setString(3, adresse);
            myStmt.setString(4, stuenr);
            myStmt.setString(5, barnId);


            int myResult = myStmt.executeUpdate();


            System.out.println("Childrow Updated");

        } catch (SQLException e) {
            System.out.println("Failed to execute update " + e);
        }
    }

    //DELETE

    public void deleteRow(int id) {
        String sql = "DELETE FROM børn WHERE id_barn = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
