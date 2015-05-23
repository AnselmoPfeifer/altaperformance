package com.epv;

import java.util.List;

public class Pedido {
	
	private List<Item> itens;

	public Pedido() {
		super();
	}
	
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
}
