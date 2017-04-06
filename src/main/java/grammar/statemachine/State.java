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

    public State getAddressBySymbol(String symbol) {

        State out = null;

        for (Pair p : jumps){
            if (p.getKey().equals(symbol)) {
                out = (State)p.getValue();
            }
        }

        return out;
    }

    public boolean isSymbolInJumps(String symb){
        boolean res = false;
        for (Pair<String, State> jump : jumps){
            if (res = jump.getKey().equals(symb)) break;
        }

        return res;
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
