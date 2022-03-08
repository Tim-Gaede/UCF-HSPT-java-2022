import java.util.*;
public class krypton {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read in how many elements we need to help Superman identify
        int elements = scan.nextInt();
        for(int i = 0 ;i<elements;i++){
            // Read in the value of the element
            int val = scan.nextInt();
            // Print the square of the element so that Superman can look it up on the periodic table
            System.out.println((int)(Math.pow(val,2)));
        }
    }
}
