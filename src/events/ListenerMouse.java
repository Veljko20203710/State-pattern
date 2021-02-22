/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ui.FrmChoise;
import ui.FrmMain;

/**
 *
 * @author Veljko
 */
public class ListenerMouse extends MouseAdapter{

    private FrmMain frmMain;

    public ListenerMouse(FrmMain frmMain) {
        this.frmMain=frmMain;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        new FrmChoise(frmMain).setVisible(true);
    }
    
    public void setFrame(FrmMain frame) {
        this.frmMain=frame;
    }
}
