import java.util.*;
public class parade {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			//add the initial 1 to n people 
			for(int i=1;i<=n;i++) {
				list.add(i);
			}
			
			//moves the first person in line to the end m times
			for(int i=0;i<m;i++) {
				int first = list.remove(0);
				list.add(first);
			}
			
			System.out.println(list.get(0));
			
		}
	}
}

/*
Holding a door essentially moves the first person to the end. We can simulate this with a list by simply removing the first element and adding it to the end m times.
This solution will run in O(n*m) since removing an element from the beginning of an ArrayList is an O(n) operation.

This is the slowest reasonable solution that passes. We can speed this up to O(m) by using a linked list which offers O(1) removals from the front of the list.
We can also solve this in a single operation in O(1) as shown in the other java solution.
*/

