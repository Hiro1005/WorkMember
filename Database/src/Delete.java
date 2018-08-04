import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	/*	
    String URL = "jdbc:mysql://localhost/cm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String USERNAME = "root";
    String PASSWORD = "maria";
    */


    public Delete(String idData) {

        try (
            //Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "maria");
            Statement statement = connection.createStatement();
       		)
        {
            String sql = "DELETE from staff WHERE id = '" + idData + "';";
            int result = statement.executeUpdate(sql);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //System.out.println("Transaction is completed");
        }
    }
}