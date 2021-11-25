import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Signup extends JFrame implements ActionListener
{
  JLabel luname,lpassword,lname,lgender,laddress,lphone;
  JTextField tfuname,tfpassword,tfname,tfaddress,tfphone;
  JButton click;
  JRadioButton r1,r2;
   String radio()
            {
                if(r1.isSelected())
                {
                    return "Male";
                }
                else 
                {
                    return "Female";
                }
            
            }
  public Signup()
  {
      luname=new JLabel("User Name");
      lpassword=new JLabel("Password");
      lname=new JLabel("Name");
      lgender=new JLabel("Gender");
      laddress=new JLabel("Address");
      lphone=new JLabel("Phone");
      r1=new JRadioButton("Male");
      r2=new JRadioButton("Female");
      ButtonGroup bg=new ButtonGroup();
      bg.add(r1);
      bg.add(r2);
      add(r1);
      add(r2);
      tfuname=new JTextField(60);
        tfpassword=new JTextField(60);
        tfname=new JTextField(60);
        tfaddress=new JTextField(60);
        tfphone=new JTextField(60);
        click=new JButton("signup");
        add(luname);
        add(tfuname);
        add(lpassword);
        add(tfpassword);
        add(lname);
        add(tfname);
        add(lgender);
        add(laddress);
        add(tfaddress);
        add(lphone);
        add(tfphone);
        add(click);
        setSize(1000,1000);
        setLayout(null);
        setVisible(true);
        luname.setBounds(20,30,80,30);
        tfuname.setBounds(120,30,80,30);
        lpassword.setBounds(20,70,80,30);
        tfpassword.setBounds(120,70,80,30);
        lname.setBounds(20,120,80,30);
        tfname.setBounds(120,120,80,30);
        lgender.setBounds(20,190,80,30);
        r1.setBounds(120,190,80,30);
        r2.setBounds(200,190,80,30);
        laddress.setBounds(20,250,80,30);
        tfaddress.setBounds(120,250,80,30);
        lphone.setBounds(20,350,80,30);
        tfphone.setBounds(120,350,80,30);
        click.setBounds(70,400,80,30);
        click.addActionListener(this);
  }
  public void actionPerformed(ActionEvent fg)
    {
        String usname=tfuname.getText();
        String pwd=tfpassword.getText();
        String name=tfname.getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();


            
             if (usname.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter Username");
            
            }else if(pwd.isEmpty())
            {
            JOptionPane.showMessageDialog(this,"enter password");
                
            }
            else if(name.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"enter your name"); 
            }
            else
            {
                try {
                    Connection c =DriverManager.getConnection("jdbc:mysql://localhost/register?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                    String q="insert into signup(UserName,Password,Name,Gender,Address,Phone) values(?,?,?,?,?,?)";
                    PreparedStatement ps=c.prepareStatement(q);
                    ps.setString(1,usname);
                    ps.setString(2,pwd);
                    ps.setString(3,name);
                    ps.setString(4,radio());
                    ps.setString(5,address);
                    ps.setString(6,phone);
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
        new Signup();
    }
}