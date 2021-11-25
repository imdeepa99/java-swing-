import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Select extends JFrame implements ActionListener
{
    JButton bsubmit;
    JLabel lselect;
    JTextField tfselect;
    public Select()
    {   
        lselect=new JLabel("Select Product name to update");
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
        String upname=tfselect.getText();
      if(ac.getSource()==bsubmit)  
      {
          new Update(upname);
      }
      
    
    }
    public static void main(String args[])
    {
        new Select();
    }
}
