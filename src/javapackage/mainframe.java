/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapackage;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javapackage.Product;
public final class mainframe extends javax.swing.JFrame {

    private int Pos;
    private int pos;

    /**
     * Creates new form mainframe
     */
    public mainframe() {
        initComponents();
        Connection Connection = getConnection(); /*connection*/
        Show_Product_In_JTable();
    }
    public Connection getConnection()
    {
       Connection con = null;
                  
       
        try {
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","aman");
       return con;
        } catch (SQLException ex) {
            Logger.getLogger(mainframe.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
        
    }
    //Check Input Fields
    
       public boolean CheckInputs()
       {
           if(txt_id.getText()==null
              ||txt_name.getText()==null
              ||txt_price.getText()==null
              ||txt_adddate ==null
             ){
               return false;
               
           }
           else {
               try{
                   Float.parseFloat(txt_price.getText());
                   return true;
               } catch(Exception ex)
               {
                   return false;
               }
           }
       } 
      //To display code in JTable:
       //1-Fill Array List with data
       
    /**
     *
     * @return
     */
    public ArrayList<Product> getProductList()
    {
            ArrayList<Product> productList  = new ArrayList<Product>();
            Connection con = getConnection();
            String query = "SELECT * FROM product";
            
            Statement st;
            ResultSet rs;
            
        try {
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            
            while(rs.next())
            {
                product = new Product(rs.getInt("id"),rs.getString("name"),Float.parseFloat(rs.getString("price")),rs.getString("add_date"));
                productList.add(product);
            }
            
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        
        return productList; 
                }
       
            
      
       
       
       // 2- Populate the table

    /**
     *
     */
       public final void Show_Product_In_JTable()
       {
           ArrayList<Product> list= (ArrayList<Product>) getProductList();
           DefaultTableModel model= (DefaultTableModel)JTable_products.getModel();
           
           Object[] row= new Object[4];
           for(int i=0;i < list.size();i++)
           {
               row[0] = list.get(i).getId();
               row[1] = list.get(i).getName();
               row[2] = list.get(i).getPrice();
               row[3] = list.get(i).getAddDate();
               model.addRow(row); 
           }
       }
       
       public void ShowItem(int index)
       {
        try {
            txt_id.setText(Integer.toString(getProductList().get(index).getId()));
            txt_name.setText(getProductList().get(index).getName());
            txt_price.setText(Float.toString(getProductList().get(index).getPrice()));
            Date addDate = null;
            addDate = new SimpleDateFormat("YYYY-MM-DD").parse((String)getProductList().get(index).getAddDate());
            txt_adddate.setDate(addDate);
            
            
        } catch (ParseException ex) {
            Logger.getLogger(mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
           
           
           
       }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_products = new javax.swing.JTable();
        btn_insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_adddate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Price:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Add date:");

        JTable_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PRICE", "Add Date"
            }
        ));
        JTable_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_productsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_products);

        btn_insert.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        btn_insert.setText("INSERT");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_back.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        btn_back.setText("BACK");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        btn_clear.setText("CLEAR");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_first.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        btn_first.setText("FIRST");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_last.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        btn_last.setText("LAST");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("PRODUCT RECORDS HANDLER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_name)
                            .addComponent(txt_id)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txt_adddate, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_price, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_back, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_first, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel5)
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txt_adddate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(btn_insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_first)
                            .addComponent(btn_last, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_back)
                            .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(130, 130, 130))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(CheckInputs() && txt_id.getText()!=null );
        {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            
            
                try {
                    UpdateQuery = "Update product set name = ?, price = ?"+", add_date = ? where id = ?";
                    ps=con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1,txt_name.getText());
                    ps.setString(2,txt_price.getText());
                    
                    SimpleDateFormat  dateFormat = new SimpleDateFormat("YYYY-MM-DD");
                     String addDate = dateFormat.format(txt_adddate.getDate());
                     ps.setString(3, addDate);
                     ps.setInt(4, Integer.parseInt(txt_id.getText()));
                     ps.executeUpdate();
                     DefaultTableModel model = (DefaultTableModel) JTable_products.getModel();
                   model.setRowCount(0);
                   Show_Product_In_JTable();
                    
                    
                } 
                catch (Exception ex) 
                {
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
         
                
                        
                        
        
                
             
            
           
               
           
             
             
            
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
      
        if(CheckInputs())
        {
         try {
                 Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUCT(id,name,price,add_date)"+"values(?,?,?,?)");
                   ps.setString(1,txt_id.getText());
                   ps.setString(2,txt_name.getText());
                   ps.setString(3,txt_price.getText());
             
                   SimpleDateFormat dateFormat= new SimpleDateFormat("YYYY-MM-DD");
                   String adddate = dateFormat.format(txt_adddate.getDate());
                   ps.setString(4,adddate);
                   ps.executeUpdate();
                   DefaultTableModel model = (DefaultTableModel) JTable_products.getModel();
                   model.setRowCount(0);
                   Show_Product_In_JTable();
                 
                   
                      JOptionPane.showMessageDialog(null,"DATA INSERTED");
                   
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"One or More Text Fields are Empty");
        }
         System.out.println("Name=>"+txt_name.getText());
         System.out.println("Price=>"+txt_price.getText());
         System.out.println("Id=>"+txt_id.getText());
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
      
        if(!txt_id.getText().equals(""))
          
            try {
                Connection con = getConnection();
                
                PreparedStatement ps= con.prepareStatement("DELETE FROM PRODUCT WHERE id=?");
                        
                        int id = Integer.parseInt(txt_id.getText());
                        ps.setInt(1,id);
                        ps.executeUpdate();
                         DefaultTableModel model = (DefaultTableModel) JTable_products.getModel();
                   model.setRowCount(0);
                   Show_Product_In_JTable();
                        JOptionPane.showMessageDialog(null,"Product deleted");
                        
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(mainframe.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null,"Product Not deleted");
            }
        
             else
            {
                    JOptionPane.showMessageDialog(null,"Product Not deleted:Enter Product ID to delete product");
                    }
        
                     
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void JTable_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_productsMouseClicked
        
        int index = JTable_products.getSelectedRow();
        ShowItem(index);
        
    }//GEN-LAST:event_JTable_productsMouseClicked

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        pos=0;
                ShowItem(pos);
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        pos = getProductList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
       pos--;
       if(pos<0)
       {
           pos = 0;
       }
       ShowItem(pos);
               
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_id.setText("");
        txt_name.setText("");
        txt_price.setText("");
        txt_name.setText("");
        txt_adddate.setDate(null);
    }//GEN-LAST:event_btn_clearActionPerformed

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
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_products;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser txt_adddate;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables

    private boolean CheckInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
