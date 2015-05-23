package br.com.du;

import java.awt.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Nota {

	LinkedList<Item> itens = new LinkedList<Item>();

	public void addItem(Item aItem) {
		
		for (Item item: itens) {
			if (item.equals(aItem)){
				item.oneMore();
				item.sumPrice(aItem.valor);
				return;
			}
		}
		itens.add(aItem);
	}
	
	@Override
	public String toString() {
		String s = new String();
		for (Item item: itens) {
			s += item.nome + ' ';
			s += Double.toString(item.quantidade) + ' ';
			s += Double.toString(item.valor) + ' ';
			s += '\n';
		}
		return s;
	}
}
