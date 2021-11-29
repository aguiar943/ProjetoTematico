package com.banco.teste;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class Teste {

	private static final String NIMBUS = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	private static final String GTK = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static final String MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	private static final String METAL = "javax.swing.plaf.metal.MetalLookAndFeel";

	public static void main(String[] args) {

		changeLookAndFeel(GTK);

//		TelaLogin tela = new TelaLogin();
//		TelaTransferencia tela = new TelaTransferencia();
//		tela.setVisible(true);
		
		exibirPainelConfirmacao();
	}

	private static void changeLookAndFeel(String lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void exibirPainelConfirmacao() {
		JPanel pnl = new JPanel();
		Dimension size = new Dimension(300,150);
		pnl.setSize(size);
		String col = "10px, pref:grow, 10px, pref:grow, 10px";
		String row = "10px, 45px, 10px, 45px, 10px";
		
		pnl.setLayout(new FormLayout(col,row));
		
		JButton btnCancelarSenha = new JButton("Cancelar");
		JButton btnConfirmarSenha = new JButton("Confirmar");
		JPasswordField txtSenha = new JPasswordField();
		
		CellConstraints cc = new CellConstraints();
		pnl.add(txtSenha, cc.xyw(2, 2, 3, CellConstraints.DEFAULT, CellConstraints.FILL));
		pnl.add(btnConfirmarSenha, cc.xy(2, 4, CellConstraints.DEFAULT, CellConstraints.FILL));
		pnl.add(btnCancelarSenha, cc.xy(4, 4, CellConstraints.DEFAULT, CellConstraints.FILL));
		
		JOptionPane jop = new JOptionPane();
		JDialog dialog = jop.createDialog("Confirme sua senha");
		dialog.setSize(size);
		dialog.setContentPane(pnl);
		dialog.setVisible(true);
	}

}
