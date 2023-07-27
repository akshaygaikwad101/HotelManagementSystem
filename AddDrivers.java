package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener{
    
    
    JButton add,cancel;
    JComboBox agecombo,availablecombo,bedcombo;
    JLabel bed,roomprice,clean,roomno,available;
    JTextField tfname,tfcompany,tfage,tfmodel,tfLocation;
    
    AddDrivers(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Driver");
        heading.setFont(new Font("Railway",Font.BOLD,22));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        
        roomno=new JLabel("Name");
        roomno.setFont(new Font("Railway",Font.PLAIN,16));
        roomno.setBounds(60,70,120,30);
        add(roomno);
        
        
        tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        
        available=new JLabel("AGE");
        available.setFont(new Font("Railway",Font.PLAIN,16));
        available.setBounds(60,110,120,30);
        add(available);
        
        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        
        clean=new JLabel("Gender");
        clean.setFont(new Font("Railway",Font.PLAIN,16));
        clean.setBounds(60,150,120,30);
        add(clean);
        
        String cleanOptions[]={"Male","Female"};
        agecombo=new JComboBox(cleanOptions);
        agecombo.setBounds(200,150,150,30);
        agecombo.setBackground(Color.CYAN);
        add(agecombo);
        
        
        
        roomprice=new JLabel("Car Company");
        roomprice.setFont(new Font("Railway",Font.PLAIN,16));
        roomprice.setBounds(60,190,120,30);
        add(roomprice);
        
        
        tfcompany=new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);
        
        
        bed=new JLabel("Car Model");
        bed.setFont(new Font("Railway",Font.PLAIN,16));
        bed.setBounds(60,230,120,30);
        add(bed);
        
        tfmodel=new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);
        
        
        JLabel lblavailable=new JLabel("Available");
        lblavailable.setFont(new Font("Railway",Font.PLAIN,16));
        lblavailable.setBounds(60,270,120,30);
        add(lblavailable);
        
        
        String driverOptions[]={"Available","Busy"};
        availablecombo=new JComboBox(driverOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.CYAN);
        add(availablecombo);
        
        JLabel lbllocation=new JLabel("Location");
        lbllocation.setFont(new Font("Railway",Font.PLAIN,16));
        lbllocation.setBounds(60,310,120,30);
        add(lbllocation);
        
        tfLocation=new JTextField();
        tfLocation.setBounds(200,310,150,30);
        add(tfLocation);
        
        add=new JButton("Add Driver");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.CYAN);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);
        
        
        cancel=new JButton("Cancel Driver");
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(Color.CYAN);
        cancel.setBounds(200,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,70,500,300);
        add(image);
        
        
        setBounds(250,160,980,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String)agecombo.getSelectedItem();
            String company=tfcompany.getText();
            String brand=tfmodel.getText();
            String available=(String)availablecombo.getSelectedItem();
            String location=tfLocation.getText();
            
            try{
                
                Conn conn=new Conn();
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "new Driver Added Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
     
    public static void main(String[] args){
        new AddDrivers();
    }
    
}

