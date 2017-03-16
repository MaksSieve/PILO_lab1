package grammar.builders;

import grammar.Grammar;

import java.io.File;

/**
 * Created by Максим on 11.03.2017.
 */
public interface GrammarBuilder {
	
	public Grammar buildFromXML(File file);
	
}
