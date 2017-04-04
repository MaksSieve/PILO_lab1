package grammar.builders;

import grammar.Grammar;
import javafx.util.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public abstract class GrammarBuilder {
	
	public Grammar buildFromXML(File file) {
		
		ContextFreeGrammar grammar = new ContextFreeGrammar();
		Document XMLdoc = makeDocument(file);
		
		try {
			Element root = XMLdoc.getDocumentElement();
			NodeList parts = root.getChildNodes();
		
			//construct a Grammar object
			for (int i = 0; i < parts.getLength(); i++){
				Node el = parts.item(i);
				if (el.getNodeName().equals("VT")){
					grammar.setVT(makeArray(el));
				}else if (el.getNodeName().equals("VN")){
					grammar.setVN(makeArray(el));
				}else if(el.getNodeName().equals("Matrix")) {
					grammar.setMatrix(makeMatrix(el));
					grammar.setRules(buildRules(grammar));
				}else if(el.getNodeName().equals("StartSymbol")) {
					grammar.setStartSymbol(el.getTextContent());
				}
			}
			return grammar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
			if (list.item(j).getNodeName().equals("symbol"))
				outList.add(list.item(j).getTextContent());
		}
		return outList;
	}
	
	private ArrayList<ArrayList<String>> makeMatrix(Node el){
		NodeList rows = el.getChildNodes();
		ArrayList<ArrayList<String>> outList = new ArrayList<ArrayList<String>>();
		
		for (int i = 0; i < rows.getLength(); i++) {
			if (rows.item(i).getNodeName().equals("row")) {
				Node row = rows.item(i);
				ArrayList<String> r = makeArray(row);
				outList.add(r);
			}
		}
		return outList;
	}
	
	abstract ArrayList<Pair<String,String>> buildRules(Grammar grammar);
	
}