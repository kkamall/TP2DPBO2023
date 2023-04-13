/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package musik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;

/**
 *
 * @author Gumilang
 */
public class CardMusisi extends javax.swing.JPanel {
    private int id_film;
    /**
     * Creates new form Card
     */
    public CardMusisi(int id_musisi, String nama_musisi, String lagu_populer, String path) {
        initComponents();
        labelNamaMusisi.setText(nama_musisi);
        labelLaguPopuler.setText(lagu_populer);
        labelPoster.setText(path);
        
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage();
        
        jPanel1.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Image scaledImage = image.getScaledInstance(fotoMusisi.getWidth(), fotoMusisi.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(scaledImage);
                fotoMusisi.setOpaque(false);
                fotoMusisi.setBorder(BorderFactory.createEmptyBorder());
                fotoMusisi.setLayout(new BorderLayout());
                fotoMusisi.add(new JLabel(newIcon));
                }
        });
        
        this.id_film = id_musisi;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelPoster = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fotoMusisi = new javax.swing.JPanel();
        labelTitleNamaMusisi = new javax.swing.JLabel();
        labelNamaMusisi = new javax.swing.JLabel();
        buttonManage = new javax.swing.JButton();
        labelTitleLaguPopuler = new javax.swing.JLabel();
        labelLaguPopuler = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        labelPoster.setText("jLabel3");

        fotoMusisi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fotoMusisi.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout fotoMusisiLayout = new javax.swing.GroupLayout(fotoMusisi);
        fotoMusisi.setLayout(fotoMusisiLayout);
        fotoMusisiLayout.setHorizontalGroup(
            fotoMusisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );
        fotoMusisiLayout.setVerticalGroup(
            fotoMusisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        labelTitleNamaMusisi.setText("Nama musisi :");

        labelNamaMusisi.setText("jLabel3");

        buttonManage.setText("Manage");
        buttonManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManageActionPerformed(evt);
            }
        });

        labelTitleLaguPopuler.setText("Lagu populer :");

        labelLaguPopuler.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fotoMusisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelTitleNamaMusisi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNamaMusisi))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelTitleLaguPopuler)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelLaguPopuler)))
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonManage)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTitleNamaMusisi)
                            .addComponent(labelNamaMusisi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTitleLaguPopuler)
                            .addComponent(labelLaguPopuler)))
                    .addComponent(fotoMusisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonManage, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManageActionPerformed
        // TODO add your handling code here:
        PanelCardMusisi mainFrame = (PanelCardMusisi) this.getTopLevelAncestor();
        File file = new File(labelPoster.getText());
        mainFrame.setTextLabelMusisi(this.id_film, labelNamaMusisi.getText(), labelLaguPopuler.getText(), file.getName(), file.getAbsolutePath());
    }//GEN-LAST:event_buttonManageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonManage;
    private javax.swing.JPanel fotoMusisi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelLaguPopuler;
    private javax.swing.JLabel labelNamaMusisi;
    private javax.swing.JLabel labelPoster;
    private javax.swing.JLabel labelTitleLaguPopuler;
    private javax.swing.JLabel labelTitleNamaMusisi;
    // End of variables declaration//GEN-END:variables
}