package parallel;

import java.util.stream.LongStream;

public class SideEffectParallel {

	public static long sideEffectParallelSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
		return accumulator.total;
	}

	public static void main(String[] args) {
		System.out.println("SideEffect parallel sum done in:"+
				TurningToParallel
				.measureSumPerf(SideEffectParallel::sideEffectParallelSum,
						10_000_000)
				);
	}

}

class Accumulator {
	public long total = 0;

	public void add(long value) {
		total += value;
	}
}
