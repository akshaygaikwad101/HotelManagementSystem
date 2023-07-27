package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    
    SearchRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Search fro Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,22));
        text.setBounds(400,30,200,30);
        add(text);
        
        
        JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        bedtype=new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.white);
        add(bedtype);
        
        available=new JCheckBox("Display Available Rooms");
        available.setBounds(650,100,160,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        
        JLabel l1=new JLabel("Room No");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Status");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(650,160,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(850,160,100,20);
        add(l5);
        
        
        table=new JTable();
        table.setBounds(0,200,950,300);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        submit=new JButton("submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,500,120,30);
        add(submit);
        
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500,500,120,30);
        add(back);
        
        
        
        setBounds(180,100,950,580);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
            try{
                
                String query1="select * from room where bed_type='"+bedtype.getSelectedItem()+"'";
                String query2="select * from room where availability='Available' AND '"+bedtype.getSelectedItem()+"'";
                
                Conn conn=new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs=conn.s.executeQuery(query2);
                }else{
                    rs=conn.s.executeQuery(query1);
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new SearchRoom();
    }
}
