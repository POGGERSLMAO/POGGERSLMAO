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

    

            System.out.println("Raderna du har valt är:");
            while(rset.next()) 
            
            {

                String title = rset.getString("body");
                System.out.println(title);
            }

            System.out.println("Nummren av rader = ");



            ResultSet linkset = stmt.executeQuery(linksSelect);


            System.out.println("Raderna du har valt är:");
            int rowCount = 0;
            while(linkset.next()) {
                int target_id = linkset.getInt("target_id");
                String description = linkset.getString("description");
                System.out.println(target_id + ", " + description);
                ++rowCount;
            }
            System.out.println("Det totala nummren av rader = " + rowCount);

         
            conn.close();
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
