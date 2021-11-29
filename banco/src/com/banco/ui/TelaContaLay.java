package com.banco.ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.banco.util.LabelFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public abstract class TelaContaLay extends JFrame {

	private static final long serialVersionUID = 1L;

	protected JLabel lblAgencia;
	protected JLabel lblNumConta;
	protected JLabel lblNome;
	protected JLabel lblSaldo;

	protected JButton btnSair;
	protected JButton btnTrasnferir;
	protected JButton btnHistorico;

	protected JButton btnConfirmarTransferencia;
	protected JButton btnCancelar;

	protected JTextField txtValor;
	protected JTextField txtNumContaDestino;

	protected String pnlAtual;
	protected static final String PNL_INICIAL = "PNL_PRINCIPAL";

	protected abstract void exibirTelaTransferencia();

	protected abstract void exibirTelaLogin();
	
	protected abstract void carregarDadosContaLogada();

	protected TelaContaLay() {
		this.setTitle("Menu Principal");
		this.setSize(600, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new CardLayout());
		this.setResizable(false);
		this.getContentPane().add(PNL_INICIAL, getPnlInicial());

		preInicializarComponentes();
		addEvents();
		carregarDadosContaLogada();

	}

	private void addEvents() {
		btnTrasnferir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				exibirTelaTransferencia();
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				exibirTelaLogin();
			}
		});
	}

	private void preInicializarComponentes() {
		btnConfirmarTransferencia = new JButton("Confirmar");
		btnCancelar = new JButton("Cancelar");
		txtNumContaDestino = new JTextField();
		txtValor = new JTextField();
	}

	private JPanel getPnlInicial() {
		JPanel pnlInicial = new JPanel();
		String colunas = "15px, pref:grow, 5px, pref:grow, 5px, pref:grow, 15px";
		String linhas = "10px, 200px, 5px, pref:grow, 10px";
		pnlInicial.setLayout(new FormLayout(colunas, linhas));

		btnTrasnferir = new JButton("Transferir");
		btnSair = new JButton("Sair");
		btnHistorico = new JButton("Histórico");
		CellConstraints cc = new CellConstraints();

		pnlInicial.add(getPnlDados(), cc.xyw(2, 2, 5));
		pnlInicial.add(btnTrasnferir, cc.xy(2, 4, CellConstraints.DEFAULT, CellConstraints.FILL));
		pnlInicial.add(btnHistorico, cc.xy(4, 4, CellConstraints.DEFAULT, CellConstraints.FILL));
		pnlInicial.add(btnSair, cc.xy(6, 4, CellConstraints.DEFAULT, CellConstraints.FILL));
		return pnlInicial;
	}

	private JPanel getPnlDados() {
		JPanel pnlDados = new JPanel();
		Border border = BorderFactory.createTitledBorder("Dados");
		pnlDados.setBorder(border);

		String colunas = "25px, pref, 80px, pref, 80px, pref, 25px";
		String linhas = "10px, 15px, 70px, 15px, 70px";

		pnlDados.setLayout(new FormLayout(colunas, linhas));

		lblAgencia = LabelFactory.createLabel("");
		lblNumConta = LabelFactory.createLabel("");
		lblNome = LabelFactory.createLabel("");
		lblSaldo = LabelFactory.createLabel("");

		CellConstraints cc = new CellConstraints();

		JLabel lblAgDesc = LabelFactory.createLabel("Agência", 2, 13);
		JLabel lblNumContaDesc = LabelFactory.createLabel("Número", 2, 13);
		JLabel lblNomeDesc = LabelFactory.createLabel("Nome", 2, 13);
		JLabel lblSaldoDesc = LabelFactory.createLabel("Saldo", 2, 13);

		pnlDados.add(lblNomeDesc, cc.xy(2, 2, CellConstraints.LEFT, CellConstraints.BOTTOM));
		pnlDados.add(lblNome, cc.xyw(2, 3, 5, CellConstraints.LEFT, CellConstraints.TOP));

		pnlDados.add(lblSaldoDesc, cc.xy(2, 4, CellConstraints.LEFT, CellConstraints.BOTTOM));
		pnlDados.add(lblSaldo, cc.xy(2, 5, CellConstraints.LEFT, CellConstraints.TOP));

		pnlDados.add(lblAgDesc, cc.xy(4, 4, CellConstraints.LEFT, CellConstraints.BOTTOM));
		pnlDados.add(lblAgencia, cc.xy(4, 5, CellConstraints.LEFT, CellConstraints.TOP));

		pnlDados.add(lblNumContaDesc, cc.xy(6, 4, CellConstraints.LEFT, CellConstraints.BOTTOM));
		pnlDados.add(lblNumConta, cc.xy(6, 5, CellConstraints.LEFT, CellConstraints.TOP));

		return pnlDados;
	}

	protected void exibirPnlInicial() {
		this.setSize(600, 300);
		this.setTitle("Menu Principal");
		this.setLocationRelativeTo(null);
		CardLayout cl = (CardLayout) this.getContentPane().getLayout();
		cl.show(this.getContentPane(), PNL_INICIAL);
		pnlAtual = PNL_INICIAL;
	}

}
