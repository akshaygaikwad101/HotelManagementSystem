
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener {
    
    DashBoard(){
        setBounds(0,0,1450,900);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1450, 800,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1450,800);
        add(image);
        
        
        JLabel text=new JLabel("ANITA GROUP WELCOMES YOU");
        text.setBounds(350,60,900,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,47));
        text.setForeground(Color.white);
        image.add(text);
        
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1450,30);
        image.add(mb);
        
        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLUE);
        mb.add(hotel);
        
        JMenuItem reception=new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        
        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem addemployee=new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms=new JMenuItem("Add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers=new JMenuItem("Add Drivers");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDrivers();
        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new DashBoard();
    }
    
}
