import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Login extends JFrame implements ActionListener
{
  JLabel lusername,lpassword,lLogin;
  JTextField tfuname,tfpassword;
  JButton click;
  public Login()
  {     
        lusername=new JLabel("User Name");
        lpassword=new JLabel("Password");
        lLogin=new JLabel("Login");
        tfuname=new JTextField(60);
        tfpassword=new JTextField(60);
        click=new JButton("login");
        add(lLogin);
        add(lusername);
        add(tfuname);
        add(lpassword);
        add(tfpassword);
        add(click);
        setSize(800,800);
        setLayout(null);
        lLogin.setBounds(400,150,150,50);
        lusername.setBounds(350,300,100,50);
        tfuname.setBounds(500,300,100,50);
        lpassword.setBounds(350,400,100,50);
        tfpassword.setBounds(500,400,100,50);
        click.setBounds(370,600,150,50);

        setVisible(true);
        click.addActionListener(this);
  }
  public void actionPerformed(ActionEvent fg)
    {
        String uname=tfuname.getText();
        String psw=tfpassword.getText();
        
            if (uname.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter your username");
            
            }else if(psw.isEmpty())
            {
            JOptionPane.showMessageDialog(this,"enter your password");
                
            }
            else
            {
                try {
                        Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/register?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                        Statement stmt = conn.createStatement();
                        String sql="select UserName,Password from signup";
                        ResultSet rs = stmt.executeQuery(sql); 
                        while(rs.next())
                        { 
                                String dbuname= rs.getString("UserName");  
                                String dbpwd= rs.getString("Password");
                           
                            if(uname.equals(dbuname) && psw.equals(dbpwd))
                                {
                                    new Product();
                                }
                            
                        }

                    
                    } catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                    
            }
        
    }
    public static void main(String args[])
    {
        new Login();
    }
}