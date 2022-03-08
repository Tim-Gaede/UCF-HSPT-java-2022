import java.util.*;

public class parade_fast {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			int m = in.nextInt();
			System.out.println(m%n+1);
		}
		
	}
}

/*
Holding a door essentially moves the first person to the end. After the first N doors, the line will cycle through the people again in the same order so we only care
about the people mod N. This clearly solves the problem in O(1).

A more brute force solution that actually simulates replacing the values should also work.
*/
