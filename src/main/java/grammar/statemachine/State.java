package grammar.statemachine;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Dictionary;

public class State {

    //Name of state
    private String name;

    //List of jumps: symbol->address_state
    private Dictionary<String, State> jumps;

    public State getAddress(String symbol) {
        return jumps.get(symbol);
    }

    //auto-generated Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
