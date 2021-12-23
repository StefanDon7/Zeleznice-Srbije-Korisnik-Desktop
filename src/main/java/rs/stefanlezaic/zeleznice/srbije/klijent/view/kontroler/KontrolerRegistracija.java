/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler;

import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.KontrolerHTTP;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.component.PanelRegistracija;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.buttons.AbstractButton;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.InvalidProductException;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

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
        ucitajSveIkonice();
        addListener();
    }

    private void addListener() {
        panelRegistracija.btnRegistrujSeMouseListener(new AbstractButton(panelRegistracija.getBtnRegistrujSe(), "register", "register1") {
            @Override
            public void execute() {
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
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Potvrda lozinke neuspesna!"));
            ocistiPoljaLozinke();
            return;
        }
        korisnik = new Klijent();

        try {
            pokupiPodatke();
            korisnik.setLozinka(lozinka);
        } catch (ParametarsException ex) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention(ex.getMessage()));
            return;
        }

        try {
            Klijent korisnikVracen = KontrolerHTTP.getInstance().registrujSe(korisnik);
            System.out.println(korisnikVracen);
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelSuccess("Uspešno ste napravili nalog!"));
            ocistiFormu();
        } catch (Exception ex) {
            if (ex instanceof InvalidProductException) {
                new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError(ex.getMessage()));
            } else if (ex instanceof SQLException) {
                new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError("Data email adresa već postoji u sistemu!"));
            } else if (ex instanceof Exception) {
                new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError("Sistem ne može da napravi nalog!"));
            }
        }
    }

    public void ocistiFormu() {
        panelRegistracija.getTxtEmail().setText("");
        panelRegistracija.getTxtIme().setText("");
        panelRegistracija.getTxtPrezime().setText("");
        panelRegistracija.getTxtKorisnickoIme().setText("");
        panelRegistracija.getTxtPassword().setText("");
        panelRegistracija.getTxtPasswordPotvrda().setText("");
    }

    private void pokupiPodatke() throws ParametarsException {
        korisnik.setEmail(panelRegistracija.getTxtEmail().getText());
        korisnik.setIme(panelRegistracija.getTxtIme().getText());
        korisnik.setPrezime(panelRegistracija.getTxtPrezime().getText());
        korisnik.setKorisnickoIme(panelRegistracija.getTxtKorisnickoIme().getText());
    }

    private void ocistiPoljaLozinke() {
        panelRegistracija.getTxtPassword().setText("");
        panelRegistracija.getTxtPasswordPotvrda().setText("");
    }

    private void ucitajSveIkonice() {
        panelRegistracija.getLblEmailRegistracija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/email.png")));
        panelRegistracija.getLblImeRegistracija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/ime.png")));
        panelRegistracija.getLblPrezimeRegistracija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/ime.png")));
        panelRegistracija.getLblKorisnickoImeRegistracija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/korisnickoIme.png")));
        panelRegistracija.getLblLozinakRegistracija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/kljuc.png")));
        panelRegistracija.getLblPotvrdaLozinkeRegistracija().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/kljuc2.png")));
        panelRegistracija.getBtnRegistrujSe().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/register.png")));
    }

}
