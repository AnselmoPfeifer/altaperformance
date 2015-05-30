package com.wordpress.alissonpedrina;

/**
 * http://hg.openjdk.java.net/code-tools/jmh/file/10560d7513f4/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_12_Forking.java
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.profile.ClassloaderProfiler;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.google.common.base.Splitter;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 0)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
public class JavaStringSplits {

	@State(Scope.Benchmark)
	public static class StringState {
		String[] lines = new String[] {
				"0000 12 34 5 666 77 88888 99",
				"aa bb cc dd ee ff gg hh ii jj kk ll mm nn oo pp qq rr ss tt uu vv ww xx yy zz",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod" };
	}

	@Benchmark
	public static void javaSplit(StringState ss, Blackhole bh) {
		for (String ln : ss.lines) {
			String[] toks = ln.split(" ");
			bh.consume(toks);
		}
	}

	@Benchmark
	public static void indexOf(StringState ss, Blackhole bh) {
		for (String ln : ss.lines) {
			List<String> ls = new ArrayList<String>();
			int pos = 0;
			int idx = 0;
			while (true) {
				idx = ln.indexOf(' ', pos);
				if (idx < 0) {
					ls.add(ln.substring(pos, ln.length()));
					break;
				}
				ls.add(ln.substring(pos, idx));
				pos = idx + 1;
			}
			bh.consume(ls);
		}
	}

	@Benchmark
	public static void stringTokenizer(StringState ss, Blackhole bh) {
		for (String ln : ss.lines) {
			List<String> ls = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(ln, " ");
			while (st.hasMoreTokens()) {
				ls.add(st.nextToken());
			}
			bh.consume(ls);
		}
	}

	@Benchmark
	public static void guavaSplit(StringState ss, Blackhole bh) {
		for (String ln : ss.lines) {
			List<String> ls = new ArrayList<String>();
			Splitter split = Splitter.on(" ");
			Iterator<String> it = split.split(ln).iterator();
			while (it.hasNext()) {
				ls.add(it.next());
			}
			bh.consume(ls);
		}
	}

	public static void main(String[] args) throws RunnerException {
		Options opts = new OptionsBuilder().include(JavaStringSplits.class.getSimpleName()).warmupIterations(5).addProfiler(ClassloaderProfiler.class)
				.measurementIterations(5).forks(0).jvmArgs("-Xprof").build();

		new Runner(opts).run();
	}
}
