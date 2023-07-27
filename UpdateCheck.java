package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom,tfname,tftime,tfdeposit,tfpending;
    JButton Check,Update,Back;
    
    UpdateCheck(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        lblroom.setBounds(30,120,100,30);
        add(lblroom);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);
        
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,160,100,30);
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        
        JLabel lbltime=new JLabel("Checkin time");
        lbltime.setBounds(30,200,100,30);
        add(lbltime);
        
        tftime=new JTextField();
        tftime.setBounds(200,200,150,25);
        add(tftime);
        
        JLabel lbldeposit=new JLabel("Amount Paid");
        lbldeposit.setBounds(30,240,100,30);
        add(lbldeposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,240,150,25);
        add(tfdeposit);
        
        JLabel lblPending=new JLabel("Pending Amount");
        lblPending.setBounds(30,280,100,30);
        add(lblPending);
        
        tfpending=new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);
        
        Check=new JButton("Check");
        Check.setBackground(Color.CYAN);
        Check.setForeground(Color.BLACK);
        Check.setBounds(30,340,100,30);
        Check.addActionListener(this);
        add(Check);
        
        Update=new JButton("Update");
        Update.setBackground(Color.CYAN);
        Update.setForeground(Color.BLACK);
        Update.setBounds(140,340,100,30);
        Update.addActionListener(this);
        add(Update);
        
        
        Back=new JButton("Back");
        Back.setBackground(Color.CYAN);
        Back.setForeground(Color.BLACK);
        Back.setBounds(250,340,100,30);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(200,130,980,500);
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
                    tfname.setText(rs.getString("name"));
                    tftime.setText(rs.getString("checkintime"));
                    tfdeposit.setText(rs.getString("deposit"));
                }
                
                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    int amountPaid=Integer.parseInt(price)-Integer.parseInt(tfdeposit.getText());
                    tfpending.setText(""+amountPaid);
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==Update){
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String checkin=tftime.getText();
            String deposit=tfdeposit.getText();
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update customer set room='"+room+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+deposit+"' where number='"+number+"'");
                
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
        new UpdateCheck();
    }
    
}