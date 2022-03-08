// Solution by Sathvik Kuthuru

import java.util.Scanner;

public class queen {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Scan in the number of chess boards we have to solve
		int testCases = scan.nextInt();
		
		// Loop through each case
		for(int tt = 0; tt < testCases; tt++) {
			// Scan in k and let n equal the actual length of the board
			// Note that 2 * k is always an even number and therefore n = 2 * k + 1 is always odd
			int k = scan.nextInt();
			int n = 2 * k + 1;
			
			/*
			 *  Instead of trying to calculate the number of squares that are free from the queen,
			 *  we can try complementary counting by subtracting out the number of blocked squares from total
			 *  squares which will also find the number of free squares
			 */
			
			// There are n ^ 2 squares in an n x n chess board
			int totalSquares = n * n;
			
			// There are 8 directions the queen can move through
			// In each of those 8 directions, the queen can move k squares
			// Have to add 1 to account for the square the queen is on
			int blockedSquares = k * 8 + 1;
			
			// Do the subtraction to find the square not under the queen's reign
			// Print out the answer
			int freeSquares = totalSquares - blockedSquares;
			System.out.println(freeSquares);
		}
	}

}
