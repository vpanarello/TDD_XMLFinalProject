/**
 * 
 */
package gamification.junit;
import gamification.dao.XmlAccess;
import static org.junit.Assert.*;
import java.io.IOException;
import org.jdom2.*;
import org.junit.*;


/**
 * S04.02_TDD_ProjetoFinal / XmlAccessTest.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class XmlAccessTest {
	
	static XmlAccess dao;

	@BeforeClass
	public static void inicializeFile() throws IOException, JDOMException {
		
		dao = new XmlAccess("mockFile.xml");
			
		Document newDocument =  dao.newDocument("mockXML");
		dao.setDocument(newDocument);
		
		newDocument.getRootElement().addContent(new Element("FirstElement"));
		newDocument.getRootElement().addContent(new Element("SecondElement"));
		newDocument.getRootElement().addContent(new Element("ThirdElement"));
		
		newDocument.getRootElement().getChildren().get(1).addContent(new Element("SubElement01").setText("Teste1"));
		newDocument.getRootElement().getChildren().get(1).addContent(new Element("SubElement02").setText("Teste2"));
				
		dao.persistXmlStruct();
	}
	

	@Test
	public void VerifyDataOfMockFileXML() throws JDOMException, IOException{
		
		Document fileDocument = dao.openDocument();
		
		String CheckStr01 = "mockXML";
		assertTrue("Different XML file", CheckStr01.equals(fileDocument.getRootElement().getName()));
		
		dao.setDocument(fileDocument);
		
		String text1 = fileDocument.getRootElement().getChild("SecondElement").getChild("SubElement01").getText();
		String text2 = fileDocument.getRootElement().getChild("SecondElement").getChild("SubElement02").getText();
		
		
		assertTrue("Parametro retornado diferente", text1.equals("Teste1"));
		assertTrue("Parametro retornado diferente", text2.equals("Teste2"));
	}
	@Test
	public void addMoreElementsAndCheck() throws IOException, JDOMException{
		
		dao.getXmlStruct().addContent(new Element("LaterAddedElement").setText("LaterAdded"));
		dao.persistXmlStruct();
		
		Document fileDocument = dao.openDocument();
		
		
		
		String CheckStr01 = "mockXML";
		assertTrue("Different XML file", CheckStr01.equals(fileDocument.getRootElement().getName()));
		
		
		String CheckStr02 = "LaterAdded";
		assertTrue("Parametro retornado diferente",
				CheckStr02.equals(fileDocument.getRootElement().getChild("LaterAddedElement").getText()));
	
	}
}
