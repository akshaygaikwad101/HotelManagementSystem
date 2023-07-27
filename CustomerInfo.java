package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    CustomerInfo(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
       
        
        
        JLabel l1=new JLabel("Document");
        l1.setBounds(40,10,90,20);
        add(l1);
        
        JLabel l2=new JLabel("Doc ID");
        l2.setBounds(150,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Name");
        l3.setBounds(270,10,90,20);
        add(l3);
        
        JLabel l4=new JLabel("Gender");
        l4.setBounds(360,10,90,20);
        add(l4);
        
        JLabel l5=new JLabel("Country");
        l5.setBounds(480,10,90,20);
        add(l5);
        
        JLabel l6=new JLabel("Room No");
        l6.setBounds(590,10,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Checkin time");
        l7.setBounds(690,10,100,20);
        add(l7);
        
        JLabel l8=new JLabel("Deposit");
        l8.setBounds(790,10,100,20);
        add(l8);
        
        
        table=new JTable();
        table.setBounds(0,40,900,400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(400,500,120,30);
        add(back);
        
        setBounds(180,100,900,580);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new CustomerInfo();
    }
}
