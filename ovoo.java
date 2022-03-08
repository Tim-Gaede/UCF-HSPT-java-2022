// 2022 UCF HSPT - Ovoo? What’s That?
// Author: Chris Gittings

import java.util.Scanner;

public class ovoo 
{
	public static void main(String[] args)
	{
		// create a scanner for input
		Scanner scan = new Scanner(System.in);
		
		// take in the number of test cases
		int clans = scan.nextInt();
		
		// loop through the test cases
		for(int clan = 1; clan <= clans; clan++)
		{
			// output the header line for the case
			System.out.println("Clan #" + clan + ":");
			
			// take in the number of days for this test case
			int days = scan.nextInt();
			
			// flush the scanner, so we can take in the following lines
			scan.nextLine();
			
			int favor = 0, ovoos = 0;
			
			// loop through each day
			for(int d = 1; d <= days; d++)
			{
				// take in the day's type: WORK or WORSHIP
				String type = scan.nextLine();
				
				// if the type is WORK: update the number of ovoos
				if(type.equals("WORK"))
				{
					ovoos ++;
				}
				
				// if the type is WORSHIP: update the favor with the gods and print the current favor
				else
				{
					favor += ovoos;
					System.out.println(favor);
				}
			}
			
			// print the extra line after each test case
			System.out.println();
		}
	}	
}
