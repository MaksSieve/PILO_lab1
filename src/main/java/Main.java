import grammar.Grammar;
import grammar.Parsable;
import grammar.builders.GrammarBuilder;
import grammar.builders.LeftSideGrammarBuilder;
import grammar.builders.RightSideGrammarBuilder;
import grammar.builders.StateMachineBuilder;
import grammar.statemachine.StateMachine;

import java.io.File;

/**
 * Created by Максим on 11.03.2017.
 */
public class Main {
	
	public static void main(String[] args) {
		GrammarBuilder rBuilder = new RightSideGrammarBuilder();
		GrammarBuilder lBuilder = new LeftSideGrammarBuilder();
		
		Grammar rGrammar = rBuilder.buildFromXML(new File("src/main/java/task1.xml"));
		Grammar lGrammar = lBuilder.buildFromXML(new File("src/main/java/task1.xml"));
		
		System.out.println("RightSideGrammar:\n" + rGrammar.toString());

		StateMachine machine = new StateMachineBuilder().build(rGrammar);
		System.out.println(machine.toString());
		
	}
	
}
