import java.util.*;
public class gnome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read in the number of missions
        int t = scan.nextInt();
        while (t-- > 0) {
            // Read in number of sticks, number of pillars, respectively.
            int n = scan.nextInt(), k = scan.nextInt();
            if (k == 0) {
                // If there are no pillars, print "this is madness"
                // Very important check to ensure no divide by 0 errors occur.
                System.out.println("this is madness");
            } else {
                System.out.printf("%.3f\n",(1.0 * n / k));
            }
        }
    }
}
