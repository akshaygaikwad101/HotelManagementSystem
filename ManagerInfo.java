package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;


public class ManagerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    ManagerInfo(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
       
        
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(40,10,90,20);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(150,10,80,20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(240,10,90,20);
        add(l3);
        
        JLabel l4=new JLabel("Job");
        l4.setBounds(360,10,90,20);
        add(l4);
        
        JLabel l5=new JLabel("Salary");
        l5.setBounds(480,10,90,20);
        add(l5);
        
        JLabel l6=new JLabel("Mobile No");
        l6.setBounds(590,10,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Email");
        l7.setBounds(690,10,100,20);
        add(l7);
        
        JLabel l8=new JLabel("Document ID");
        l8.setBounds(790,10,100,20);
        add(l8);
        
        
        table=new JTable();
        table.setBounds(0,40,900,400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee where job='Manager'");
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
        new ManagerInfo();
    }
}
