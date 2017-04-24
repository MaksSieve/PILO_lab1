package grammar;

import grammar.builders.StateMachineBuilder;
import grammar.statemachine.State;
import grammar.statemachine.StateMachine;
import javafx.util.Pair;

import java.text.ParseException;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;


public class ContextFreeGrammar extends Grammar {
	
	public boolean confirm(String in) {
		//String out = "";
		StateMachine sm = new StateMachineBuilder().build(this);
		State temp = sm.getStartState();
		ArrayList<String> arr = strToArr(in);
		
		int n, s ,e;
		
		n = s = e = 0;
		
		for (String symb : arr) {
			
			if (temp.getAddressBySymbol(symb) != null) {
				if (temp == sm.getStartState()){
					s = n;
				}
				temp = temp.getAddressBySymbol(symb);
			}
			
			n++;

		}
		//out += (sm.getFinishStates().contains(temp))?"Pass":"Fail";

		return (sm.getFinishStates().contains(temp));
	}
	
	public ArrayList<String> parse(String in){
		ArrayList<String> out = new ArrayList<String>();
		StateMachine sm = new StateMachineBuilder().build(this);
		ArrayList<String> arr = strToArr(in);
		String symb = "";
		State temp;
		int s,e;
		
		
		for (int i = 0; i < arr.size(); i++){
			s = e = 0;
			temp = sm.getStartState();
			symb = arr.get(i);
			if (temp.isSymbolInJumps(symb)){
				s = i;
				for (e = i; e < arr.size(); e++){
					symb = arr.get(e);
					if (temp.getAddressBySymbol(symb) != null) {
						temp = temp.getAddressBySymbol(symb);
					}
				}
			}
			if (sm.getFinishStates().contains(temp)){
				out.add(arr.subList(s,e).toString().replaceAll("\\[|\\]", "").replaceAll(", ","\t"));
				i = e;
			}
		}
		
		return out;
	}
	
	private ArrayList<String> strToArr(String str){
		char[] temp = str.toCharArray();
		ArrayList<String> arr = new ArrayList<String>(temp.length);
		for (char c : temp){
			arr.add(String.valueOf(c));
		}
		return arr;
	}
}
