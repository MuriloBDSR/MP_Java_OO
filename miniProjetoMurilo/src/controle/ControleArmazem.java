package controle;

import modelo.*;
/**
 * Classe que controla Armazem com a view
 * @author Murilo Brandão de Souza Rodrigues
 * @since 2023
 */
public class ControleArmazem {
	private Armazem a = new Armazem();
/**
 * Construtor que cria uma classe Armazem com listas Tangivel e Intangivel
 */
	public ControleArmazem() {
		a.fillLista();
	}
	
	public Armazem getPatrimonio() {
		return a;
	}
	public void setPatrimonio(Armazem a) {
		this.a = a;
	}
	public Intangivel[] getIntangivel() {
		return this.a.getIntangivel();
	}
	public int getTmnIntangivel() {
		return this.a.getTmnIntangivel();
	}
	
	
	public Tangivel[] getTangivel() {
		return this.a.getTangivel();
	}
	public int getTmnTangivel() {
		return this.a.getTmnTangivel();
	}
	/**
	 * Cria ou edita um objeto Tangivel, dependendo dos dados dado pela view
	 * @param tangivel  a lista com os dados do objeto e posição
	 * @return  boolean para acionar as janelas de erro ou sucesso
	 */
	public boolean adicionarEditarTangivel(String[] tangivel) {
		if(tangivel[1].isEmpty() || tangivel[2].isEmpty() || tangivel[4].isEmpty()) {
			return false;
		}else {
		Tangivel t = new Tangivel(tangivel[1], tangivel[2], Double.parseDouble(tangivel[3]), 
				tangivel[4], Integer.parseInt(tangivel[5]));
		a.inserirEditarTangivel(t, Integer.parseUnsignedInt(tangivel[0]));
		return true;
		}
		}
	/**
	 * Cria ou edita um objeto Intangivel, dependendo dos dados dado pela view
	 * @param intangivel  a lista com os dados do objeto e posição
	 * @return  boolean para acionar as janelas de erro ou sucesso
	 */
	public boolean adicionarEditarIntangivel(String[] intangivel) {
		if(intangivel[1].isEmpty() || intangivel[2].isEmpty() || intangivel[5].isEmpty() || intangivel[6].isEmpty()) {
			return false;
		}else {
			Intangivel it = new Intangivel(intangivel[1], intangivel[2], Double.parseDouble(intangivel[3]),
					intangivel[4], intangivel[5], intangivel[6]);
			a.inserirEditarIntangivel(it, Integer.parseUnsignedInt(intangivel[0]));
			return true;
		}
		}
	/**
	 * Remove um objeto da lista Tangivel.
	 * @param i  index do objeto na lista Tangivel
	 * @return  boolean para acionar as janelas de erro ou sucesso
	 */
	public boolean removerTangivel(int i) {
		String tangivelRemove = a.getTangivel()[i].getNome();
		if(i == (a.getTmnTangivel() - 1)) { // O Tangivel está no final da lista
			a.setTmnTangivel(a.getTmnTangivel() - 1);
			a.getTangivel()[a.getTmnTangivel()] = null;
			return true;
		} else { // o Tangivel está no meio da lista
			int cont = 0;
			while(a.getTangivel()[cont].getNome().compareTo(tangivelRemove) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < a.getTmnTangivel() - 1; j++) {
				a.getTangivel()[j] = null;
				a.getTangivel()[j] = a.getTangivel()[j+1];
			}
			a.getTangivel()[a.getTmnTangivel()] = null;
			a.setTmnTangivel(a.getTmnTangivel() - 1);
			return true;
		}
	}
	/**
	 * Remove um objeto da lista Intangivel.
	 * @param i  index do objeto na lista Intangivel
	 * @return  boolean para acionar as janelas de erro ou sucesso
	 */
		public boolean removerIntangivel(int i) {
			String intangivelRemove = a.getIntangivel()[i].getNome();
			if(i == (a.getTmnIntangivel() - 1)) { // O Intangivel está no final da lista
				a.setTmnIntangivel(a.getTmnIntangivel() - 1);
				a.getIntangivel()[a.getTmnIntangivel()] = null;
				return true;
			} else { // o Intangivel está no meio da lista
				int cont = 0;
				while(a.getIntangivel()[cont].getNome().compareTo(intangivelRemove) != 0) {
					cont++;
				}
				//Rotina swap
				for(int j = cont; j < a.getTmnIntangivel() - 1; j++) {
					a.getIntangivel()[j] = null;
					a.getIntangivel()[j] = a.getIntangivel()[j+1];
				}
				a.getIntangivel()[a.getTmnIntangivel()] = null;
				a.setTmnIntangivel(a.getTmnIntangivel() - 1);
				return true;
			}
	}
		/**
		 * Leva o objeto Tangivel com o mesmo nome do parâmetro
		 * para o topo da lista
		 * @param nome  Nome para o parâmetro
		 * @return boolean para a tela de erro
		 */
		public boolean buscarTangivel(String nome) {
			int tamanho = a.getTmnTangivel();
			int index = 0;
			boolean retorno = false;
			for(int i = 0; i < tamanho; i++) {
				if(a.getTangivel()[index].getNome().equals(nome) != true) {
					a.inserirEditarTangivel(a.getTangivel()[index], a.getTmnTangivel());
					removerTangivel(index);
				}else {
					index++;
				}
			if (index > 0) {
				retorno = true;
			}else {
				retorno = false;
			}
			}
			return retorno;
		}
		/**
		 * Leva o objeto Intangivel com o mesmo nome do parâmetro
		 * para o topo da lista
		 * @param nome Nome para o parâmetro
		 * @return boolean para a tela de erro
		 */
		public boolean buscarIntangivel(String nome) {
			int tamanho = a.getTmnIntangivel();
			int index = 0;
			boolean retorno = false;
			for(int i = 0; i < tamanho; i++) {
				if(a.getIntangivel()[index].getNome().compareTo(nome) != 0) {
					a.inserirEditarIntangivel(a.getIntangivel()[index], a.getTmnIntangivel());
					removerIntangivel(index);
				}else {
					index++;
			}
		if (index > 0) {
			retorno = true;
		}else {
			retorno = false;
		}
		}
		return retorno;
	}
}


