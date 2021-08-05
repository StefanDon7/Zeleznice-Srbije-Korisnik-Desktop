/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.buttons;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Stefan
 */
public abstract class AbstractButton extends AbstractMouseListener {

    private JButton button;
    private String icon;
    private String icon1;

    public AbstractButton(JButton button, String icon, String icon1) {
        this.button = button;
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
        button.setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/" + icon1 + ".png")));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        button.setIcon(new ImageIcon(getClass().
                getResource("/rs/stefanlezaic/zeleznice/srbije/klijent/resources/icons/buttons/" + icon + ".png")));
    }

    public abstract void execute();

}
