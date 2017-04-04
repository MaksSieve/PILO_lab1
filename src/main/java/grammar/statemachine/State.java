package grammar.statemachine;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Dictionary;

public class State {

    //Name of state
    private String name;

    //List of jumps: symbol->address_state
    private ArrayList<Pair<String, State>> jumps;

    public String toString(){
        String out = "";
        out += "    Name: " + name + "\n";
        for (Pair p : jumps){
            out += "        " + p.getKey() + " => " + ((State)p.getValue()).name + "\n";
        }
        return out;
    }

    public State getAddress(String symbol) {

        State out = null;

        for (Pair p : jumps){
            if (p.getKey() == symbol) {
                out = (State)p.getValue();
            }
        }

        return out;
    }

    //auto-generated Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pair<String, State>> getJumps() {
        return jumps;
    }

    public void setJumps(ArrayList<Pair<String, State>> jumps) {
        this.jumps = jumps;
    }
}
