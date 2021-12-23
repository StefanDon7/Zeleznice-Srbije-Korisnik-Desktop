/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.KontrolerHTTP;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelKorisnik;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.buttons.AbstractButton;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author Stefan
 */
public class KontrolerKorisnik {

    private final JFrame glavnaForma;
    private Klijent korisnik;
    private final PanelKorisnik panelKorisnika;

    public KontrolerKorisnik(GlavnaForma glavnaForma, PanelKorisnik panelKorisnik, Klijent korisnik) {
        this.glavnaForma = glavnaForma;
        this.korisnik = korisnik;
        this.panelKorisnika = panelKorisnik;
        popuniKorisnika();
        ucitajIkonice();
        addListener();
    }

    private void addListener() {
        panelKorisnika.btnPromeniMouseListener(new AbstractButton(panelKorisnika.getBtnPromeni(), "save", "save1") {
            @Override
            public void execute() {
                promeni();
            }
        });
    }

    private void promeni() {
        String ime = panelKorisnika.getTxtIme().getText();
        String prezime = panelKorisnika.getTxtPrezime().getText();
        String email = panelKorisnika.getTxtEmail().getText();
        String korisnickoIme = panelKorisnika.getTxtKorisnickoIme().getText();
        char[] niz = panelKorisnika.getTxtPassword().getPassword();
        String lozinka = String.copyValueOf(niz);
        char[] niz2 = panelKorisnika.getTxtPasswordPotvrda().getPassword();
        String lozinka2 = String.copyValueOf(niz2);

        if (korisnik.getKorisnickoIme().equals(korisnickoIme) && lozinka.isEmpty() && lozinka2.isEmpty()) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Niste napravili nikakvu promenu!"));
            return;
        }

        if (!lozinka.equals(lozinka2)) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Potrvrda lozinke nije uspela!"));
            return;
        }
        Klijent klijent = new Klijent(korisnik.getKlijentID(), email, korisnickoIme, ime, prezime, lozinka);
        try {
            if (!korisnickoIme.isEmpty()) {
                KontrolerHTTP.getInstance().izmeniKorisnickoIme(klijent);
            }
            if (!lozinka.isEmpty()) {
                 KontrolerHTTP.getInstance().izmeniLozinku(klijent);
            }
            korisnik = klijent;
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelSuccess("Uspešno ste izmenili podatake!"));
        } catch (Exception ex) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError(ex.getMessage()));
        } finally {
            panelKorisnika.getTxtPassword().setText("");
            panelKorisnika.getTxtPasswordPotvrda().setText("");
        }
    }

    private void popuniKorisnika() {
        panelKorisnika.getTxtEmail().setText(korisnik.getEmail());
        panelKorisnika.getTxtIme().setText(korisnik.getIme());
        panelKorisnika.getTxtPrezime().setText(korisnik.getPrezime());
        panelKorisnika.getTxtKorisnickoIme().setText(korisnik.getKorisnickoIme());
    }

    private void ucitajIkonice() {
        panelKorisnika.getLblEmail().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/email.png")));
        panelKorisnika.getLblIme().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/ime.png")));
        panelKorisnika.getLblPrezime().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/ime.png")));
        panelKorisnika.getLblKorisnickoIme().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/korisnickoIme.png")));
        panelKorisnika.getLblLozinak().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/kljuc.png")));
        panelKorisnika.getLblPotvrdaLozinke().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/kljuc2.png")));
        panelKorisnika.getBtnPromeni().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/save.png")));

    }

}
