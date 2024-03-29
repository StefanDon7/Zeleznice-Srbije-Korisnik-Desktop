/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.modeli.tabela;

import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import rs.stefanlezaic.zeleznice.srbije.klijent.kontroler.KontrolerHTTP;

/**
 *
 * @author sleza
 */
public class ModelTabelePolasci extends AbstractTableModel {

    SimpleDateFormat smfDatum = new SimpleDateFormat("dd.MM.yyyy");
    SimpleDateFormat smfVreme = new SimpleDateFormat("HH:mm");
    String[] kolone = {"Linija", "Polazak", "Datum polaska", "Dolazak", "Datum dolaska", "Putuje", "Rang", "Rezervisano/Mesta", "Napomena"};
    ArrayList<Polazak> list = new ArrayList<>();

    @Override
    public int getRowCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Polazak p = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getLinija().getNazivLinije();
            case 1:
                return smfVreme.format(p.getDatumPolaska());
            case 2:
                return smfDatum.format(p.getDatumPolaska());
            case 3:
                return smfVreme.format(p.getDatumDolaska());
            case 4:
                return smfDatum.format(p.getDatumDolaska());
            case 5:
                //vrati vreme putovanja
                int vreme = p.getLinija().getMinutaza();
                int sati = vreme / 60;
                int minuti = vreme % 60;
                if (sati == 0) {
                    return minuti + "min";
                }
                if (minuti == 0) {
                    return sati + "h";
                }
                return sati + "h i " + minuti + "min";
            case 6:
                return p.getLinija().getTipLinije().getNaziv();
            case 7:
                return vratiBroj(p) + "/" + p.getVoz().getBrojSedista();
            case 8:
                return p.getNapomena();
            default:
                return "Cao zdravo!";
        }
    }

    @Override
    public String getColumnName(int column) {
        for (int i = 0; i < kolone.length; i++) {
            return kolone[column];
        }
        return "Cao";
    }

    public void dodajPredmet(Polazak p) {
        list.add(p);
        fireTableDataChanged();
    }

    public void obrisiIzListe(int i) {
        list.remove(i);
        fireTableDataChanged();
    }

    public ArrayList<Polazak> getList() {
        return list;
    }

    public void setList(ArrayList<Polazak> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public void ocistiTabelu() {
        list = new ArrayList<>();
        fireTableDataChanged();
    }

    public ArrayList<Polazak> vratiListu() {
        return list;
    }

    public int vratiBroj(Polazak p) {
        int broj = 0;
        try {
            return KontrolerHTTP.getInstance().vratiBrojRezervacija(p);
        } catch (Exception ex) {
            return broj;
        }
    }

    public boolean popunjeno(Polazak p) {
        return !(vratiBroj(p) < p.getVoz().getBrojSedista());
    }

}
