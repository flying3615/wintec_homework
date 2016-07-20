package recursion;

import java.util.Scanner;

/**
 *
 	The base case for the problem is n = 1. If n == 1, you could simply move the disk from A
	to B. When n > 1, you could split the original problem into the following three subproblems
	and solve them sequentially.
	1. Move the first n - 1 disks from A to C recursively with the assistance of tower B,
	2. Move disk n from A to B,
	3. Move n - 1 disks from C to B recursively with the assistance of tower A
 * @author yufliu21
 *
 */

public class TowerOfHanoi {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of disks: ");
		int n = scanner.nextInt();
		System.out.println("The moves are: ");
		moveDisk(n,"A","B","C");
	}

	private static void moveDisk(int n, String fromTower, String toTower, String auxTower) {
		//If n == 1, you could simply move the disk from A to B
		if(n==1){
			System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);
		}else {
			//Move the first n - 1 disks from A to C recursively with the assistance of tower B
			moveDisk(n-1, fromTower, auxTower, toTower);
			//Move disk n from A to B
			System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);
			//Move n - 1 disks from C to B recursively with the assistance of tower A
			moveDisk(n-1, auxTower, toTower, fromTower);
		}

	}

}
