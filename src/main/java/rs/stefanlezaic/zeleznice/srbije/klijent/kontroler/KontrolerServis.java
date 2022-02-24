/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.kontroler;

import java.util.ArrayList;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Rezervacija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;

/**
 *
 * @author Stefan
 */
public interface KontrolerServis {

    public Klijent ulogujSe(Klijent k) throws Exception;

    public void registrujSe(Klijent k) throws Exception;

    public void rezervisiPolazak(Rezervacija r) throws Exception;

    public ArrayList<Rezervacija> vratiMojeRezervacije(Rezervacija r) throws Exception;

    public void izmeniNalog(Klijent klijent) throws Exception;

    public int vratiBrojRezervacija(Rezervacija r) throws Exception;

    public void otkaziRezervaciju(Rezervacija r) throws Exception;

    public ArrayList<MedjuStanica> vratiMiMedjustaniceLiniju(MedjuStanica medjuStanica) throws Exception;

    public ArrayList<Stanica> vratiMiSveStanice() throws Exception;

    public ArrayList<Polazak> vratiMiPolaskeZaDatum(Polazak p) throws Exception;

    public ArrayList<Polazak> vratiMiPolaskeZaDatumPocetnuIKrajnjuStanicu(Polazak p) throws Exception;
}
