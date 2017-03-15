package grammar.builders;

import grammar.ContextFreeGrammar;
import grammar.Grammar;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;

import java.io.File;

/**
 * Created by Максим on 11.03.2017.
 */
public class LeftSideBuilder implements GrammarBuilder {
	
	public Grammar buildFromXML(File file) {
		
		ContextFreeGrammar grammar = new ContextFreeGrammar();
		
		Document XMLdoc = makeDocument(file);
		
		Element root = XMLdoc.getDocumentElement();
		NodeList parts = root.getChildNodes();
		for (int i = 0; i < parts.getLength(); i++){
			Node el = parts.item(i);
			if (el.getNodeName() == "VT"){
				
			}
		}
		
		return null;
	}
	
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
}
