package paparReviewProcess;


import exceptions.IllegalStateTransfer;
import java.util.LinkedList;
import java.util.List;
import states.AcceptedState;
import states.CancelState;
import states.RejectState;
import states.ReviewState;
import states.State;
import states.WritingState;
/**
 *
 * @author Veljko
 */
public class PaperReviewProcess {

    private List<State> nonFinalstates;
    private List<State> finalStates;
    private State currentState;

    public void initialize() {
        createAllFinalStates();
        createAllNonFinalStates();
        addNextStates();
        setInitCurrentState();
    }

    private void addNextStates() {
        for (State state : nonFinalstates) {
            state.setNextStates();
        }
    }

    private void setInitCurrentState() {
        currentState = WritingState.getInstance();
    }

    private void createAllFinalStates() {
        finalStates = new LinkedList<>();
        finalStates.add(CancelState.getInstance());
        finalStates.add(AcceptedState.getInstance());
        finalStates.add(RejectState.getInstance());
    }

    private void createAllNonFinalStates() {
        nonFinalstates = new LinkedList<>();

        nonFinalstates.add(WritingState.getInstance());
        nonFinalstates.add(ReviewState.getInstance());
    }

    public String handleRequest() {
        return currentState.handleRequest();
    }

    public void changeState(State state) throws IllegalStateTransfer {
        if (!currentState.getNextStates().contains(state) || finalStates.contains(currentState)) {
            throw new IllegalStateTransfer();
        }
        this.currentState = state;
    }

    public List<State> getNonFinalStates() {
        return nonFinalstates;
    }

    public List<State> getFinalStates() {
        return finalStates;
    }

    public State getCurrentState() {
        return currentState;
    }
    
    public boolean isCurrentStateFinal() {
        return finalStates.contains(currentState);
    }
    
    
}
