package grammar.statemachine;

import java.util.ArrayList;

public class StateMachine {

    private ArrayList<State> states;

    private ArrayList<String> alphabet;

    private ArrayList<State> finishStates;

    private State startState;


    public StateMachine determine(){
        return null;
    };


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

    public ArrayList<State> getFinishStates() {
        return finishStates;
    }

    public void setFinishStates(ArrayList<State> finishStates) {
        this.finishStates = finishStates;
    }

    public State getStartState() {
        return startState;
    }

    public void setStartState(State startState) {
        this.startState = startState;
    }

}
