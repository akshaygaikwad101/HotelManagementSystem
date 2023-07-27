
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    
    JButton add,cancel;
    JComboBox cleancombo,availablecombo,bedcombo;
    JLabel bed,roomprice,clean,roomno,available;
    JTextField room,price;
    
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Railway",Font.BOLD,22));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        
        roomno=new JLabel("Room Number");
        roomno.setFont(new Font("Railway",Font.PLAIN,16));
        roomno.setBounds(60,80,120,30);
        add(roomno);
        
        
        room=new JTextField();
        room.setBounds(200,80,150,30);
        add(room);
        
        
        available=new JLabel("Available");
        available.setFont(new Font("Railway",Font.PLAIN,16));
        available.setBounds(60,130,120,30);
        add(available);
        
        String availableOptions[]={"Available","Occupied"};
        availablecombo=new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.CYAN);
        add(availablecombo);
        
        
        clean=new JLabel("Cleaning Status");
        clean.setFont(new Font("Railway",Font.PLAIN,16));
        clean.setBounds(60,180,120,30);
        add(clean);
        
        String cleanOptions[]={"Clean","Not Clean"};
        cleancombo=new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.CYAN);
        add(cleancombo);
        
        
        
        roomprice=new JLabel("Room Price");
        roomprice.setFont(new Font("Railway",Font.PLAIN,16));
        roomprice.setBounds(60,230,120,30);
        add(roomprice);
        
        
        price=new JTextField();
        price.setBounds(200,230,150,30);
        add(price);
        
        
        bed=new JLabel("Bed Type");
        bed.setFont(new Font("Railway",Font.PLAIN,16));
        bed.setBounds(60,280,120,30);
        add(bed);
        
        String bedOptions[]={"Single Bed","Double Bed"};
        bedcombo=new JComboBox(bedOptions);
        bedcombo.setBounds(200,280,150,30);
        bedcombo.setBackground(Color.CYAN);
        add(bedcombo);
        
        
        add=new JButton("Add Room");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.CYAN);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        
        cancel=new JButton("Cancel Room");
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(Color.CYAN);
        cancel.setBounds(200,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,70,500,300);
        add(image);
        
        
        setBounds(280,160,940,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomnumber=room.getText();
            String ava=(String)availablecombo.getSelectedItem();
            String status=(String)cleancombo.getSelectedItem();
            String sprice=price.getText();
            String type=(String) bedcombo.getSelectedItem();
            
            try{
                
                Conn conn=new Conn();
                String str="insert into room values('"+roomnumber+"','"+ava+"','"+status+"','"+sprice+"','"+type+"')";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "new Room Added Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
     
    public static void main(String[] args){
        new AddRooms();
    }
    
}
