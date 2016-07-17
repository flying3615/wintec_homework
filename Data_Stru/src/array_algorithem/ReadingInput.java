package array_algorithem;

import java.util.Scanner;

public class ReadingInput {

	public static void main(String[] args) {
		System.out.println("Hello - Reading input");
		int n;
		String s;
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Enter your integer");
		n = inputScanner.nextInt();
		System.out.println("Hi - The number you entered is "+n);
		System.out.println("Enter your string");
		s = inputScanner.next();
		System.out.println("Hi - The String you entered is "+s);

	}

}
