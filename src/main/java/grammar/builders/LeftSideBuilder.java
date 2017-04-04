package grammar.builders;

import grammar.Grammar;
import grammar.Parsable;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Максим on 11.03.2017.
 */
public class LeftSideBuilder extends GrammarBuilder {
	
	@Override
	public ArrayList<Pair<String, String>> buildRules(Grammar grammar) {
		ArrayList<Pair<String, String>> rules = new ArrayList<Pair<String, String>>();
		ArrayList<ArrayList<String>> matrix = grammar.getMatrix();
		
		for (ArrayList<String> row: matrix){
			String leftSide = grammar.getVN().get(matrix.indexOf(row));
			ArrayList<String> temp = new ArrayList<String>();
			
			for (ArrayList<String> row2 : matrix){
				for (String el : row2){
					if (el.equals(leftSide)){
						temp.add(grammar.getVN().get(matrix.indexOf(row2)) + row2.indexOf(el));
					}
				}
			}
			String rightSide;
			if (temp.size() == 0 ){
				rightSide = "e";
			}else {
				rightSide = temp.get(0);
				for (int i = 1; i < temp.size(); i++) {
					rightSide += "|" + temp.get(i);
				}
			}
			rules.add(new Pair<String, String>(leftSide, rightSide));
		}
		
		return rules;
	}
	
}
