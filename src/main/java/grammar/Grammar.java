package grammar;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Максим on 11.03.2017.
 */
public abstract class Grammar {
	
	protected ArrayList<String> VT;
	protected ArrayList<String> VN;
	protected ArrayList<Pair<String,String>> rules;
	protected String startSymbol;
	
	@Override
	public String toString(){
		String out = "";
		
		out += "Terminals:";
		for (String s: VT) {
			out += " \"" + s + "\";";
		}
		out += "\n";
		
		out += "Non-terminals:";
		for (String s: VN) {
			out +=" \"" + s + "\";";
		}
		out += "\n";
		
		out += "Rules:\n";
		for (Pair r: rules) {
			out += r.getKey() + " := " + r.getValue() + ";\n";
		}
		
		out += "Start symbol: \"" + startSymbol + "\"";
		
		return out;
	}
	
	public abstract String parse();
	
}
