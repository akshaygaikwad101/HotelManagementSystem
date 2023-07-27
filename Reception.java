
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    
    
    JButton newbut,rooms,department,allEmployee,customers,managerInfo,checkout,update,roomStatus;
    JButton pickup,search,logout;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newbut=new JButton("New Customer Form");
        newbut.setBounds(10,30,200,30);
        newbut.addActionListener(this);
        add(newbut);
        
        
        rooms=new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.addActionListener(this);
        add(rooms);
        
        
        department=new JButton("Department");
        department.setBounds(10,110,200,30);
        department.addActionListener(this);
        add(department);
        
        
        allEmployee=new JButton("All Employee");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        
        customers=new JButton("Customers Info");
        customers.setBounds(10,190,200,30);
        customers.addActionListener(this);
        add(customers);
        
        
        managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        checkout=new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.addActionListener(this);
        add(checkout);
        
        
        update=new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.addActionListener(this);
        add(update);
        
        
        roomStatus=new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        
        pickup=new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.addActionListener(this);
        add(pickup);
        
        
        search=new JButton("Search Room");
        search.setBounds(10,430,200,30);
        search.addActionListener(this);
        add(search);
        
        
        logout=new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.addActionListener(this);
        add(logout);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
                
                
                
        setBounds(350,120,780,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newbut){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource()==department){
            setVisible(false);
            new Department();
        }else if(ae.getSource()==allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }else if(ae.getSource()==managerInfo){
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource()==customers){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()==search){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource()==roomStatus){
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource()==pickup){
            setVisible(false);
            new SearchDriver();
        }else if(ae.getSource()==checkout){
            setVisible(false);
            new CheckOut();
        }else if(ae.getSource()==logout){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Reception();
    }
}
