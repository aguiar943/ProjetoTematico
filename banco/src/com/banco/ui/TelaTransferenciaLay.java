package com.banco.ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.banco.util.LabelFactory;
import com.banco.util.ObjectHandle;
import com.banco.util.Utils;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public abstract class TelaTransferenciaLay extends JFrame {

	private static final long serialVersionUID = 1L;

	protected JTextField txtUsuario;
	protected JTextField txtValor;

	protected JPasswordField txtSenha;

	// labels onde serão exibidos os dados
	protected JLabel lblNome;
	protected JLabel lblNumConta;
	protected JLabel lblCpf;
	protected JLabel lblAgencia;

	// Esses são menores e ficam em cima do label com os dados,
	// para indicar o que é aquele campo
	protected JLabel lblUsuarioDesc;
	protected JLabel lblValorDesc;
	protected JLabel lblNomeDesc;
	protected JLabel lblNumContaDesc;
	protected JLabel lblCpfDesc;
	protected JLabel lblAgenciaDesc;

	protected JButton btnPesquisar;
	protected JButton btnTransferir;
	protected JButton btnLimpar;
	protected JButton btnVoltar;
	protected JButton btnConfirmarSenha;
	protected JButton btnCancelarSenha;

	protected JDialog dialogConfirmaSenha;

	protected boolean senhaConfirmada;

	protected static final String PNL_INICIAL = "PNL_INICIAL";

	protected abstract void buscarUsuario(String usuario);

	protected abstract void realizarTransferencia();
	
	protected abstract void exibirTelaConta();

	protected TelaTransferenciaLay() {
		this.setTitle("Trasnferencia");
		this.setSize(600, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new CardLayout());
		this.setResizable(false);
		this.getContentPane().add(PNL_INICIAL, getPnlInicial());

		btnCancelarSenha = new JButton("Cancelar");
		btnConfirmarSenha = new JButton("Confirmar");
		txtSenha = new JPasswordField();
		dialogConfirmaSenha = getDialogConfirmaSenha();
		addEvents();

	}

	private JPanel getPnlInicial() {
		JPanel pnl = new JPanel();
		String col = "15px, pref:grow, 5px, pref:grow, 5px, pref:grow, 15px";
		String row = "25px, 25px, 45px, 25px, 45px, 25px, 45px, 25px, 45px";
		pnl.setLayout(new FormLayout(col, row));

		lblNome = LabelFactory.createLabel("");
		lblNumConta = LabelFactory.createLabel("");
		lblCpf = LabelFactory.createLabel("");
		lblAgencia = LabelFactory.createLabel("");

		lblUsuarioDesc = LabelFactory.createLabel("Usuário", 2, 13);
		lblNumContaDesc = LabelFactory.createLabel("Número", 2, 13);
		lblNomeDesc = LabelFactory.createLabel("Nome", 2, 13);
		lblCpfDesc = LabelFactory.createLabel("CPF", 2, 13);
		lblValorDesc = LabelFactory.createLabel("Valor", 2, 13);
		lblAgenciaDesc = LabelFactory.createLabel("Agência", 2, 13);

		txtUsuario = new JTextField();
		txtValor = new JTextField();

		btnPesquisar = new JButton("Pesquisar");
		btnTransferir = new JButton("Transferir");
		btnLimpar = new JButton("Limpar");
		btnVoltar = new JButton("Voltar");

		btnTransferir.setEnabled(false);
		btnLimpar.setEnabled(false);
		btnLimpar.setEnabled(false);
		btnVoltar.setEnabled(false);
		txtValor.setEnabled(false);

		CellConstraints cc = new CellConstraints();

		pnl.add(lblUsuarioDesc, cc.xy(2, 2));
		pnl.add(txtUsuario, cc.xy(2, 3, CellConstraints.DEFAULT, CellConstraints.FILL));

		pnl.add(btnPesquisar, cc.xy(4, 3, CellConstraints.DEFAULT, CellConstraints.FILL));
		pnl.add(btnLimpar, cc.xy(6, 3, CellConstraints.DEFAULT, CellConstraints.FILL));

		pnl.add(lblNomeDesc, cc.xy(2, 4));
		pnl.add(lblNome, cc.xyw(2, 5, 5, CellConstraints.DEFAULT, CellConstraints.TOP));

		pnl.add(lblCpfDesc, cc.xy(2, 6));
		pnl.add(lblCpf, cc.xy(2, 7, CellConstraints.DEFAULT, CellConstraints.TOP));

		pnl.add(lblNumContaDesc, cc.xy(4, 6));
		pnl.add(lblNumConta, cc.xy(4, 7, CellConstraints.DEFAULT, CellConstraints.TOP));

		pnl.add(lblAgenciaDesc, cc.xy(6, 6));
		pnl.add(lblAgencia, cc.xy(6, 7, CellConstraints.DEFAULT, CellConstraints.TOP));

		pnl.add(lblValorDesc, cc.xy(2, 8));
		pnl.add(txtValor, cc.xy(2, 9, CellConstraints.DEFAULT, CellConstraints.FILL));

		pnl.add(btnTransferir, cc.xy(4, 9, CellConstraints.DEFAULT, CellConstraints.FILL));
		pnl.add(btnVoltar, cc.xy(6, 9, CellConstraints.DEFAULT, CellConstraints.FILL));

		return pnl;
	}

	private void addEvents() {
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscarUsuario(txtUsuario.getText());
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNome.setText("");
				lblNumConta.setText("");
				lblCpf.setText("");
				lblAgencia.setText("");
				txtValor.setText("");
				txtUsuario.setText("");
			}
		});

		btnTransferir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Quando clica no botão de transferir, algumas confirmações são feitas antes de
				// pedir a senha
				// - txtValor não pode estar vazio
				// - Valor informado não pode ser maior do que o saldo da conta

				txtValor.setText(txtValor.getText().replace(",", "."));

				if (txtValor.getText().isEmpty() || txtValor.getText().isBlank()) {
					Utils.showErrorDialog(TelaTransferenciaLay.this, "Você deve informar um valor a ser transferido");
					return;
				}

				if (Double.parseDouble(txtValor.getText()) > ObjectHandle.getContaLogada().getSaldo()) {
					Utils.showErrorDialog(TelaTransferenciaLay.this,
							"Valor a ser transferido não deve ser superior ao saldo atual");
					return;
				}

				dialogConfirmaSenha.setVisible(true);
			}
		});

		btnConfirmarSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String senhaDigitada = String.valueOf(txtSenha.getPassword());
				String senhaUsuario = ObjectHandle.getContaLogada().getSenha();

				// txtSenha não pode estar vazio
				if (senhaDigitada.isBlank() || senhaDigitada.isEmpty()) {
					Utils.showErrorDialog(TelaTransferenciaLay.this, "Digite sua senha para continuar");
					return;
				}

				// senha informada não pode ser diferente da senha do usuario
				if (!senhaDigitada.contentEquals(senhaUsuario)) {
					Utils.showErrorDialog(TelaTransferenciaLay.this, "Senha incorreta!");
					return;
				}

				// Se todas as verificações derem certo, realizará a transferência
				senhaConfirmada = true;
				realizarTransferencia();

			}
		});

		btnCancelarSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				senhaConfirmada = false;
				getDialogConfirmaSenha().dispose();
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirTelaConta();
			}
		});
	}

	protected void habilitarCampos() {
		btnTransferir.setEnabled(true);
		btnLimpar.setEnabled(true);
		btnLimpar.setEnabled(true);
		btnVoltar.setEnabled(true);
		txtValor.setEnabled(true);
	}

	protected JDialog getDialogConfirmaSenha() {
		// Toda vez que esse painel for exibido, resetará a confirmação da senha
		senhaConfirmada = false;

		JPanel pnl = new JPanel();
		Dimension size = new Dimension(300, 150);
		pnl.setSize(size);
		String col = "10px, pref:grow, 10px, pref:grow, 10px";
		String row = "10px, 45px, 10px, 45px, 10px";

		pnl.setLayout(new FormLayout(col, row));

		CellConstraints cc = new CellConstraints();
		pnl.add(txtSenha, cc.xyw(2, 2, 3, CellConstraints.DEFAULT, CellConstraints.FILL));
		pnl.add(btnConfirmarSenha, cc.xy(2, 4, CellConstraints.DEFAULT, CellConstraints.FILL));
		pnl.add(btnCancelarSenha, cc.xy(4, 4, CellConstraints.DEFAULT, CellConstraints.FILL));

		JOptionPane jop = new JOptionPane();
		JDialog dialog = jop.createDialog("Confirme sua senha");
		dialog.setSize(size);
		dialog.setContentPane(pnl);

		return dialog;
	}

}
