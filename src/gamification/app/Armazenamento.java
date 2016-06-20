/**
 * 
 */
package gamification.app;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;

import gamification.dao.ArrayList;
import gamification.dao.daoPlayer;
import gamification.entity.Player;
import gamification.entity.Scores;

/**
 * S04.02_TDD_ProjetoFinal / Armazenamento.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class Armazenamento {
	
	daoPlayer file;
	
	
	public void armazenarJogador(Player usuario) throws IOException, JDOMException{
		file = new daoPlayer();
		file.store(usuario);
	}
	
	
	public int retornarPontos(String pontoTipo, String usuario){
		
		Player p = file.recover(usuario);
		
		switch (pontoTipo){
			case "moeda":
				return p.getMoedas();
			case "estrela":
				return p.getEstrelas();
			case "topico":
				return p.getTopicos();
			case "comentario":
				return p.getComentarios();
			case "curtida":
				return p.getCurtidas();
		}
		
		return 0;
	}
	
	public List<Player> usuariosComPontos(){
		
		List<Player> retList = new ArrayList<>();
		for(Player p :file.recoverAll()){
			if (p.hasScore()) retList.add(p);
		}
		return retList;
	}
	
	public Scores retornarTodosPontosGanhos(){
		Scores s = new Scores();
		
		for(Player p :file.recoverAll()){
			if (p.hasScore()){
				s.incrementScore(p.getScores());
			}
		}
	return s;	
	}
	
	public boolean excluirUsuario(String nomeUsuario) throws IOException, JDOMException{
		
		return file.delete(nomeUsuario);
		
	}
	
}
