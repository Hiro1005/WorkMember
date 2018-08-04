import java.awt.event.*;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;


/*

社員表の理想はこの項目かな

Employee ID
Name
Branch
Age
Gender
Date of Birth
Organization
Position
Time Type
AnnualBasePay
Performance
CheckBox
Phone Number
Address
E-mail
Race
Religion

*/

public class Work extends JFrame {
    
	private static final long serialVersionUID = 2L;

	public Work(){
        
        super("Member Table");
        setLocationRelativeTo(null);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//center
        //setExtendedState(JFrame.MAXIMIZED_BOTH);//WindowMax
        setVisible(true);
        
        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // Menu item (File)
        JMenu menu1 = new JMenu("File");        
        
        JMenuItem item1 = new JMenuItem("New");
        JMenuItem item2 = new JMenuItem("Open");
        menu1.add(item1);
        menu1.add(item2);
        
        menuBar.add(menu1);
        
        // Menu item (Edit)
        JMenu menu2 = new JMenu("Edit");        
        JMenuItem item2_1 = new JMenuItem("Undo");
        JMenuItem item2_2 = new JMenuItem("Redo");
        menu2.add(item2_1);
        menu2.add(item2_2);
        
        menuBar.add(menu2);
        
    }

 // create a Function to get the connection
    static Connection getConnection(){
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/cm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","maria");
        } catch (SQLException ex) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
 // create a function to fill the an arraylist from database
    static ArrayList<Users> getUsers(){
        
        ArrayList<Users> users = new ArrayList<Users>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        Users u;
        
        try {
            
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM staff");
            
            while(rs.next()){
                
                u = new Users(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("branch"),
                        rs.getInt("age")
                );
                
                users.add(u);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }
    
    
    public static void main(String[] args){

 /*
   now we are gonna create and populate a jtable from the arraylist who is populated from mysql database
*/
    
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[4];
        columnsName[0] = "Id";
        columnsName[1] = "Name";
        columnsName[2] = "Branch";
        columnsName[3] = "Age";
        
        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[4];
        for(int i = 0; i < getUsers().size(); i++){
            
            rowData[0] = getUsers().get(i).getId();
             rowData[1] = getUsers().get(i).getFname();
              rowData[2] = getUsers().get(i).getLname();
               rowData[3] = getUsers().get(i).getAge();
               
               model.addRow(rowData);
        }
        
        table.setModel(model);
        
        // Create Instance and nameed [window]
        
        Work window = new Work();
        
        // Create container [contentPane]
        
        Container contentPane = window.getContentPane();
        
        // Put tabledata on Container [contentPane] BorderLayout.PAGE_START
        
        JScrollPane pane = new JScrollPane(table);
		contentPane.add(pane,BorderLayout.CENTER);
        //JPanel memTable = new JPanel();
        //memTable.setLayout(new BorderLayout());
        //memTable.add(pane,BorderLayout.NORTH);)
        //window.setContentPane(memTable);
        
        
        // 2 , Control Panel [conPanel]

        JPanel conPanel = new JPanel();
        conPanel.setLayout(new FlowLayout());// It is actually no need degignate FlowLayout. Because default Layout is FlowLayout
		contentPane.add(conPanel,BorderLayout.SOUTH);
        //conPanel.add(window, BorderLayout.SOUTH);
        //window.setContentPane(conPanel);
        
        JLabel id = new JLabel("ID");
        id.setBounds(100, 20, 100, 20);
        id.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        conPanel.add(id);
        
        JTextField idtext = new JTextField(10);
        idtext.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        idtext.setBounds(100, 50, 50, 20);
        conPanel.add(idtext);

        JLabel name = new JLabel("Name");
        name.setBounds(200, 50, 50, 20);
        name.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        conPanel.add(name);
        
        JTextField nametext = new JTextField(10);
        nametext.setBounds(300, 50, 50, 20);
        nametext.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        conPanel.add(nametext);
        
        JLabel branch = new JLabel("Brunch");
        branch.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        branch.setBounds(50, 100, 50, 20);
        conPanel.add(branch);
        
        JTextField branchtext = new JTextField(10);
        branchtext.setBounds(100, 100, 50, 20);
        branchtext.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        conPanel.add(branchtext);
        
        JLabel age = new JLabel("Age");
        age.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        age.setBounds(200, 100, 50, 20);
        conPanel.add(age);
        
        JTextField agetext = new JTextField(10);
        agetext.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        agetext.setBounds(300, 100, 50, 20);
        conPanel.add(agetext);
        
        JButton di = new JButton("Display");
        di.setBounds(200, 150, 50, 20);
        di.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        //cframe.getContentPane().add(di);
        conPanel.add(di);

        di.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent arg0) {
               Display u = new Display();
            }
        });
        
        JButton in = new JButton("INSERT");
        in.setBounds(50, 150, 50, 20);
        in.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        conPanel.add(in);
        
        in.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent arg0) {
            
            	String idData = idtext.getText();
                String nameData = nametext.getText();
                String brunchData = branchtext.getText();
                String ageData = agetext.getText();
            
                Insert x = new Insert(idData, nameData, brunchData, ageData);
            }

        });
        
        JButton up = new JButton("UPDATE");
        up.setBounds(50, 150, 50, 20);
        up.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        conPanel.add(up);
        
        up.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent arg0) {

            	String idData = idtext.getText();
                String nameData = nametext.getText();
                String brunchData = branchtext.getText();
                String ageData = agetext.getText();
            
                Update z = new Update(idData, nameData, brunchData, ageData);

            }

        });
        
        JButton de = new JButton("DELETE");
        de.setBounds(50, 150, 50, 20);
        de.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        conPanel.add(de);
        
        de.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent arg0) {
            	String idData = idtext.getText();
                Delete y = new Delete(idData);
            }

        });
        
        JButton reset = new JButton("Reset");
        reset.setBounds(100, 150, 50, 20);
        reset.setFont(new Font("IPAMincho", Font.ITALIC, 20));
        //cframe.getContentPane().add(reset);
        conPanel.add(reset);
        
        reset.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent arg0) {
                idtext.setText("");
                nametext.setText("");
                branchtext.setText("");
                agetext.setText("");
            }
        });
        
    }

}