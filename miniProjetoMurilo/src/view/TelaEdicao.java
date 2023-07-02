package view;

import controle.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Tela para editar um patrimônio
 * @author Murilo Brandão de Souza Rodrigues
 * @since 2023
 */
public class TelaEdicao implements ActionListener{
	private JFrame janela;
	private int opcao;
	private int posicao;
	private static ControleArmazem armazem;
	private JLabel titulo;
	private JTextField Patrimonio;
	private JLabel nomePatrimonio1 = new JLabel("Nome do");
	private JLabel nomePatrimonio2 = new JLabel("Patrimonio:");
	private JTextField anotacoes;
	private JLabel nomeAnotacoes = new JLabel("Anotações:");
	private JTextField valor;
	private JLabel nomeValor = new JLabel("Valor:");
	private JTextField pessoa;
	private JLabel nomePessoa = new JLabel("Pessoa:");
	private JTextField local;
	private JTextField ambiente;
	private JLabel nomeAmbienteElocal;
	private JTextField expiracao;
	private JTextField quantidade;	

	private JLabel nomeExpiracaoeQuantidade;
	private JButton confirmacao = new JButton("Confirmar");
	private String[] novosDados = new String[9];
	private JButton remove = new JButton("Deletar");
	private JButton info = new JButton("Info");

	
/**
 * Construtor da classe TelaEdicao
 * @param opcao  define se o objeto a ser alterado é Tangivel e Intangivel
 * @param a  ControleArmazem onde estão salvo os dados
 * @param posicao  Pega o index do objeto dentro da lista
 */
	public TelaEdicao(int opcao, ControleArmazem a,int posicao){
		this.opcao = opcao;
		this.posicao = posicao;
		armazem = a;
		
		if(opcao == 2) {
			// Cria as JTextFields, JLabel e JFrame para a classe Intangivel
			janela = new JFrame("Editar Intangivel");
			titulo = new JLabel("Editar Intangivel");
			Patrimonio = new JTextField(armazem.getIntangivel()[posicao].getNome());
			anotacoes = new JTextField(armazem.getIntangivel()[posicao].getAnotacoes());
			valor = new JTextField(String.valueOf(armazem.getIntangivel()[posicao].getValor()));
			pessoa = new JTextField(armazem.getIntangivel()[posicao].getPessoa());
			ambiente = new JTextField(armazem.getIntangivel()[posicao].getAmbiente());
			expiracao = new JTextField(armazem.getIntangivel()[posicao].getExpiracao());
			nomeAmbienteElocal = new JLabel("Ambiente:");
			nomeExpiracaoeQuantidade = new JLabel("Expiração:");
			
			nomePatrimonio1.setBounds(90, 60, 180, 30);
			nomePatrimonio2.setBounds(90, 75, 180, 30);
			nomeAnotacoes.setBounds(90, 120, 180, 30);
			nomeValor.setBounds(90, 170, 180, 30);
			
			nomePessoa.setBounds(90, 220, 180, 30);
			nomeAmbienteElocal.setBounds(90, 270, 180, 30);
			nomeExpiracaoeQuantidade.setBounds(90,320, 180, 30);
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(140, 20, 300, 30);
			Patrimonio.setBounds(170, 70, 180,30);
			anotacoes.setBounds(170, 120, 180, 30);
			valor.setBounds(170, 170, 180, 30);
			pessoa.setBounds(170, 220, 180, 30);
			ambiente.setBounds(170, 270, 180, 30);
			expiracao.setBounds(170, 320, 180, 30);
			
			//adiciona os itens para a JFrame
			janela.add(titulo);
			janela.add(Patrimonio);
			janela.add(nomePatrimonio1);
			janela.add(nomePatrimonio2);
			janela.add(anotacoes);
			janela.add(nomeAnotacoes);
			janela.add(valor);
			janela.add(nomeValor);
			janela.add(pessoa);
			janela.add(nomePessoa);
			janela.add(ambiente);
			janela.add(nomeAmbienteElocal);
			janela.add(expiracao);
			janela.add(nomeExpiracaoeQuantidade);
			
		}else if(opcao == 1) {
			//cria as JTextFields, JFrame e JLabel para a class Intangivel
			janela = new JFrame("Editar Tangivel");
			titulo = new JLabel("Editar Tangivel");
			Patrimonio = new JTextField(armazem.getTangivel()[posicao].getNome());
			anotacoes = new JTextField(armazem.getTangivel()[posicao].getAnotacoes());
			valor = new JTextField(String.valueOf(armazem.getTangivel()[posicao].getValor()));
			local = new JTextField(armazem.getTangivel()[posicao].getLocal());
			quantidade = new JTextField(String.valueOf(armazem.getTangivel()[posicao].getQuantidade()));
			nomeAmbienteElocal = new JLabel("Local:");
			nomeExpiracaoeQuantidade = new JLabel("Quantidade:");
			
			//Define o local de cada item
			nomePatrimonio1.setBounds(90, 60, 180, 30);
			nomePatrimonio2.setBounds(90, 75, 180, 30);
			nomeAnotacoes.setBounds(90, 120, 180, 30);
			nomeValor.setBounds(90, 170, 180, 30);
			nomeAmbienteElocal.setBounds(90, 220, 180, 30);
			nomeExpiracaoeQuantidade.setBounds(90,270, 180, 30);
			
			//Define o local de cada item
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(140, 20, 300, 30);
			Patrimonio.setBounds(170,70,180,30);
			anotacoes.setBounds(170, 120, 180, 30);
			valor.setBounds(170, 170, 180, 30);
			local.setBounds(170, 220, 180, 30);
			quantidade.setBounds(170, 270, 180, 30);
		
			//adiciona os itens para a JFrame
			janela.add(titulo);
			janela.add(Patrimonio);
			janela.add(nomePatrimonio1);
			janela.add(nomePatrimonio2);
			janela.add(anotacoes);
			janela.add(nomeAnotacoes);
			janela.add(valor);
			janela.add(nomeValor);
			janela.add(local);
			janela.add(nomeAmbienteElocal);
			janela.add(quantidade);
			janela.add(nomeExpiracaoeQuantidade);
		}
		//define os que são comuns aos dois
		confirmacao.setBounds(90, 370, 120, 30);
		confirmacao.addActionListener(this);
		remove.setBounds(230, 370, 120, 30);
		remove.addActionListener(this);
		info.setBounds(90, 420, 260, 30);
		info.addActionListener(this);
		
		//adiciona o comum aos dois
		janela.add(confirmacao);
		janela.add(remove);
		janela.add(info);
		
		//define a janela(JFrame)
		janela.setLayout(null);
		janela.setSize(450, 550);
		janela.setVisible(true);
		janela.setResizable(false);
	}

