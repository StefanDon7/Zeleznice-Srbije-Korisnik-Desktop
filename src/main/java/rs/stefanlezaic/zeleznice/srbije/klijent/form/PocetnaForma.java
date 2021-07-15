/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.form;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelDugme;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelRegistracija;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelUlogujSe;

/**
 *
 * @author Stefan
 */
public class PocetnaForma extends javax.swing.JFrame {

    /**
     * Creates new form PocetnaForma
     */
    public PocetnaForma() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblExit = new javax.swing.JLabel();
        panelDugme = new rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelDugme();
        panelUlogujSe = new rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelUlogujSe();
        panelRegistracija = new rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelRegistracija();
        pozadinaSlika = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 690));
        setMinimumSize(new java.awt.Dimension(600, 690));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 690));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_close_window_96px.png"))); // NOI18N
        lblExit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, -1, 40, 40));

        panelDugme.setOpaque(false);
        getContentPane().add(panelDugme, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 480, -1));

        panelUlogujSe.setOpaque(false);
        getContentPane().add(panelUlogujSe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 510, -1));

        panelRegistracija.setOpaque(false);
        getContentPane().add(panelRegistracija, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 510, -1));

        pozadinaSlika.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        pozadinaSlika.setForeground(new java.awt.Color(0, 0, 51));
        pozadinaSlika.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/rffw88nr-1354076846.jpg"))); // NOI18N
        getContentPane().add(pozadinaSlika, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1810, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public PanelDugme getPanelDugme() {
        return panelDugme;
    }

    public PanelRegistracija getPanelRegistracija() {
        return panelRegistracija;
    }

    public PanelUlogujSe getPanelUlogujSe() {
        return panelUlogujSe;
    }

    public JLabel getPozadinaSlika() {
        return pozadinaSlika;
    }

    public JLabel getLblExit() {
        return lblExit;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblExit;
    private rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelDugme panelDugme;
    private rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelRegistracija panelRegistracija;
    private rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelUlogujSe panelUlogujSe;
    private javax.swing.JLabel pozadinaSlika;
    // End of variables declaration//GEN-END:variables

    public void lblUlogujSeActionListener(MouseListener mouseListener) {
        panelDugme.getLblUlogujSe().addMouseListener(mouseListener);
    }

    public void lblRegistrujSeActionListener(MouseListener mouseListener) {
        panelDugme.getLblRegistrujSe().addMouseListener(mouseListener);
    }

    public void lblExitSeActionListener(MouseListener mouseListener) {
        lblExit.addMouseListener(mouseListener);
    }

}
