/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.buttons;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;

/**
 *
 * @author Stefan
 */
public abstract class AbstractMenu extends AbstractMouseListener {

    private JMenu menu;
    private String icon;
    private String icon1;

    public AbstractMenu(JMenu menu, String icon, String icon1) {
        this.menu = menu;
        this.icon = icon;
        this.icon1 = icon1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        execute();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        menu.setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/" + icon1 + ".png")));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        menu.setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/menu/" + icon + ".png")));
    }

    public abstract void execute();

}
