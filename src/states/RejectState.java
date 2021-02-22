/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

/**
 *
 * @author Veljko
 */
public class RejectState extends State{
    
    private final static State INSTANCE;
    
    static {
        INSTANCE = new RejectState();
    }
    
    public static State getInstance() {
        return INSTANCE;
    }
    
    private RejectState() {}

    @Override
    public void setNextStates() {}

    @Override
    public String toString() {
        return "Reject State";
    }
    
    @Override
    public String handleRequest() {
        return "Paper is rejected!";
    }
    
    
}
