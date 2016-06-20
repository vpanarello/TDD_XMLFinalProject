/**
 * 
 */
package gamification.entity;

/**
 * S04.02_TDD_ProjetoFinal / Player.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class Player implements Comparable<Player>{
	
	private String name;
	private Scores scores;
	private int compareSelection;
	

	public Player() {
		super();
		scores = new Scores();
		compareSelection = 0;
	}
	public Player(String name) {
		super();
		scores = new Scores();
		this.name = name;
		compareSelection = 0;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	
	public int getMoedas() {return scores.getMoedas();}
	public void setMoedas(int moedas) {scores.setMoedas(moedas);}
	public int getEstrelas() {return scores.getEstrelas();}
	public void setEstrelas(int estrelas) {scores.setEstrelas(estrelas);}
	public int getTopicos() {return scores.getTopicos();}
	public void setTopicos(int topicos) {scores.setTopicos(topicos);}
	public int getComentarios() {return scores.getComentarios();}
	public void setComentarios(int comentarios) {scores.setComentarios(comentarios);}
	public int getCurtidas() {return scores.getCurtidas();}
	public void setCurtidas(int curtidas) {scores.setCurtidas(curtidas);}
	
	public boolean hasScore(){
		return scores.hasScore();
	}
	
	public void setScores(Scores scores){
		this.scores = scores;
	}
	public Scores getScores() {
		return scores;
	}
	public void incrementScores(Scores scores){
		this.scores.incrementScore(scores);
	}
	
	
	@Override
	public String toString() {
		String retString = "";
		
		retString = retString.concat("Jogador: ").concat(name).concat("\n");
		if(getMoedas() > 0) retString = retString.concat("Moedas: ").concat(String.valueOf(getMoedas())).concat("\n");
		if(getEstrelas() > 0) retString = retString.concat("Estrelas: ").concat(String.valueOf(getEstrelas())).concat("\n");
		if(getTopicos() > 0) retString = retString.concat("Topicos: ").concat(String.valueOf(getTopicos())).concat("\n");
		if(getComentarios() > 0) retString = retString.concat("Comentarios: ").concat(String.valueOf(getComentarios())).concat("\n");
		if(getCurtidas() > 0) retString = retString.concat("Curtidas: ").concat(String.valueOf(getCurtidas())).concat("\n");
		
		
		return retString;
	}
	
	public enum scoreType {
		MOEDAS,
		ESTRELAS,
		TOPICOS,
		COMENTARIOS,
		CURTIDAS;
	}
	

	@Override
	public int compareTo(Player player) {
		
			
		return 0;
	}
	
	
	
}
