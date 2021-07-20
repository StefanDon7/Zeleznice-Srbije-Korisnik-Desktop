/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.form;

import java.awt.event.MouseListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelKorisnik;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelPretragraPolazaka;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelRezervacije;

/**
 *
 * @author Stefan
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
    }

    public JMenuBar getMenu() {
        return Menu;
    }
    
    
    public JMenu getMenuOdjava() {
        return menuOdjava;
    }

    public JMenu getMenuMojeRezervacije() {
        return menuMojeRezervacije;
    }

    public JMenu getMenuNalog() {
        return menuNalog;
    }

    public JMenu getMenuPretraga() {
        return menuPretraga;
    }

    public PanelKorisnik getPanelKorisnik() {
        return panelKorisnik;
    }

    public PanelPretragraPolazaka getPanelPretragraPolazaka() {
        return panelPretragraPolazaka;
    }

    public PanelRezervacije getPanelRezervacije() {
        return panelRezervacije;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelKorisnik = new rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelKorisnik();
        panelRezervacije = new rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelRezervacije();
        panelPretragraPolazaka = new rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelPretragraPolazaka();
        Menu = new javax.swing.JMenuBar();
        menuPretraga = new javax.swing.JMenu();
        menuNalog = new javax.swing.JMenu();
        menuMojeRezervacije = new javax.swing.JMenu();
        menuOdjava = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelKorisnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(panelRezervacije, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        getContentPane().add(panelPretragraPolazaka, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1300, 490));

        Menu.setMaximumSize(new java.awt.Dimension(1336, 80));
        Menu.setMinimumSize(new java.awt.Dimension(1336, 80));
        Menu.setPreferredSize(new java.awt.Dimension(1336, 80));

        menuPretraga.setText("Pretraga");
        menuPretraga.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        menuPretraga.setMaximumSize(new java.awt.Dimension(200, 80));
        Menu.add(menuPretraga);

        menuNalog.setText("Nalog");
        menuNalog.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        menuNalog.setMaximumSize(new java.awt.Dimension(200, 80));
        Menu.add(menuNalog);

        menuMojeRezervacije.setText("Rezervacije");
        menuMojeRezervacije.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        menuMojeRezervacije.setMaximumSize(new java.awt.Dimension(200, 80));
        Menu.add(menuMojeRezervacije);

        menuOdjava.setText("Odjavi se");
        menuOdjava.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        menuOdjava.setMaximumSize(new java.awt.Dimension(200, 80));
        menuOdjava.setMinimumSize(new java.awt.Dimension(200, 30));
        Menu.add(menuOdjava);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu menuMojeRezervacije;
    private javax.swing.JMenu menuNalog;
    private javax.swing.JMenu menuOdjava;
    private javax.swing.JMenu menuPretraga;
    private rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelKorisnik panelKorisnik;
    private rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelPretragraPolazaka panelPretragraPolazaka;
    private rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelRezervacije panelRezervacije;
    // End of variables declaration//GEN-END:variables

    public void menuPretragaActionListener(MouseListener mouseListener) {
        menuPretraga.addMouseListener(mouseListener);
    }

    public void menuNalogActionListener(MouseListener mouseListener) {
        menuNalog.addMouseListener(mouseListener);
    }

    public void menuMojeRezervacijeActionListener(MouseListener mouseListener) {
        menuMojeRezervacije.addMouseListener(mouseListener);
    }

    public void menuOdjavaActionListener(MouseListener mouseListener) {
        menuOdjava.addMouseListener(mouseListener);
    }
}
