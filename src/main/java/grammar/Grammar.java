package grammar;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Максим on 11.03.2017.
 */
public class Grammar {
	
	//Common fields for all types of Grammar
	
	//Alphabet of terminals
	protected ArrayList<String> VT;
	
	//Alphabet of non-terminals
	protected ArrayList<String> VN;
	
	//List of rules
	protected ArrayList<Pair<String,String>> rules;
	
	//Start symbol
	protected String startSymbol;
	
	//Matrix which contains information about Grammar
	protected ArrayList<ArrayList<String>> matrix;
	
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
	
	//This will be unique for different types of Grammar
	public String parse(){return null;};
	
	//Getters & Setters
	public ArrayList<String> getVT() {
		return VT;
	}
	
	public void setVT(ArrayList<String> VT) {
		this.VT = VT;
	}
	
	public ArrayList<String> getVN() {
		return VN;
	}
	
	public void setVN(ArrayList<String> VN) {
		this.VN = VN;
	}
	
	public ArrayList<Pair<String, String>> getRules() {
		return rules;
	}
	
	public void setRules(ArrayList<Pair<String, String>> rules) {
		this.rules = rules;
	}
	
	public String getStartSymbol() {
		return startSymbol;
	}
	
	public void setStartSymbol(String startSymbol) {
		this.startSymbol = startSymbol;
	}
	
	public ArrayList<ArrayList<String>> getMatrix() {
		return matrix;
	}
	
	public void setMatrix(ArrayList<ArrayList<String>> matrix) {
		this.matrix = matrix;
	}
}
