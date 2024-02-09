/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import java.sql.*;
 
 import JFrame.DBconnection;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rahul
 */
public class Addbooks extends javax.swing.JFrame {

    
    /**
     * Creates new form Addbooks
     */
    
    public Addbooks() {
          initComponents();
       Connect();
       load();
    }
    
     Connection con;
     PreparedStatement pst;   
     ResultSet rs;
    
     
    public void Connect()  
   {
       
        try {
            Class.forName("oracle.jdbc.OracleDriver");
              String url="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
               con=DriverManager.getConnection(url,"system","rahul123");
             
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
        }          
            
        
  }
    public void loadplsql(){
        String plsql=Bookids.getText();
        if(Bookids.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Valid Book_id For Check Quantity!");
            PLSQL.setVisible(false);
        } else 
        {
        try{
            pst=con.prepareStatement("select count(*) from books where book_id=?");
            pst.setString(1, plsql);
            rs=pst.executeQuery();
            if(rs.next()){
                PLSQL.setText(rs.getString(1));
            }
            else{
                JOptionPane.showMessageDialog(this, "Incorrect Book_id!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }
    
    public void load()
    {
        try {
            pst=con.prepareStatement("select book_id,book_category,book_name,book_author,book_date,sbin_id from books");
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            int c;
            c=rsd.getColumnCount();
             DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
             d.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v=new Vector();
                 for(int i=0;i<=c;i++)
                 {
                    v.add(rs.getString("book_id"));
                      v.add(rs.getString("book_category"));
                       v.add(rs.getString("book_name"));
                        v.add(rs.getString("book_author"));
                       v.add(rs.getString("book_date")); 
                       v.add(rs.getString("sbin_id"));
                        
                       
                         
                 }
                 
                 d.addRow(v);
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void Clears(){
         books.setText("");
         category.setText("");
         names.setText("");
         author.setText("");
         date.setDateFormatString("");
         sbinid.setText("");
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
        category = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        names = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        books = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        author = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        addbooks = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        date = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        sbinid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        PLSQL = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Bookids = new javax.swing.JTextField();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Your Books");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 0, 301, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1186, 64));

        category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 186, 290, 40));

        jLabel3.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel3.setText("Category");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 189, 100, -1));

        names.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(names, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 288, 290, 40));

        jLabel4.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel4.setText("Book_name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 291, 130, -1));

        books.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(books, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 95, 290, 40));

        jLabel5.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel5.setText("Book_id");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, 90, -1));

        author.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorActionPerformed(evt);
            }
        });
        getContentPane().add(author, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 383, 290, 40));

        jLabel7.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel7.setText("Author");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 382, 90, -1));

        clear.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        clear.setText("Back");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 690, 150, 50));

        addbooks.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addbooks.setText("Add book");
        addbooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbooksActionPerformed(evt);
            }
        });
        getContentPane().add(addbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 150, 50));

        edit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 690, 150, 50));

        delete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 690, 160, 50));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 690, 150, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "book_id", "book_category", "book_name", "book_author", "date", "sbin_id"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 723, 564));
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 462, 290, 43));

        jLabel8.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel8.setText("Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 462, 90, -1));

        sbinid.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        getContentPane().add(sbinid, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 555, 290, 47));

        jLabel10.setFont(new java.awt.Font("Mangal", 1, 21)); // NOI18N
        jLabel10.setText("Sbin_id");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 90, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Fetch Qty of Books");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 330, 140, 30));

        PLSQL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PLSQL.setText(" ");
        getContentPane().add(PLSQL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 290, 30, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("=");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 290, 20, -1));

        Bookids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookidsActionPerformed(evt);
            }
        });
        getContentPane().add(Bookids, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 290, 70, 30));

        back.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        back.setText("Clear");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 690, 150, 50));

        setSize(new java.awt.Dimension(1391, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
      
        this.dispose();
        
    }//GEN-LAST:event_clearActionPerformed

    private void addbooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbooksActionPerformed
        // TODO add your handling code here:
          String bookid=books.getText();
          String categories=category.getText();
          String name=names.getText();
          String authors=author.getText();
          SimpleDateFormat date_form=new SimpleDateFormat("DD-MM-YYYY");
          String dates=date_form.format(date.getDate());
          String qnts=sbinid.getText();
        
    
        

        
      
        try {
            Connection con=DBconnection.getConnection();
             Statement st=con.createStatement();
          
             int k    =  st.executeUpdate("insert into books (book_id,book_category,book_name,book_author,book_date,sbin_id)values('"+bookid+"','"+categories+"','"+name+"','"+authors+"','"+dates+"','"+qnts+"')");
             if(k==1)
             {
                 JOptionPane.showMessageDialog(this, "Book Added Successfully");
       
             }else
             {
                  JOptionPane.showMessageDialog(this, "Failed to Add book");
             }
            
        
         addbooks.setEnabled(true);
    
        
        }   
          catch (SQLException ex) {
              JOptionPane.showMessageDialog(this, "Book Allready exist");
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
       
              
          } 
        
        
    }//GEN-LAST:event_addbooksActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
         String bookid=books.getText();
        String categories=category.getText();
        String name=names.getText();
        String authorS=author.getText();
          SimpleDateFormat date_form=new SimpleDateFormat("YYYY-DD-MM");
        String dates=date_form.format(date.getDate());
          String qnts=sbinid.getText();
          
       
        
       
        try {
             pst= con.prepareStatement("update books set book_id=?,book_category=?,book_name=?,book_author=?,book_date=? where  sbin_id=?");
            
           pst.setString(1, bookid);
            pst.setString(2,categories);
            pst.setString(3,name);
            pst.setString(4,authorS);
            pst.setString(5,dates);
            pst.setString(6, qnts);
             
           
           
             
            int k= pst.executeUpdate();
            
            if(k==1)
            {
   
                 JOptionPane.showMessageDialog(null,"Record Updated Successfully");
            }
            else 
            {
                JOptionPane.showMessageDialog(null ,"Record  Failed");
            }
         
//        else
//            {
//                JOptionPane.showMessageDialog(this,"Record Can't Added");
//            }
//        
                
                 
         books.setText("");
         category.setText("");
         names.setText("");
         author.setText("");
         date.setDateFormatString("");
         sbinid.setText("");
        
         books.requestFocus();
         
        
         load();
         edit.setEnabled(true);
        }   
          catch (SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
          } 
    }//GEN-LAST:event_editActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
        
        int selectIndex=jTable1.getSelectedRow();
        
        books.setText(d.getValueAt(selectIndex,0).toString());
        category.setText(d.getValueAt(selectIndex,1).toString());
        names.setText(d.getValueAt(selectIndex,2).toString());
        author.setText(d.getValueAt(selectIndex,3).toString());
        date.setDateFormatString(d.getValueAt(selectIndex,4).toString());
        sbinid.setText( d.getValueAt(selectIndex, 5).toString());
    
        
        
        
       addbooks.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
         String book_id=sbinid.getText();
       
        
        
       
        try {
             pst= con.prepareStatement("delete from books where sbin_id=? ");
            pst.setString(1,book_id);
          
            
            int k= pst.executeUpdate();
            
            
            if(k==1)
            {
   
                 JOptionPane.showMessageDialog(this,"Record Deleted Successfully");
            }
            else 
            {
                JOptionPane.showMessageDialog(this ,"Record  Failed");
            }
         
//        else
//            {
//                JOptionPane.showMessageDialog(this,"Record Can't Added");
//            }
//        
                
       books.setText("");
         category.setText("");
         names.setText("");
         author.setText("");
         date.setDateFormatString("");
         sbinid.setText("");
         
         books.requestFocus();
       load();
       delete.setEnabled(true);
         
        
        }   
          catch (SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
          } 
    }//GEN-LAST:event_deleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        loadplsql();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BookidsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookidsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookidsActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        Clears();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Addbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addbooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Bookids;
    private javax.swing.JLabel PLSQL;
    private javax.swing.JButton addbooks;
    private javax.swing.JTextField author;
    private javax.swing.JButton back;
    private javax.swing.JTextField books;
    private javax.swing.JTextField category;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField names;
    private javax.swing.JTextField sbinid;
    // End of variables declaration//GEN-END:variables
}
