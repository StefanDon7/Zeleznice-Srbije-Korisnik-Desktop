/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.klijent.view.kontroler.buttons;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.SoundEffect;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.constant.SoundConst;

/**
 *
 * @author Stefan
 */
public abstract class AbstractMouseListener implements MouseListener {

    private final SoundEffect soundEffect = new SoundEffect();

    @Override
    public void mouseClicked(MouseEvent e) {
        soundEffect.startAudioKlip(SoundConst.INTERFEJS);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        soundEffect.startAudioKlip(SoundConst.KLIK);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


}
