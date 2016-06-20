/**
 * 
 */
package gamification.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import gamification.app.Armazenamento;
import gamification.entity.Player;
import gamification.entity.Scores;

/**
 * S04.02_TDD_ProjetoFinal / ArmazenamentoTest.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class ArmazenamentoTest {
	
	static Armazenamento a;
	
	@BeforeClass
	public static void inicializacao() throws IOException, JDOMException{
		
		a =  new Armazenamento();
		
		Player usuario1 = new Player();
 		usuario1.setName("Usuario de testes");
 		usuario1.setMoedas(2);
 		usuario1.setEstrelas(3);
 		usuario1.setTopicos(1);
 		usuario1.setComentarios(7);
 		usuario1.setCurtidas(10);
		
		Player usuario2 = new Player();
 		usuario2.setName("Usuario de testes sem pontos");
 		usuario2.setMoedas(0);
 		usuario2.setEstrelas(0);
 		usuario2.setTopicos(0);
 		usuario2.setComentarios(0);
 		usuario2.setCurtidas(0);
		
		Player usuario3 = new Player();
 		usuario3.setName("Usuario de testes poucos pontos");
 		usuario3.setMoedas(0);
 		usuario3.setEstrelas(0);
 		usuario3.setTopicos(3);
 		usuario3.setComentarios(0);
 		usuario3.setCurtidas(0);
 		
		a.armazenarJogador(usuario1);
		a.armazenarJogador(usuario2);
		a.armazenarJogador(usuario3);
	}

	@Test
	public void verificarRetornarPontos() throws IOException, JDOMException {
		
		assertEquals(2, a.retornarPontos("moeda", "Usuario de testes"));
		assertEquals(3, a.retornarPontos("estrela", "Usuario de testes"));
		assertEquals(1, a.retornarPontos("topico", "Usuario de testes"));
		assertEquals(7, a.retornarPontos("comentario", "Usuario de testes"));
		assertEquals(10, a.retornarPontos("curtida", "Usuario de testes"));

	}
	
	@Test
	public void verificarUsuariosComPontos() throws IOException, JDOMException {
		
		List<Player> usuarios = a.usuariosComPontos();
		
		for (Player player : usuarios) {
			if(player.getName().equals("TemplateUser")) assertEquals(4, player.getComentarios());
			if(player.getName().equals("Usuario de testes")) assertEquals(10, player.getCurtidas());
			if(player.getName().equals("Usuario de testes poucos pontos")) assertEquals(3, player.getTopicos());
		}
	}
	
	@Test
	public void verificarPontos() throws IOException, JDOMException {
		
		Scores s = a.retornarTodosPontosGanhos();
		
		assertTrue(s.toString().equals("Scores [moedas=3, estrelas=5, topicos=7, comentarios=11, curtidas=15]"));
	}
	
	@AfterClass
	public static void finalizarExcluirUsuariosTeste() throws IOException, JDOMException{
		
		assertTrue("Não pode excluir item", a.excluirUsuario("Usuario de testes"));
		assertTrue("Não pode excluir item", a.excluirUsuario("Usuario de testes sem pontos"));
		assertTrue("Não pode excluir item", a.excluirUsuario("Usuario de testes poucos pontos"));
		
	}
	

}
