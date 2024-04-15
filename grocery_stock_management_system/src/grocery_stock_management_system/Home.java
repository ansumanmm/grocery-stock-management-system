
package grocery_stock_management_system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton add,order,inventory,delete;
    Home(){
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/groc.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading = new JLabel("Grocerry management system");
        heading.setBounds(650,20,400,40);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
        image.add(heading);
        
         add = new JButton("Add new Items");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
          
          order = new JButton("Inventory");
        order.setBounds(820,80,150,40);
        order.addActionListener(this);
        image.add(order);
        
          inventory = new JButton("Order");
        inventory.setBounds(650,140,150,40);
        inventory.addActionListener(this);
        image.add(inventory);
        
          delete = new JButton("remove Items");
        delete.setBounds(820,140,150,40);
        delete.addActionListener(this);
        image.add(delete);
        
       setSize(1120,630);
       setLocation(250,100);
       setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
        setVisible(false);
        new AddItems();
    }else if(ae.getSource() == order){
        setVisible(false);
        new Order();
    }else if(ae.getSource() == inventory){
         setVisible(false);
         new Order();
    }else{
        setVisible(false);
        new Remove();
    }
    }
    public static void main(String[] args){
       new Home();
    }
}
