package controle;

import modelo.*;
/**
 * Classe de controle dos objetos Tangivel com a classe ControleArmazem
 * @author Murilo Brandão de Souza Rodrigues
 * @since 2023
 */
public class ControleTangivel {
	private Tangivel[] t;
	private int tmnTangivel;

	/**
	 * Cria a classe ControleTangivel para controlar os 
	 * objetos Tangivel da classe ControleArmazem
	 * @param a - a classe ControleArmazem
	 */
	public ControleTangivel(ControleArmazem a) {
		t = a.getTangivel();
		tmnTangivel = a.getTmnTangivel();
	}
	/**
	 * Pega o nome de todas os objetos as lista e os retornam
	 * @return os nomes dos objetos em uma lista
	 */
	public String[] getNomeTangivel() {
		String[] s = new String[tmnTangivel];
		for(int i = 0; i < tmnTangivel; i++) {
			s[i] = t[i].getNome();
		}
		
		return s;
	}
	//GETS e SETS
	public int getTmn() {
		return tmnTangivel;
	}
	public void setTmn(int tmn) {
		this.tmnTangivel = tmn;
	}
	public String getNome(int i) {
		return t[i].getNome();
	}
	public String getAnotacoes(int i) {
		return t[i].getAnotacoes();
	}
	public String getValor(int i) {
		String valor = String.valueOf(t[i].getValor());
		return valor;
	}
	public String getLocal(int i) {
		return t[i].getLocal();
	}
	public String getQuantidade(int i) {
		String quantidade = String.valueOf(t[i].getQuantidade());
		return quantidade;
	}
	
	public String getImprimir(int i) {
		return t[i].imprimir();
	}
	
}
