/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.kontroler;

import java.io.IOException;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Rezervacija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;
import java.util.ArrayList;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import rs.stefanlezaic.zeleznice.srbije.klijent.komunikacija.KomunikacijaSaServerom;
import rs.stefanlezaic.zeleznice.srbije.lib.kons.Konstante;
import rs.stefanlezaic.zeleznice.srbije.lib.kons.ResponseStatus;
import rs.stefanlezaic.zeleznice.srbije.lib.transfer.KlijentskiZahtev;
import rs.stefanlezaic.zeleznice.srbije.lib.transfer.ServerskiOdgovor;

/**
 *
 * @author sleza
 */
public class Kontroler {

    private static Kontroler instance;
    private KlijentskiZahtev kz;
    private final OkHttpClient httpClient = new OkHttpClient();

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    /*TCP*/
    public Klijent ulogujSe(Klijent k) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setParametar(k);
        kz.setOperacija(Konstante.PRIJAVLJIVANJE);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return (Klijent) so.getOdgovor();
    }

    /*HTTP*/
    public Klijent ulogujSeHTTP(String email, String lozinka) throws IOException, Exception {
        Klijent klijent;
        String json = new StringBuilder()
                .append("{\r\n")
                .append("\"email\":\"" + email + "\",")
                .append("\"lozinka\":\"" + lozinka + "\"")
                .append("}").toString();
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/klijent/get")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        System.out.println(request);

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            JSONObject json2 = new JSONObject(response.body().string());
            klijent = new Klijent(json2.getInt("klijentID"), json2.getString("korisnickoIme"), json2.getString("lozinka"), json2.getString("ime"), json2.getString("prezime"), json2.getString("email"));
            // Get response body

        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj prijave!");
        }
        return klijent;
    }

    public void registrujSe(Klijent k) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.REGISTRACIJA);
        kz.setParametar(k);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public Klijent registrujSeHTTP(Klijent k) throws IOException, Exception {
        Klijent klijent;
        String json = new StringBuilder()
                .append("{\r\n")
                .append("\"email\":\"" + k.getEmail() + "\",")
                .append("\"korisnickoIme\":\"" + k.getKorisnickoIme() + "\",")
                .append("\"ime\":\"" + k.getIme() + "\",")
                .append("\"prezime\":\"" + k.getPrezime() + "\",")
                .append("\"lozinka\":\"" + k.getLozinka() + "\"")
                .append("}").toString();
        System.out.println(json);
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/klijent/add")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            JSONObject json2 = new JSONObject(response.body().string());
            klijent = new Klijent(json2.getInt("klijentID"), json2.getString("korisnickoIme"), json2.getString("lozinka"), json2.getString("ime"), json2.getString("prezime"), json2.getString("email"));
            // Get response body
            System.out.println(response.request());
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
        return klijent;
    }

    public void rezervisiPolazak(Rezervacija r) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.REZERVISI_POLAZAK);
        kz.setParametar(r);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public void rezervisiPolazakHTTP(Rezervacija r) throws Exception {
        String json = new StringBuilder()
                .append("{\r\n")
                .append("\"klijentID\":" + r.getKlijent().getKlijentID() + ",")
                .append("\"polazakID\":" + r.getPolazak().getPolazakID())
                .append("}").toString();
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/rezervacija/add")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        System.out.println(request.toString());

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            JSONObject json2 = new JSONObject(response.body().string());

            // Get response body
            System.out.println(json2);
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj rezervacije karata!");
        }
    }

    public ArrayList<Rezervacija> vratiMojeRezervacije(Rezervacija r) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_REZERVACIJE_ZA_KLIJENTA);
        kz.setParametar(r);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Rezervacija> lista = (ArrayList<Rezervacija>) so.getOdgovor();
        return lista;
    }

    public ArrayList<Rezervacija> vratiMojeRezervacijeHTTP(Klijent klijent) throws Exception {
        ArrayList<Rezervacija> lista = new ArrayList<>();
        String json = new StringBuilder()
                .append("{")
                .append("\"id\":\"" + klijent.getKlijentID() + "\"")
                .append("}").toString();
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/rezervacija/klijent/rezervacije")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        System.out.println(request);
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            JSONArray json2 = new JSONArray(response.body().string());
            // Get response body
            ArrayList<String> list = new ArrayList<String>();
            JSONArray jsonArray = (JSONArray) json2;
            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i = 0; i < len; i++) {
                    list.add(jsonArray.get(i).toString());
                    System.out.println(jsonArray.get(i).toString());
                }
            }
            return lista;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
    }

    public void izmeniNalog(Klijent klijent) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.IZMENA_KORISNICKOG_NALOGA);
        kz.setParametar(klijent);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public void izmeniLozinkuHTTP(Klijent k) throws Exception {
        String json = new StringBuilder()
                .append("{\r\n")
                .append("\"id\":\"" + k.getKlijentID() + "\",")
                .append("\"lozinka\":\"" + k.getLozinka() + "\"")
                .append("}").toString();
        System.out.println(json);
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/klijent/updatepassword")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Get response body
            System.out.println(response.request());
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
    }
    public void izmeniKorisnickoImeHTTP(Klijent k) throws Exception {
        String json = new StringBuilder()
                .append("{\r\n")
                .append("\"id\":\"" + k.getKlijentID()+ "\",")
                .append("\"korisnickoIme\":\"" + k.getKorisnickoIme() + "\"")
                .append("}").toString();
        System.out.println(json);
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/klijent/updateusername")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Get response body
            System.out.println(response.request());
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
    }

    public int vratiBrojRezervacija(Rezervacija r) throws Exception {
        int broj = 0;
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_REZERVACIJE_ZA_POLAZAK);
        kz.setParametar(r);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        broj = ((ArrayList<Rezervacija>) so.getOdgovor()).size();
        return broj;
    }

    public void otkaziRezervaciju(Rezervacija r) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.OTKAZI_REZERVACIJU);
        kz.setParametar(r);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
    }

    public ArrayList<MedjuStanica> vratiMiSveMedjustanica() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_MEDJUSTANICE);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<MedjuStanica> listaMedjuStanica = (ArrayList<MedjuStanica>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaMedjuStanica;
    }

    public ArrayList<MedjuStanica> vratiMiMedjustaniceLiniju(MedjuStanica medjuStanica) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_MEDJUSTANICE_LINIJE);
        kz.setParametar(medjuStanica);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<MedjuStanica> listaMedjustanica = (ArrayList<MedjuStanica>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaMedjustanica;
    }

    public ArrayList<Stanica> vratiMiSveStanice() throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_STANICE);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Stanica> listaStanica = (ArrayList<Stanica>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaStanica;
    }

    public ArrayList<Polazak> vratiMiPolaskeZaDatum(Polazak p) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_POLASKE_ZA_DATUM);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Polazak> listaPolazaka = (ArrayList<Polazak>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaPolazaka;
    }

    public ArrayList<Polazak> vratiMiPolaskeZaDatumPocetnuIKrajnjuStanicu(Polazak p) throws Exception {
        kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.VRATI_POLASKE_ZA_POCETNU_I_KRAJNJU_STANICU);
        kz.setParametar(p);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Polazak> listaPolazaka = (ArrayList<Polazak>) so.getOdgovor();
        if (so.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) so.getError();
            throw ex;
        }
        return listaPolazaka;
    }

}
