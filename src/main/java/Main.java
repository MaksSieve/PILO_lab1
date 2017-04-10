import grammar.Grammar;
import grammar.builders.GrammarBuilder;
import grammar.builders.LeftSideGrammarBuilder;
import grammar.builders.RightSideGrammarBuilder;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Максим on 11.03.2017.
 */
public class Main {
	
	public static void main(String[] args) {
		GrammarBuilder rBuilder = new RightSideGrammarBuilder();
		GrammarBuilder lBuilder = new LeftSideGrammarBuilder();
		
		Grammar rGrammar = rBuilder.buildFromXML(new File("src/main/java/task1.xml"));
		Grammar lGrammar = lBuilder.buildFromXML(new File("src/main/java/task1.xml"));
		//Task1
		System.out.println("RightSideGrammar:\n" + rGrammar.toString());
		System.out.println("LeftSideGrammar:\n" + lGrammar.toString());


		//Task3
		rGrammar = rBuilder.buildFromXML(new File("src/main/java/task3.xml"));
		Scanner scan = new Scanner(System.in);
		System.out.print("Print string to parse: ");
		System.out.println("Result: " + rGrammar.parse(scan.next()));

	}
	
}
