/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import events.ListenerMouse;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import paparReviewProcess.PaperReviewProcess;
import states.State;

/**
 *
 * @author Veljko
 */
public class FrmMain extends JFrame {

    private PaperReviewProcess paperReviewProcess;
    private List<Komponenta> komponente;
    private List<FinalnaKomponenta> finalneKomponente;
    private Line line;
    private ListenerMouse listenerMouse;

    public FrmMain() throws HeadlessException {
        initPaperReviewProcess();
        initStates();
        setListener();
        setSize();
        setCloseOperation();
    }

    private void initStates() {
        komponente = new LinkedList<>();
        finalneKomponente = new LinkedList<>();
        listenerMouse = new ListenerMouse(this);
    }

    private void initPaperReviewProcess() {
        paperReviewProcess = new PaperReviewProcess();
        paperReviewProcess.initialize();
    }

    @Override
    public void paint(Graphics g) {
        int x = 100;

        for (State s : paperReviewProcess.getNonFinalStates()) {
            Komponenta komp = new Komponenta(s, x, paperReviewProcess);
            komp.paint(g);
            if (!komponente.contains(komp)) {
                komponente.add(komp);
            }
            x += 150;
        }

        x = 100;
        for (State s : paperReviewProcess.getFinalStates()) {
            FinalnaKomponenta komp = new FinalnaKomponenta(s, x, paperReviewProcess);
            komp.paint(g);
            if (!finalneKomponente.contains(komp)) {
                finalneKomponente.add(komp);
            }
            x += 150;
        }

        for (Komponenta k : komponente) {
            for (State s : k.getState().getNextStates()) {
                if (k.getState().equals(s)) {
                    g.drawArc(k.LocationX() - 60, 50, 20, 100, 0, 180);
                    int xPoints[] = new int[]{k.LocationX() - 60, k.LocationX() - 60 - 8, k.LocationX() - 60 + 8};
                    int yPoints[] = new int[]{100, 100 - 8, 100 - 8};
                    g.fillPolygon(xPoints, yPoints, 3);
                }
                for (Komponenta k1 : komponente) {
                    if (!k1.equals(k) && s.equals(k1.getState())) {
                        line = new Line(k, k1);
                        line.paintLine(g);
                    }
                }
            }
        }

        for (Komponenta k : komponente) {
            for (State s : k.getState().getNextStates()) {
                for (FinalnaKomponenta k1 : finalneKomponente) {
                    if (s.equals(k1.getState())) {
                        line = new Line(k1, k);
                        line.paintFinalComponentLine(g);
                    }
                }
            }
        }
    }

    private void setListener() {
        this.addMouseListener(listenerMouse);
    }

    private void setSize() {
        this.setSize(700, 500);
    }

    public PaperReviewProcess getPaperReviewProcess() {
        return paperReviewProcess;
    }

    void changeState(State state) {
        this.paperReviewProcess.changeState(state);
        this.repaint();
        JOptionPane.showMessageDialog(this, state.handleRequest());
        if (this.paperReviewProcess.isCurrentStateFinal()) {
            JOptionPane.showMessageDialog(this, "You are in final state. End of simulation.");
            this.dispose();
        }
    }

    private void setCloseOperation() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
