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
import javax.swing.Box;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.FormaLoginRegistracija;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.PocetnaForma;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.KontrolerKorisnik;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.KontrolerPretragaPolazaka;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.KontrolerRezervacije;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.theme.Tema;

/**
 *
 * @author Stefan
 */
public class KontrolerGlavnaForma {

    private GlavnaForma glavnaForma;
    private Klijent korisnik;
    private Tema tema;
    private KontrolerPretragaPolazaka kpk;
    private KontrolerKorisnik kk;
    private KontrolerRezervacije kr;
    private KontrolerPocetneForme kontrolerPocetneForme;

    public KontrolerGlavnaForma(Klijent korisnik, KontrolerPocetneForme kontrolerPocetneForme) {
        this.glavnaForma = new GlavnaForma();
        this.korisnik = korisnik;
        this.kontrolerPocetneForme = kontrolerPocetneForme;
        tema = new Tema(glavnaForma);
        tema.blackTheme();
        ucitajPotrebneKontrolere();
        otvoriFormu();
        pokreniPanelPretraga();
        centrirajFormu();
        menuOdjavaSaDesneStrane();
        addListener();
    }

    private void addListener() {
        glavnaForma.menuPretragaActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuPretraga();
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
        glavnaForma.menuNalogActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuNalog();
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
        glavnaForma.menuMojeRezervacijeActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuRezervacije();
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
        glavnaForma.menuOdjavaActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuOdjaviSe();
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

    private void menuPretraga() {
        pokreniPanelPretraga();
    }

    private void menuNalog() {
        pokreniPanelNalog();
    }

    private void menuRezervacije() {
        pokreniPanelMojeRezervacije();
    }

    private void menuOdjaviSe() {
        glavnaForma.setVisible(false);
        glavnaForma = null;
        kontrolerPocetneForme.otvoriFormu();
        kontrolerPocetneForme.getKontrolerRegistracija().ocistiFormu();
        kontrolerPocetneForme.getKontrolerUlogujSe().ocistiFormu();
    }

    private void pokreniPanelPretraga() {
        glavnaForma.getPanelKorisnik().setVisible(false);
        glavnaForma.getPanelRezervacije().setVisible(false);
        glavnaForma.getPanelPretragraPolazaka().setVisible(true);
    }

    private void pokreniPanelNalog() {
        glavnaForma.getPanelPretragraPolazaka().setVisible(false);
        glavnaForma.getPanelRezervacije().setVisible(false);
        glavnaForma.getPanelKorisnik().setVisible(true);
    }

    private void pokreniPanelMojeRezervacije() {
        glavnaForma.getPanelPretragraPolazaka().setVisible(false);
        glavnaForma.getPanelKorisnik().setVisible(false);
        glavnaForma.getPanelRezervacije().setVisible(true);
    }

    private void ucitajPotrebneKontrolere() {
        kpk = new KontrolerPretragaPolazaka(glavnaForma, glavnaForma.getPanelPretragraPolazaka(), korisnik);
        kk = new KontrolerKorisnik(glavnaForma, glavnaForma.getPanelKorisnik(), korisnik);
        kr = new KontrolerRezervacije(glavnaForma, glavnaForma.getPanelRezervacije(), korisnik);
    }

    private void menuOdjavaSaDesneStrane() {
        glavnaForma.getMenu().add(Box.createHorizontalGlue());
        glavnaForma.getMenu().add(Box.createHorizontalGlue());
        glavnaForma.getMenu().add(glavnaForma.getMenuOdjava());
    }

    public void otvoriFormu() {
        glavnaForma.setVisible(true);
    }

    public void zatvoriFormu() {
        glavnaForma.setVisible(false);
    }

    private void centrirajFormu() {
        Toolkit toolkit = glavnaForma.getToolkit();
        Dimension size = toolkit.getScreenSize();
        glavnaForma.setLocation(size.width / 2 - glavnaForma.getWidth() / 2, size.height / 2 - glavnaForma.getHeight() / 2);
    }

}
