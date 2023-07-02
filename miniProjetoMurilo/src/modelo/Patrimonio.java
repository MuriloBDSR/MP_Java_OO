package modelo;

/**
 * Classe Patrimonio é uma calsse Abstract que define os Tangivel e Intangivel
 * @author User
 * @since 2023
 */
abstract class Patrimonio {
	protected String nome; //nome do patrimonio
	protected String anotacoes; // anotações do patrimonio
	protected  double valor; //valor do patrimonio
	
//GETS e SETS
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}
	public String getAnotacoes() {
		return anotacoes;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}
	/**
	 * Semelhante ao método toString
	 * @return null já Patrimonio não deverá ser instanciado 
	 */
	public String imprimir() {
		return null;
	}	
}
