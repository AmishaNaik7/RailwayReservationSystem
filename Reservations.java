/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinereservation;

import com.mysql.jdbc.Connection;
import com.sun.glass.events.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kailas
 */
public class Reservations extends javax.swing.JFrame {

    /**
     * Creates new form Reservations
     */
    public Reservations() {
        initComponents();
        connect();
       LoadStartPlace();
       LoadEndPlace();
       Loadclass();
        
    }
    
    Connection con;
    PreparedStatement pst;
     ResultSet rs;
    
    
    
      public void connect() 
                
      {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/reservation","root","");
            } catch (SQLException ex) {
                Logger.getLogger(addtrain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addtrain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      }
      
      public void LoadStartPlace()
       {
           try
           {   
                pst = con.prepareStatement("SELECT StartPlace From details");
                rs =  pst.executeQuery();
                txtsplace.removeAllItems();
                
                
                while(rs.next())
                {
              txtsplace.addItem(rs.getString(1));
                }  
           } 
           
           catch (Exception e)
           {
               e.printStackTrace();
               
           }
       
       }

    
     public void LoadEndPlace()
       {
           try
           {   
                pst = con.prepareStatement("SELECT destinationplace From details");
                rs =  pst.executeQuery();
                txteplace.removeAllItems();
                
                
                while(rs.next())
                {
              txteplace.addItem(rs.getString(1));
                }  
           } 
           
           catch (Exception e)
           {
               e.printStackTrace();
               
           }
       
       }
    
    
     public void Loadclass()
       {
           try
           {   
                pst = con.prepareStatement("SELECT Class From details");
                rs =  pst.executeQuery();
                txtclass.removeAllItems();
                
                
                while(rs.next())
                {
          txtclass.addItem(rs.getString(1));
                }  
           } 
           
           catch (Exception e)
           {
               e.printStackTrace();
               
           }
       
       }
     
     
     
     
     
     
     
    
     
     
         public void load()
      {
      String splace = txtsplace.getSelectedItem().toString();
      String eplace = txteplace.getSelectedItem().toString();
      String Class = txtclass.getSelectedItem().toString();
      
      
      
          try
          
          {
            pst=con.prepareStatement("SELECT * FROM   details where startplace =? and destinationplace = ? and Class = ?");
            pst.setString(1,splace );
            pst.setString(2, eplace);
            pst.setString(3, Class);
            rs =pst.executeQuery();
            
            
            if(rs.next()==true)
            {
            txttno.setText(rs.getString(1));
            txttname.setText(rs.getString(2));
            txtdpart.setText(rs.getString(6));
            txtarr.setText(rs.getString(7));
            txtprice.setText(rs.getString(8));
            }
            else
            {
             JOptionPane.showMessageDialog(this,"Record not found");
             
             
                
            }
          
          }
          catch (Exception e)
          {
              
             e.printStackTrace();
          }
      
          
          
          
      }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtpno = new javax.swing.JTextField();
        txtsplace = new javax.swing.JComboBox<>();
        txteplace = new javax.swing.JComboBox<>();
        txttno = new javax.swing.JTextField();
        txttname = new javax.swing.JTextField();
        txtdpart = new javax.swing.JTextField();
        txtarr = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtticket = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtclass = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reservation");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 197, 23));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Passenger No :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 71, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Start place :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 109, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("End place :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Train No :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Train Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Departs :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Arrives :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Price :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));
        jPanel1.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 162, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(" No of Tickets :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));
        jPanel1.add(txtpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 162, -1));

        jPanel1.add(txtsplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 162, -1));

        txteplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteplaceActionPerformed(evt);
            }
        });
        jPanel1.add(txteplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 162, -1));
        jPanel1.add(txttno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 160, -1));
        jPanel1.add(txttname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 162, -1));
        jPanel1.add(txtdpart, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 162, -1));
        jPanel1.add(txtarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 162, -1));

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 162, -1));

        txtticket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtticketKeyPressed(evt);
            }
        });
        jPanel1.add(txtticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 162, -1));
        jPanel1.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 162, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reserve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 376, 96, 33));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 175, 96, 36));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Class :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        txtclass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(txtclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 160, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kailas\\Desktop\\train images\\reservation.PNG")); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 530));

        setSize(new java.awt.Dimension(785, 563));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String pno = txtpno.getText();
        String splace =txtsplace.getSelectedItem().toString();
        String eplace =txteplace.getSelectedItem().toString();
        String Class = txtclass.getSelectedItem().toString();
       String tno = txttno.getText();
       String tname =txttname.getText();
       String depart =txtdpart.getText();
       String arrives =txtarr.getText();
       String price =txtprice.getText();
    
       SimpleDateFormat date_form = new SimpleDateFormat("yyyy-MM-dd");
     String date= date_form.format(txtdate.getDate());
       
       String ticket =txtprice.getText();
       String tot =txttotal.getText();
       
       
       
        try {
            pst= con.prepareStatement("insert into Reservation(	pno,splace,eplace,Class,tno,tname,depart,arrives,price,date,ticket,tot)values(?,?,?,?,?,?,?,?,?,?,?,?)");
        
            pst.setString(1, pno);
            pst.setString(2, splace);
            pst.setString(3,eplace );
             pst.setString(4,Class );
            pst.setString(5,tno );
            pst.setString(6,tname );
            pst.setString(7,depart );
            pst.setString(8,arrives );
            pst.setString(9,price );
            pst.setString(10,date );
            pst.setString(11,ticket );
            pst.setString(12,tot );
            
            
            int k =pst.executeUpdate();
            
             if(k==1)
            {
                JOptionPane.showMessageDialog(this,"Record Adddedddd");
            }
            else
            {
             JOptionPane.showMessageDialog(this,"Record failed");
             
            }
            
          
        } catch (SQLException ex) {
            Logger.getLogger(addtrain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                 
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        load();
        
        
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtticketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtticketKeyPressed
        // TODO add your handling code here:
        
        int price,ticket,tot;
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        
        {
        price =Integer.parseInt(txtprice.getText());
        ticket =Integer.parseInt(txtticket.getText());
        
        tot = price * ticket;
        txttotal.setText(String.valueOf(tot));
            
        }
        
    }//GEN-LAST:event_txtticketKeyPressed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txteplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteplaceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtarr;
    private javax.swing.JComboBox<String> txtclass;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtdpart;
    private javax.swing.JComboBox<String> txteplace;
    private javax.swing.JTextField txtpno;
    private javax.swing.JTextField txtprice;
    private javax.swing.JComboBox<String> txtsplace;
    private javax.swing.JTextField txtticket;
    private javax.swing.JTextField txttname;
    private javax.swing.JTextField txttno;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
