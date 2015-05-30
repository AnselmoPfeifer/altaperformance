package com.wordpress.alissonpedrina.string;

/**
 * Rode com os parametros -Xprof
 * @author Auxiliadora
 *
 */
public class WrapperEPrimitivosComXProf {

	public static void main(String[] args) {
		WrapperEPrimitivosComXProf w = new WrapperEPrimitivosComXProf();
		w.deveTestarDesempenhoDeCalculoDeLongComPrimitivos();
		//w.deveTestarDesempenhoDeCalculoDeLongComWrapper();
	}
	
	public void deveTestarDesempenhoDeCalculoDeLongComWrapper(){
		calculoComAutoBoxing();
	}

	public void deveTestarDesempenhoDeCalculoDeLongComPrimitivos(){
		calculoComPrimitivos();
	}
	
	public long calculoComPrimitivos(){
		long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum = sum + i;
		}
		return sum;
	}
	
	public long calculoComAutoBoxing(){
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum = sum + i;
		}
		return sum;
	}
}
