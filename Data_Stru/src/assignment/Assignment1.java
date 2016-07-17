package assignment;

public class Assignment1 {

	public static void main(String[] args) {
		int[] input = readInputFomeFile();
		System.out.println("max "+maxNum(input));
		System.out.println("sum prime num "+sumPrimeNum(input));
		System.out.println("total dig "+totalDig(input));
	}

	private static int averageNum(int[] input){
		int sum = 0;
		for(int x:input){
			sum+=x;
		}
		return sum/input.length;
	}

	private static int totalDig(int[] input){
		StringBuffer sBuffer = new StringBuffer();
		for(int x:input){
			sBuffer.append(x);
		}
		return sBuffer.toString().length();
	}

	private static int maxNum(int[] input) {
		int max = Integer.MIN_VALUE;
		for (int x : input) {
			if (x > max) {
				max = x;
			}
		}
		return max;
	}

	private static int sumPrimeNum(int[] input) {
		int sum = 0;
		for (int temp : input) {
			if (checkPrimeNumber(temp))
				sum++;
		}
		return sum;
	}

	private static boolean checkPrimeNumber(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int[] readInputFomeFile() {
		int[] result = { 8, 2, 3, 4, 5, 6, 7, 11, 13, 22, 44 };
		return result;
	}

}
