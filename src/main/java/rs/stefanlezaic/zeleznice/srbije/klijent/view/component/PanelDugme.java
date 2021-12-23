/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.component;

import javax.swing.JLabel;

/**
 *
 * @author Stefan
 */
public class PanelDugme extends javax.swing.JPanel {

    /**
     * Creates new form PanelDugme
     */
    public PanelDugme() {
        initComponents();
    }

    public JLabel getLblRegistrujSe() {
        return lblRegistrujSe;
    }

    public JLabel getLblUlogujSe() {
        return lblUlogujSe;
    }

    public JLabel getLblR() {
        return lblR;
    }

    public JLabel getLblU() {
        return lblU;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        lblU = new javax.swing.JLabel();
        lblR = new javax.swing.JLabel();
        lblUlogujSe = new javax.swing.JLabel();
        lblRegistrujSe = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 2, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("/");
        jLabel6.setToolTipText("");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 40, 40));

        lblU.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblU.setForeground(new java.awt.Color(0, 0, 0));
        lblU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblU.setText("Prijavi se");
        lblU.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(lblU, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 150, 40));

        lblR.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblR.setForeground(new java.awt.Color(0, 0, 0));
        lblR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblR.setText("Napravi nalog");
        add(lblR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, 40));

        lblUlogujSe.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblUlogujSe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUlogujSe.setPreferredSize(new java.awt.Dimension(150, 100));
        add(lblUlogujSe, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 100, 60));

        lblRegistrujSe.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblRegistrujSe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrujSe.setPreferredSize(new java.awt.Dimension(150, 100));
        add(lblRegistrujSe, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 100, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblR;
    private javax.swing.JLabel lblRegistrujSe;
    private javax.swing.JLabel lblU;
    private javax.swing.JLabel lblUlogujSe;
    // End of variables declaration//GEN-END:variables

    
}
