
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
class Product extends JFrame implements ActionListener
{
    JButton badd,bupdate, bdelete;
    JTable jtable;
   public Product()
   {    
      badd=new JButton("Add");
      bupdate=new JButton("Update");
      bdelete=new JButton("Delete");
      jtable=new JTable();
      add(badd);
      add(bupdate);
      add(bdelete);
        setSize(1000,1000);
        setVisible(true);
        setLayout(null);
        badd.setBounds(40,500,75,50);
        bupdate.setBounds(150,500,75,50);
        bdelete.setBounds(250,500,75,50);
        badd.addActionListener(this);
        bupdate.addActionListener(this);
        bdelete.addActionListener(this);
   

        try 
        {
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/register?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            Statement stmt=conn.createStatement();
            String q="select * from Product";
            ResultSet rs=stmt.executeQuery(q);
            DefaultTableModel model=new DefaultTableModel();
            model.addColumn("Name");
            model.addColumn("Price");
            model.addColumn("Description");
            model.addColumn("Category");
            while(rs.next())
            {
                String[] row ={rs.getString("Name"),rs.getString("Price"),rs.getString("Description"),rs.getString("Category")};
                model.addRow(row);
            }
                
                 jtable = new JTable(model);
                 JScrollPane jsp = new JScrollPane(jtable);
                add(jsp);
                jsp.setBounds(70,80,550,400);
        }catch(SQLException e) 
                {
                     e.printStackTrace();
                }
            }
   
        public void actionPerformed(ActionEvent ag)
        {
            if(ag.getSource()==badd)
            {
                new Add();
            }
            else if(ag.getSource()==bupdate)
            {
                new Select();
            }
            else if(ag.getSource()==bdelete)
            {
                new Delete();
            }
    
        }
   public static void main(String args[])
   {
       new Product();
   }
}