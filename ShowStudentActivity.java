/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rahul
 */
public class ShowStudentActivity extends javax.swing.JFrame {

    /**
     * Creates new form ShowStudentActivity
     */
    public ShowStudentActivity() {
        initComponents();
        Connect();
    }
     Connection con;
     PreparedStatement pst;   
     ResultSet rs;
     
     
    
//      public void clear(){
//          name.setText("");
//          fathername.setText("");
//          cname.setText("");
//          
//           cyear.setText("");
//             
//            
//         
//    }
      
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
       
        public void load()
    {     
       
        String splace=sid.getText();
        
      
         
        
        try {
            pst=con.prepareStatement("SELECT  student_name,father_name,course_name,course_year from student where student_id=? ");
            
            pst.setString(1, splace);
        
            
            rs=pst.executeQuery();
            
            if(rs.next()==true)
            {
                name.setText(rs.getString(1));
                 fathername.setText(rs.getString(2));
               cname.setText(rs.getString(3));
                
              cyear.setText(rs.getString(4));
           
             
              
              
             
              
              
            }
      
            
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
            public void validation(){
             String username=sid.getText();
              if(sid.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Please Enter student_id");
       }else{
        
        try{
              
            
                   pst=con.prepareStatement("select * from student where student_id=?");
                    pst.setString(1,username);
                    
                  rs=pst.executeQuery();
                    
                    if(rs.next()){
                        
                       load();
                       
                    }else
                    {
                         JOptionPane.showMessageDialog(this, "Incorrect Student_id !"); 
                    }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
            }
            
           
              
            
                 
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////         
            
               public void loadTableissue()
    {     
       
        String splace=sids.getText();
        
        
         
        
        try {
             pst=con.prepareStatement("select * from issue where student_id=?");
             pst.setString(1, splace);
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
                       v.add(rs.getString("issue_id"));
                       v.add(rs.getString("student_id"));
                       v.add(rs.getString("sbin_id"));
                       v.add(rs.getString("book_id"));
                       v.add(rs.getString("book_name")); 
                       v.add(rs.getString("book_category")); 
                       v.add(rs.getString("book_author")); 
                       v.add(rs.getString("issue_date")); 
                       
                         
                 }
                 
                 d.addRow(v);
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
               
                  public void validationForTableissue(){
             String username=sids.getText();
              if(sids.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Please Enter student_id");
       }else{
        
        try{
              
            
                   pst=con.prepareStatement("select * from issue where student_id=?");
                    pst.setString(1,username);
                    
                  rs=pst.executeQuery();
                    
                    if(rs.next()){
                        
                       loadTableissue();
                       
                    }else
                    {
                         JOptionPane.showMessageDialog(this, "insufficient Data for This id OR may be your id was wrong!"); 
                    }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
            }
    
          
               
               
               
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
               
               
               
               
         public void loadTablereturn()
    {     
       
        String splace=sidss.getText();
        
        
         
        
        try {
             pst=con.prepareStatement("select * from return where student_id=?");
             pst.setString(1, splace);
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            int c;
            c=rsd.getColumnCount();
             DefaultTableModel d = (DefaultTableModel)jTable2.getModel();
             d.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v=new Vector();
                 for(int i=0;i<=c;i++)
                 {
                    v.add(rs.getString("return_id"));
                      v.add(rs.getString("student_id"));
                       v.add(rs.getString("sbin_id"));
                        v.add(rs.getString("book_id"));
                       v.add(rs.getString("book_name")); 
                       v.add(rs.getString("book_category")); 
                       v.add(rs.getString("book_author")); 
                       v.add(rs.getString("return_date")); 
                       
                         
                 }
                 
                 d.addRow(v);
             }
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(Addbooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
                 public void validationForTablereturn(){
             String username=sidss.getText();
              if(sidss.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Please Enter student_id");
       }else{
        
        try{
              
            
                   pst=con.prepareStatement("select * from return where student_id=?");
                    pst.setString(1,username);
                    
                    
                     rs=pst.executeQuery();
                    
                    if(rs.next()){
                        
                       loadTablereturn();
                       
                    }else
                    {
                         JOptionPane.showMessageDialog(this, "insufficient Data for This id OR may be your id was wrong!"); 
                    }
        }catch(Exception e)
        {
            
            e.printStackTrace();
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        fathername = new javax.swing.JLabel();
        cname = new javax.swing.JLabel();
        cyear = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        sids = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        sidss = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ISSUE_ID", "STUDENT_ID", "SBIN_ID", "BOOK_ID", "BOOK_NAME", "BOOK_CATEGORY", "BOOK_AUTHOR", "ISSUE_DATE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 890, 220));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Return Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 190, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Father_name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 100, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Course_name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Course_Year");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 100, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 30));

        name.setText(" ");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 170, 30));

        fathername.setText(" ");
        getContentPane().add(fathername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 200, 30));

        cname.setText(" ");
        getContentPane().add(cname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 180, 30));

        cyear.setText(" ");
        getContentPane().add(cyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 180, 30));
        getContentPane().add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 120, 40));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 70, 40));
        getContentPane().add(sids, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 130, 40));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 70, 40));
        getContentPane().add(sidss, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 130, 40));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, 70, 40));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ISSUE_ID", "STUDENT_ID", "SBIN_ID", "BOOK_ID", "BOOK_NAME", "BOOK_CATEGORY", "BOOK_AUTHOR", "ISSUE_DATE"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 890, 220));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("Show Student Activity");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 420, 60));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Issue Details");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 190, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Student Details");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 190, 40));

        jPanel1.setBackground(new java.awt.Color(255, 51, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1290, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 60));

        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton4.setText("close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 70, -1, -1));

        setSize(new java.awt.Dimension(1306, 740));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        validation();
        
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        validationForTableissue();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        validationForTablereturn();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ShowStudentActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowStudentActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowStudentActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowStudentActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowStudentActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cname;
    private javax.swing.JLabel cyear;
    private javax.swing.JLabel fathername;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel name;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sids;
    private javax.swing.JTextField sidss;
    // End of variables declaration//GEN-END:variables
}
