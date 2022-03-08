import java.util.*;
import java.io.*;
public class groove {
    public static void main(String[] args) {
        /*
        Solving this problem we use a Two-Pointer approach
        We maintain an left index and a right index, and increment on the maximum value that k can be.
        Using our pointers, we close in towards the middle and ensure that we found the current incremented value
        on both sides
        Once the pointers cross over, finding more values on either side does not improve our answer anymore
        because it breaks the property of the subsequence.
        Thus, we can print the highest value we succeeded in completing.
         */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int best = 0;
            int left = 0;
            int right = n-1;
            int need = 1;
            loop:while(left<n){
                //The left pointer found the value we are incrementing on
                if(arr[left] == need){
                    while(arr[right]!=need){
                        right--;
                        // Break out of the superior loop when pointers cross over
                        if(right<=left)break loop;
                    }
                    // If the pointers did not cross over in search for a matching value on the right,
                    // We succeeded in finding this value on both sides
                    best = Math.max(best,need);
                    need++;
                }
                left++;
            }
            System.out.println(best);
        }
    }
}
