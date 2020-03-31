import java.sql.*;

public class database {
    public static void main(String[] args) {
        try {
            
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://"+DatabaseInfo.DBURL + ":" + DatabaseInfo.port + "/" + DatabaseInfo.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                            DatabaseInfo.user, DatabaseInfo.password);

           
            int x = 1;
            Statement stmt = conn.createStatement();
           
            String strSelect = "select body from story where id = " + x;
            String linksSelect = "select target_id, description from links where id = " + x;
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

        }
    
}
