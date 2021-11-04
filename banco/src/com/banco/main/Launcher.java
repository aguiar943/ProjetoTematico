package com.banco.main;

import javax.swing.UIManager;

import com.banco.ui.TelaLogin;

public class Launcher {

	public static void main(String[] args) {
		changeLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);
	}

	private static void changeLookAndFeel(String lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
