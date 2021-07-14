/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Stefan
 */
public class PanelRezervacije extends javax.swing.JPanel {

    /**
     * Creates new form PanelRezervacije
     */
    public PanelRezervacije() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNazivTabeleMojeRezervacije = new javax.swing.JLabel();
        btnRefreshTabela = new javax.swing.JButton();
        btnAktivneRezervacije = new javax.swing.JButton();
        btnRealizovaneRezervacije = new javax.swing.JButton();
        btnOtkaziRezervaciju = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMojeRezeravacije = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNazivTabeleMojeRezervacije.setBackground(new java.awt.Color(34, 40, 44));
        lblNazivTabeleMojeRezervacije.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNazivTabeleMojeRezervacije.setForeground(java.awt.Color.white);
        lblNazivTabeleMojeRezervacije.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNazivTabeleMojeRezervacije.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_grid_64px.png"))); // NOI18N
        lblNazivTabeleMojeRezervacije.setText("Tabela rezervacija:");
        add(lblNazivTabeleMojeRezervacije, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 60));

        btnRefreshTabela.setBackground(new java.awt.Color(34, 40, 44));
        btnRefreshTabela.setForeground(java.awt.Color.white);
        btnRefreshTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_synchronize_64px_1.png"))); // NOI18N
        btnRefreshTabela.setBorder(null);
        btnRefreshTabela.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(btnRefreshTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 60, 60));

        btnAktivneRezervacije.setBackground(new java.awt.Color(34, 40, 44));
        btnAktivneRezervacije.setForeground(java.awt.Color.white);
        btnAktivneRezervacije.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_calendar_64px.png"))); // NOI18N
        btnAktivneRezervacije.setText("Aktivne rezervacije");
        btnAktivneRezervacije.setBorder(null);
        add(btnAktivneRezervacije, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 220, 60));

        btnRealizovaneRezervacije.setBackground(new java.awt.Color(34, 40, 44));
        btnRealizovaneRezervacije.setForeground(java.awt.Color.white);
        btnRealizovaneRezervacije.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_checked_64px.png"))); // NOI18N
        btnRealizovaneRezervacije.setText("Realizovane rezervacije");
        btnRealizovaneRezervacije.setBorder(null);
        add(btnRealizovaneRezervacije, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 220, 60));

        btnOtkaziRezervaciju.setBackground(new java.awt.Color(34, 40, 44));
        btnOtkaziRezervaciju.setForeground(java.awt.Color.white);
        btnOtkaziRezervaciju.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/icons8_cancel_64px.png"))); // NOI18N
        btnOtkaziRezervaciju.setText("Oktazi rezervaciju");
        btnOtkaziRezervaciju.setBorder(null);
        btnOtkaziRezervaciju.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(btnOtkaziRezervaciju, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, 310, 60));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(java.awt.Color.white);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabelMojeRezeravacije.setForeground(new java.awt.Color(0, 0, 0));
        tabelMojeRezeravacije.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelMojeRezeravacije.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelMojeRezeravacije.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelMojeRezeravacije.setMaximumSize(new java.awt.Dimension(100, 64));
        tabelMojeRezeravacije.setMinimumSize(new java.awt.Dimension(1100, 64));
        tabelMojeRezeravacije.setShowVerticalLines(false);
        tabelMojeRezeravacije.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelMojeRezeravacije);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1270, 220));
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnOtkaziRezervaciju() {
        return btnOtkaziRezervaciju;
    }

    public JButton getBtnRealizovaneRezervacije() {
        return btnRealizovaneRezervacije;
    }

    public JButton getBtnAktivneRezervacije() {
        return btnAktivneRezervacije;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JLabel getLblNazivTabeleMojeRezervacije() {
        return lblNazivTabeleMojeRezervacije;
    }

    public JTable getTabelMojeRezeravacije() {
        return tabelMojeRezeravacije;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAktivneRezervacije;
    private javax.swing.JButton btnOtkaziRezervaciju;
    private javax.swing.JButton btnRealizovaneRezervacije;
    private javax.swing.JButton btnRefreshTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNazivTabeleMojeRezervacije;
    private javax.swing.JTable tabelMojeRezeravacije;
    // End of variables declaration//GEN-END:variables

    public void btnAktivneRezervacijeActionListener(ActionListener actionListener) {
        btnAktivneRezervacije.addActionListener(actionListener);
    }

    public void btnOtkaziRezervacijuActionListener(ActionListener actionListener) {
        btnOtkaziRezervaciju.addActionListener(actionListener);
    }

    public void btnRealizovaneRezervacijeActionListener(ActionListener actionListener) {
        btnRealizovaneRezervacije.addActionListener(actionListener);
    }

    public void btnRefreshTabelaActionListener(ActionListener actionListener) {
        btnRefreshTabela.addActionListener(actionListener);
    }
}
