package com.company;


import java.sql.*;
import java.util.Scanner;

public class Crud {

    Connector connector;
    Connection con;

    public Crud(){

        connector = new Connector("root", "Healmelawl0210");
        con = connector.getCon();

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

    public String reader(String table) {
        String testWord = "";

        try {


            Statement test = con.createStatement();
            ResultSet query1 = test.executeQuery("use rfb_db;");

            /*
            DatabaseMetaData rfbdb = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rst = rfbdb.getTables(null, null, "%", types);
            while (rst.next()) {
                //System.out.println(rst.getString("TABLE_NAME"));
                temp[i] = rst.getString("TABLE_NAME");
                i++;
            }
            */


            switch (table) {
                case "Børn":
                    ResultSet query4 = test.executeQuery("select * from Børn");
                    while (query4.next()) {
                        //temp.add("\n"+query4.getString("navn"));
                        //temp.add(query4.getString("adresse"));
                        //temp.add(query4.getString("Stue_stuenr"));

                        testWord += (query4.getString("navn") + " ");
                        testWord += (query4.getString("adresse") + " ");
                        testWord += (query4.getString("Stue_stuenr")+"\n");

                    }
                    System.out.println(testWord);
                    return testWord;

                case "Forældre":
                    ResultSet query5 = test.executeQuery("select * from Forældre");
                    while (query5.next()) {
                        testWord += (query5.getString("navn") + " ");
                        testWord += (query5.getString("mobilnummmer") + " ");
                        testWord += (query5.getString("arbejdsnummer")+"\n");
                    }
                    System.out.println(testWord);
                    return testWord;

                case "Stue":
                    ResultSet query6 = test.executeQuery("select * from Stue");
                    while (query6.next()) {
                        testWord += (query6.getString("stuenr") + " ");
                        testWord += (query6.getString("farve")+"\n");
                    }
                    System.out.println(testWord);
                    return testWord;

                default:
                    ResultSet query7 = test.executeQuery("SELECT * FROM Børn " +
                            "inner join forældre " +
                            "where Forældre.Børn_id_barn = Børn.id_barn and Børn.navn = "+ "\"" + table +"\"");
                    while (query7.next()) {
                        testWord += (query7.getString("navn") + " ");
                        testWord += (query7.getString("adresse") + " ");
                        testWord += (query7.getString("mobilnummmer") + " ");
                        testWord += (query7.getString("arbejdsnummer")+"\n");

                    }
                    System.out.println(testWord);
                    return testWord;

            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return testWord;

    }

    //UPDATE

    public void update(String cpr_nummer, String navn, String adresse, int stuenr, int barnId) {

        /*
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

         */

        try {

            PreparedStatement myStmt = con.prepareStatement("UPDATE BØRN SET cpr_nummer = ?, navn = ?, adresse = ?, Stue_stuenr = ? WHERE id_barn =?;");

            myStmt.setString(1, cpr_nummer);
            myStmt.setString(2, navn);
            myStmt.setString(3, adresse);
            myStmt.setInt(4, stuenr);
            myStmt.setInt(5, barnId);


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
