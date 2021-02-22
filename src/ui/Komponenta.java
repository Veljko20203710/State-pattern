/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;
import paparReviewProcess.PaperReviewProcess;
import states.State;

/**
 *
 * @author Veljko
 */
public class Komponenta {

    protected State state;
    protected int x;
    protected int y = 100;
    protected int width = 100;
    protected int height = 100;
    protected PaperReviewProcess paperReviewProcess;

    public Komponenta(State state, int x, PaperReviewProcess paperReviewProcess) {
        this.state = state;
        this.x = x;
        this.paperReviewProcess = paperReviewProcess;
    }

    //@Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawOval(x, y, width, width);
        if (state.equals(paperReviewProcess.getCurrentState())) {
            g.setColor(Color.GREEN);
        }
        g.fillOval(x, y, width, height);
        g.setColor(Color.black);
        g.drawString(state.toString(), x + 15, y + 50);
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Komponenta other = (Komponenta) obj;
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.state);
        hash = 31 * hash + this.x;
        hash = 31 * hash + this.y;
        hash = 31 * hash + this.width;
        hash = 31 * hash + this.height;
        hash = 31 * hash + Objects.hashCode(this.paperReviewProcess);
        return hash;
    }

    public int LocationX() {
        return x + 100;
    }

    public int LocationY() {
        return y + 50;
    }
}
