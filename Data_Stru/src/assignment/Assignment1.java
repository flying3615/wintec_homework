package assignment;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		int[] A = readInputFomeFile();
		System.out.println("max " + maxNum(A));
		System.out.println("sum of prime num = " + totalPrimeNumber(A));
		System.out.println("total dig " + totalDig(A));
		System.out.println("average number " + averageNum(A));
		System.out.println("Number bigger than average number = " + Arrays.toString(numberBiggerThanAvg(A)));
		System.out.println("All number are " + (checkAllEqual(A) ? "" : "NOT ") + "equal");
		System.out.println("All number are " + (checkAllDiff(A) ? "" : "NOT ") + "totally different");
	} // end of main

	// This function if all numbers in the array are different
	private static boolean checkAllDiff(int[] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] == A[j])
					return (false);
			}
		}
		return (true);
	} // end of checkAllDiff

	// This is function if all numbers in the array are the same
	private static boolean checkAllEqual(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if (A[0] != A[i])
				return (false);
		}
		return (true);
	}// end of checkAllEqual

	//This is function for find the number bigger than Avg
	private static int[] numberBiggerThanAvg(int[] A) {
		double avgNum = averageNum(A);
		int result_size = 0;
		// so awkward to have double for-loop, one for init array size, other
		// for adding elements
		// ArrayList is a solution
		for (int i = 0; i < A.length; i++) {
			if (avgNum < A[i])
				result_size++;
		}
		int[] result = new int[result_size];
		int j = 0;
		for (int i = 0; i < A.length; i++) {
			if (avgNum < A[i])
				result[j++] = A[i];
		}
		return result;
	}// end of numberBiggerThanAvg

	// The function for the average number.
	private static double averageNum(int[] A) {
		double sum = 0;
		for (int x : A) {
			sum += x;
		}
		return sum / A.length;
	}// end of averageNum

	// The total number of digits of the 20 numbers.
	//divide 10
	private static int totalDig(int[] A) {
		int totalDig = 0;
		for (int x : A) {
			totalDig+=dig(1, x);
		}
		return totalDig;

	}// end of totalDig

	private static int dig(int acc,int number){
		if(number/10==0){
			return acc;
		}else{
			return dig(acc+1,number = number/10) ;
		}
	}


	// The maxNum number.
	private static int maxNum(int[] input) {
		if (input == null || input.length == 0)
			return 0;
		int ind = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > input[ind])
				ind = i;
		}
		return input[ind];
	}//end of maxNum

	// The number of prime numbers.
	private static int totalPrimeNumber(int[] input) {
		int sum = 0;
		for (int temp : input) {
			if (checkPrimeNumber(temp)){
				System.out.print(temp+" ");
				sum++;
			}
		}
		return sum;
	}

	private static boolean checkPrimeNumber(int num) {
		// 1 is not prime
		if (num == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}


	//auxiliary method to init array from file
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
	}//end of readInputFomeFile

}
