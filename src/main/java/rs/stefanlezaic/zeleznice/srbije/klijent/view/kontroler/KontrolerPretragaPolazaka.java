/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.FormaRezervacije;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.Kontroler;
import rs.stefanlezaic.zeleznice.srbije.klijent.modeli.Prikaz;
import rs.stefanlezaic.zeleznice.srbije.klijent.modeli.tabela.ModelTabelePolasci;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelPretragraPolazaka;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Linija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Rezervacija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import rs.stefanlezaic.zeleznice.srbije.lib.kalendar.Vreme;
import rs.stefanlezaic.zeleznice.srbije.lib.swing.Tabela;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelSuccess;

/**
 *
 * @author Stefan
 */
public class KontrolerPretragaPolazaka {

    private Rezervacija rezervacija;
    private Klijent korisnik;
    private JFrame glavnaForma;
    private Prikaz prikaz;
    private PanelPretragraPolazaka panelPretragaPolazaka;
    private final ModelTabelePolasci mtp = new ModelTabelePolasci();
    private final SimpleDateFormat smf = new SimpleDateFormat("dd.MM.yyyy");
    private final Tabela tabela = new Tabela();

    public KontrolerPretragaPolazaka(JFrame glavnaForma, PanelPretragraPolazaka panelPretragraPolazaka, Klijent korisnik) {
        this.glavnaForma = glavnaForma;
        this.korisnik = korisnik;
        this.panelPretragaPolazaka = panelPretragraPolazaka;
        urediPanelDatum();
        ucitajIkonice();
        urediTabelu();
        ucitajStanice();
        addListener();
    }

