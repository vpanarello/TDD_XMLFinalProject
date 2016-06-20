/**
 * 
 */
package gamification.junit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jdom2.JDOMException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import gamification.dao.daoPlayer;
import gamification.entity.Player;

/**
 * S04.02_TDD_ProjetoFinal / DaoPlayerTest.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class DaoPlayerTest {
	
	static daoPlayer dao; 
	static String verificationStr;
	
	@BeforeClass
	public static void inicializar() throws IOException, JDOMException{
		dao = new daoPlayer();
		
		Player p = new Player();
 		p.setName("daoTestUser");
 		p.setMoedas(5);
 		p.setEstrelas(4);
 		p.setTopicos(3);
 		p.setComentarios(2);
 		p.setCurtidas(1);
 		
 		verificationStr = p.toString();
 		
 		dao.store(p);
	}

	@Test
	public void verifyRecord() throws IOException, JDOMException {
		
		Player p = dao.recover("daoTestUser");
		assertTrue("Diferent entities stored/recovered", p.toString().equals(verificationStr));
		
	}
	
	@AfterClass
	public static void deleteItems() throws IOException, JDOMException{
		
		assertTrue("Item not Deleted", dao.delete("daoTestUser"));
		
	}

}
