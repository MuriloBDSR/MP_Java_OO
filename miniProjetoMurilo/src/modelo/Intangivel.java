package modelo;
/**
 * Intangivel é uma classe filha de Partrimonio
 * @author Murilo Brandão de Souza Rodrigues
 * @since 2023
 */
public class Intangivel extends Patrimonio{
	private String tipo = "Intangivel";
	private String ambiente;
	private String expiracao;
/**
 * Construtor da classe Intangivel
 * @param n - nome do Intangivel
 * @param an anotacoes do Intangivel
 * @param v valor do Intangivel
 * @param am ambiente do Intangivel
 * @param e expiração do Intangivel
 */
	public Intangivel(String n, String an, double v, String am, String e) {	
		nome = n;
		anotacoes = an;
		valor = v;
		ambiente = am;
		expiracao = e;
		
	}
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;		
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getExpiracao() {
		return expiracao;
	}
	public void setExpiracao(String expiracao) {
		this.expiracao = expiracao;
	}
/**
 * sobrescreve o metodo imprimir da classe Patrimonio
 * @return as informações do objeto 
 */
	public String imprimir() {
		return "Nome: " + nome + 
				"; \n Anotacoes: " + anotacoes +
				"; \n Valor: " + valor +
				"; \n Tipo: " + tipo +
				"; \n Ambiente: " + ambiente +
				"; \n Expiração: " + expiracao;
	}
}