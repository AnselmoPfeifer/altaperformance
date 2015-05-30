package com.wordpress.alissonpedrina.string;

public class EliminandoCodigo {

	public static void main(String[] args) {
		Teste teste = new Teste();
		teste.micro();
	}
}

class Teste {
	long count;
	
	public void micro() {
		long inicio = System.currentTimeMillis();

		for (long i = 0; i < 900000; ++i) {
			count = fazAlgo(i);
			//i = fazAlgo(i);
			//fazAlgo(i);
		}
		System.out.println("Tempo decorrido:" + (System.currentTimeMillis() - inicio));
	}

	private long fazAlgo(long i) {
		System.out.println(i);
		return i += i;
	}
}
