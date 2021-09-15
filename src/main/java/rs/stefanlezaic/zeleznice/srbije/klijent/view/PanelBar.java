/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view;

import rs.stefanlezaic.zeleznice.srbije.klijent.view.component.PanelSat;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.PanelSound;
import rs.stefanlezaic.zeleznice.srbije.lib.theme.PanelTema;




/**
 *
 * @author Stefan
 */
public class PanelBar extends javax.swing.JPanel {

    public PanelBar() {
        initComponents();
    }

    public PanelSat getPanelSat() {
        return panelSat;
    }

    public PanelTema getPanelTema() {
        return panelTema;
    }

    public PanelSound getPanelSound() {
        return panelSound;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSat = new rs.stefanlezaic.zeleznice.srbije.klijent.view.component.PanelSat();
        panelTema = new rs.stefanlezaic.zeleznice.srbije.lib.theme.PanelTema();
        panelSound = new rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.PanelSound();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(panelSat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 150));
        add(panelTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 260, 80));
        add(panelSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rs.stefanlezaic.zeleznice.srbije.klijent.view.component.PanelSat panelSat;
    private rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.PanelSound panelSound;
    private rs.stefanlezaic.zeleznice.srbije.lib.theme.PanelTema panelTema;
    // End of variables declaration//GEN-END:variables
}
