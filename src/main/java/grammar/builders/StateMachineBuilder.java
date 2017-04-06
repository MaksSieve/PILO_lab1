package grammar.builders;

import grammar.Grammar;
import grammar.statemachine.State;
import grammar.statemachine.StateMachine;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Hashtable;


public class StateMachineBuilder {

    public StateMachine build(Grammar grammar) {

        StateMachine sm = new StateMachine();
        sm.setAlphabet(grammar.getVT());
        sm.setStates(new ArrayList<State>());

        ArrayList<State> endStates = new ArrayList<State>();


        for (String n : grammar.getVN()) {
            State tmp = new State();
            tmp.setName(n);
            sm.getStates().add(tmp);
        }

        for (State st : sm.getStates()) {
            ArrayList<Pair<String, State>> tbl_temp = new ArrayList<Pair<String, State>>();
            ArrayList<String> row = grammar.getMatrix().get(sm.getStates().indexOf(st));
            for (String el : row){
                if (el != null && !el.equals("")){
                    if (el.equals("1")){
                        endStates.add(st);
                    }else {
                        tbl_temp.add(new Pair<String, State>(grammar.getVT().get(row.indexOf(el)), sm.getStateByName(el)));
                    }
                }
            }
            st.setJumps(tbl_temp);
        }

        sm.setStartState(sm.getStateByName(grammar.getStartSymbol()));
        sm.setFinishStates(endStates);

        return sm;
    }
}
