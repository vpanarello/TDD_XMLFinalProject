/**
 * 
 */
package gamification.dao;

import java.io.*;
/**
 * S04.02_TDD_ProjetoFinal / CreateXmlFileDemo.java
 * FIAP / RM30222 - Vagner Panarello
 */
import java.io.IOException;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;


public class XmlAccess {

	private Document document;
	private String fileName;
	private String xmlName;

	public XmlAccess(String fileName) throws IOException, JDOMException {
		super();
		this.fileName = fileName;
		try {
			this.document = this.openDocument();
			this.xmlName = this.document.getRootElement().getName();
		}
		catch (FileNotFoundException e) {
			System.err.printf("Error: File '%s' not Found %nCreating new file... %n", fileName);
			storeDocument(autoGenerateStandardXmlStructure());
			this.document = this.openDocument();
		}
		catch (JDOMException e) {e.printStackTrace();}
	}
	
	public String getFileName() {
		return fileName;
	}
	public String getXmlName() {
		return xmlName;
	}
	public Element getXmlStruct(){
		return this.document.getRootElement();
	}
	public void setDocument(Document document){
		this.document = document;
		this.xmlName = document.getRootElement().getName();
	}
	
	public void persistXmlStruct() throws IOException{
		storeDocument(this.document);
	}

	public Document openDocument() throws JDOMException, IOException {
		File inputFile = new File(this.fileName);
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(inputFile);
		return document;
	}
	
	public Document newDocument(String name) {
		Element element = new Element(name);
		Document document = new Document(element);
		return document;
	}

	/* Private Methods */
	
	private void storeDocument(Document document) throws IOException {
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		if(fileName == null) xmlOutput.output(document, System.out); 
		else xmlOutput.output(document, new FileWriter(this.fileName));   
	}
	
	
	private Document autoGenerateStandardXmlStructure(){

		Document document = newDocument("GamificationApp");
		Element rootElement = document.getRootElement();
		
		Element players = new Element("players");
		
		rootElement.addContent(players);
		
		ArrayList<Element> scores = new ArrayList<>();
			scores.add(new Element("moeda").setText("1"));
			scores.add(new Element("estrela").setText("2"));
			scores.add(new Element("topico").setText("3"));
			scores.add(new Element("comentario").setText("4"));
			scores.add(new Element("curtida").setText("5"));

		players.addContent(
				new Element("player").
				addContent(new Element("name").setText("TemplateUser")).
				addContent(new Element("score").addContent(scores)));

		return document;
	}

}