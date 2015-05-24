package br.com.du;

public class Item {

	public
	String nome;
	Double valor;
	Double quantidade;
	
	Item(String nome, Double valor) {
		this.nome=nome;
		this.valor=valor;
		this.quantidade= 1.0;
	}
	
	Item() {
		this.quantidade= 1.0;
		this.valor=0.0;
	}
	
	public boolean equals(Item item) {
		// TODO Auto-generated method stub
		return this.nome.compareTo(item.nome) == 0? true: false;
	}

	public void oneMore() {
		this.quantidade += 1;
	}

	public void sumPrice(Double valor2) {
		this.valor += valor2;
		
	}
}
