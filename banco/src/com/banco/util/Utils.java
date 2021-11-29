package com.banco.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Utils {

	/**
	 * Classe com métodos estáticos para auxiliar no desenvolvimento
	 */
	private Utils() {

	}

	public static void showErrorDialog(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	public static void showWarningDialog(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "AVISO", JOptionPane.WARNING_MESSAGE);
	}

	public static void showInfoDialog(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "AVISO", JOptionPane.INFORMATION_MESSAGE);
	}

	public static String removerCaracteresCpf(String cpf) {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		return cpf;
	}

	public static String removerCaracteresTelefone(String numero) {
		numero = numero.replace(".", "");
		numero = numero.replace("-", "");
		numero = numero.replace("(", "");
		numero = numero.replace(")", "");
		numero = numero.replace(".", "");
		numero = numero.replace(" ", "");
		return numero;
	}

	public static String formatarCpf(String cpf) {
		char[] chars = cpf.toCharArray();

		StringBuilder newCpf = new StringBuilder();

		// Quando coloca ponto ou traço, volta o index na posição anterior para não estourar o vetor.
		// Essas variáveis indicam se o caracter especial foi colocado.
		
		boolean aux1 = false; 
		boolean aux2 = false;
		boolean aux3 = false;
		
		for (int i = 0; i < 11; i++) {
			if (i == 3 && !aux1) {
				newCpf.append(".");
				i = 2;
				aux1 = true;
			} else if (i == 6 && !aux2) {
				newCpf.append(".");
				i = 5;
				aux2 = true;
			} else if (i == 9 && !aux3) {
				newCpf.append("-");
				aux3 = true;
				i = 8;
			} else {
				newCpf.append(chars[i]);
			}
		}
		return newCpf.toString();
	}
}
