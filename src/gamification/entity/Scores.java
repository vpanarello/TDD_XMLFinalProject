/**
 * 
 */
package gamification.entity;

/**
 * S04.02_TDD_ProjetoFinal / Scores.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class Scores {
	
	public Scores() {super();}
	

	/**
	 * @param moedas
	 * @param estrelas
	 * @param topicos
	 * @param comentarios
	 * @param curtidas
	 */
	public Scores(int moedas, int estrelas, int topicos, int comentarios, int curtidas) {
		super();
		this.moedas = moedas;
		this.estrelas = estrelas;
		this.topicos = topicos;
		this.comentarios = comentarios;
		this.curtidas = curtidas;
	}


	private int moedas;
	private int estrelas;
	private int topicos;
	private int comentarios;
	private int curtidas;
	
	
	public int getMoedas() {return moedas;}
	public void setMoedas(int moedas) {this.moedas = moedas;}
	public int getEstrelas() {return estrelas;}
	public void setEstrelas(int estrelas) {this.estrelas = estrelas;}
	public int getTopicos() {return topicos;}
	public void setTopicos(int topicos) {this.topicos = topicos;}
	public int getComentarios() {return comentarios;}
	public void setComentarios(int comentarios) {this.comentarios = comentarios;}
	public int getCurtidas() {return curtidas;}
	public void setCurtidas(int curtidas) {this.curtidas = curtidas;}
	
	public boolean hasScore(){
		if((moedas+estrelas+topicos+comentarios+curtidas) > 0) return true;
		else return false;
	}
	
	public void incrementScore(Scores scores){
		moedas += scores.getMoedas();
		estrelas += scores.getEstrelas();
		topicos += scores.getTopicos();
		comentarios += scores.getComentarios();
		curtidas += scores.getCurtidas();
	}

	@Override
	public String toString() {
		return "Scores [moedas=" + moedas + ", estrelas=" + estrelas + ", topicos=" + topicos + ", comentarios="
				+ comentarios + ", curtidas=" + curtidas + "]";
	}
	
	

}
