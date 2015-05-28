package com.jit;

/**
 * https://docs.oracle.com/javase/8/embedded/develop-apps-platforms/codecache.
 * htm
 * 
 * -XX:+UnlockDiagnosticVMOptions -XX:+TraceClassLoading -XX:+PrintCompilation
 * -XX:+LogCompilation -XX:LogFile=C:\log\logcompilation.log
 * -XX:ReservedCodeCacheSize=3000k -XX:CompileThreshold=100
 * 
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintCompilation
 * -XX:LogFile=C:\log\logdecompilacao.log -XX:+LogCompilation
 * -XX:ReservedCodeCacheSize=2000k -XX:+PrintCodeCache -XX:CompileThreshold=100
 * -XX:InitialCodeCacheSize=96K -XX:CICompilerCount=2
 * 
 * @author Auxiliadora
 *
 */
public class JIT extends Object {

	public static void main(String[] args) {
		JIT jit = new JIT();
		jit.fazAlgo();
	}

	public void fazAlgo() {
		Integer i = new Integer(9);
		fazAlog2(i);
		System.out.println(i);
	}

	private void fazAlog2(Integer i) {
		i = new Integer(8);
		System.out.println(i);
	}

}