	/**
	 * Detecta o aperto de um botão
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == confirmacao) {
			try {
			boolean res = false;
			if(opcao == 1) {
				novosDados[0] = Integer.toString(posicao);
				novosDados[1] = Patrimonio.getText();
				novosDados[2] = anotacoes.getText();
				novosDados[3] = valor.getText();
				novosDados[4] = local.getText();
				novosDados[5] = quantidade.getText();
				res = armazem.adicionarEditarTangivel(novosDados);
			}else if(opcao == 2) {
				novosDados[0] = Integer.toString(posicao);
				novosDados[1] = Patrimonio.getText();
				novosDados[2] = anotacoes.getText();
				novosDados[3] = valor.getText();
				novosDados[4] = pessoa.getText();
				novosDados[5] = ambiente.getText();
				novosDados[6] = expiracao.getText();
				res = armazem.adicionarEditarIntangivel(novosDados);
				}
			if(res == true){
				mensagemSucessoEdicao();
			}else{
				mensagemErroEdicao();				
				}
			}catch (NullPointerException exc1) {
					mensagemErroEdicao();
				} catch (NumberFormatException exc2) {
					mensagemErroEdicao();
				}
		}
		if(src == remove) {
			boolean res = true;
			if(opcao == 1) {
				armazem.removerTangivel(posicao);
			if (res) {
				mensagemSucessoDeletacao();
				janela.dispose();
			}else {
				mensagemErroDeletacao();	
			}
			}
			if(opcao == 2) {
				res = armazem.removerIntangivel(posicao);
				if (res) {
					mensagemSucessoDeletacao();
					janela.dispose();
				}else {
					mensagemErroDeletacao();	
				}
			}
			}
		if(src == info) {
			if(opcao == 1) {
				JOptionPane.showMessageDialog(null,"Informação do Patrimonio: \n" +
			armazem.getTangivel()[posicao].imprimir(), null, 
						JOptionPane.INFORMATION_MESSAGE);
			}
		else if(opcao == 2) {
				JOptionPane.showMessageDialog(null,"Informação do Patrimonio: \n" +
			armazem.getIntangivel()[posicao].imprimir(), null, 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	/**
	 * Mensagem de sucessso para edição do objeto
	 */
	public void mensagemSucessoEdicao() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	/**
	 * Mensagem de erro para edição do objeto
	 */
	public void mensagemErroEdicao() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. valores e/ou quantidade não contem apenas números \n"
				+ "3. valor deve ter o '.'(ponto) como indicador de casas decimais", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * Mensagem de sucesso para deletar um objeto
	 */
	public void mensagemSucessoDeletacao() {
		JOptionPane.showMessageDialog(null, "Os dados foram deletados com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Mensagem de erro para deletar um objeto
	 */
	public void mensagemErroDeletacao() {
		JOptionPane.showMessageDialog(null,"ERRO AO DELETAR OS DADOS! \n"
				+ "Um erro inesperado ocorreu na hora de deletar o patrimonio"
				+ "Saia da janela e tente novamente",null, JOptionPane.ERROR_MESSAGE);
	}
}