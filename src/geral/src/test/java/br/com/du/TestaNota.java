package br.com.du;

public class TestaNota {

	
	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		Item item1 = new Item("Arroz", 2.0);
		Item item2 = new Item("Feijao", 2.0);
		Item item3 = new Item("Arroz", 3.0);
		Item item4 = new Item("Feijao", 3.0);
		Item item5 = new Item("Feijao", 3.0);
		
		pedido.add(item1);
		pedido.add(item2);
		pedido.add(item3);
		pedido.add(item4);
		pedido.add(item5);
		
		Nota n = pedido.getNota();
		
		System.out.println(n);
		
	}
}
