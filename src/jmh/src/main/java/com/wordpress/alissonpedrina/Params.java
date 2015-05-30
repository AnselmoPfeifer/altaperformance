package com.wordpress.alissonpedrina;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.profile.ClassloaderProfiler;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.VerboseMode;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(0)
@State(Scope.Benchmark)
public class Params {

	@Param({ "1", "31", "65", "101", "103" })
	public int arg;

	@Param({ "0", "1", "2", "4", "8", "16", "32" })
	public int certainty;

	@Benchmark
	public boolean bench() {
		return BigInteger.valueOf(arg).isProbablePrime(certainty);
	}

	public static void main(String[] args) throws RunnerException {
		Options opts = new OptionsBuilder()
				.include(JavaStringSplits.class.getSimpleName())
				.warmupIterations(1)
				.output("teste.log")
				.param("-of", "cvs")
				.resultFormat(ResultFormatType.CSV)
				.measurementIterations(5).forks(0).jvmArgs("-Xprof").build();
		new Runner(opts).run();
	}

}