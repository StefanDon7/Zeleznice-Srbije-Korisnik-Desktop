/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view;

import java.awt.event.MouseAdapter;
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblUlogujSe = new javax.swing.JLabel();
        lblRegistrujSe = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 2, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("/");
        jLabel6.setToolTipText("");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 40, 40));

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_login_32px_3.png"))); // NOI18N
        jLabel4.setText("Uloguj se");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 150, 40));

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_logout_rounded_left_32px.png"))); // NOI18N
        jLabel5.setText("Registruj se");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        lblUlogujSe.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblUlogujSe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUlogujSe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_toggle_on_100px.png"))); // NOI18N
        lblUlogujSe.setPreferredSize(new java.awt.Dimension(150, 100));
        add(lblUlogujSe, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 100, 60));

        lblRegistrujSe.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblRegistrujSe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrujSe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_toggle_off_100px.png"))); // NOI18N
        lblRegistrujSe.setPreferredSize(new java.awt.Dimension(150, 100));
        add(lblRegistrujSe, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 100, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblRegistrujSe;
    private javax.swing.JLabel lblUlogujSe;
    // End of variables declaration//GEN-END:variables

    
}
