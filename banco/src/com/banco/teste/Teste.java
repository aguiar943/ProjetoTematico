package com.banco.teste;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.banco.ui.TelaLogin;

public class Teste {

	private static final String NIMBUS = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	private static final String GTK = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static final String MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	private static final String METAL = "javax.swing.plaf.metal.MetalLookAndFeel";

	public static void main(String[] args) {

		changeLookAndFeel(GTK);

		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);

		UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo info : lafInfo) {
			System.out.println(info);
		}
	}

	private static void changeLookAndFeel(String lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
