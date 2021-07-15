/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.form.kontroler;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.PocetnaForma;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.KontrolerRegistracija;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.KontrolerUlogujSe;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;

/**
 *
 * @author Stefan
 */
public class KontrolerPocetneForme {

    private PocetnaForma pocetnaForma;
    private KontrolerUlogujSe kontrolerUlogujSe;
    private KontrolerRegistracija kontrolerRegistracija;

    public KontrolerPocetneForme(PocetnaForma pocetnaForma) {
        this.pocetnaForma = pocetnaForma;
        this.kontrolerUlogujSe = new KontrolerUlogujSe(pocetnaForma, pocetnaForma.getPanelUlogujSe(), this);
        this.kontrolerRegistracija = new KontrolerRegistracija(pocetnaForma, pocetnaForma.getPanelRegistracija());
        prebaciNaPanelUlogujSe();
        centrirajFormu();
        addListener();
    }

    public KontrolerRegistracija getKontrolerRegistracija() {
        return kontrolerRegistracija;
    }

    public KontrolerUlogujSe getKontrolerUlogujSe() {
        return kontrolerUlogujSe;
    }
    

    private void addListener() {
        pocetnaForma.lblUlogujSeActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prebaciNaPanelRegistracija();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        pocetnaForma.lblRegistrujSeActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prebaciNaPanelUlogujSe();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        pocetnaForma.lblExitSeActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                zatvoriFormu();
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void prebaciNaPanelUlogujSe() {
        otvoriPanelUlogujSe();
        prebaciDugmeNaUlogujSe();
    }

    private void prebaciNaPanelRegistracija() {
        otvoriPanelRegistracija();
        prebaciDugmeNaRegistrujSe();
    }

    private void otvoriPanelUlogujSe() {
        pocetnaForma.getPanelRegistracija().setVisible(false);
        pocetnaForma.getPanelUlogujSe().setVisible(true);
    }

    private void otvoriPanelRegistracija() {
        pocetnaForma.getPanelUlogujSe().setVisible(false);
        pocetnaForma.getPanelRegistracija().setVisible(true);
    }

    private void prebaciDugmeNaRegistrujSe() {
        pocetnaForma.getPanelDugme().getLblUlogujSe().setVisible(false);
        pocetnaForma.getPanelDugme().getLblRegistrujSe().setVisible(true);
    }

    private void prebaciDugmeNaUlogujSe() {
        pocetnaForma.getPanelDugme().getLblRegistrujSe().setVisible(false);
        pocetnaForma.getPanelDugme().getLblUlogujSe().setVisible(true);
    }

    public void otvoriFormu() {
        pocetnaForma.setVisible(true);
    }

    public void zatvoriFormu() {
        pocetnaForma.setVisible(false);
    }

    private void centrirajFormu() {
        Toolkit toolkit = pocetnaForma.getToolkit();
        Dimension size = toolkit.getScreenSize();
        pocetnaForma.setLocation(size.width / 2 - pocetnaForma.getWidth() / 2, size.height / 2 - pocetnaForma.getHeight() / 2);
    }

    public void prikaziGlavnuFormu(Klijent klijent) {
        this.zatvoriFormu();
        new KontrolerGlavnaForma(klijent,this);

    }

}
