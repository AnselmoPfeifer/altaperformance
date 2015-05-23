package com.epv;

import java.math.BigDecimal;

public class Item {
	
	public Item() {
		super();
	}
	
	public Item(String nome, BigDecimal valor, Integer quantidade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	private String nome;
	
	private BigDecimal valor;
	
	private Integer quantidade;
	
	
}
