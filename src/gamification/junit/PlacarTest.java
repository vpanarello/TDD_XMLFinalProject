/**
 * 
 */
package gamification.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import gamification.app.Placar;
import gamification.entity.Scores;

/**
 * S04.02_TDD_ProjetoFinal / PlacarTest.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class PlacarTest {
	
	static Placar placar;
	
	@BeforeClass
	public static void insereUsuariosComPontos(){
		placar = new Placar();
		
		placar.registrarUsuario("Charlie Chapplin", new Scores(0, 10, 5, 0, 0));
		placar.registrarUsuario("Mario Bros", new Scores(45, 10, 5, 30, 52));
		placar.registrarUsuario("Rubens Barrichelo", new Scores(0, 0, 0, 0, 0));
		placar.registrarUsuario("Carlos Blanka", new Scores(0, 10, 5, 1, 2));
		placar.registrarUsuario("Lionel Richie", new Scores(3, 7, 5, 3, 1));
		
		
	}

	@Test
	public void pontosDeAlgumJogador() {
		System.out.println(placar.retornaPontosUmJogador("Mario Bros"));
		
	}
	
	@Test
	public void ranking() {
		System.out.println(placar.retornaRankingDe("estrelas"));
		
	}

}
