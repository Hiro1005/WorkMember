import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	/*	
    String URL = "jdbc:mysql://localhost/cm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String USERNAME = "root";
    String PASSWORD = "maria";
    */


    public Update(String idData, String nameData, String brunchData, String ageData) {

        try (
            //Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "maria");
            Statement statement = connection.createStatement();
       		)
        {
            String sql = "UPDATE staff SET name = '" + nameData + "', branch = '" + brunchData + "', age = '" + ageData + "' WHERE id = '" + idData + "';";
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