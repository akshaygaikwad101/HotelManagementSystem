package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus,tfdeposit,tfpending;
    JButton Check,Update,Back;
    
    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lblid=new JLabel("Customer ID");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number")); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);
        
        
        JLabel lblname=new JLabel("Availability");
        lblname.setBounds(30,180,100,30);
        add(lblname);
        
        tfavailable=new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);
        
        
        JLabel lbltime=new JLabel("Cleaning Status");
        lbltime.setBounds(30,230,100,30);
        add(lbltime);
        
        tfstatus=new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);
        
        
        Check=new JButton("Check");
        Check.setBackground(Color.CYAN);
        Check.setForeground(Color.BLACK);
        Check.setBounds(30,300,100,30);
        Check.addActionListener(this);
        add(Check);
        
        Update=new JButton("Update");
        Update.setBackground(Color.CYAN);
        Update.setForeground(Color.BLACK);
        Update.setBounds(140,300,100,30);
        Update.addActionListener(this);
        add(Update);
        
        
        Back=new JButton("Back");
        Back.setBackground(Color.CYAN);
        Back.setForeground(Color.BLACK);
        Back.setBounds(250,300,100,30);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(200,130,980,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Check){
            
            String id=ccustomer.getSelectedItem();
            String query="Select * from customer where number='"+id+"'";
            
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }
                
                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next()){
                   tfavailable.setText(rs2.getString("availability"));
                   tfstatus.setText(rs2.getString("cleaning_status"));
                    
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==Update){
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String available=tfavailable.getText();
            String status=tfstatus.getText(); 
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set availability='"+available+"',cleaning_status='"+status+"' where roomnumber='"+room+"'");
                
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main (String[] args){
        new UpdateRoom();
    }
    
}