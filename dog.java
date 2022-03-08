import java.util.*;

public class dog {
    public static void main(String[] args){
        // grab our Scanner for input
        Scanner sc = new Scanner(System.in);

        // num test cases
        int t = sc.nextInt();

        // floop through each test case and solve each as it comes in
        for(int testNum = 0; testNum < t; ++testNum){
            // num flowers in park
            int n = sc.nextInt();
            // length of leash
            int L = sc.nextInt();
            // our position (x, y) coordinates
            int myX = sc.nextInt(), myY = sc.nextInt();

            // we will reduce this problem into counting the number of
            // points in the input that are inside a circle defined with
            // center (myX, myY) and radius L, as the dog can reach anything
            // with distance <= L away from our location, giving a circle

            // keep a count of points that the dog can reach
            int numCanReach = 0;
            for(int i = 0; i < n; ++i){
                // get the current flower's x and y coordinates
                int x = sc.nextInt(), y = sc.nextInt();

                // to check if a point is inside a circle, we can use the
                // distance formula between the center of the circle and the
                // point we are considering and check if that distance is
                // less than or equal to the radius

                // the distance formula between our two points compared to
                // the radius would look something like this:
                // sqrt((myX - x)^2 + (myY - y)^2) <= L

                // a key thing to consider when working with floating point values
                // (doubles, floats, long doubles, anything that could store more than
                // just a whole number value, etc.) is something called precision error;
                // this arises naturally when working with doubles as they can't always
                // perfectly store fractions or complicated real number functions (such as
                // Math.sqrt(), Math.sin(), etc.)

                // one way you can exemplify this for yourself is to try printing the result
                // of 0.1 + 0.2

                // we should try to avoid precision error as much as possible, and we can do
                // so with our original inequality above; everything is being computed in whole
                // numbers (specifically ints) except for when we sqrt() the left side of the
                // equation; to avoid this, we can square both sides of our inequality while
                // still maintaining our inequality to get something like this:
                // (myX - x)^2 + (myY - y)^2 <= L^2

                // the above inequality can be computed without doubles, therefore avoiding any
                // floating point error all together

                // do our check
                if((myX - x) * (myX - x) + (myY - y) * (myY - y) <= L * L){
                    // this point is inside our circle, so increment our count
                    ++numCanReach;
                }
            }
            
            // print our answer
            System.out.println(numCanReach);
        }
    }
}