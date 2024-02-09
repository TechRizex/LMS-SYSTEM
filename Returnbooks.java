/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import java.sql.*;
import java.sql.Connection;
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
 * @author Rahul
 */
public class Returnbooks extends javax.swing.JFrame {

    /**
     * Creates new form Returnbooks
     */
    public Returnbooks() {
        initComponents();
        Connect();
        
//        sbin_id();
//        student_id();
    }
     Connection con;
     PreparedStatement pst;   
     ResultSet rs;
    
      public void clear(){
          return_id.setText("");
          Student_id.setText("");
          sbin_id.setText("");
          book_id.setText("");
          book_name.setText("");
          
           book_cat.setText("");
            book_author.setText("");
             
            
         
    }
    
      
       public void validationForTablereturn(){
             String username=return_id.getText();
               
        
        try{
              
            
                   pst=con.prepareStatement("select * from issue where issue_id=?");
                    pst.setString(1,username);
                    
                    
                     rs=pst.executeQuery();
                    
                    if(rs.next()){
                        
                       load();
                       
                    }else
                    {
                         JOptionPane.showMessageDialog(this, "Please Enter Correct Return id!"); 
                    }
        }catch(Exception e)
        {
            
            e.printStackTrace();
        }
       }
    
      
     
     
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
          
     
        
//    public void  sbin_id()
//    {
//        try {
//            pst=con.prepareStatement("select sbin_id  from issue");
//            rs=pst.executeQuery();
//           sbi_id.removeAllItems();
//            while(rs.next())
//            {
//                sbi_id.addItem(rs.getString(1));
//            }
//        } catch (Exception e) {
//           e.printStackTrace();
//        }
//        
//    }
//     public void  student_id()
//    {
//        try {
//            pst=con.prepareStatement("select student_id  from issue");
//            rs=pst.executeQuery();
//           stuid.removeAllItems();
//            while(rs.next())
//            {
//                stuid.addItem(rs.getString(1));
//            }
//        } catch (Exception e) {
//           e.printStackTrace();
//        }
//        
//    }
    
     
  
    public void load()
    {     
       
        String returnid=return_id.getText();
        
        
     if(return_id.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Please Enter Return id!");
     }
         
     else{
         
        
        try {
            pst=con.prepareStatement("SELECT   student_id ,sbin_id,book_id, book_name,book_category,book_author  from issue where issue_id=?");
            
            pst.setString(1, returnid);
         
        
            
            rs=pst.executeQuery();
            
            if(rs.next()==true)
            {
                 Student_id.setText(rs.getString(1));
                 sbin_id.setText(rs.getString(2));
                 book_id.setText(rs.getString(3));
               book_name.setText(rs.getString(4));
                
              book_cat.setText(rs.getString(5));
              book_author.setText(rs.getString(6));
             
              
              
             
              
              
            } 
      
            
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    }
    
     
    public void  returnbook(){
        String returnid=return_id.getText();
        String stud=Student_id.getText();
       String SBIN=sbin_id.getText();
        String bookid=book_id.getText();
          String BKNAME=book_name.getText();
        
           String bookcategory=book_cat.getText();
           String bookauthor=book_author.getText();
           SimpleDateFormat date_form=new SimpleDateFormat("YYYY-MM-DD");
           String dates=date_form.format(duedate.getDate());
       
            
           if(book_name.getText().isEmpty()||book_cat.getText().isEmpty()||book_author.getText().isEmpty()||book_id.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(this,"Please Click Search Button!");
           } else 

        
         
        try {
             pst= con.prepareStatement("insert into return values(?,?,?,?,?,?,?,?)");
             pst.setString(1, returnid);
           pst.setString(2, stud);
             pst.setString(3,SBIN);
            pst.setString(4,bookid);
           
            pst.setString(5,BKNAME);
            pst.setString(6, bookcategory);
            
            pst.setString(7,bookauthor);
            pst.setString(8,dates);
             
            
            int k= pst.executeUpdate();
            

                if(k==1){
                   
                                   
                           JOptionPane.showMessageDialog(this,"Book Return  Successfully");
                     
                }
                      
                    
                else
                {
                     JOptionPane.showMessageDialog(null,"Failed to Return Books");

                }
                
        }
        
          catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"This Book Already Return");
             
        Logger.getLogger(Returnbooks.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sbinid = new javax.swing.JLabel();
        returnbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        duedate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        avlbookno = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        return_id = new javax.swing.JTextField();
        book_author = new javax.swing.JLabel();
        Student_id = new javax.swing.JLabel();
        sbin_id = new javax.swing.JLabel();
        book_id = new javax.swing.JLabel();
        book_name = new javax.swing.JLabel();
        book_cat = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Return your Book");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 301, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1270, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Book ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 90, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Book_name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, -1, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Book_Category");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Book_Author");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, -1, 30));

        sbinid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sbinid.setText("Sbin_id");
        getContentPane().add(sbinid, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 100, -1));

        returnbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        returnbtn.setText("Return");
        returnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbtnActionPerformed(evt);
            }
        });
        getContentPane().add(returnbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 680, 120, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 670, 90, 40));
        getContentPane().add(duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, 290, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Return_date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, 104, -1));

        avlbookno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        avlbookno.setText(" ");
        getContentPane().add(avlbookno, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Student ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Enter Your Return_id");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));
        getContentPane().add(return_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 200, 40));

        book_author.setText(" ");
        getContentPane().add(book_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 190, 30));

        Student_id.setText(" ");
        getContentPane().add(Student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 190, 30));

        sbin_id.setText(" ");
        getContentPane().add(sbin_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 190, 30));

        book_id.setText(" ");
        getContentPane().add(book_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 190, 30));

        book_name.setText(" ");
        getContentPane().add(book_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 190, 30));

        book_cat.setText(" ");
        getContentPane().add(book_cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 240, 200, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 680, 90, 40));

        setSize(new java.awt.Dimension(1282, 767));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
       validationForTablereturn();
    }//GEN-LAST:event_searchActionPerformed

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        // TODO add your handling code here:
 
                
                returnbook();
                clear();
           
        
        

    }//GEN-LAST:event_returnbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Returnbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Returnbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Returnbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Returnbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Returnbooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Student_id;
    private javax.swing.JLabel avlbookno;
    private javax.swing.JLabel book_author;
    private javax.swing.JLabel book_cat;
    private javax.swing.JLabel book_id;
    private javax.swing.JLabel book_name;
    private com.toedter.calendar.JDateChooser duedate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField return_id;
    private javax.swing.JButton returnbtn;
    private javax.swing.JLabel sbin_id;
    private javax.swing.JLabel sbinid;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