    private void addListener() {
        panelPretragaPolazaka.btnRezervisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rezervisi();
            }
        });
        panelPretragaPolazaka.btnPretraziPolaskeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretrazi();
            }
        });
        panelPretragaPolazaka.btnRefreshTabelaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        panelPretragaPolazaka.btnSviPolasciDanasActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sviPolasciDanas();
            }
        });
        panelPretragaPolazaka.btnViseOPolaskuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viseOPolasku();
            }
        });
    }

    private void rezervisi() {
        int red = panelPretragaPolazaka.getTablePolasci().getSelectedRow();
        if (red == -1) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Morate izabrati polazak!"));
            return;
        }
        Polazak p = mtp.vratiListu().get(red);
        //        if (p.getNapomena() != null && (p.getNapomena().contains("OTKAZANO") || p.getNapomena().contains("Otkazano") || p.getNapomena().contains("Otkazan"))) {
        //            JOptionPane.showMessageDialog(this, "Polazak je otkazan. Ne mozete ga rezervisati!");
        //            return;
        //        }
        //ovo moze u validaciji
        //        if (p.getDatumPolaska().before(new Date())) {
        //            JOptionPane.showMessageDialog(this, "Ne mozete rezervisati kartu za polazak koji je vec realizovan!");
        //            return;
        //        }
        //        Rezervacija rez = new Rezervacija(null, p, null);
        //        boolean popunjeno = mtp.popunjeno(rez);
        //        if (!popunjeno) {
        //            pretraziPolaskeZaDatum();
        //        } else {
        //            JOptionPane.showMessageDialog(this, "Popunjena su sva mesta!");
        //        }
        Date d = new Date();
        rezervacija = new Rezervacija(korisnik, p, d);
        try {
            Kontroler.getInstance().rezervisiPolazak(rezervacija);
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelSuccess("Uspesno ste rezervisali kartu za polazak!"));
        } catch (Exception ex) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError(ex.getMessage()));
        }

    }

    private void pretrazi() {
        prikaz = Prikaz.MOJA_PRETRAGA;
        pretraziPolaskeZaPocetnuKrajnuDatum();
    }

    private void sviPolasciDanas() {
        prikaz = Prikaz.DNEVNA_PRETRAGA;
        pretraziPolaskeZaDatum();
    }

    private void refresh() {
        switch (prikaz) {
            case DNEVNA_PRETRAGA:
                pretraziPolaskeZaDatum();
                break;
            case MOJA_PRETRAGA:
                pretraziPolaskeZaPocetnuKrajnuDatum();
                break;
            default:
                new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError("Greska!"));
        }
    }

    private void pretraziPolaskeZaPocetnuKrajnuDatum() {
        Date date = null;
        try {
            date = panelPretragaPolazaka.getPanelDatum1().getUtilDate();
        } catch (Exception ex) {
            Logger.getLogger(FormaRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stanica pocetna = (Stanica) panelPretragaPolazaka.getCmbPocetnaStanica().getSelectedItem();
        Stanica krajnja = (Stanica) panelPretragaPolazaka.getCmbKrajnjaStanica().getSelectedItem();

        Polazak p = new Polazak(-1, "", date, null, new Linija(-1, null, -1, -1, pocetna, krajnja, null), null);

        ArrayList<Polazak> listPolazaka = new ArrayList<>();
        try {
            listPolazaka = Kontroler.getInstance().vratiMiPolaskeZaDatumPocetnuIKrajnjuStanicu(p);
        } catch (Exception ex) {
            Logger.getLogger(FormaRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }

        mtp.ocistiTabelu();
        if (listPolazaka.isEmpty()) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Nema polazaka za datu realaciju!"));
            return;
        }
        mtp.setList(listPolazaka);
        panelPretragaPolazaka.getTablePolasci().setModel(mtp);
    }

    private void pretraziPolaskeZaDatum() {
        Date date = new Date();
        Polazak p = new Polazak(-1, "", date, null, null, null);
        ArrayList<Polazak> listPolazaka = new ArrayList<>();
        try {
            listPolazaka = Kontroler.getInstance().vratiMiPolaskeZaDatum(p);
        } catch (Exception ex) {
            Logger.getLogger(FormaRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (listPolazaka.isEmpty()) {
            panelPretragaPolazaka.getLblNazivTabele().setText("Nema polazaka za datum: " + smf.format(date));
            return;
        } else {
            panelPretragaPolazaka.getLblNazivTabele().setText("Svi polasci za datum: " + smf.format(date));
        }
        mtp.ocistiTabelu();
        mtp.setList(listPolazaka);
        panelPretragaPolazaka.getTablePolasci().setModel(mtp);
    }

    private void viseOPolasku() {
        int broj = panelPretragaPolazaka.getTablePolasci().getSelectedRow();
        if (broj == -1) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelAttention("Izaberite polazak za koji zelite da vidite sve medjustanice!"));
            return;
        }
        Polazak p = mtp.getList().get(broj);
        MedjuStanica m = new MedjuStanica(null, p.getLinija(), 0);
        ArrayList<MedjuStanica> listaMedjustanica;
        try {
            listaMedjustanica = Kontroler.getInstance().vratiMiMedjustaniceLiniju(m);
            JOptionPane.showMessageDialog(glavnaForma, ispisiListu(listaMedjustanica), p.getLinija().getStanicaPocetna() + "-" + p.getLinija().getStanicaKrajnja() + " (" + p.getLinija().getTipLinije() + ")", 1);
        } catch (Exception ex) {
            new JOptionPaneExample().createAndDisplayGUI(glavnaForma, new PanelError(ex.toString()));
        }
    }

    private String ispisiListu(ArrayList<MedjuStanica> lista) {
        String listaString = "";
        for (MedjuStanica medjuStanica : lista) {
            listaString += medjuStanica.getRedniBroj() + ". ";
            listaString += medjuStanica.getStanica().getNaziv();
            listaString += "\n";
        }
        return listaString;
    }

    private void urediTabelu() {
        panelPretragaPolazaka.getTablePolasci().setModel(mtp);
        tabela.urediTabelu(panelPretragaPolazaka.getTablePolasci());
    }

    private void urediPanelDatum() {
        panelPretragaPolazaka.getPanelDatum1().postavi(3, Vreme.Unapred);
        panelPretragaPolazaka.getPanelDatum1().postaviDanasnjiDatum();
    }

    private void ucitajStanice() {
        panelPretragaPolazaka.getCmbPocetnaStanica().removeAllItems();
        panelPretragaPolazaka.getCmbKrajnjaStanica().removeAllItems();

        ArrayList<Stanica> listaStanica = new ArrayList<>();
        try {
            listaStanica = Kontroler.getInstance().vratiMiSveStanice();
        } catch (Exception ex) {
            Logger.getLogger(FormaRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Stanica stanica : listaStanica) {
            panelPretragaPolazaka.getCmbPocetnaStanica().addItem(stanica);
            panelPretragaPolazaka.getCmbKrajnjaStanica().addItem(stanica);
        }

    }

    private void ucitajIkonice() {
        panelPretragaPolazaka.getLblOd().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/lokacijaCovek.png")));
        panelPretragaPolazaka.getLblDo().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/lokacija.png")));
        panelPretragaPolazaka.getLblDatum().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/datumVreme.png")));
        panelPretragaPolazaka.getBtnPretraziPolaske().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/pretraga.png")));
        panelPretragaPolazaka.getBtnRefreshTabela().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/refresh2.png")));
        panelPretragaPolazaka.getBtnSviPolasciDUGME().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/datumIVreme.png")));
        panelPretragaPolazaka.getBtnRezervisi().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/potvrdi.png")));
        panelPretragaPolazaka.getBtnViseOPolasku().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/informacije.png")));

    }

}
