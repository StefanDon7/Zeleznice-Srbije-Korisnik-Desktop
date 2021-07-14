/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelKorisnik;
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
        this.panelKorisnika=panelKorisnik;
        popuniKorisnika();
        addListener();
    }

    private void addListener() {
        panelKorisnika.btnPromeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        if (lozinka.isEmpty() && lozinka2.isEmpty()) {
            lozinka = korisnik.getLozinka();
            lozinka2 = korisnik.getLozinka();
        }
        if (!lozinka.equals(lozinka2)) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Potrvrda lozinke nije dobra!"));
            return;
        }
        Klijent klijent = new Klijent(korisnik.getKlijentID(), korisnickoIme, lozinka, ime, prezime, email);
        try {
            Kontroler.getInstance().IzmeniNalog(klijent);
            korisnik = klijent;
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelSuccess("Uspesno ste izmenili podatake!"));
        } catch (Exception ex) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError(ex.toString()));
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

}
