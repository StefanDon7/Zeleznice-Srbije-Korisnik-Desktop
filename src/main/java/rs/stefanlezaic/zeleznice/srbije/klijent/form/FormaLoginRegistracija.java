/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.form;

import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.InvalidProductException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.kontroler.KontrolerGlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.EntityNotFoundException;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author sleza
 */
public class FormaLoginRegistracija extends javax.swing.JFrame {

    /**
     * Creates new form FormaLoginRegistracija
     */
    public FormaLoginRegistracija() {
        initComponents();
        this.setSize(1200, 600);
        lblProblemKorisnik.setVisible(false);
        centrirajFrejm();
        lblRegistrationChange();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLevi = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        lblEmailLogin = new javax.swing.JLabel();
        txtEmailLogin = new javax.swing.JTextField();
        lblLoznikaLogin = new javax.swing.JLabel();
        txtPasswordLogin = new javax.swing.JPasswordField();
        btnPrijaviSe = new javax.swing.JButton();
        panelRegistracije = new javax.swing.JPanel();
        lblEmailRegistracija = new javax.swing.JLabel();
        lblImeRegistracija = new javax.swing.JLabel();
        lblPrezimeRegistracija = new javax.swing.JLabel();
        lblKorisnickoImeRegistracija = new javax.swing.JLabel();
        lblLozinakRegistracija = new javax.swing.JLabel();
        lblPotvrdaLozinkeRegistracija = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtKorisnickoIme = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordPotvrda = new javax.swing.JPasswordField();
        btnRegistrujSe = new javax.swing.JButton();
        lblProblemKorisnik = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblRegistrujSe = new javax.swing.JLabel();
        lblUlogujSe = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log in / Sing in");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setPreferredSize(new java.awt.Dimension(1000, 550));
        setResizable(false);
        getContentPane().setLayout(null);

        panelLevi.setBackground(new java.awt.Color(44, 44, 44));
        panelLevi.setLayout(null);

        panelLogin.setBackground(new java.awt.Color(34, 40, 44));
        panelLogin.setOpaque(false);
        panelLogin.setLayout(null);

        lblEmailLogin.setBackground(new java.awt.Color(102, 102, 102));
        lblEmailLogin.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblEmailLogin.setForeground(new java.awt.Color(0, 0, 51));
        lblEmailLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmailLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_email.png"))); // NOI18N
        lblEmailLogin.setText("Email:");
        panelLogin.add(lblEmailLogin);
        lblEmailLogin.setBounds(10, 40, 230, 60);

        txtEmailLogin.setBackground(new java.awt.Color(102, 102, 102));
        txtEmailLogin.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        txtEmailLogin.setForeground(new java.awt.Color(0, 0, 51));
        txtEmailLogin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmailLogin.setOpaque(false);
        panelLogin.add(txtEmailLogin);
        txtEmailLogin.setBounds(240, 50, 250, 40);

        lblLoznikaLogin.setBackground(new java.awt.Color(102, 102, 102));
        lblLoznikaLogin.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblLoznikaLogin.setForeground(new java.awt.Color(0, 0, 51));
        lblLoznikaLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoznikaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_password prvi.png"))); // NOI18N
        lblLoznikaLogin.setText("Lozinka:");
        panelLogin.add(lblLoznikaLogin);
        lblLoznikaLogin.setBounds(10, 100, 230, 60);

        txtPasswordLogin.setBackground(new java.awt.Color(102, 102, 102));
        txtPasswordLogin.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        txtPasswordLogin.setForeground(new java.awt.Color(0, 0, 51));
        txtPasswordLogin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPasswordLogin.setOpaque(false);
        panelLogin.add(txtPasswordLogin);
        txtPasswordLogin.setBounds(240, 110, 250, 40);

        btnPrijaviSe.setBackground(new java.awt.Color(102, 102, 102));
        btnPrijaviSe.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        btnPrijaviSe.setForeground(new java.awt.Color(0, 0, 51));
        btnPrijaviSe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_login.png"))); // NOI18N
        btnPrijaviSe.setText("Uloguj se");
        btnPrijaviSe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPrijaviSe.setOpaque(false);
        btnPrijaviSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijaviSeActionPerformed(evt);
            }
        });
        panelLogin.add(btnPrijaviSe);
        btnPrijaviSe.setBounds(240, 160, 250, 70);

        panelLevi.add(panelLogin);
        panelLogin.setBounds(260, 40, 500, 350);

        panelRegistracije.setBackground(new java.awt.Color(44, 44, 44));
        panelRegistracije.setOpaque(false);
        panelRegistracije.setLayout(null);

        lblEmailRegistracija.setBackground(new java.awt.Color(102, 102, 102));
        lblEmailRegistracija.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblEmailRegistracija.setForeground(new java.awt.Color(0, 0, 51));
        lblEmailRegistracija.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmailRegistracija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_email.png"))); // NOI18N
        lblEmailRegistracija.setText("Email:");
        panelRegistracije.add(lblEmailRegistracija);
        lblEmailRegistracija.setBounds(10, 40, 230, 60);

        lblImeRegistracija.setBackground(new java.awt.Color(102, 102, 102));
        lblImeRegistracija.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblImeRegistracija.setForeground(new java.awt.Color(0, 0, 51));
        lblImeRegistracija.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImeRegistracija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_ime_prezime.png"))); // NOI18N
        lblImeRegistracija.setText("Ime:");
        panelRegistracije.add(lblImeRegistracija);
        lblImeRegistracija.setBounds(10, 100, 230, 60);

        lblPrezimeRegistracija.setBackground(new java.awt.Color(102, 102, 102));
        lblPrezimeRegistracija.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblPrezimeRegistracija.setForeground(new java.awt.Color(0, 0, 51));
        lblPrezimeRegistracija.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrezimeRegistracija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_ime_prezime.png"))); // NOI18N
        lblPrezimeRegistracija.setText("Prezime:");
        panelRegistracije.add(lblPrezimeRegistracija);
        lblPrezimeRegistracija.setBounds(10, 160, 230, 60);

        lblKorisnickoImeRegistracija.setBackground(new java.awt.Color(102, 102, 102));
        lblKorisnickoImeRegistracija.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblKorisnickoImeRegistracija.setForeground(new java.awt.Color(0, 0, 51));
        lblKorisnickoImeRegistracija.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKorisnickoImeRegistracija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_korisnickoime.png"))); // NOI18N
        lblKorisnickoImeRegistracija.setText("Korisnicko ime:");
        panelRegistracije.add(lblKorisnickoImeRegistracija);
        lblKorisnickoImeRegistracija.setBounds(10, 220, 230, 60);

        lblLozinakRegistracija.setBackground(new java.awt.Color(102, 102, 102));
        lblLozinakRegistracija.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblLozinakRegistracija.setForeground(new java.awt.Color(0, 0, 51));
        lblLozinakRegistracija.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLozinakRegistracija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_password prvi.png"))); // NOI18N
        lblLozinakRegistracija.setText("Lozinka:");
        panelRegistracije.add(lblLozinakRegistracija);
        lblLozinakRegistracija.setBounds(10, 280, 230, 60);

        lblPotvrdaLozinkeRegistracija.setBackground(new java.awt.Color(102, 102, 102));
        lblPotvrdaLozinkeRegistracija.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblPotvrdaLozinkeRegistracija.setForeground(new java.awt.Color(0, 0, 51));
        lblPotvrdaLozinkeRegistracija.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPotvrdaLozinkeRegistracija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_password_drugi.png"))); // NOI18N
        lblPotvrdaLozinkeRegistracija.setText("Potvrda loznike:");
        panelRegistracije.add(lblPotvrdaLozinkeRegistracija);
        lblPotvrdaLozinkeRegistracija.setBounds(10, 340, 230, 60);

        txtEmail.setBackground(new java.awt.Color(102, 102, 102));
        txtEmail.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 51));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmail.setOpaque(false);
        panelRegistracije.add(txtEmail);
        txtEmail.setBounds(240, 50, 250, 40);

        txtIme.setBackground(new java.awt.Color(102, 102, 102));
        txtIme.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        txtIme.setForeground(new java.awt.Color(0, 0, 51));
        txtIme.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIme.setOpaque(false);
        panelRegistracije.add(txtIme);
        txtIme.setBounds(240, 110, 250, 40);

        txtPrezime.setBackground(new java.awt.Color(102, 102, 102));
        txtPrezime.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        txtPrezime.setForeground(new java.awt.Color(0, 0, 51));
        txtPrezime.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPrezime.setOpaque(false);
        panelRegistracije.add(txtPrezime);
        txtPrezime.setBounds(240, 170, 250, 40);

        txtKorisnickoIme.setBackground(new java.awt.Color(102, 102, 102));
        txtKorisnickoIme.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        txtKorisnickoIme.setForeground(new java.awt.Color(0, 0, 51));
        txtKorisnickoIme.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtKorisnickoIme.setOpaque(false);
        panelRegistracije.add(txtKorisnickoIme);
        txtKorisnickoIme.setBounds(240, 230, 250, 40);

        txtPassword.setBackground(new java.awt.Color(102, 102, 102));
        txtPassword.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 51));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPassword.setOpaque(false);
        panelRegistracije.add(txtPassword);
        txtPassword.setBounds(240, 290, 250, 40);

        txtPasswordPotvrda.setBackground(new java.awt.Color(102, 102, 102));
        txtPasswordPotvrda.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        txtPasswordPotvrda.setForeground(new java.awt.Color(0, 0, 51));
        txtPasswordPotvrda.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPasswordPotvrda.setOpaque(false);
        panelRegistracije.add(txtPasswordPotvrda);
        txtPasswordPotvrda.setBounds(240, 350, 250, 40);

        btnRegistrujSe.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrujSe.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        btnRegistrujSe.setForeground(new java.awt.Color(0, 0, 51));
        btnRegistrujSe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/registracija_registruj se.png"))); // NOI18N
        btnRegistrujSe.setText("Registruj se");
        btnRegistrujSe.setOpaque(false);
        btnRegistrujSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrujSeActionPerformed(evt);
            }
        });
        panelRegistracije.add(btnRegistrujSe);
        btnRegistrujSe.setBounds(240, 400, 250, 70);

        panelLevi.add(panelRegistracije);
        panelRegistracije.setBounds(260, 40, 500, 480);

        lblProblemKorisnik.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        lblProblemKorisnik.setForeground(new java.awt.Color(204, 0, 51));
        lblProblemKorisnik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/problem_klijent_postoji.png"))); // NOI18N
        lblProblemKorisnik.setText("Postoji korisnik sa tim email!");
        panelLevi.add(lblProblemKorisnik);
        lblProblemKorisnik.setBounds(760, 80, 430, 50);

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 2, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("|");
        panelLevi.add(jLabel6);
        jLabel6.setBounds(150, 0, 10, 30);

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_login_32px_3.png"))); // NOI18N
        jLabel4.setText("Uloguj se");
        panelLevi.add(jLabel4);
        jLabel4.setBounds(170, 0, 130, 40);

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_logout_rounded_left_32px.png"))); // NOI18N
        jLabel5.setText("Registruj se");
        panelLevi.add(jLabel5);
        jLabel5.setBounds(0, 0, 150, 40);

        lblRegistrujSe.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblRegistrujSe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_toggle_off_100px.png"))); // NOI18N
        lblRegistrujSe.setPreferredSize(new java.awt.Dimension(150, 100));
        lblRegistrujSe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrujSeMouseClicked(evt);
            }
        });
        panelLevi.add(lblRegistrujSe);
        lblRegistrujSe.setBounds(90, 40, 100, 60);

        lblUlogujSe.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        lblUlogujSe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_toggle_on_100px.png"))); // NOI18N
        lblUlogujSe.setPreferredSize(new java.awt.Dimension(150, 100));
        lblUlogujSe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUlogujSeMouseClicked(evt);
            }
        });
        panelLevi.add(lblUlogujSe);
        lblUlogujSe.setBounds(90, 40, 100, 60);

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/Slika_Pozadina_planine_voz.jpg"))); // NOI18N
        panelLevi.add(jLabel3);
        jLabel3.setBounds(-790, 0, 2000, 600);

        getContentPane().add(panelLevi);
        panelLevi.setBounds(0, 0, 1200, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrijaviSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijaviSeActionPerformed
        String email = txtEmailLogin.getText();
        String lozinka = new String(txtPasswordLogin.getPassword());
        Klijent k = new Klijent(-1, "korisnickoIme", lozinka, "ime", "prezime", email);
        //mozda ne bih treba da smaram server sa upitom o tome da li je sve popunio al nema veze stoji i na serverskoj strani
        if (email.isEmpty() || lozinka.isEmpty()) {
            new JOptionPaneExample().createAndDisplayGUI(this, new PanelAttention("Sva polja moraju biti popunjena!"));
            return;
        }
        Klijent klijent;
        try {
            klijent = Kontroler.getInstance().UlogujSe(k);
            new JOptionPaneExample().createAndDisplayGUI(this, new PanelSuccess("Korisnik: " + klijent.getIme() + " " + klijent.getPrezime() + ".\nUspesno ste se prijavili!"));
            prikaziGlavnuFormu(klijent);
        } catch (EntityNotFoundException ex) {
            new JOptionPaneExample().createAndDisplayGUI(this, new PanelError(ex.getMessage()));
        } catch (SQLException ex) {
            new JOptionPaneExample().createAndDisplayGUI(this, new PanelError(ex.getMessage()));
        } catch (Exception ex) {
            Logger.getLogger(FormaLoginRegistracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrijaviSeActionPerformed

    private void btnRegistrujSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrujSeActionPerformed
        lblProblemKorisnik.setVisible(false);
        char[] niz = txtPassword.getPassword();
        String lozinka = String.copyValueOf(niz);
        char[] niz2 = txtPasswordPotvrda.getPassword();
        String lozinka2 = String.copyValueOf(niz2);
        if (!lozinka.equals(lozinka2)) {
            new JOptionPaneExample().createAndDisplayGUI(this, new PanelError("Potvrda lozinke neuspesna!"));
            txtPassword.setText("");
            txtPasswordPotvrda.setText("");
            return;
        }
        String korisnickoIme = txtKorisnickoIme.getText();
        String ime = txtIme.getText();
        String prezime = txtPrezime.getText();
        String email = txtEmail.getText();
        //mozda ne bih treba da smaram server sa upitom o tome da li je sve popunio al nema veze stoji i na serverskoj strani
        if (korisnickoIme.isEmpty() || lozinka.isEmpty() || ime.isEmpty() || prezime.isEmpty() || email.isEmpty()) {
            new JOptionPaneExample().createAndDisplayGUI(this, new PanelAttention("Sva polja moraju biti popunjena!"));
            return;
        }

        Klijent klijent = new Klijent(-1, korisnickoIme, lozinka, ime, prezime, email);
        try {
            Kontroler.getInstance().RegistrujSe(klijent);
            lblLoginChange();
            txtIme.setText("");
            txtPrezime.setText("");
            txtEmail.setText("");
            txtKorisnickoIme.setText("");
        } catch (Exception ex) {
            if (ex instanceof InvalidProductException) {
                new JOptionPaneExample().createAndDisplayGUI(this, new PanelError(ex.toString()));
            } else if (ex instanceof SQLException) {
                lblProblemKorisnik.setVisible(true);
                txtEmail.setForeground(Color.red);
                new JOptionPaneExample().createAndDisplayGUI(this, new PanelError("Korisnik ne moze biti unesen!"));
            }
        } finally {
            txtEmail.setForeground(new Color(0, 0, 51));
            txtEmail.setText("");
        }
    }//GEN-LAST:event_btnRegistrujSeActionPerformed

    private void lblUlogujSeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUlogujSeMouseClicked
        lblLoginChange();

    }//GEN-LAST:event_lblUlogujSeMouseClicked

    private void lblRegistrujSeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrujSeMouseClicked
        lblRegistrationChange();

    }//GEN-LAST:event_lblRegistrujSeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijaviSe;
    private javax.swing.JButton btnRegistrujSe;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblEmailLogin;
    private javax.swing.JLabel lblEmailRegistracija;
    private javax.swing.JLabel lblImeRegistracija;
    private javax.swing.JLabel lblKorisnickoImeRegistracija;
    private javax.swing.JLabel lblLozinakRegistracija;
    private javax.swing.JLabel lblLoznikaLogin;
    private javax.swing.JLabel lblPotvrdaLozinkeRegistracija;
    private javax.swing.JLabel lblPrezimeRegistracija;
    private javax.swing.JLabel lblProblemKorisnik;
    private javax.swing.JLabel lblRegistrujSe;
    private javax.swing.JLabel lblUlogujSe;
    private javax.swing.JPanel panelLevi;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelRegistracije;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailLogin;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordLogin;
    private javax.swing.JPasswordField txtPasswordPotvrda;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void centrirajFrejm() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    public void prikaziGlavnuFormu(Klijent klijent) {
        
    }

    private void lblLoginChange() {
        lblUlogujSe.setVisible(false);
        lblRegistrujSe.setVisible(true);
        panelLogin.setVisible(false);
        panelRegistracije.setVisible(true);
    }

    private void lblRegistrationChange() {
        lblUlogujSe.setVisible(true);
        lblRegistrujSe.setVisible(false);
        panelLogin.setVisible(true);
        panelRegistracije.setVisible(false);
    }

}
