package br.com.du;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Pedido {

	LinkedList<Item> itens;
	
	Pedido() {
		itens = new LinkedList<Item>();
		
	}
	
	public void add(Item item) {
		itens.add(item);
	}

	public Nota getNota() {
		Nota n = new Nota();
		
		for (Item item : itens) {
			n.addItem(item);
		}
		return n;
	}
	
	
	
}
