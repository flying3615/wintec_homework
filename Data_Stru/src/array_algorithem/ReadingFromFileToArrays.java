package array_algorithem;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ReadingFromFileToArrays {

	public static void main(String[] args) {
		int[] myIntArray = new int[10];
		String[] myStringArray = new String[10];
		System.out.println("Hi - Wellcome to week 2");

		File file = new File(System.getProperty("user.dir") + "file1.txt");
		try {
			Scanner scanner = new Scanner(file);
			for (int i = 0; i <= 9; i++) {
				myStringArray[i] = scanner.next();
			}
			for (int i = 0; i <= 9; i++) {
				myIntArray[i] = scanner.nextInt();
			}
			System.out.println("I am here 1");
			scanner.close();
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			scanner.close();
			System.out.println("I am here 2");

		} catch (IOException e) {
			System.out.println("Unable to create: " + e.getMessage());
		}
	}
}
