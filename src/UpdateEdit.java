import com.company.Connector;
import java.util.Scanner;
import java.sql.*;

public class UpdateEdit {

    public static void Update(String url, String user, String password) {
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
    }
}
