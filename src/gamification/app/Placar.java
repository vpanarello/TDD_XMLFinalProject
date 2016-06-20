/**
 * 
 */
package gamification.app;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jdom2.JDOMException;

import gamification.entity.Player;
import gamification.entity.PlayerComparators;
import gamification.entity.Scores;

/**
 * S04.02_TDD_ProjetoFinal / Placar.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class Placar {
	
	private Armazenamento ar;

	public Placar() {
		super();
		ar = new Armazenamento();
	}
	
	public void registrarUsuario(String nomeUsuario, Scores pontos){
		
		Player p01 = new Player(nomeUsuario);
		p01.setScores(pontos);
		
			
		try {
			ar.armazenarJogador(p01);
		} catch (IOException | JDOMException e) {
			e.printStackTrace();
	}
	}
	
	public String retornaPontosUmJogador(String nomeUsuario){
		
		for (Player p : ar.usuariosComPontos()){
			if (p.getName().equals(nomeUsuario)) return p.toString();
		}
		return null;
	}
	
	public String retornaRankingDe(String pontoTipo){
		
		List<Player> usuarios = ar.usuariosComPontos();
		
		Collections.sort(usuarios, PlayerComparators.ESTRELAS);
		
		String retStr = "..... Ranking .... \n";
		for (Player player : usuarios) {
			retStr += player.getName().concat(" - ").concat(String.valueOf(player.getEstrelas()).concat("\n"));
		}
		return retStr;
	}
}
