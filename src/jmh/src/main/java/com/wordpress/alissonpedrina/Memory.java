/**
 *  mvn archetype:generate \
          -DinteractiveMode=false \
          -DarchetypeGroupId=org.openjdk.jmh \
          -DarchetypeArtifactId=jmh-java-benchmark-archetype \
          -DgroupId=org.sample \
          -DartifactId=test \
          -Dversion=1.0
          
          java -jar target/benchmarks.jar
 */
package com.wordpress.alissonpedrina;

import java.util.Collection;
import java.util.Iterator;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.BenchmarkResult;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@Fork(value = 2)
@BenchmarkMode(Mode.AverageTime)
public class Memory {

	private final static int ARRAY_SIZE = 64 * 1024 * 1024;
	private int[] array = new int[ARRAY_SIZE];

	@Benchmark
	public void iteracaoNormal() {
		for (int i = 0, n = array.length; i < n; i++) {
			array[i] *= 3;
		}
	}

	@Benchmark
	public void iteracaoCom16() {
		for (int i = 0, n = array.length; i < n; i += 16) {
			array[i] *= 3;
		}
	}

	public static void main(String[] args) throws RunnerException {
		Options opts = new OptionsBuilder()
				.include(Memory.class.getSimpleName()).forks(0)
				.warmupIterations(2).measurementIterations(1).build();
		
		Collection<RunResult> records = new Runner(opts).run();
		for (RunResult result: records){
			Iterator<BenchmarkResult> i = result.getBenchmarkResults().iterator();
			while(i.hasNext()){
				BenchmarkResult b = i.next();
				System.out.println("report:" +b.getScoreUnit());
			}
		}
	}

}
