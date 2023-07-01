package view;

import controle.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Tela inicial do Programa 
 * @author Murilo Brandão de Souza Rodrigues
 * @since 2023
 */
public class TelaMenu implements ActionListener {
	private static JFrame janela = new JFrame("Controle de Patrimonio");
	private static JLabel titulo = new JLabel("Bem vindo, Marcos");
	private static JButton patrimonio = new JButton("Adicionar Patrimonios");
	private static JButton listaTangivel = new JButton("Lista Tangivel");
	private static JButton listaIntangivel = new JButton("Lista Intangivel");
	private ControleArmazem armazem = new ControleArmazem();
	
	/**
	 * Cria a tela inicial do programa
	 */
	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 50));
		titulo.setBounds(425, 100, 600, 70);
		patrimonio.setBounds(460, 250, 400, 60);
		listaTangivel.setBounds(460, 350, 400, 60);
		listaIntangivel.setBounds(460, 450, 400, 60);
			
		patrimonio.addActionListener(this);
		listaTangivel.addActionListener(this);
		listaIntangivel.addActionListener(this);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(patrimonio);
		janela.add(listaTangivel);
		janela.add(listaIntangivel);
		
		janela.setExtendedState(janela.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setVisible(true);
	}
	/**
	 * Criação do método main 
	 * @param args 
	 */
	public static void main(String[] args) {
		new TelaMenu();		
	}
	/**
	 * Responsável pela resposta dos botões
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == patrimonio)
			new TelaPatrimonio().mostrarOpcoes(armazem);			
		if(src == listaTangivel) {
			new TelaLista(armazem, 1);
			janela.dispose();
		}
		if(src == listaIntangivel) {
			new TelaLista(armazem, 2);
			janela.dispose();
		}
	}
}