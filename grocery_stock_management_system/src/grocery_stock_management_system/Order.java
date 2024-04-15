
package grocery_stock_management_system;
//inventory showing code the next is order class this is not order class
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Order extends JFrame implements ActionListener{
    JTable table;
    Choice productnamee;
    JButton search,print,update,back;
    
    Order(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Product Name");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);
        
        productnamee = new Choice();
        productnamee.setBounds(180,20,150,20);
        add(productnamee);
        
        
        table = new JTable();
         try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from additems");
            while(rs.next()){
                 productnamee.add(rs.getString("productname"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from additems");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        
         print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        
        update = new JButton("update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
      
        
        
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == search){
            String query = "select *from additems where productname = '"+productnamee.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == print){
            try{
                
                table.print();
            }catch(Exception e){
              e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            setVisible(false);
            
            new Inventorry(productnamee.getSelectedItem());
            
        }
        else{
            setVisible(true);
            new Home();
        }
    }
    
    public static void main(String[] args){
        
       new Order();
    }
    
}
