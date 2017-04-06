package grammar;

import grammar.builders.StateMachineBuilder;
import grammar.statemachine.State;
import grammar.statemachine.StateMachine;
import javafx.util.Pair;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;


public class ContextFreeGrammar extends Grammar {
	
	public String parse(String in) {
		String out = "";
		StateMachine sm = new StateMachineBuilder().build(this);
		State temp = sm.getStartState();
		ArrayList<String> arr= new ArrayList<String>(Arrays.asList(in.split("")));

		boolean f = true;

		for (String symb : arr) {
			if (!temp.isSymbolInJumps(symb)) {
				f = false;
				break;
			}else {
				if (temp.getAddressBySymbol(symb) != null) {
					temp = temp.getAddressBySymbol(symb);
				}

			}
		}

		if (f){
			out += (sm.getFinishStates().contains(temp))?"Pass":"Fail";
		}else{
			out += "Fail";
		}

		return out;
	}
}
