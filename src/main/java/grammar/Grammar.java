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
	
	public abstract String print();
	
}
