package grammar.builders;

import grammar.Grammar;

import javafx.util.Pair;

import java.util.ArrayList;

public class LeftSideGrammarBuilder extends GrammarBuilder {
	
	@Override
	public ArrayList<Pair<String, ArrayList<String>>> buildRules(Grammar grammar) {
		grammar.setType(Grammar.Type.left);
		ArrayList<Pair<String, ArrayList<String>>> rules = new ArrayList<Pair<String, ArrayList<String>>>();
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

			rules.add(new Pair<String, ArrayList<String>>(leftSide, temp));
		}
		
		return rules;
	}
	
}
