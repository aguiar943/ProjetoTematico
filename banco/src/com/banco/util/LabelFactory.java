package com.banco.util;

import java.awt.Font;

import javax.swing.JLabel;

public class LabelFactory {

	private LabelFactory() {
		
	}
	
	public static JLabel createLabel(String text) {
		return createLabel(text, null, 25);
	}

	public static JLabel createLabel(String text, Integer style, Integer size) {
		JLabel tmpLbl = new JLabel("tmp");
		String fontFamily = tmpLbl.getFont().getFamily();

		if (style == null) {
			style = tmpLbl.getFont().getStyle();
		}

		if (size == null) {
			size = tmpLbl.getFont().getSize();
		}

		JLabel label = new JLabel(text);
		label.setFont(new Font(fontFamily, style, size));
		return label;

	}
}
