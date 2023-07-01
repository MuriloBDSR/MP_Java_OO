package controle;

import modelo.*;
/**
 * Classe de controle dos objetos Intangivel com a classe ControleArmazem
 * @author Murilo Brandão de Souza Rodrigues
 * @since 2023
 //*/
public class ControleIntangivel {
	private Intangivel[] it;
	private int tmnIntangivel;
	
	/**
	 * Cria a classe ControleIntangivel para controlar os 
	 * objetos Intangivel da classe ControleArmazem
	 * @param a  A classe ControleArmazem
	 */
	public ControleIntangivel(ControleArmazem a) {
		it = a.getIntangivel();
		tmnIntangivel = a.getTmnIntangivel();
	}
	/**
	 * Pega o nome de todas os objetos as lista e os retornam
	 * @return os nomes dos objetos em uma lista
	 */
	public String[] getNomeIntangivel() {
		String[] s = new String[tmnIntangivel];
		for(int i = 0; i < tmnIntangivel; i++) {
			s[i] = it[i].getNome();
		}
		
		return s;
	}
	//GETS e SETS
	public int getTmn() {
		return tmnIntangivel;
	}
	public void setTmn(int tmn) {
		this.tmnIntangivel = tmn;
	}
	public String getNome(int i) {
		return it[i].getNome();
	}
	public String getAnotacoes(int i) {
		return it[i].getAnotacoes();
	}
	public String getValor(int i) {
		String valor = String.valueOf(it[i].getValor());
		return valor;
	}
	public String getAmbiente(int i) {
		return it[i].getAmbiente();
	}
	public String getExpiracao(int i) {
		return it[i].getExpiracao();
	}
	public String getImprimir(int i) {
		return it[i].imprimir();
	}
}