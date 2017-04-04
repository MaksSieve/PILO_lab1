package grammar.builders;

import grammar.Grammar;
import grammar.statemachine.StateMachine;

/**
 * Created by MSitnikov on 04.04.2017.
 */
public class StateMachineBuilder {

    public StateMachine build(Grammar grammar){
        StateMachine sm = new StateMachine();

        sm.setAlphabet(grammar.getVN());

        return sm;
    }

}
