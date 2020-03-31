import java.sql.*;

public class database {
    public static void main(String[] args) {
        try {
            
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://"+DatabaseInfo.DBURL + ":" + DatabaseInfo.port + "/" + DatabaseInfo.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                            DatabaseInfo.user, DatabaseInfo.password);

           
           
        }
    }
}
