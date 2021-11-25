import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Delete extends JFrame implements ActionListener
{
    JButton bsubmit;
    JLabel lselect;
    JTextField tfselect;
    public Delete()
    {   
        lselect=new JLabel("Select Product name to delete");
        tfselect=new JTextField(90);
        bsubmit=new JButton("submit");
        setLayout(null);
        lselect.setBounds(400,150,200,40);
        tfselect.setBounds(650,150,100,40);
        bsubmit.setBounds(480,250,150,40);
        setSize(1000,1000);
        add(lselect);
        add(tfselect);
        add(bsubmit);
        setVisible(true);
        bsubmit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ac)
    {
        String dlname=tfselect.getText();
     
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
            String q="Delete from Product where Name=?";
            PreparedStatement ps=c.prepareStatement(q);
            ps.setString(1,dlname);
            int a = ps.executeUpdate();
            if(a > 0){
                JOptionPane.showMessageDialog(this,"deleted successfully"); 
            }
            else 
            {
                JOptionPane.showMessageDialog(this,"not deleted"); 
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
            
    }
    
    

    public static void main(String args[])
    {
        new Delete();
    }
}
