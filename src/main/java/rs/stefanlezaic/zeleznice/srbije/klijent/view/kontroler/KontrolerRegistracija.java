/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelRegistracija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.InvalidProductException;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;

/**
 *
 * @author Stefan
 */
public class KontrolerRegistracija {

    private Klijent korisnik;
    private JFrame glavnaForma;
    private PanelRegistracija panelRegistracija;

    public KontrolerRegistracija(JFrame glavnaForma, PanelRegistracija panelRegistracija) {
        this.glavnaForma = glavnaForma;
        this.panelRegistracija = panelRegistracija;
        addListener();
    }

    private void addListener() {
        panelRegistracija.btnRegistrujSeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrujse();
            }
        });
    }

    private void registrujse() {
        char[] niz = panelRegistracija.getTxtPassword().getPassword();
        String lozinka = String.copyValueOf(niz);
        char[] niz2 = panelRegistracija.getTxtPasswordPotvrda().getPassword();
        String lozinka2 = String.copyValueOf(niz2);
        if (!lozinka.equals(lozinka2)) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError("Potvrda lozinke neuspesna!"));
            ocistiPoljaLozinke();
            return;
        }
        korisnik = new Klijent();
        korisnik.setLozinka(lozinka);
        pokupiPodatke();
        //mozda ne bih treba da smaram server sa upitom o tome da li je sve popunio al nema veze stoji i na serverskoj strani
        if (korisnik.getKorisnickoIme().isEmpty() || korisnik.getLozinka().isEmpty() || korisnik.getIme().isEmpty() || korisnik.getPrezime().isEmpty() || korisnik.getEmail().isEmpty()) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Sva polja moraju biti popunjena!"));
            return;
        }

        try {
            Kontroler.getInstance().RegistrujSe(korisnik);
            ocistiFormu();
        } catch (Exception ex) {
            if (ex instanceof InvalidProductException) {
                new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError(ex.toString()));
            } else if (ex instanceof SQLException) {
                new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError("Korisnik ne moze biti unesen!"));
            }
        } 
    }

    public void ocistiFormu() {
        panelRegistracija.getTxtIme().setText("");
        panelRegistracija.getTxtPrezime().setText("");
        panelRegistracija.getTxtEmail().setText("");
        panelRegistracija.getTxtKorisnickoIme().setText("");
    }

    private void pokupiPodatke() {
        korisnik.setIme(panelRegistracija.getTxtIme().getText());
        korisnik.setPrezime(panelRegistracija.getTxtPrezime().getText());
        korisnik.setEmail(panelRegistracija.getTxtEmail().getText());
        korisnik.setKorisnickoIme(panelRegistracija.getTxtKorisnickoIme().getText());
    }

    private void ocistiPoljaLozinke() {
        panelRegistracija.getTxtPassword().setText("");
        panelRegistracija.getTxtPasswordPotvrda().setText("");
    }

}
