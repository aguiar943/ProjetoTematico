package com.banco.util;

import com.banco.entidades.ContaCorrente;

public class ObjectHandle {

	private static ContaCorrente contaAtiva;
	
	private ObjectHandle() {
		
	}
	
	public static ContaCorrente getContaLogada() {
		return contaAtiva;
	}
	
	public static void setContaLogada(ContaCorrente conta) {
		contaAtiva = conta;
	}
	
}
