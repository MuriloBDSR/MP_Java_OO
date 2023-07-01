package view;

import controle.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Tela com as listas de patrimônios
 * @author Murilo Brandão de Souza Rodrigues
 * @Since 2023
 */
public class TelaLista implements ActionListener, ListSelectionListener{
	
	private static ControleArmazem armazem;
	private JFrame janela = new JFrame("Lista de Patrimonio");
	private JLabel titulo = new JLabel("Lista de seus patrimonios");
	private JTextField filtroText;
	private JLabel filtroLabel;
	private JButton filtroButton;
	private JButton refreshTangivel;
	private JButton refreshIntangivel;
	private JButton addPatrimonio;
	private JButton retorno;
	private JList<String> listaTangivel;
	private JList<String> listaIntangivel;
	private String[] listaPatrimonio;
	private int opcao;
	
	/**
	 * Construtor da TelaLista, ela apresenta a janela com as Listas e
	 * suas funcionalidades
	 * @param a  O ControleArmazem que a TelaLista pega a lista
	 * @param o  Opção para mostrar a lista Tangivel(1) ou Intangivel(2)
	 */
	public TelaLista(ControleArmazem a, int o){
		armazem = a;
		opcao = o;
		
		switch(o) {
		
		case 1:
			listaPatrimonio = new ControleTangivel(armazem).getNomeTangivel();
			listaTangivel = new JList<String>(listaPatrimonio);
					
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(280, 20, 300, 30);
			
			listaTangivel.setBounds(20, 140, 750, 450);
			listaTangivel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaTangivel.setVisibleRowCount(10);
			listaTangivel.addListSelectionListener(this);
			
			refreshTangivel = new JButton("Refresh");
			refreshTangivel.addActionListener(this);
			refreshTangivel.setBounds(200, 600, 360, 30);
			
			janela.setLayout(null);
			janela.add(titulo);
			janela.add(listaTangivel);
			janela.add(refreshTangivel);
	
			janela.setSize(800, 700);
			janela.setVisible(true);
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		case 2:
			listaPatrimonio = new ControleIntangivel(armazem).getNomeIntangivel();
			listaIntangivel = new JList<String>(listaPatrimonio);
					
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(280, 20, 300, 30);
			
			listaIntangivel.setBounds(20, 140, 750, 450);
			listaIntangivel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaIntangivel.setVisibleRowCount(10);
			listaIntangivel.addListSelectionListener(this);
		
			refreshIntangivel = new JButton("Refresh");
			refreshIntangivel.addActionListener(this);
			refreshIntangivel.setBounds(200, 600, 360, 30);
				
			janela.setLayout(null);
			janela.add(titulo);
			janela.add(listaIntangivel);
			janela.add(refreshIntangivel);
			
			janela.setSize(800, 700);
			janela.setVisible(true);
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		filtroLabel = new JLabel("Procurar patrimonio por nome");
		filtroLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		filtroLabel.setBounds(20, 100, 200, 30);
		filtroText = new JTextField();
		filtroText.setBounds(220, 100, 440, 30);
		filtroButton = new JButton("Filtrar");
		filtroButton.addActionListener(this);
		filtroButton.setBounds(670, 100, 100, 30);
		
		
		addPatrimonio = new JButton("Adicionar Patri");
		addPatrimonio.addActionListener(this);
		addPatrimonio.setBounds(20,600,180,30);
		
		retorno = new JButton("Voltar");
		retorno.addActionListener(this);
		retorno.setBounds(560, 600, 180, 30);
		
		janela.add(filtroLabel);
		janela.add(filtroText);
		janela.add(filtroButton);
		janela.add(addPatrimonio);
		janela.add(retorno);
	}

	/**
	 * Responsável por detectar os botões da TelaLista 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == filtroButton) {
			if(opcao == 1) {
				armazem.buscarTangivel(filtroText.getText());
				JOptionPane.showMessageDialog(null,"o valor inserido foi:\n" + filtroText.getText()
				,null, JOptionPane.INFORMATION_MESSAGE);
				}	
			else if(opcao == 2) {
				armazem.buscarIntangivel(filtroText.getText());
				JOptionPane.showMessageDialog(null,"o valor inserido foi:\n"+  filtroText.getText()
				,null, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(src == addPatrimonio){
			new TelaPatrimonio().mostrarOpcoes(armazem);
		}
		if(src == refreshTangivel) {
			listaTangivel.setListData(new ControleTangivel(armazem).getNomeTangivel());
			listaTangivel.updateUI();
		}
		if(src == refreshIntangivel) {
			listaIntangivel.setListData(new ControleIntangivel(armazem).getNomeIntangivel());
			listaIntangivel.updateUI();
		}
		if(src == retorno && opcao == 2) {
			janela.dispose();
			new TelaLista(armazem, 1);
		}else if(src == retorno && opcao == 1) {
			janela.dispose();
			new TelaLista(armazem, 2);
		}
	}
	
	/**
	 * Responsável por detectar a seleção de algum objeto dentro
	 * da JList como os patrimonios
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaTangivel) {
			new TelaEdicao(1, armazem, listaTangivel.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaIntangivel) {
			new TelaEdicao(2, armazem, listaIntangivel.getSelectedIndex());
		}
	}
}