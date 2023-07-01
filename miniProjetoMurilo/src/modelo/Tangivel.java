package modelo;

/**
 * Classe Tangivel é uma subclasse da classe abstrata Patrimonio
 * @author User
 * @since 2023
 */
public class Tangivel extends Patrimonio{
	private String tipo = "Tangivel";
	private String local;
	private int quantidade;
/**
 *  Construtor da classe Tangivel
 * @param n  nome do Tangivel
 * @param a  anotações do Tangivel
 * @param v  valor do Tangivel
 * @param l  local do Tangivel
 * @param q  quantidade do Tangivel
 */
	public Tangivel(String n,String a, double v, String l, int q) {	
		nome = n;
		anotacoes = a;
		valor = v;
		local = l;
		quantidade = q;
	}

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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	/**
	 * Sobrescreve o método imprimir na classe Patrimonio
	 * @return as informações do objeto
	 */
	public String imprimir() {
		return "Nome: "+ nome + 
				"; \n Anotacoes: "+ anotacoes +
				"; \n Valor: "+ valor +
				"; \n tipo: " + tipo +
				"; \n local: " + local+
				"; \n quantidade: "+ quantidade;
	}

}
