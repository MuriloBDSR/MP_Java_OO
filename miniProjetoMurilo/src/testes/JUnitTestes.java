/**
 * Package para realizar os testes do projeto
 */
package testes;

import controle.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
/**
 * Classe para os teste unitários do projeto
 * @author Murilo Brandão de Souzarodrigues
 * @since 2023
 */
public class JUnitTestes {
	/**
	 * Cria um novo controleArmazem para os testes
	 */
	ControleArmazem a = new ControleArmazem();

	/**
	 * Teste para ver a criação da classe ControleArmazem e
	 * que todos o nomes não estão "vazios"
	 */
	@Test
	void testNomePatrimonio() {
		String nomeInvalido = "";
		for(int i = 0; i < a.getTmnTangivel(); i ++) {
			assertTrue(a.getTangivel()[i].getNome() != nomeInvalido);
			assertFalse(a.getTangivel()[i].getNome() == nomeInvalido);
		}
		for(int i = 0; i < a.getTmnIntangivel(); i ++) {
			assertTrue(a.getIntangivel()[i].getNome() != nomeInvalido);
			assertFalse(a.getIntangivel()[i].getNome() == nomeInvalido);
		}
	}
	/**
	 * Teste para ver seu a lista após a remoção de um objeto se ele ainda 
	 * pemanece nela
	 */
	@Test
	void testRemoverPatrimonio() {
		String nomeDeletadoTangivel = "Tangivel4";
		String nomeDeletadoIntangivel = "Intangivel3";
		a.removerTangivel(3);
		a.removerIntangivel(2);
		for(int i = 0; i < a.getTmnTangivel(); i++) {
			assertTrue(a.getTangivel()[i].getNome() != nomeDeletadoTangivel);
			assertFalse(a.getTangivel()[i].getNome() == nomeDeletadoTangivel);
		}
		for(int i = 0; i < a.getTmnIntangivel(); i++) {
			assertTrue(a.getTangivel()[i].getNome() != nomeDeletadoIntangivel);
			assertFalse(a.getIntangivel()[i].getNome() == nomeDeletadoIntangivel);
		}		
	}
	/**
	 * Teste para ver se um Patrimonio está no index 0 após seu nome  ser
	 * pesquisado
	 */
	@Test
	void testBuscarPatromonio() {
		String resultadoEsperadoT = "Tangivel4";
		String resultadoEsperadoI = "Intangivel2";
		a.buscarTangivel(resultadoEsperadoT);
		String respostaT = a.getTangivel()[0].getNome();
		assertEquals(resultadoEsperadoT, respostaT);
		
		a.buscarIntangivel(resultadoEsperadoI);
		String respostaI = a.getIntangivel()[0].getNome();
		assertEquals(resultadoEsperadoI, respostaI);
	}
}