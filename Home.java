import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Home extends JFrame implements ActionListener
{
    JButton blogin, bsignup;
    JLabel text;
    public Home()
    {   
        text=new JLabel("Welcome");
        blogin=new JButton("Login");
        bsignup=new JButton("Register");
        setLayout(null);
        text.setBounds(400,150,150,50);
        blogin.setBounds(350,300,150,50);
        bsignup.setBounds(350,500,150,50);
        setSize(1000,1000);
        add(text);
        add(blogin);
        add(bsignup);
        setVisible(true);
        blogin.addActionListener(this);
        bsignup.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ac)
    {
      if(ac.getSource()==blogin)  
      {
          new Register();
      }
      else if(ac.getSource()==bsignup)  
      {
          new Register();
      }
    
    }
    public static void main(String args[])
    {
        new Home();
    }
}