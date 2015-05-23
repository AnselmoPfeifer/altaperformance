package com.epv;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		try {
			for (int i = 0; i < 100; i++) {

				Pedido pedido = populaPedido();

				if (pedido != null) {

					if (pedido.getItens() != null
							&& pedido.getItens().size() > 0) {

						HashMap<String, Item> itensNota = new HashMap<String, Item>();

						for (Item item : pedido.getItens()) {

							if (!itensNota.containsKey(item.getNome())) {
								itensNota.put(item.getNome(), item);
							} else {

								BigDecimal valor = itensNota
										.get(item.getNome()).getValor()
										.add(item.getValor());
								Integer quantidade = itensNota.get(
										item.getNome()).getQuantidade()
										+ item.getQuantidade();

								itensNota.get(item.getNome()).setValor(valor);
								itensNota.get(item.getNome()).setQuantidade(
										quantidade);
							}
						}

						if (itensNota != null) {
							NotaFiscal nota = new NotaFiscal();
							List<Item> itens = new ArrayList<>();
							itens.addAll(itensNota.values());
							nota.setItens(itens);

							for (Item item : nota.getItens()) {
								System.out.println(item.getNome() + " - R$ "
										+ String.valueOf(item.getValor())
										+ " - " + item.getQuantidade());
							}
						}
					}
				}

				Thread.sleep(3000);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Pedido populaPedido() {

		Pedido pedido = new Pedido();
		List<Item> itens = new ArrayList<Item>();

		Item item = new Item("Arroz", BigDecimal.ONE, 5);
		Item item2 = new Item("Feijao", BigDecimal.ONE, 2);
		Item item3 = new Item("Bife", BigDecimal.ONE, 3);
		Item item4 = new Item("Ovo", BigDecimal.ONE, 12);
		Item item5 = new Item("Ovo", BigDecimal.ONE, 4);

		itens.add(item);
		itens.add(item2);
		itens.add(item3);
		itens.add(item4);
		itens.add(item5);

		pedido.setItens(itens);

		return pedido;

	}

}
