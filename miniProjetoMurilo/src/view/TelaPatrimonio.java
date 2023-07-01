package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import controle.*;

/**
 * Tela Para adicionar novos patrimonios
 * @author Murilo Brandão de Souza Rodrigues
 * @seince 2023
 */
public class TelaPatrimonio implements ItemListener, ActionListener{
	private JFrame janela = new JFrame("Controle de Patrimonio");
	private JLabel titulo = new JLabel("Adicionar Patrimonio");
	private JLabel nomePatrimonio1 = new JLabel("Nome do");
	private JLabel nomePatrimonio2 = new JLabel("Patrimonio:");
	private JTextField Patrimonio = new JTextField();
	private JLabel nomeAnotacoes = new JLabel("Anotações:");
	private JTextField anotacoes = new JTextField();
	private JLabel nomeValor = new JLabel("Valor:");
	private JTextField valor = new JTextField();
	private static JComboBox<?> selecao;
	private JLabel nomeSelecao = new JLabel("Tipo:");
	private JLabel nomeLocal = new JLabel("Local:");
	private JTextField local = new JTextField();
	private JLabel nomeAmbiente = new JLabel("Ambiente:");
	private JTextField ambiente = new JTextField();
	private JLabel nomeExpiracao = new JLabel("Expiração:");
	private JTextField expiracao = new JTextField();
	private JLabel nomeQuantidade = new JLabel("Quantidade:");
	private JTextField quantidade = new JTextField();
	private JButton confirmacao = new JButton("Confirmar");
	private JButton cancela = new JButton("Cancelar");
	private String[] novoPatrimonio = new String[9];
	private static ControleArmazem armazem;
	/**
	 * Irá criar uma novo patrimonio para a lista
	 * @param a O ControleArmazem em que o patrimônio será adicionado
	 */
	public void mostrarOpcoes(ControleArmazem a) {
		armazem = a;
		
		String list[] = {"<selec. o tipo>","Tangiveis", "Intangiveis"};
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(100, 20, 300, 30);
		Patrimonio.setBounds(170, 70, 180, 30);
		nomePatrimonio1.setBounds(90, 60, 180,30);
		nomePatrimonio2.setBounds(90, 75, 180, 30);
		anotacoes.setBounds(170, 120, 180, 30);
		nomeAnotacoes.setBounds(90, 120, 180, 30);
		valor.setBounds(170, 170, 180, 30);
		nomeValor.setBounds(90, 170, 180, 30);
		selecao = new JComboBox<>(list);
		selecao.setBounds(170, 220, 180, 30);
		nomeSelecao.setBounds(90, 220, 180, 30);
		local.setBounds(170, 270, 180, 30);
		nomeLocal.setBounds(90, 270, 180, 30);
		ambiente.setBounds(170, 270, 180, 30);
		nomeAmbiente.setBounds(90, 270, 180, 30);
		quantidade.setBounds(170,320,180,30);
		nomeQuantidade.setBounds(90, 320, 180, 30);
		expiracao.setBounds(170,320,180,30);
		nomeExpiracao.setBounds(90, 320, 180, 30);
		confirmacao.setBounds(90, 370, 120, 30);
		cancela.setBounds(230, 370, 120, 30);
		
		confirmacao.addActionListener(this);
		cancela.addActionListener(this);
		selecao.addItemListener(this);
		
		janela.add(titulo);
		janela.add(nomePatrimonio1);
		janela.add(nomePatrimonio2);
		janela.add(Patrimonio);
		janela.add(nomeAnotacoes);
		janela.add(anotacoes);
		janela.add(nomeValor);
		janela.add(valor);
		janela.add(nomeValor);
		janela.add(nomeSelecao);
		janela.add(selecao);
		janela.add(nomeSelecao);
		janela.add(nomeAmbiente);
		nomeAmbiente.setVisible(false);
		janela.add(nomeLocal);
		nomeLocal.setVisible(false);
		janela.add(nomeQuantidade);
		nomeQuantidade.setVisible(false);
		janela.add(nomeExpiracao);
		nomeExpiracao.setVisible(false);
		
		janela.setLayout(null);
		janela.setSize(400, 300);
		janela.setVisible(true);
		janela.setResizable(false);
	}
	/**
	 * Muda a tela se a caixa de selação for alterada
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		String str = selecao.getSelectedItem().toString();
		if( str == "Intangiveis"){
			janela.remove(local);
			quantidade.setVisible(false);
			janela.remove(quantidade);
			expiracao.setVisible(true);
			
			nomeAmbiente.setVisible(true);
			nomeLocal.setVisible(false);
			janela.add(ambiente);
			
			nomeQuantidade.setVisible(false);
			nomeExpiracao.setVisible(true);
			janela.add(expiracao);
			
			janela.add(confirmacao);
			janela.add(cancela);
			
			janela.setSize(400, 500);
		}else if(str == "Tangiveis") {
			
			janela.remove(ambiente);
			expiracao.setVisible(false);
			janela.remove(expiracao);
			quantidade.setVisible(true);
			
			nomeAmbiente.setVisible(false);
			nomeLocal.setVisible(true);
			janela.add(local);
			
			nomeQuantidade.setVisible(true);
			nomeExpiracao.setVisible(false);
			janela.add(quantidade);
			
			janela.add(confirmacao);
			janela.add(cancela);
			
			janela.setSize(400, 500);
		}else{
			janela.remove(cancela);
			
			janela.remove(local);
			janela.remove(quantidade);
			janela.remove(ambiente);
			janela.remove(expiracao);
			janela.remove(confirmacao);
			
			nomeAmbiente.setVisible(false);
			nomeLocal.setVisible(false);
			nomeQuantidade.setVisible(false);
			nomeExpiracao.setVisible(false);
			
			janela.setSize(400, 300);
			janela.setVisible(true);
		}
	}
	
	/**
	 * Responsável pela resposta dos botões pessionados
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object str = e.getSource();
		//adiciona um patrimonio dependendo de qual 
		//classe ela pertença(Tangivel ou Intangivel)
		if(str == confirmacao) {
			try {
			boolean res = false;
			if(selecao.getSelectedItem().toString() == "Tangiveis") {
				novoPatrimonio[0] = Integer.toString(armazem.getTmnTangivel());
				novoPatrimonio[1] = Patrimonio.getText();
				novoPatrimonio[2] = anotacoes.getText();
				novoPatrimonio[3] = valor.getText();
				novoPatrimonio[4] = local.getText();
				novoPatrimonio[5] = quantidade.getText();
				res = armazem.adicionarEditarTangivel(novoPatrimonio);
			}else if(selecao.getSelectedItem().toString() == "Intangiveis") {
				novoPatrimonio[0] = Integer.toString(armazem.getTmnIntangivel());
				novoPatrimonio[1] = Patrimonio.getText();
				novoPatrimonio[2] = anotacoes.getText();
				novoPatrimonio[3] = valor.getText();
				novoPatrimonio[4] = ambiente.getText();
				novoPatrimonio[5] = expiracao.getText();
				res = armazem.adicionarEditarIntangivel(novoPatrimonio);
			}
				if(res == true){
					mensagemSucessoAdicionar();
					}else {
						mensagemErroAdicionar();
					}
				}catch (NullPointerException exc1) {
					mensagemErroAdicionar();
				} catch (NumberFormatException exc2) {
					mensagemErroAdicionar();
				}
				}
		//fecha a janela
		if(str == cancela) {
			janela.dispose();
		}
	}
	/**
	 * Mensagem de sucesso ao adicionar um novo patrimônio
	 */
		public void mensagemSucessoAdicionar() {
			JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
		}
		
		/**
		 * Mensagem de erro ao tentar adicionar um novo patrimônio 
		 */
		public void mensagemErroAdicionar() {
			JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
					+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
					+ "1. Nem todos os campos foram preenchidos \n"
					+ "2. valores e/ou quantidade não contem apenas números \n"
					+ "3. valor deve ter o '.'(ponto) como indicador de casas decimais", null, 
					JOptionPane.ERROR_MESSAGE);
		}
}