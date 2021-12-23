/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.kontroler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Linija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.MedjuStanica;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Polazak;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Rezervacija;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Stanica;

/**
 *
 * @author Stefan
 */
public class KontrolerHTTP {

    private static KontrolerHTTP instance;
    private OkHttpClient httpClient;
    private Gson gson;

    private KontrolerHTTP() {
        httpClient = new OkHttpClient();
        gson = new Gson();
        gson.serializeNulls();
    }

    public static KontrolerHTTP getInstance() {
        if (instance == null) {
            instance = new KontrolerHTTP();

        }
        return instance;
    }

    public Klijent ulogujSe(Klijent k) throws IOException, Exception {
        System.out.println("uloguj se");
        String json = gson.toJson(k);

        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url("http://localhost:8089/api/klijent/get")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();

        Klijent klijent;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            JSONObject jsonResponse = new JSONObject(response.body().string());
            klijent = gson.fromJson(jsonResponse.toString(), Klijent.class);
        } catch (Exception ex) {
            throw new Exception("Sistem ne može da pronađe korisnika!");
        }
        return klijent;
    }

    public Klijent registrujSe(Klijent k) throws IOException, Exception {
        System.out.println("registruj se");
        String json = gson.toJson(k);
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/klijent/add")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        Klijent klijent;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            JSONObject jsonResponse = new JSONObject(response.body().string());

            klijent = gson.fromJson(jsonResponse.toString(), Klijent.class);
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
        return klijent;
    }

    public void rezervisiPolazak(Rezervacija r) throws Exception {
        System.out.println("rezervisi polazak");
        String json = gson.toJson(r);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/rezervacija/add")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

        } catch (Exception ex) {
            throw new Exception("Sistem ne može da sačuva rezervaciju!");
        }
    }

    public ArrayList<Rezervacija> vratiMojeRezervacije(Klijent klijent) throws Exception {
        System.out.println("vrati moje rezervacije");
        String json = gson.toJson(klijent);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/rezervacija/klijent/all")
                .addHeader("Accept-Encoding", "gzip")
                .post(body)
                .build();
        ArrayList<Rezervacija> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type rezervacijaListaType = new TypeToken<ArrayList<Rezervacija>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), rezervacijaListaType);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public void izmeniNalog(Klijent k) throws Exception {
        System.out.println("izmeni nalog");
        String json = gson.toJson(k);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/klijent/update")
                .addHeader("Accept-Encoding", "gzip")
                .put(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
    }

    public void izmeniKorisnickoIme(Klijent k) throws Exception {
        String json = gson.toJson(k);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/klijent/updateusername")
                .addHeader("Accept-Encoding", "gzip")
                .put(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
    }

    public void izmeniLozinku(Klijent k) throws Exception {
        String json = gson.toJson(k);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/klijent/updatepassword")
                .addHeader("Accept-Encoding", "gzip")
                .put(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
    }

    public int vratiBrojRezervacija(Polazak p) throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/polazak/reservation/" + p.getPolazakID())
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        int broj = 0;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            JSONObject jsonResponse = new JSONObject(response.body().string());
            Polazak polazak = gson.fromJson(jsonResponse.toString(), Polazak.class);
            broj = polazak.getPolazakID();
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
        System.out.println(broj);
        return broj;
    }

    public ArrayList<MedjuStanica> vratiMiMedjustaniceLiniju(Linija l) throws Exception {
        String json = gson.toJson(l);
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/medjustanica/" + l.getLinijaID())
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<MedjuStanica> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type rezervacijaListaType = new TypeToken<ArrayList<MedjuStanica>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), rezervacijaListaType);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<Stanica> vratiMiSveStanice() throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/stanica/all")
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<Stanica> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<Stanica>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<Polazak> vratiMiPolaskeZaDatum(String datum) throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/polazak/" + datum)
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<Polazak> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<Polazak>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public ArrayList<Polazak> vratiMiPolaske(Stanica pocetna, Stanica krajnja, String datum) throws Exception {
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/polazak/" + pocetna.getNaziv() + "/" + krajnja.getNaziv() + "/" + datum)
                .addHeader("Accept-Encoding", "gzip")
                .get()
                .build();
        ArrayList<Polazak> lista;
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Type tipListe = new TypeToken<ArrayList<Polazak>>() {
            }.getType();
            lista = gson.fromJson(response.body().string(), tipListe);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw new Exception("Neuspešan pokušaj vraćanja svih rezervacija!");
        }
        System.out.println(lista);
        return lista;
    }

    public void otkaziRezervaciju(Rezervacija r) throws Exception {
        String json = gson.toJson(r);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        System.out.println(json);
        Request request = new Request.Builder()
                .url("http://localhost:8089/api/rezervacija/delete")
                .addHeader("Accept-Encoding", "gzip")
                .delete(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception ex) {
            throw new Exception("Neuspešan pokušaj registracije!");
        }
    }

}
