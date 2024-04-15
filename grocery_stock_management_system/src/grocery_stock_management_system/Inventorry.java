
package grocery_stock_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Inventorry extends JFrame implements ActionListener{
    JTextField tfname,tfprice,tfqun,tfdate;
    JButton add,back;
    
    String prod;
    Inventorry(String prod){
        this.prod = prod;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Product Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Product name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
         tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel labelprice = new JLabel("Price");
        labelprice.setBounds(400,150,150,30);
        labelprice.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelprice);
        
         tfprice = new JTextField();
        tfprice.setBounds(500,150,150,30);
        add(tfprice);
        
        
         JLabel labelquantity = new JLabel("Quantity");
        labelquantity.setBounds(50,200,150,30);
        labelquantity.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelquantity);
        
         tfqun = new JTextField();
        tfqun.setBounds(200,200,150,30);
        add(tfqun);
        
        
         JLabel labeldate = new JLabel("Date");
        labeldate.setBounds(400,200,150,30);
        labeldate.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldate);
        
         tfdate = new JTextField();
        tfdate.setBounds(500,200,150,30);
        add(tfdate);
        
        
        try{
            Conn c = new Conn();
            String query = "select *from additems where productname = '"+prod+"'";
            ResultSet rs =  c.s.executeQuery(query);
            
            while(rs.next()){
              
               tfname.setText(rs.getString("productname"));
               
               tfprice.setText(rs.getString("price"));
               
               tfqun.setText(rs.getString("quantity"));
               
               tfdate.setText(rs.getString("date"));
            
            }
        }
        catch(Exception e){
           e.printStackTrace();
           
        }
        
        
        add = new JButton("Update Details");;
       add.setBounds(250,550,150,40);
       add.addActionListener(this);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add(add);
       
        back = new JButton("Back");;
       back.setBounds(450,550,150,40);
       back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       add(back);
        
        
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == add){
           String name = tfname.getText();
           String price = tfprice.getText();
           String Quantity = tfqun.getText();
           String date = tfdate.getText();
           
           
           try{
               Conn conn = new Conn();
               String query="update additems set productname = '"+name+"',price = '"+price+"',quantity = '"+Quantity+"',datee = '"+date+"'";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Details updated Successfully");
               setVisible(false);
               new Home();
           }catch(Exception e){
              e.printStackTrace();
           }
       }
       else{
           setVisible(true);
           new Home();
       }
    }
    public static void main(String[] args){
      new Inventorry("");
    }
}
