package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long>{

	private static final long serialVersionUID = 1L;
	private final long[] numbers;
	private final int start;
	private final int end;

	public static final long THRESHOLD = 10_000;


	public ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}

	public ForkJoinSumCalculator(long[] numbers,int start,int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		int lenght = end - start;
		if(lenght<=THRESHOLD){
			return computeSequentially();
		}
		ForkJoinSumCalculator leftTask =
				new ForkJoinSumCalculator(numbers,start,start+lenght/2);

		//Asynchronously execute the newly created subtask using another thread of ForkJoinPool
		//left
		leftTask.fork();
		ForkJoinSumCalculator rightTask =
				new ForkJoinSumCalculator(numbers,start+lenght/2,end);

		//Execute this second subtask synchronously, potentially allowing further recursive splits
		Long rightResult = rightTask.compute();

		//Read the result of the first subtask or wait for it if it isn't ready
		//left
		Long leftResult = leftTask.join();
		return leftResult+rightResult;

	};

	private long computeSequentially(){
		long sum = 0;
		for(int i=start;i<end;i++){
			sum+=numbers[i];
		}
		return sum;
	}


	public static long forkJoinSum(long n){
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}


	public static void main(String[] args) {

		System.out.println("ForkJoin sum don in:"+
				TurningToParallel.measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000));
	}

}
