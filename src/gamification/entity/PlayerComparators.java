/**
 * 
 */
package gamification.entity;

import java.util.Comparator;

/**
 * S04.02_TDD_ProjetoFinal / PlayerComparators.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class PlayerComparators {

	public static Comparator<Player> MOEDAS = new Comparator<Player>() {	
		@Override
		public int compare(Player p1, Player p2) {
			if(p1.getMoedas() > p2.getMoedas()) return -1;
			else if (p1.getMoedas() < p2.getMoedas()) return 1;
			else return 0;
		}
	};

	public static Comparator<Player> ESTRELAS = new Comparator<Player>() {	
		@Override
		public int compare(Player p1, Player p2) {
			if(p1.getEstrelas() > p2.getEstrelas()) return -1;
			else if (p1.getEstrelas() < p2.getEstrelas()) return 1;
			else return 0;
		}
	};

	public static Comparator<Player> TOPICO = new Comparator<Player>() {	
		@Override
		public int compare(Player p1, Player p2) {
			if(p1.getTopicos() > p2.getTopicos()) return -1;
			else if (p1.getTopicos() < p2.getTopicos()) return 1;
			else return 0;
		}
	};

	public static Comparator<Player> COMENTARIO = new Comparator<Player>() {	
		@Override
		public int compare(Player p1, Player p2) {
			if(p1.getComentarios() > p2.getComentarios()) return -1;
			else if (p1.getComentarios() < p2.getComentarios()) return 1;
			else return 0;
		}
	};	
	public static Comparator<Player> CURTIDA = new Comparator<Player>() {	
		@Override
		public int compare(Player p1, Player p2) {
			if(p1.getCurtidas()> p2.getCurtidas()) return -1;
			else if (p1.getCurtidas() < p2.getCurtidas()) return 1;
			else return 0;
		}
	};	

}

		
