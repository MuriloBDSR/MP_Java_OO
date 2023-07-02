package modelo;

/**
 * Classe responsvel por armazenar os Patrimonios
 * @author Murilo Brandão de Souza Rodrigues
 * @since 2023
 */
public class Armazem {
	    private Intangivel[] intangivel = new Intangivel[50];
	    private Tangivel[] tangivel = new Tangivel[50];
	    private int tmnIntangivel = 0;
	    private int tmnTangivel = 0;
	    
	    /**
	     * Cria patrimonios para as listas tangivel e intangivel
	     */
	    public void fillLista() {
	    	for(int i = 0; i < 5; i++) {
	    		tangivel[i] = new Tangivel("Tangivel"+(i+1), "Anotação", (i+1),"Local", (i+1));
	    		intangivel[i] = new Intangivel("Intangivel"+(i+1), "Anotação",(i+1),"Pessoa" ,"Ambiente", "Coloque a data aqui");
	    	}
	    	tmnTangivel = 5;
	    	tmnIntangivel = 5;
	    }
	    
		public Tangivel[] getTangivel() {
			return tangivel;
		}
		public void setTangivel(Tangivel[] tangivel) {
			this.tangivel = tangivel;
		}
		public int getTmnTangivel() {
			return tmnTangivel;
		}
		public void setTmnTangivel(int tmnTangivel) {
			this.tmnTangivel = tmnTangivel;
		}
		
		
		public Intangivel[] getIntangivel() {
			return intangivel;
		}
		public void setIntangivel(Intangivel[] intangivel) {
			this.intangivel = intangivel;
		}
		public int getTmnIntangivel() {
			return tmnIntangivel;
		}
		public void setTmnIntangivel(int tmnIntangivel) {
			this.tmnIntangivel = tmnIntangivel;
		}
		/**
		 * Pega o index da lista de tangivel e edita ou adiciona o patrimonio
		 * @param i  o patrimonio tangivel
		 * @param posicao  sua posição na lista
		 */
		public void inserirEditarTangivel(Tangivel t, int posicao) {
			this.tangivel[posicao] = t;
			if(posicao == tmnTangivel) {
				tmnTangivel++;
			}
		}
		/**
		 * Pega o index da lista de intangivel e edita ou adiciona o patrimonio
		 * @param i  o patrimonio intangivel
		 * @param posicao  sua posição na lista
		 */
		public void inserirEditarIntangivel(Intangivel in, int posicao) {
			this.intangivel[posicao] = in;
			if(posicao == tmnIntangivel) {
				tmnIntangivel++;
			}
		}
		
}
	 

		
