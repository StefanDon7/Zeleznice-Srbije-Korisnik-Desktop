/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Stefan
 */
public class PanelKorisnik extends javax.swing.JPanel {

    /**
     * Creates new form PanelKorisnik
     */
    public PanelKorisnik() {
        initComponents();
        this.setMinimumSize(new Dimension(390, 320));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblIme = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        lblPrezime = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        lblKorisnickoIme = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        lblLozinak = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblPotvrdaLozinke = new javax.swing.JLabel();
        txtPasswordPotvrda = new javax.swing.JPasswordField();
        btnPromeni = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmail.setBackground(new java.awt.Color(34, 40, 44));
        lblEmail.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblEmail.setForeground(java.awt.Color.white);
        lblEmail.setText("Email:");
        lblEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 40));

        txtEmail.setBackground(new java.awt.Color(102, 102, 102));
        txtEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtEmail.setForeground(java.awt.Color.black);
        txtEmail.setBorder(null);
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtEmail.setEnabled(false);
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 220, 40));

        lblIme.setBackground(new java.awt.Color(34, 40, 44));
        lblIme.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblIme.setForeground(java.awt.Color.white);
        lblIme.setText("Ime:");
        add(lblIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 220, 40));

        txtIme.setBackground(new java.awt.Color(102, 102, 102));
        txtIme.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtIme.setForeground(java.awt.Color.black);
        txtIme.setBorder(null);
        txtIme.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtIme.setEnabled(false);
        add(txtIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 220, 40));

        lblPrezime.setBackground(new java.awt.Color(34, 40, 44));
        lblPrezime.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPrezime.setForeground(java.awt.Color.white);
        lblPrezime.setText("Prezime:");
        lblPrezime.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lblPrezime, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 220, 40));

        txtPrezime.setBackground(new java.awt.Color(102, 102, 102));
        txtPrezime.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPrezime.setForeground(java.awt.Color.black);
        txtPrezime.setBorder(null);
        txtPrezime.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPrezime.setEnabled(false);
        add(txtPrezime, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 220, 40));

        lblKorisnickoIme.setBackground(new java.awt.Color(34, 40, 44));
        lblKorisnickoIme.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblKorisnickoIme.setForeground(java.awt.Color.white);
        lblKorisnickoIme.setText("Korisnicko ime:");
        lblKorisnickoIme.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lblKorisnickoIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 220, 40));

        txtKorisnickoIme.setBackground(new java.awt.Color(102, 102, 102));
        txtKorisnickoIme.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtKorisnickoIme.setForeground(java.awt.Color.black);
        txtKorisnickoIme.setBorder(null);
        txtKorisnickoIme.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(txtKorisnickoIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 220, 40));

        lblLozinak.setBackground(new java.awt.Color(34, 40, 44));
        lblLozinak.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblLozinak.setForeground(java.awt.Color.white);
        lblLozinak.setText("Lozinka:");
        lblLozinak.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lblLozinak, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 220, 40));

        txtPassword.setBackground(new java.awt.Color(102, 102, 102));
        txtPassword.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPassword.setForeground(java.awt.Color.black);
        txtPassword.setBorder(null);
        txtPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 220, 40));

        lblPotvrdaLozinke.setBackground(new java.awt.Color(34, 40, 44));
        lblPotvrdaLozinke.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPotvrdaLozinke.setForeground(java.awt.Color.white);
        lblPotvrdaLozinke.setText("Potvrda loznike:");
        lblPotvrdaLozinke.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lblPotvrdaLozinke, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 220, 40));

        txtPasswordPotvrda.setBackground(new java.awt.Color(102, 102, 102));
        txtPasswordPotvrda.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPasswordPotvrda.setForeground(java.awt.Color.black);
        txtPasswordPotvrda.setBorder(null);
        txtPasswordPotvrda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(txtPasswordPotvrda, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 220, 40));

        btnPromeni.setBackground(new java.awt.Color(34, 40, 44));
        btnPromeni.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnPromeni.setForeground(java.awt.Color.white);
        btnPromeni.setText("Promeni");
        btnPromeni.setBorder(null);
        btnPromeni.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(btnPromeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 220, 60));
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnPromeni() {
        return btnPromeni;
    }

    public JLabel getLblEmail() {
        return lblEmail;
    }

    public JLabel getLblIme() {
        return lblIme;
    }

    public JLabel getLblKorisnickoIme() {
        return lblKorisnickoIme;
    }

    public JLabel getLblLozinak() {
        return lblLozinak;
    }

    public JLabel getLblPotvrdaLozinke() {
        return lblPotvrdaLozinke;
    }

    public JLabel getLblPrezime() {
        return lblPrezime;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtIme() {
        return txtIme;
    }

    public JTextField getTxtKorisnickoIme() {
        return txtKorisnickoIme;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JPasswordField getTxtPasswordPotvrda() {
        return txtPasswordPotvrda;
    }

    public JTextField getTxtPrezime() {
        return txtPrezime;
    }
  
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPromeni;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblKorisnickoIme;
    private javax.swing.JLabel lblLozinak;
    private javax.swing.JLabel lblPotvrdaLozinke;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordPotvrda;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    public void btnPromeniActionListener(ActionListener actionListener) {
        btnPromeni.addActionListener(actionListener);
    }
}
