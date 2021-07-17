/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.FormaRezervacije;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.klijent.modeli.tabela.ModelTabeleRezervacija;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelRezervacije;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Rezervacija;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.InvalidProductException;
import rs.stefanlezaic.zeleznice.srbije.lib.swing.Tabela;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author Stefan
 */
public class KontrolerRezervacije {

    private final JFrame glavnaForma;
    private Klijent korisnik;
    private ArrayList<Rezervacija> listaRezervacija;
    private final PanelRezervacije panelRezervacije;
    private final ModelTabeleRezervacija mtr = new ModelTabeleRezervacija();
    private final Tabela tabela = new Tabela();

    public KontrolerRezervacije(GlavnaForma glavnaForma, PanelRezervacije panelRezervacije, Klijent korisnik) {
        this.glavnaForma = glavnaForma;
        this.korisnik = korisnik;
        this.panelRezervacije = panelRezervacije;
        ucitajIkonice();
        ucitajSveRezervacije();
        uradiTabelu();
        addListener();
    }

    private void addListener() {
        panelRezervacije.btnAktivneRezervacijeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aktivneRezervacije();
            }
        });
        panelRezervacije.btnRealizovaneRezervacijeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizovaneRezervacije();
            }
        });
        panelRezervacije.btnOtkaziRezervacijuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                otkaziRezervaciju();
            }
        });
        panelRezervacije.btnRefreshTabelaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ucitajSveRezervacije();
            }
        });
    }

    private void otkaziRezervaciju() {
        int broj = panelRezervacije.getTabelMojeRezeravacije().getSelectedRow();
        if (broj == -1) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Izaberite polazak!"));
            return;
        }
        Rezervacija r = mtr.getList().get(broj);
        Date danasnji = new Date();

        //Ovo bi trebalo da ide u validaciju
        if (danasnji.after(r.getPolazak().getDatumPolaska())) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Polazak je vec realizovan!"));
            return;
        }
        try {
            Kontroler.getInstance().otkaziRezervaciju(r);
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelSuccess("Uspesno ste otkazali rezervaciju!"));
            mtr.izbrisiIzTabele(broj);
        } catch (InvalidProductException ex) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError(ex.toString()));
        } catch (Exception ex) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError(ex.toString()));
        }

    }

    private void aktivneRezervacije() {
        Date datum = new Date();
        ArrayList<Rezervacija> listaAkt = new ArrayList<>();
        for (Rezervacija rezervacija : listaRezervacija) {
            if (datum.before(rezervacija.getPolazak().getDatumPolaska())) {
                listaAkt.add(rezervacija);
            }
        }
        if (!listaAkt.isEmpty()) {
            mtr.ocistiTabelu();
            mtr.setList(listaAkt);
        } else {
            mtr.ocistiTabelu();
        }
    }

    private void realizovaneRezervacije() {
        Date datum = new Date();
        ArrayList<Rezervacija> listaRealizovanih = new ArrayList<>();
        for (Rezervacija rezervacija : listaRezervacija) {
            if (datum.after(rezervacija.getPolazak().getDatumPolaska())) {
                listaRealizovanih.add(rezervacija);
            }
        }
        if (!listaRealizovanih.isEmpty()) {
            mtr.ocistiTabelu();
            mtr.setList(listaRealizovanih);
        } else {
            mtr.ocistiTabelu();
        }
    }

    public void ucitajSveRezervacije() {
        listaRezervacija = new ArrayList<>();
        try {
            listaRezervacija = Kontroler.getInstance().vratiMojeRezervacije(new Rezervacija(korisnik, null, null));
        } catch (Exception ex) {
            Logger.getLogger(FormaRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
        mtr.setList(listaRezervacija);
        panelRezervacije.getTabelMojeRezeravacije().setModel(mtr);
    }

    private void uradiTabelu() {
        tabela.urediTabelu(panelRezervacije.getTabelMojeRezeravacije());
        panelRezervacije.getTabelMojeRezeravacije().setModel(mtr);
    }

    private void ucitajIkonice() {
        panelRezervacije.getLblNazivTabeleMojeRezervacije().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/lista.png")));
        panelRezervacije.getBtnAktivneRezervacije().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/voz.png")));
        panelRezervacije.getBtnOtkaziRezervaciju().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/obrisi.png")));
        panelRezervacije.getBtnRealizovaneRezervacije().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/prosleRezervacije.png")));
        panelRezervacije.getBtnRefreshTabela().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/refresh.png")));
    }

}
