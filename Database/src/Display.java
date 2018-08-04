import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Display {

	public Display(){
		
		static ArrayList<Users> getUsers(){

			ArrayList<Users> users = new ArrayList<Users>();

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "maria");

			Statement st = con.createStatement();;

			ResultSet rs;
			

			Users u;

			try {
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM staff");

				while(rs.next()){

				u = new Users(
						rs.getInt("id"),
						rs.getString("fname"),
						rs.getString("lname"),
						rs.getInt("age")
						);

				users.add(u);}

			} catch (SQLException ex) {
				Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
			}

			return users;
		}
		
		// create and populate a jtable from the arraylist who is populated from mysql database

		JTable table = new JTable();

		DefaultTableModel model = new DefaultTableModel();
		
		Object[] columnsName = new Object[4];
		
		columnsName[0] = "Id";
		columnsName[1] = "Fname";
		columnsName[2] = "Lname";
		columnsName[3] = "Age";

		model.setColumnIdentifiers(columnsName);

		Object[] rowData1 = new Object[4];

		for(int i = 0; i < getUsers().size(); i++){

			rowData[0] = getUsers().get(i).getId();
			rowData[1] = getUsers().get(i).getFname();
			rowData[2] = getUsers().get(i).getLname();
			rowData[3] = getUsers().get(i).getAge();

		model.addRow(rowData1);
	
		}
		table.setModel(model);

    }
}