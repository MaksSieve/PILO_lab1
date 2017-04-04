package grammar.statemachine;

import java.util.ArrayList;

/**
 * Created by MSitnikov on 04.04.2017.
 */
public class StateMachine {

    private ArrayList<State> states;

    private ArrayList<String> alphabet;

    private ArrayList<String> finishStates;

    private String startState;

    @Override
    public String toString(){
        String out = "";
        out += "Alpabet: " + alphabet + "\n";
        out += "End-states: " + finishStates + "\n";
        out += "States:\n";
        for (State st : states){
            out += st.toString();
        }
        return out;
    }



    public State getStateByName(String name){
        State state = null;
        for (State s : states){
            if (s.getName().equals(name)){
                state = s;
                break;
            }
        }
        return state;
    }

    //auto-generated Getters and Setters
    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    public ArrayList<String> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(ArrayList<String> alphabet) {
        this.alphabet = alphabet;
    }

    public ArrayList<String> getFinishStates() {
        return finishStates;
    }

    public void setFinishStates(ArrayList<String> finishStates) {
        this.finishStates = finishStates;
    }

    public String getStartState() {
        return startState;
    }

    public void setStartState(String startState) {
        this.startState = startState;
    }
}
