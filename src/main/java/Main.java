import grammar.Parsable;
import grammar.builders.GrammarBuilder;
import grammar.builders.LeftSideBuilder;
import grammar.builders.RightSideBuilder;

import java.io.File;

/**
 * Created by Максим on 11.03.2017.
 */
public class Main {
	
	public static void main(String[] args) {
		GrammarBuilder rBuilder = new RightSideBuilder();
		GrammarBuilder lBuilder = new LeftSideBuilder();
		
		Parsable rGrammar = rBuilder.buildFromXML(new File("src/main/java/task1.xml"));
		Parsable lGrammar = lBuilder.buildFromXML(new File("src/main/java/task1.xml"));
		
		System.out.println("RightSideGrammar:\n" + rGrammar.toString());
		System.out.println();
		System.out.println("LeftSideGrammar:\n" + lGrammar.toString());
		
		
	}
	
}
