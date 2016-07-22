package assignment;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {


	public static void main(String[] args) {
		int[] A = readInputFomeFile();
		 System.out.println("max "+maxNum(A));
		 System.out.println("sum prime num "+totalPrimeNumber(A));
		 System.out.println("total dig "+totalDig(A));
		 System.out.println("avage number "+averageNum(A));
		 System.out.println("avage number "+Arrays.toString(numberBiggerThanAvg(A)));
		 System.out.println("All number are "+(checkAllEqual(A)?"":"NOT ")+"equal");
		 System.out.println("All number are " + (checkAllDiff(A) ? "" : "NOT ") + "totally different");
	} // end of main


	// This function if all numbers in the array are different
	private static boolean checkAllDiff(int[] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j= i+1; j < A.length; j++) {
				if (A[i] == A[j]) return (false);
			}
		}
		return (true);
	} // end of checkAllDiff


	//This is function if all numbers in the array are the same
	private static boolean checkAllEqual(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if (A[0] != A[i])
				return (false);
		}
		return (true);
	}// end of checkAllEqual



	private static int[] numberBiggerThanAvg(int[] input) {
		double avgNum = averageNum(input);
		int result_size = 0;
		// so awkward to have double for-loop, one for init array size, other
		// for adding elements
		// ArrayList is a solution
		for (int i = 0; i < input.length; i++) {
			if (avgNum < input[i])
				result_size++;
		}
		int[] result = new int[result_size];
		int j = 0;
		for (int i = 0; i < input.length; i++) {
			if (avgNum < input[i])
				result[j++] = input[i];
		}
		return result;
	}


	//The average number.
	private static double averageNum(int[] input) {
		double sum = 0;
		for (int x : input) {
			sum += x;
		}
		return sum / input.length;
	}


	//The total number of digits of the 20 numbers.
	private static int totalDig(int[] input) {
		StringBuffer sBuffer = new StringBuffer();
		for (int x : input) {
			sBuffer.append(x);
		}
		return sBuffer.toString().length();
	}

	//The maximum number.
	private static int maxNum(int[] input) {
		if(input==null||input.length==0) return 0;
		int ind = 0;
		for (int i=0;i<input.length;i++) {
			if(input[i]>input[ind]) ind=i;
		}
		return input[ind];
	}

	//The number of prime numbers.
	private static int totalPrimeNumber(int[] input) {
		int sum = 0;
		for (int temp : input) {
			if (checkPrimeNumber(temp))
				sum++;
		}
		return sum;
	}

	private static boolean checkPrimeNumber(int num) {
		//1 is not prime
		if(num==1) return false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int[] readInputFomeFile() {
		File file = new File("inputassignment1.txt");
		Scanner scanner = null;
		int[] myIntArray = new int[20];

		try {
			scanner = new Scanner(file);
			for (int i = 0; i < myIntArray.length; i++) {
				myIntArray[i] = scanner.nextInt();
			}

		} catch (IOException e) {
			System.out.println("Unable to create: " + e.getMessage());
		} finally {
			if (scanner != null)
				scanner.close();
		}
		System.out.println(Arrays.toString(myIntArray));
		return myIntArray;
	}

}
