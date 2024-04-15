
package grocery_stock_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Remove extends JFrame implements ActionListener {
    Choice cpname;
    JButton delete,back;
    Remove(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelpname = new JLabel("product name");
        labelpname.setBounds(50,50,100,30);
        add(labelpname);
        
        cpname = new Choice();
        cpname.setBounds(200,50,150,30);
        add(cpname);
        
        
        try{
            
            Conn c = new Conn();
            String query = "select * from additems";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
            cpname.add(rs.getString("productname"));
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        
        }
        JLabel labelprice = new JLabel("product price");
        labelprice.setBounds(50,100,100,30);
        add(labelprice);
        
        JLabel lblprice = new JLabel();
        lblprice.setBounds(200,100,100,30);
        add(lblprice);
        
        JLabel labelquan = new JLabel("Quantity");
        labelquan.setBounds(50,150,100,30);
        add(labelquan);
        
        JLabel lblquan = new JLabel();
        lblquan.setBounds(200,150,100,30);
        add(lblquan);
        
        JLabel labeldate = new JLabel("Date");
        labeldate.setBounds(50,200,100,30);
        add(labeldate);
        
        JLabel lbldate = new JLabel();
        lbldate.setBounds(200,200,100,30);
        add(lbldate);
        
        
         try{
            Conn c = new Conn();
            String query = "select * from additems where productname='"+cpname.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                lblprice.setText(rs.getString("price"));
                 lblquan.setText(rs.getString("quantity"));
                  lbldate.setText(rs.getString("datee"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        
        }
         
        cpname.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    try{
            Conn c = new Conn();
            String query = "select * from additems where productname='"+cpname.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                lblprice.setText(rs.getString("price"));
                 lblquan.setText(rs.getString("quantity"));
                  lbldate.setText(rs.getString("datee"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        
        }
                    
                 
                }
    
    });
        
        
        delete  = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        
        back  = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,1050,500);
        add(image);
        
        
        
       setSize(1000,400);
       setLocation(300,150);
       setVisible(true);
       
     
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Conn c =new Conn();
                String query ="delete from additems where productname='"+cpname.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Deleted successfully");
                setVisible(false);
                new Home();
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        }
        else{
        setVisible(false);
        new Home();
        
        }
    }
    
    public static void main(String[] args){
        
        new Remove();
    }
}
