import grammar.Grammar;
import grammar.builders.GrammarBuilder;
import grammar.builders.LeftSideGrammarBuilder;
import grammar.builders.RightSideGrammarBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		Grammar task3 = rBuilder.buildFromXML(new File("src/main/java/task3.xml"));
		try {
			System.out.println("Result: " + task3.parse(readFile("src/main/java/test3.txt", Charset.defaultCharset())));
		}catch (Exception e){
			
		}
	}
	
	static String readFile(String path, Charset encoding) throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
}
