/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Graphics;
import paparReviewProcess.PaperReviewProcess;
import states.State;

/**
 *
 * @author Veljko
 */
public class FinalnaKomponenta extends Komponenta {
    
    public FinalnaKomponenta(State state, int x, PaperReviewProcess paperReviewProcess) {
        super(state, x, paperReviewProcess);
        y = 300;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(x, y, 50, 50);
        if (state.equals(paperReviewProcess.getCurrentState())) {
            g.setColor(Color.GREEN);
            g.fillOval(x, y, 50, 50);
        }
        g.setColor(Color.black);
        g.fillOval(x + 15, y + 15, 20, 20);
        g.drawString(state.toString(), x - 5, y + 70);
    }

    @Override
    public int LocationX() {
        return x + 25;
    }

    @Override
    public int LocationY() {
        return y;
    }

    @Override
    public State getState() {
        return state;
    }

}
