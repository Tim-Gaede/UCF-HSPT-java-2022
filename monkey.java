// 2022 UCF HSPT - Monkey Madness
// Solution Author: Chris Gittings

import java.util.ArrayDeque;
import java.util.Scanner;

public class monkey 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		// get the number of test cases
		int jungles = scan.nextInt();
		
		// for each test case
		for(int jungle = 0; jungle < jungles; jungle++)
		{
			// get the rows and columns of the jungle
			int rows = scan.nextInt(), cols = scan.nextInt();
			
			// flush the scanner
			scan.nextLine();
			
			// take in the 2D array of monkeys
			int[][] board = new int[rows][cols];
			for(int i = 0; i < rows; i++)
			{
				char[] in = scan.nextLine().toCharArray();
				
				for(int j = 0; j < cols; j++)
					board[i][j] = in[j] - '0';
			}
			
			// test each strength starting at 1
			// once the monkeys can escape, that's the minimum strength value
			// they will always be able to escape when strength = 9
			int strength = 1;
			for( ; strength < 9; strength++)
				if(escape(strength, board, rows, cols))
					break;
			
			// print out the minimum strength value
			System.out.println(strength);
		}
		
		scan.close();
	}
	
	// returns true only if the given strength value is 
	// sufficient for every monkey to reach the edge of the board
	// performs a bfs from the edges of the jungle to any reachable cell
	private static boolean escape(int strength, int[][] board, int rows, int cols) 
	{
		// the points to check around
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		
		// the cells that have been visited by the bfs
		boolean[][] visited = new boolean[rows][cols];
		
		// check each of the leftmost and rightmost cells
		// if it is, add it to the queue
		for(int i = 0; i < board.length; i++)
		{
			// leftmost point
			if(board[i][0] <= strength)
				updatePoint(i, 0, q, visited);
			
			// rightmost point
			if(board[i][cols - 1] <= strength)
				updatePoint(i, cols - 1, q, visited);
		}
		
		// do the same as above with the bottommost and topmost points
		// skips the corner since those are already checked above
		for(int j = 1; j < cols - 1; j++)
		{
			// topmost point
			if(board[0][j] <= strength)
				updatePoint(0, j, q, visited);
			
			// bottommost point
			if(board[rows - 1][j] <= strength)
				updatePoint(rows - 1, j, q, visited);
		}
		
		// the four cardinal directions
		int[] dr = {0, 0, 1, -1};
		int[] dc = {1, -1, 0, 0};
		
		// while the list still has points to check
		while(!q.isEmpty())
		{
			// grab the first point and set the current row and column values
			int[] point = q.poll();
			int r = point[0], c = point[1];
			
			// check each of the cardinal directions
			for(int d = 0; d < 4; d++)
			{
				// i and j are the new point
				int i = r + dr[d], j = c + dc[d];
				
				// checks that the cell:
				// is within the jungle
				// has not yet been visited
				// can be chopped
				if(!valid(i, j, rows, cols) || visited[i][j] || board[i][j] > strength) 
					// if the point doesn't pass these tests, then just skip it
					continue;
				
				// add the point since it's passed the tests
				updatePoint(i, j, q, visited);
			}
		}
		
		// check the jungle
		// make sure that each monkey cell can reach and be reached by
		// one of the outer cells and can escape
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				if(board[i][j] == 0 && !visited[i][j])
					return false;
		
		// no trapped monkeys have been found, so return that everyone's escaped!
		return true;
	}
	
	// takes in a valid point and adds that point to the
	// list of points to be checked and the visited array
	private static void updatePoint(int i, int j, ArrayDeque<int[]> q, boolean[][] visited) 
	{
		q.add(new int[] {i, j});
		visited[i][j] = true;
	}
	
	// checks if a given point is within the bounds of the jungle
	public static boolean valid(int y, int x, int rows, int cols)
	{
		return y >= 0 && x >= 0 && y < rows && x < cols;
	}
}
