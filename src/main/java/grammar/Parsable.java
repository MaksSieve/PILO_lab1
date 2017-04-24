package grammar;

import java.util.ArrayList;

/**
 * Created by Максим on 11.03.2017.
 */
public interface Parsable {
	
	//This will be unique for different types of Parsable
	ArrayList<String> parse(String in);
	
}
