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
import rs.stefanlezaic.zeleznice.srbije.klijent.form.GlavnaForma;
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
        ucitajIkonice();
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
                glavnaForma.getMenuPretraga().setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/search1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                glavnaForma.getMenuPretraga().setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/search.png")));
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
                glavnaForma.getMenuNalog().setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/user1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                glavnaForma.getMenuNalog().setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/user.png")));
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
                glavnaForma.getMenuMojeRezervacije().setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/karta1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                glavnaForma.getMenuMojeRezervacije().setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/karta.png")));

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
                glavnaForma.getMenuOdjava().setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/logOut1.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                glavnaForma.getMenuOdjava().setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/logOut.png")));
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

    private void ucitajIkonice() {
        try {
            glavnaForma.getMenuPretraga().setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/search.png")));
            glavnaForma.getMenuNalog().setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/user.png")));
            glavnaForma.getMenuMojeRezervacije().setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/karta.png")));
            glavnaForma.getMenuOdjava().setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/logOut.png")));
        } catch (Exception e) {
            System.out.println("ds;gaagd");
        }

    }

}
