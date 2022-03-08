// UCF HSPT 2022
// Astronomy Rules!
// Solution by Natalie Longtin

import java.util.Scanner;

public class astronomy {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// take in input for multiple cases
		int numCases = scan.nextInt();

		for (int c = 0; c < numCases; c++) {
			// recall that a rotation of the second disk is equivalent to a cyclic shift of the disk2 array,
			// and a flip of the second disk is equivalent to a reversal of the disk2 array.
			// therefore, the set of all arrays that can be obtained by manipulating the second disk
			// is equal to the union of all cyclic shifts of the disk2 array
			// and all cyclic shifts of the reverse of the disk2 array.

			// note also that each array is a permutation of the integers 1 to n.
			// it is therefore sufficient to do two sweeps through the arrays.
			// let x be the index of the number 1 in the disk1 array.
			// let y be the index of the number 1 in the disk2 array.
			// our first sweep will start at x in disk1 and y in disk2, and sweep forward in both disks
			// our second sweep will start at x in disk1 and y in disk2, and sweep forward in disk1 and backward in disk2
			// during each sweep, check if each number on both disks line up.

			// take in input for both disks
			int n = scan.nextInt();
			int[] disk1 = new int[n];
			int[] disk2 = new int[n];

			// index of number 1 in disk1 array and disk2 array, respectively
			int x = -1, y = -1;

			for (int i = 0; i < n; i++) {
				disk1[i] = scan.nextInt();
				if (disk1[i] == 1) x = i;
			}
			for (int i = 0; i < n; i++) {
				disk2[i] = scan.nextInt();
				if (disk2[i] == 1) y = i;
			}

			// sweep forward in both disks
			boolean sweep1 = true;
			for (int i = 1; i < n; i++) {
				if (disk1[(x+i)%n] != disk2[(y+i)%n]) {
					// these two disks don't match
					sweep1 = false;
					break;
				}
			}

			// sweep forward in disk1 and backward in disk2
			boolean sweep2 = true;
			for (int i = 1; i < n; i++) {
				if (disk1[(x+i)%n] != disk2[(y-i+n)%n]) {
					// these two disks don't match
					sweep2 = false;
					break;
				}
			}
			
			// if either sweep worked, we are saved
			if (sweep1 || sweep2) {
				System.out.println("Saved");
			}
			else {
				System.out.println("Doomed");
			}
		}
	}
}
