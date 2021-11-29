package com.banco.entidades;

import java.util.Calendar;

public class ContaCorrente {

	private Integer numero;
	private String agencia;
	private Cliente titular;
	private Double saldo;
	private String usuario;
	private String senha;
	private String dataAbertura;

	public ContaCorrente(Integer numero, Cliente titular, String usuario, String senha) {
		this.numero = numero;
		this.titular = titular;
		this.usuario = usuario;
		this.senha = senha;
		this.saldo = 1000.0;
		this.agencia = "Ag0000";
		this.dataAbertura = Calendar.YEAR + "-" + Calendar.MONTH + "-" + Calendar.DAY_OF_WEEK_IN_MONTH;
	}

	public ContaCorrente(Integer numero, String agencia, Double saldo, String usuario, String senha) {
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.usuario = usuario;
		this.senha = senha;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getDataAbertura() {
		return this.dataAbertura;
	}

}
