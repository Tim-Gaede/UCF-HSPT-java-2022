// UCF HSPT 2022
// A Very Hard Problem
// Solution by Natalie Longtin

import java.util.Scanner;

public class hard {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// take in input for multiple cases
		int numCases = scan.nextInt();

		for (int c = 0; c < numCases; c++) {
			// take in length and complexity of both problems
			int length1 = scan.nextInt(), complexity1 = scan.nextInt();
			int length2 = scan.nextInt(), complexity2 = scan.nextInt();
			
			// the difficulty of the harder problem is equal to the maximum value between
			// length1 * complexity1 and length2 * complexity2
			System.out.println(Math.max(length1 * complexity1, length2 * complexity2));
		}
	}
}