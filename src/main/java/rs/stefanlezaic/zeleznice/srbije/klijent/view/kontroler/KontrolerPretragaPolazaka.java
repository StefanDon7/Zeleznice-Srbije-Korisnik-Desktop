/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import rs.stefanlezaic.zeleznice.srbije.klijent.form.GlavnaForma;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.KontrolerHTTP;
import rs.stefanlezaic.zeleznice.srbije.klijent.modeli.Prikaz;
import rs.stefanlezaic.zeleznice.srbije.klijent.modeli.tabela.ModelTabelePolasci;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.PanelPretragraPolazaka;
import rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.buttons.AbstractButton;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
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
        panelPretragaPolazaka.btnPretraziPolaskeMouseListener(new AbstractButton(panelPretragaPolazaka.getBtnPretraziPolaske(), "pretraga", "pretraga1") {
            @Override
            public void execute() {
                pretrazi();
            }
        });
        panelPretragaPolazaka.btnRefreshTabelaMouseListener(new AbstractButton(panelPretragaPolazaka.getBtnRefreshTabela(), "refresh", "refresh1") {
            @Override
            public void execute() {
                refresh();
            }
        });
        panelPretragaPolazaka.btnRezervisiMouseListener(new AbstractButton(panelPretragaPolazaka.getBtnRezervisi(), "potvrda", "potvrda1") {
            @Override
            public void execute() {
                rezervisi();
            }
        });
        panelPretragaPolazaka.btnSviPolasciDanasMouseListener(new AbstractButton(panelPretragaPolazaka.getBtnSviPolasciDUGME(), "kalendar", "kalendar1") {
            @Override
            public void execute() {
                sviPolasciDanas();
            }
        });

        panelPretragaPolazaka.btnViseOPolaskuMouseListener(new AbstractButton(panelPretragaPolazaka.getBtnViseOPolasku(), "informacije", "informacije1") {
            @Override
            public void execute() {
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
        rezervacija = new Rezervacija(new Klijent(korisnik.getKlijentID()), new Polazak(p.getPolazakID()));
        try {
            KontrolerHTTP.getInstance().rezervisiPolazak(rezervacija);
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
        String date = null;
        try {
            date = panelPretragaPolazaka.getPanelDatum1().getSQLDate();
        } catch (Exception ex) {
            System.out.println("vraca");
        }
        Stanica pocetna = (Stanica) panelPretragaPolazaka.getCmbPocetnaStanica().getSelectedItem();
        Stanica krajnja = (Stanica) panelPretragaPolazaka.getCmbKrajnjaStanica().getSelectedItem();

        ArrayList<Polazak> listPolazaka = new ArrayList<>();
        try {
            listPolazaka = KontrolerHTTP.getInstance().vratiMiPolaske(pocetna,krajnja,date);
        } catch (Exception ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
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
        String datum = null;
        try {
            datum = panelPretragaPolazaka.getPanelDatum1().getSQLDate(date);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerPretragaPolazaka.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Polazak> listPolazaka = new ArrayList<>();
        try {
            listPolazaka = KontrolerHTTP.getInstance().vratiMiPolaskeZaDatum(datum);
        } catch (Exception ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
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
        ArrayList<MedjuStanica> listaMedjustanica;
        try {
            listaMedjustanica = KontrolerHTTP.getInstance().vratiMiMedjustaniceLiniju(p.getLinija());
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
            listaStanica = KontrolerHTTP.getInstance().vratiMiSveStanice();
        } catch (Exception ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
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
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/refresh.png")));
        panelPretragaPolazaka.getBtnSviPolasciDUGME().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/kalendar.png")));
        panelPretragaPolazaka.getBtnRezervisi().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/potvrda.png")));
        panelPretragaPolazaka.getBtnViseOPolasku().setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/informacije.png")));

    }

}
