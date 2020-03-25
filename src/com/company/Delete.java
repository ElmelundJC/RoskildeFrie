package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Delete extends Connector {

    public Delete(String username, String password) {
        super(username, password);
    }

    public void deleteRow(int id) {
        String sql = "DELETE FROM børn WHERE id_barn = ?";

        try (Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/rfb_db?serverTimezone = UTC",username,password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
