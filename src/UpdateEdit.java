import com.company.Connector;
import java.util.Scanner;
import java.sql.*;

public class UpdateEdit {

    public static void Update(String url, String user, String password) {
        Connection con;
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
            Statement stmt1 = con.createStatement();
            String sql1 = "UPDATE BØRN SET cpr_nummer = '" + cpr_nummer + "', navn = '" + navn +"', adresse = '" + adresse + "', Stue_stuenr = '" + stuenr + "' WHERE id_barn =" + barnId + ";";
            int rs1 = stmt1.executeUpdate(sql1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
