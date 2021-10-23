/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.buttons;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Stefan
 */
public abstract class AbstractLabel extends AbstractMouseListener {

    private JLabel label;
    private String icon;
    private String icon1;

    public AbstractLabel(JLabel label, String icon, String icon1) {
        this.label = label;
        this.icon = icon;
        this.icon1 = icon1;
        dodajIkonicu();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        execute();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        label.setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/" + icon1 + ".png")));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        label.setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/" + icon + ".png")));
    }

    public abstract void execute();

    public void sakriIkonicu() {
        label.setIcon(null);
    }

    public void dodajIkonicu() {
        label.setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/label/" + icon + ".png")));
    }

}
