package array_algorithem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Java_Basic_5 {

	public static void main(String[] args) throws IOException {

		init();

		System.out.println("Hello - This is a simple example");
		int[] A = new int[70];
		readFile(A);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your integer:");
		int n = scanner.nextInt();

		if (binarySearh(A, n)) {
			System.out.println("Binary...Yes, the number is there");
		} else {
			System.out.println("No, the number is not there");
		}

		if (linerSearch(A, n)) {
			System.out.println("Linear Yes, the number is there");
		} else {
			System.out.println("Linear....No, the number is not there");
		}
		scanner.close();
	}

	private static boolean linerSearch(int[] a, int n) {
		boolean f = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == n) {
				f = true;
				break;
			}
		}
		return f;
	}

	private static boolean binarySearh(int[] a, int n) {
		int lower = 0, upper = a.length - 1;
		while (lower <= upper) {
			int k = (lower + upper) / 2;
			if (a[k] == n)
				return true;

			if (n < a[k]) {
				upper = k - 1;
			} else {
				lower = k + 1;
			}
		}
		return false;
	}

	private static void readFile(int[] a) {
		File file = new File("sortednumbers.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			for (int i = 0; i < 70; i++) {
				a[i] = scanner.nextInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void init() throws IOException {
		File file = new File("sortednumbers.txt");
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		 FileWriter fileWriter = new FileWriter(file);
		for (int i = 0; i < 70; i++) {
			fileWriter.write(i + " ");
		}
		fileWriter.flush();
		fileWriter.close();
	}

}
