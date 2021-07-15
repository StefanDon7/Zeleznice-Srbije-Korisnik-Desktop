/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.lib.transfer.KlijentskiZahtev;
import rs.stefanlezaic.zeleznice.srbije.lib.transfer.ServerskiOdgovor;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelError;

/**
 *
 * @author sleza
 */
public class KomunikacijaSaServerom {

    private static KomunikacijaSaServerom instance;
    Socket s;

    private KomunikacijaSaServerom() {
        try {
            s = new Socket("localhost", 8999);
        } catch (IOException ex) {
            new JOptionPaneExample().createAndDisplayGUI(new JFrame(), new PanelError("Gresaka! Server trenutno ne radi!"));
            System.exit(0);
        }
    }

    public static KomunikacijaSaServerom getInstance() {
        if (instance == null) {
            instance = new KomunikacijaSaServerom();
        }
        return instance;
    }

    public ServerskiOdgovor primiOdgovor() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (ServerskiOdgovor) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
