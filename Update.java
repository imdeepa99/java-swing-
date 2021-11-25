import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Update extends JFrame implements ActionListener
{
    //DatabaseManager dbm;
  JLabel lname,lprice,ldescription,Category;
  JTextField tfname,tfprice,tfdescription;
  JButton baddUpdate;
  JComboBox jccategory;
  String selected;
  public Update(String s)
  {   
      
      lname=new JLabel("Name");
      lprice=new JLabel("Price");
      ldescription=new JLabel("Description");
      String[] arr = {"Tshirt","Shorts","Pants"};
      jccategory = new JComboBox(arr);
      tfname=new JTextField(60);
        tfprice=new JTextField(60);
        tfdescription=new JTextField(60);
        baddUpdate=new JButton("Add or Update");
        add(lname);
        add(tfname);
        add(lprice);
        add(tfprice);
        add(ldescription);
        add(tfdescription);
        add(baddUpdate);
        add(jccategory);
        setSize(800,800);
        setLayout(null);
        lname.setBounds(50,100,50,30);
        tfname.setBounds(150,100,100,30);
        lprice.setBounds(50,150,50,30);
        tfprice.setBounds(150,150,100,30);
        ldescription.setBounds(50,200,80,30);
        tfdescription.setBounds(150,200,100,30);
        jccategory.setBounds(50,250,80,30);

        baddUpdate.setBounds(80,300,130,30);

        setVisible(true);
        baddUpdate.addActionListener(this);
        this.selected = s;
  }
  public void actionPerformed(ActionEvent fg)
    {
        String name=tfname.getText();
        String price=tfprice.getText();
        String description=tfdescription.getText();
        String category = jccategory.getSelectedItem().toString();
            if (name.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter your name");
            
            }if(price.isEmpty())
            {
            JOptionPane.showMessageDialog(this,"enter price");
                
            }
            if(description.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"enter description"); 
            }
            else
            {
               
                
                try {
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
                    String q="update Product set Name=?,Price=?,Description=?,Category=? where Name=?"; //up is variable storing selected product's name for update
                    PreparedStatement ps=c.prepareStatement(q);
                    ps.setString(1,name);
                    ps.setString(2,price);
                    ps.setString(3,description);
                    ps.setString(4,category);
                    ps.setString(5,selected);
                    int a = ps.executeUpdate();
                    if(a > 0){
                        JOptionPane.showMessageDialog(this,"updated successfully"); 
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(this,"not updated"); 
                    }
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
                    
            }
        
       
        
    }
  
}