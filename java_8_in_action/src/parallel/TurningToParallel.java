package parallel;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TurningToParallel {

	public static void main(String[] args) {
//		System.out.println("Sequential sum done in: "
//				+measureSumPerf(TurningToParallel::sequentialSum, 10_000_000));
//
//		System.out.println("Parallel sum done in: "
//				+measureSumPerf(TurningToParallel::parallelSum, 10_000_000));

		System.out.println("Sequential sum done in: "
				+measureSumPerf(TurningToParallel::sequentialRangeSum, 10_000_000));

		System.out.println("Parallel sum done in: "
				+measureSumPerf(TurningToParallel::parallelRangeSum, 10_000_000));
}


	public static long parallelSum(long n){
		return Stream.iterate(1L, i->i+1)
				.limit(n)
				.parallel()
				.reduce(0L, Long::sum);
	}

	public static long sequentialSum(long n){
		return Stream.iterate(1L, i->i+1)
				.limit(n)
				.reduce(0L, Long::sum);
	}

	public static long sequentialRangeSum(long n){
		return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
	}

	public static long parallelRangeSum(long n){
		return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
	}

	public static long measureSumPerf(Function<Long, Long> adder,long n){
		long fastest = Long.MAX_VALUE;
		for(int i=0;i<10;i++){
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime()-start)/1_000_000;
			System.out.println("Result:"+sum);
			if(duration<fastest) fastest = duration;
		}
		return fastest;
	}
}
