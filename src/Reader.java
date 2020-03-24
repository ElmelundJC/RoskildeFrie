import com.company.Connector;

import java.util.Scanner;
import java.sql.*;

public class Reader {

    Connection con;
    int i;
    String[] temp = new String[20];

    public void reader() {


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
                        System.out.println(query6.getString("stuenr."));
                    }
                    break;
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }
}
