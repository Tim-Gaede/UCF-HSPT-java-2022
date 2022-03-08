// array.java by Jacob Steinebronn
import java.util.Scanner;

public class array{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // If you do it this way, then you don't have to do the extra nextLine()
        // after doing nextInt(), because i'm using nextLine later.
        int t = Integer.parseInt(s.nextLine());
        // For each testcase, read two lines, trash the first one, take the second one, and add
        // a trailing space for the purposes of matching the spec.
        while(t-- > 0) System.out.println(s.nextLine().substring(0,0) + s.nextLine() + " ");
    }
}