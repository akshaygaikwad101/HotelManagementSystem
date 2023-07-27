
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;


public class Room extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Room(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(550, 550,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,5,550,550);
        add(image);
        
        
        JLabel l1=new JLabel("Room No");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(320,10,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(410,10,100,20);
        add(l5);
        
        
        table=new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
        setBounds(180,100,1000,580);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new Room();
    }
}
