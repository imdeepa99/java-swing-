import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Add extends JFrame implements ActionListener
{
    //DatabaseManager dbm;
  JLabel lname,lprice,ldescription,lcategory;
  JTextField tfname,tfprice,tfdescription;
  JButton baddUpdate;
  JComboBox jccategory;
  public Add()
  {
      lname=new JLabel("Name");
      lprice=new JLabel("Price");
      ldescription=new JLabel("Description");
      lcategory=new JLabel("Category");
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
        add(lcategory);
        setSize(800,800);
        setLayout(null);
        lname.setBounds(50,100,50,30);
        tfname.setBounds(150,100,100,30);
        lprice.setBounds(50,150,50,30);
        tfprice.setBounds(150,150,100,30);
        ldescription.setBounds(50,200,80,30);
        tfdescription.setBounds(150,200,100,30);
        lcategory.setBounds(50,250,80,30);
        jccategory.setBounds(150,250,80,30);

        baddUpdate.setBounds(80,300,130,30);

        setVisible(true);
        baddUpdate.addActionListener(this);
  }
  public void actionPerformed(ActionEvent fg)
    {
        String name=tfname.getText();
        String price=tfprice.getText();
        String description=tfdescription.getText();
        String category = jccategory.getSelectedItem().toString();
            if (name.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter yourname");
            
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
                    Connection c =DriverManager.getConnection("jdbc:mysql://localhost/register?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                    String q="insert into Product(Name,Price,Description,Category) values(?,?,?,?)";
                    PreparedStatement ps=c.prepareStatement(q);
                    ps.setString(1,name);
                    ps.setString(2,price);
                    ps.setString(3,description);
                    ps.setString(4,category);
                    int a = ps.executeUpdate();
                    if(a > 0){
                        JOptionPane.showMessageDialog(this,"recorded successfully"); 
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(this,"not recorded"); 
                    }
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
                    
            } 
        
    }
    public static void main(String args[])
    {
        new Add();
    }
}