/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package musik;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Gumilang
 */
public class PanelCardMusisi extends javax.swing.JFrame {
    private Boolean isUpdate = false;
    private dbConnection db;
    private LoginForm lf = new LoginForm();
    
    /**
     * Creates new form JPanelCard
     */
    public PanelCardMusisi() {
        initComponents();
        db = new dbConnection();
        setPanel();
        
        // Hide Delete button
        btnDelete.setVisible(false);
    }
    
    public void setTextLabelMusisi(int id_musisi, String nama_musisi, String lagu_populer, String path, String fullPath){
        fieldIdAlbum.setText(Integer.toString(id_musisi));
        fieldNamaMusisi.setText(nama_musisi);
        fieldFotoAlbum.setText(path);
        fieldFotoAlbumUpdate.setText(fullPath);
        fieldFotoAlbumPath.setText(fullPath);
        fieldLaguPopuler.setText(lagu_populer);
        btnAdd.setText("Update");
        btnDelete.setVisible(true);
        this.isUpdate = true;
    }
    
    public void setPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(0, 1));
        
        ResultSet res = db.selectQuery("SELECT * FROM musisi");
        try
        {
            while(res.next())
            {
                mainPanel.add(new CardMusisi(res.getInt("id_musisi"), res.getString("nama_musisi"), res.getString("lagu_populer"), res.getString("path")));
            }
        }
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }      
        
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public void insertData()
    {
        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to insert new data?", "Confirm Creation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            File file = new File(fieldFotoAlbumPath.getText());
            String destinationFolder = "fotoMusisi/";
            File destinationFile = new File(destinationFolder + file.getName());
            String pathFile = destinationFolder + file.getName();
            
            // Copy file into destination folder
            if(fieldFotoAlbumPath.getText().isEmpty())
            {
                pathFile = "fotoMusisi/default.jpg";
            }
            else
            {
                try
                {
                    Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
            
            String sql = "INSERT INTO musisi (nama_musisi, lagu_populer, path) VALUES ('" + fieldNamaMusisi.getText() + "', '"+ fieldLaguPopuler.getText() +"', '" + pathFile + "')";
            int res = db.updateQuery(sql);
            if(res == 1)
            {
                // Show a message to indicate that the data has been deleted
                JOptionPane.showMessageDialog(this, "Data created successfully.");
            }
        }
        // Reset Form
        resetForm();
        setPanel();
    }
    
    public void updateData()
    {
        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to update this data?", "Confirm Update", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            String destinationFolder = "fotoMusisi/";
            File beforeFile = new File(fieldFotoAlbumUpdate.getText());
            String pathFile = destinationFolder + beforeFile.getName();
            
            // String pathFile = destination Folder + file.getName();
            if(!fieldFotoAlbumPath.getText().equals(fieldFotoAlbumUpdate.getText()))
            {
                File file = new File(fieldFotoAlbumPath.getText());
                File destinationFile = new File(destinationFolder + file.getName());
                pathFile = destinationFolder + file.getName();
                File fileToDelete = new File(fieldFotoAlbumUpdate.getText());
                
                // Copy file into destination folder
                try
                {
                    Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
                if(!fieldFotoAlbumUpdate.getText().endsWith("fotoMusisi\\default.jpg"))
                {
                    fileToDelete.delete();
                }
            }
            
            String sql = "UPDATE musisi SET nama_musisi = '" + fieldNamaMusisi.getText() + "', lagu_populer = '" + fieldLaguPopuler.getText() + "', path = '" + pathFile + "' WHERE id_musisi = " + fieldIdAlbum.getText();
            int res = db.updateQuery(sql);
            if(res == 1)
            {
                // Show a message to indicate that the data has been deleted
                JOptionPane.showMessageDialog(this, "Data updated successfully.");
            }
        }
        // Reset Form
        resetForm();
        setPanel();
    }
    
    public void deleteData() {
        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this data?", "Confirm Deletion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            String sql = "DELETE FROM musisi WHERE id_musisi =" + fieldIdAlbum.getText();
            int res = db.updateQuery(sql);
            
            File fileToDelete = new File(fieldFotoAlbumPath.getText());
            if(!fieldFotoAlbumPath.getText().endsWith("fotoMusisi\\default.jpg"))
            {
                fileToDelete.delete();
            }
            
            if(res == 1)
            {
                // Show a message to indicate that the data has been deleted
                JOptionPane.showMessageDialog(this, "Data deleted successfully.");
            }
        }
        // Reset Form
        resetForm();
        setPanel();
    }
    
    public void resetForm() {
        // Set All Value Form to Empty
        fieldNamaMusisi.setText("");
        fieldFotoAlbum.setText("");
        fieldLaguPopuler.setText("");
        fieldFotoAlbumPath.setText("");
        fieldFotoAlbumUpdate.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldIdAlbum = new javax.swing.JTextField();
        jFileChooser2 = new javax.swing.JFileChooser();
        fieldFotoAlbumPath = new javax.swing.JTextField();
        fieldFotoAlbumUpdate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        labelBigTitle = new javax.swing.JLabel();
        labelNamaMusisi = new javax.swing.JLabel();
        labelLaguPopuler = new javax.swing.JLabel();
        fieldNamaMusisi = new javax.swing.JTextField();
        fieldLaguPopuler = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        labelFotoAlbum = new javax.swing.JLabel();
        fieldFotoAlbum = new javax.swing.JTextField();
        btnChoose = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnListAlbum = new javax.swing.JButton();

        fieldIdAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdAlbumActionPerformed(evt);
            }
        });

        fieldFotoAlbumPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFotoAlbumPathActionPerformed(evt);
            }
        });

        fieldFotoAlbumUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFotoAlbumUpdateActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainPanel);

        labelBigTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelBigTitle.setText("DAFTAR MUSISI");

        labelNamaMusisi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNamaMusisi.setText("Nama Musisi");

        labelLaguPopuler.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelLaguPopuler.setText("Lagu Populer");

        fieldNamaMusisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNamaMusisiActionPerformed(evt);
            }
        });

        fieldLaguPopuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldLaguPopulerActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnAdd.setText("Insert");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        labelFotoAlbum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFotoAlbum.setText("Foto Musisi");

        fieldFotoAlbum.setEditable(false);
        fieldFotoAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFotoAlbumActionPerformed(evt);
            }
        });

        btnChoose.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnChoose.setText("Attach");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnListAlbum.setText("List Album");
        btnListAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListAlbumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNamaMusisi)
                                    .addComponent(labelFotoAlbum)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(labelLaguPopuler)))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldFotoAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(fieldNamaMusisi)
                            .addComponent(fieldLaguPopuler))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)
                            .addComponent(btnCancel)
                            .addComponent(btnChoose))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelBigTitle)
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBigTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNamaMusisi)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldNamaMusisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(labelLaguPopuler)
                    .addComponent(fieldLaguPopuler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldFotoAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFotoAlbum)
                    .addComponent(btnChoose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNamaMusisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNamaMusisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaMusisiActionPerformed

    private void fieldLaguPopulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldLaguPopulerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldLaguPopulerActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        // If Add (data not clicked)
        if(isUpdate == false)
        {
            insertData();
        }
        else
        {
            updateData();
            btnAdd.setText("Insert");
            btnDelete.setVisible(false);
            this.isUpdate = false;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        // Cancel Input Form
        btnAdd.setText("Insert");
        btnDelete.setVisible(false);
        this.isUpdate = false;

        // Reset Form
        resetForm();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(isUpdate == true)
        {
            deleteData();
            btnAdd.setText("Insert");
            btnDelete.setVisible(false);
            this.isUpdate = false;
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void fieldIdAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdAlbumActionPerformed

    private void fieldFotoAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFotoAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFotoAlbumActionPerformed

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        fieldFotoAlbumPath.setText(f.getAbsolutePath());
        fieldFotoAlbum.setText(f.getName());
    }//GEN-LAST:event_btnChooseActionPerformed

    private void fieldFotoAlbumPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFotoAlbumPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFotoAlbumPathActionPerformed

    private void fieldFotoAlbumUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFotoAlbumUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFotoAlbumUpdateActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnListAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListAlbumActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new PanelCardAlbum().setVisible(true);
    }//GEN-LAST:event_btnListAlbumActionPerformed

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
            java.util.logging.Logger.getLogger(PanelCardMusisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelCardMusisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelCardMusisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelCardMusisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelCardMusisi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnListAlbum;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JTextField fieldFotoAlbum;
    private javax.swing.JTextField fieldFotoAlbumPath;
    private javax.swing.JTextField fieldFotoAlbumUpdate;
    private javax.swing.JTextField fieldIdAlbum;
    private javax.swing.JTextField fieldLaguPopuler;
    private javax.swing.JTextField fieldNamaMusisi;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBigTitle;
    private javax.swing.JLabel labelFotoAlbum;
    private javax.swing.JLabel labelLaguPopuler;
    private javax.swing.JLabel labelNamaMusisi;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
