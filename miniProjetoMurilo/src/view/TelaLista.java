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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Tela com as listas de patrimônios
 * @author Murilo Brandão de Souza Rodrigues
 * @since 2023
 */
public class TelaLista implements ActionListener, ListSelectionListener{
	
	private static ControleArmazem armazem;
	private JFrame janela = new JFrame("Lista de Patrimonio");
	private JLabel titulo = new JLabel("Lista de seus patrimonios");
	private JLabel subtituloT = new JLabel("Tangivel");
	private JLabel subtituloI = new JLabel("Intangivel");
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
	private JScrollPane scroll;
	
	/**
	 * Construtor da TelaLista, ela apresenta a janela com as Listas e
	 * suas funcionalidades
	 * @param a  O ControleArmazem que a TelaLista pega a lista
	 * @param o  Opção para mostrar a lista Tangivel(1) ou Intangivel(2)
	 */
	public TelaLista(ControleArmazem a, int o){
		armazem = a;
		opcao = o;
		
		if(opcao ==  1) {
			listaPatrimonio = new ControleTangivel(armazem).getNomeTangivel();
			listaTangivel = new JList<String>(listaPatrimonio);
	
			subtituloT.setFont(new Font("Arial", Font.BOLD, 30));
			subtituloT.setBounds(600, 80, 400, 40);
			
			listaTangivel.setBounds(300, 200, 750, 450);
			listaTangivel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaTangivel.setVisibleRowCount(10);
			listaTangivel.addListSelectionListener(this);
			listaTangivel.setFixedCellHeight(25);
			scroll = new JScrollPane(listaTangivel);
						
			refreshTangivel = new JButton("Refresh");
			refreshTangivel.addActionListener(this);
			refreshTangivel.setBounds(495, 660, 360, 30);
			
			//janela.add(listaTangivel);
			janela.add(refreshTangivel);
			janela.add(subtituloT);
		}
		if(opcao == 2) {
			listaPatrimonio = new ControleIntangivel(armazem).getNomeIntangivel();
			listaIntangivel = new JList<String>(listaPatrimonio);
	
			subtituloI.setFont(new Font("Arial", Font.BOLD, 30));
			subtituloI.setBounds(590, 80, 400, 40);
			
			listaIntangivel.setBounds(300, 200, 750, 450);
			listaIntangivel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaIntangivel.setVisibleRowCount(10);
			listaIntangivel.addListSelectionListener(this);
			listaIntangivel.setFixedCellHeight(25);
			scroll = new JScrollPane(listaIntangivel);
		
			refreshIntangivel = new JButton("Atualizar");
			refreshIntangivel.addActionListener(this);
			refreshIntangivel.setBounds(495, 660, 360, 30);
				
			//janela.add(listaIntangivel);
			janela.add(refreshIntangivel);
			janela.add(subtituloI);
		}
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setBounds(480, 40, 400, 30);
		
		filtroLabel = new JLabel("Procurar patrimonio por nome");
		filtroLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		filtroLabel.setBounds(300, 160, 200, 30);
		filtroText = new JTextField();
		filtroText.setBounds(500, 160, 440, 30);
		filtroButton = new JButton("Filtrar");
		filtroButton.addActionListener(this);
		filtroButton.setBounds(950, 160, 100, 30);
		
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(300, 200, 750, 450);
		
		addPatrimonio = new JButton("Novo Patrimônio");
		addPatrimonio.addActionListener(this);
		addPatrimonio.setBounds(300,660,180,30);
		
		retorno = new JButton("Trocar Lista");
		retorno.addActionListener(this);
		retorno.setBounds(870, 660, 180, 30);
		
		janela.add(scroll);
		janela.add(titulo);
		janela.add(filtroLabel);
		janela.add(filtroText);
		janela.add(filtroButton);
		janela.add(addPatrimonio);
		janela.add(retorno);
		
		janela.setLayout(null);
		janela.setExtendedState(janela.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Responsável por detectar os botões da TelaLista 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == filtroButton) {
			boolean res = false;
			if(opcao == 1) {
				res = armazem.buscarTangivel(filtroText.getText());
				if(res == false){
					mensagemErroFiltrar();
				}
				}	
			else if(opcao == 2) {
				res = armazem.buscarIntangivel(filtroText.getText());
				if(res == false){
					mensagemErroFiltrar();
				}
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
	 * esponsável por detectar a seleção de algum objeto dentro
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
	/**
	 * Mensegem quando a pesquisa corresponde a nenhum item da lista
	 */
	public void mensagemErroFiltrar() {
		JOptionPane.showMessageDialog(null,"NENHUM PATRIMONIO ENCONTRADO! \n"
		+ "Nenhum Patrimonio da lista possue esse nome \n" 
		+ "Confirme se o nome foi digitado corretamente \n"
		+ "(inclusive os caracteres mauiusculos, minusculos e especiais)"
		,null, JOptionPane.ERROR_MESSAGE);
	}
}