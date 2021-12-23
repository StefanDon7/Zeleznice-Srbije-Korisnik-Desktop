/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.KontrolerHTTP;
import rs.stefanlezaic.zeleznice.srbije.klijent.modeli.tabela.ModelTabeleRezervacija;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelRezervacije;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.buttons.AbstractButton;
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

    public ModelTabeleRezervacija getMtr() {
        return mtr;
    }
    
    private void addListener() {
        panelRezervacije.btnAktivneRezervacijeMouseListener(new AbstractButton(panelRezervacije.getBtnAktivneRezervacije(), "voz", "voz1") {
            @Override
            public void execute() {
                aktivneRezervacije();
            }
        });
        panelRezervacije.btnOtkaziRezervacijuMouseListener(new AbstractButton(panelRezervacije.getBtnOtkaziRezervaciju(), "obrisi", "obrisi1") {
            @Override
            public void execute() {
                otkaziRezervaciju();
            }
        });
        panelRezervacije.btnRealizovaneRezervacijeMouseListener(new AbstractButton(panelRezervacije.getBtnRealizovaneRezervacije(), "potvrda", "potvrda1") {
            @Override
            public void execute() {
                realizovaneRezervacije();
            }
        });
        panelRezervacije.btnRefreshTabelaMouseListener(new AbstractButton(panelRezervacije.getBtnRefreshTabela(), "refresh", "refresh1") {
            @Override
            public void execute() {
                ucitajSveRezervacije();
            }
        });
    }

    private void otkaziRezervaciju() {
        int broj = panelRezervacije.getTabelMojeRezeravacije().getSelectedRow();
        if (broj == -1) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Izaberite rezervaciju!"));
            return;
        }
        Rezervacija r = mtr.getList().get(broj);
        Date danasnji = new Date();

        //Ovo bi trebalo da ide u validaciju
        if (danasnji.after(r.getPolazak().getDatumPolaska())) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Polazak je već realizovan!"));
            return;
        }
        try {
            KontrolerHTTP.getInstance().otkaziRezervaciju(new Rezervacija(r.getRezervacijaID()));
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelSuccess("Uspešno ste otkazali rezervaciju!"));
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
            KontrolerHTTP.getInstance().vratiMojeRezervacije(korisnik);
            listaRezervacija = KontrolerHTTP.getInstance().vratiMojeRezervacije(korisnik);
        } catch (Exception ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        mtr.setList(listaRezervacija);
    }

    private void uradiTabelu() {
        tabela.urediTabelu(panelRezervacije.getTabelMojeRezeravacije());
        panelRezervacije.getTabelMojeRezeravacije().setModel(mtr);
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < panelRezervacije.getTabelMojeRezeravacije().getColumnCount(); i++) {
           panelRezervacije.getTabelMojeRezeravacije().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void ucitajIkonice() {
        panelRezervacije.getLblNazivTabeleMojeRezervacije().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/lista.png")));
        panelRezervacije.getBtnAktivneRezervacije().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/voz.png")));
        panelRezervacije.getBtnOtkaziRezervaciju().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/obrisi.png")));
        panelRezervacije.getBtnRealizovaneRezervacije().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/potvrda.png")));
        panelRezervacije.getBtnRefreshTabela().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/refresh.png")));
    }

}
