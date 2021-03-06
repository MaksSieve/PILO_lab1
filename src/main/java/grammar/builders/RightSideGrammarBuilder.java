package grammar.builders;

import grammar.Grammar;
import grammar.Parsable;
import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Максим on 11.03.2017.
 */
public class RightSideGrammarBuilder extends GrammarBuilder {
	
	@Override
	ArrayList<Pair<String, ArrayList<String>>> buildRules(Grammar grammar) {
		grammar.setType(Grammar.Type.right);

		ArrayList<Pair<String, ArrayList<String>>> rules = new ArrayList<Pair<String, ArrayList<String>>>();
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


			
			rules.add(new Pair<String, ArrayList<String>>(leftSide, temp));
		}
		
		return rules;
	}
}
