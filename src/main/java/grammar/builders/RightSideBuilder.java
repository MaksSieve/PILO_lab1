package grammar.builders;

import grammar.Grammar;
import javafx.util.Pair;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Максим on 11.03.2017.
 */
public class RightSideBuilder extends GrammarBuilder {
	
	@Override
	ArrayList<Pair<String, String>> buildRules(Grammar grammar) {
		ArrayList<Pair<String, String>> rules = new ArrayList<Pair<String, String>>();
		ArrayList<ArrayList<String>> matrix = grammar.getMatrix();
		
		for (ArrayList<String> row : matrix) {
			String leftSide = grammar.getVN().get(matrix.indexOf(row));
			ArrayList<String> temp = new ArrayList<String>();
			
			for (int i =0; i < row.size(); i++){
				if (i != row.size()-1){
					if (!row.get(i).equals("") && row.get(i) != null){
						temp.add(grammar.getVT().get(i)+row.get(i));
					}
				}else if (row.get(i).equals("1")){
					temp.add("e");
				}
			}
			
			String rightSide = temp.get(0);
			for (int i = 1; i < temp.size(); i++){
				rightSide += "|"+temp.get(i);
			}
			
			rules.add(new Pair<String, String>(leftSide, rightSide));
		}
		
		return rules;
	}
}
