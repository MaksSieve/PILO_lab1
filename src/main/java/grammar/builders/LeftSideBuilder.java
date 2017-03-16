package grammar.builders;

import grammar.ContextFreeGrammar;
import grammar.Grammar;

import org.w3c.dom.*;

import javax.xml.parsers.*;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Максим on 11.03.2017.
 */
public class LeftSideBuilder implements GrammarBuilder {
	
	public Grammar buildFromXML(File file) {
		
		ContextFreeGrammar grammar = new ContextFreeGrammar();
		Document XMLdoc = makeDocument(file);
		
		Element root = XMLdoc.getDocumentElement();
		NodeList parts = root.getChildNodes();
		
		//construct a Grammar object
		try {
			for (int i = 0; i < parts.getLength(); i++){
				Node el = parts.item(i);
				if (el.getNodeName().equals("VT")){
					grammar.setVT(makeArray(el));
				}else if (el.getNodeName().equals("VN")){
					grammar.setVN(makeArray(el));
				}else if(el.getNodeName().equals("matrix")){
					grammar.setMatrix(makeMatrix(el));
				}
				
			}
			
			return grammar;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//make a Document object for main method
	private Document makeDocument(File file){
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder XMLbuilder = null;
		Document doc = null;
		
		try {
			XMLbuilder = factory.newDocumentBuilder();
			doc = XMLbuilder.parse(file);
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private ArrayList<String> makeArray(Node el){
		NodeList list = el.getChildNodes();
		ArrayList<String> outList = new ArrayList<String>();
		for (int j = 0; j < list.getLength(); j++) {
			outList.add(list.item(j).getNodeValue());
		}
		return outList;
	}
	
	private ArrayList<ArrayList<String>> makeMatrix(Node el){
		NodeList rows = el.getChildNodes();
		ArrayList<ArrayList<String>> outList = new ArrayList<ArrayList<String>>();
		
		for (int i = 0; i < rows.getLength(); i++) {
			Node row = rows.item(i);
			outList.add(makeArray(row));
		}
		return outList;
	}
}
