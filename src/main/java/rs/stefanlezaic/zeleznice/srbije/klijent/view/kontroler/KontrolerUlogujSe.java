/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.kontroler.KontrolerPocetneForme;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.component.PanelUlogujSe;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.buttons.AbstractButton;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.EntityNotFoundException;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author Stefan
 */
public class KontrolerUlogujSe {

    private Klijent korisnik;
    private JFrame forma;
    private PanelUlogujSe panelUlogujSe;
    private KontrolerPocetneForme kontrolerPocetneForme;

    public KontrolerUlogujSe(JFrame forma, PanelUlogujSe panelUlogujSe, KontrolerPocetneForme kontrolerPocetneForme) {
        this.forma = forma;
        this.panelUlogujSe = panelUlogujSe;
        this.kontrolerPocetneForme = kontrolerPocetneForme;
        ucitajIkonice();
        addListener();
    }

    private void addListener() {       
        panelUlogujSe.btnPrijaviSeMouseListener(new AbstractButton(panelUlogujSe.getBtnPrijaviSe(), "logIn", "logIn1") {
            @Override
            public void execute() {
                ulogujSe();
            }
        });
    }

    private void ulogujSe() {
        String email = panelUlogujSe.getTxtEmailLogin().getText();
        String lozinka = new String(panelUlogujSe.getTxtPasswordLogin().getPassword());
        korisnik = new Klijent(-1, "korisnickoIme", lozinka, "ime", "prezime", email);

        if (email.isEmpty() || lozinka.isEmpty()) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelAttention("Sva polja moraju biti popunjena!"));
            return;
        }
        Klijent klijent;
        try {
            klijent = Kontroler.getInstance().UlogujSe(korisnik);
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelSuccess("Korisnik: " + klijent.getIme() + " " + klijent.getPrezime() + ".\nUspesno ste se prijavili!"));
            kontrolerPocetneForme.prikaziGlavnuFormu(klijent);
        } catch (EntityNotFoundException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        } catch (SQLException ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        } catch (Exception ex) {
            new JOptionPaneExample().createAndDisplayGUI(forma, new PanelError(ex.getMessage()));
        }
    }

    public void ocistiFormu() {
        panelUlogujSe.getTxtEmailLogin().setText("");
        panelUlogujSe.getTxtPasswordLogin().setText("");
    }

    private void ucitajIkonice() {
        panelUlogujSe.getLblEmailLogin().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/email.png")));
        panelUlogujSe.getLblLoznikaLogin().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/kljuc.png")));
        panelUlogujSe.getBtnPrijaviSe().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/logIn.png")));
    }

}
