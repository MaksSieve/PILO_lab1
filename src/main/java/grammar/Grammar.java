package grammar;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Максим on 04.04.2017.
 */
public abstract class Grammar implements Parsable {

	public enum Type {
		right,
		left
	}

	protected Type type;
	//Common fields for all types of Parsable
	//Alphabet of terminals
	protected ArrayList<String> VT;
	
	//Alphabet of non-terminals
	protected ArrayList<String> VN;
	
	//List of rules
	protected ArrayList<Pair<String, ArrayList<String>>> rules;
	
	//Start symbol
	protected String startSymbol;
	
	//Matrix which contains information about Grammar
	protected ArrayList<ArrayList<String>> matrix;

	private String rightSideToString(ArrayList<String> rs){
		String rightSide = "";
		switch(type){
			case right:{
				rightSide = rs.get(0);
				for (int i = 1; i < rs.size(); i++){
					rightSide += "|"+rs.get(i);
				}
			};
			case left:{
				if (rs.size() == 0 ){
					rightSide = "e";
				}else {
					rightSide = rs.get(0);
					for (int i = 1; i < rs.size(); i++) {
						rightSide += "|" + rs.get(i);
					}
				}
			};
		}
		return rightSide;
	}

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
			out += r.getKey() + " := " + rightSideToString((ArrayList<String>)r.getValue()) + ";\n";
		}
		
		out += "Start symbol: \"" + startSymbol + "\"";
		
		return out;
	}

	//auto-generated Getters and Setters
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
	
	public ArrayList<Pair<String, ArrayList<String>>> getRules() {
		return rules;
	}
	
	public void setRules(ArrayList<Pair<String, ArrayList<String>>> rules) {
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
