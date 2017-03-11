package grammar.builders;

import grammar.Grammar;
import grammar.GrammarMatrix;

import java.io.File;

/**
 * Created by Максим on 11.03.2017.
 */
public interface Builder {
	
	public Grammar build(GrammarMatrix matrix);
	public Grammar build(File file);
	
}
