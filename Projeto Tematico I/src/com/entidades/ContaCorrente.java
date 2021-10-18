package com.banco.entidades;

public class ContaCorrente {

	private Integer numero;
	private String agencia;
	private Cliente titular;
	private Double saldo;

	public ContaCorrente(Cliente titular) {
		this.titular = titular;
		this.saldo = 0.0;
	}

	public ContaCorrente(Cliente titular, String agencia, Integer numero) {
		this.titular = titular;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = 0.0;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void depositar(Double value) {
		this.saldo += value;
	}

	public boolean sacar(Double value) {
		if (value.compareTo(this.saldo) > 0) {
			return false;
		}
		this.saldo -= value;
		return true;
	}

}
