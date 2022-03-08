//UCF HSPT 2022 - What are the odds?
//Author - Tyler Marks
import java.util.*;

//We are given two strings and we want to find the probability of removing a letter
//from the first string and getting our second string. To solve this we can use
//the Inclusion-Exclusion Principle. First we will compute the lengths of our longest
//common suffix and our longest common prefix. If the sum of these two lengths does not
//equal or exceed the length of Malachi's string minus 1, then there is a 0.0 probability (0/1).
//The sum of these two strings now includes the number of possible letters to remove and
//all of Robette's string so we subtract out the length of Robette's string. This gives us
//our numerator for our ratio and our denominator is going to be the length of Robette's
//string. Simplify the fraction using the Euclidean Algorithm and output the reduced fraction.

public class odds{
    public static void main(String[] args) {
        //Declare and initiate scanner 
        Scanner in = new Scanner(System.in);

        //Scan in the number of games
        int numGames = in.nextInt();

        //Loop through each game
        for(int game = 0; game < numGames; game++){
            //Scan in Robette's and Malachi's strings
            String robette = in.next(), malachi = in.next();
            int robetteLen = robette.length(), malachiLen = malachi.length();

            //Get the length of the longest common prefix(lcp)
            int lcpLen = 0;
            while(lcpLen < malachiLen){
                if(robette.charAt(lcpLen) != malachi.charAt(lcpLen))
                    break;
                lcpLen++;
            }

            //Get the length of the longest common suffix(lcs)
            int lcsLen = 0;
            while(lcsLen < malachiLen){
                int idx = robetteLen-lcsLen-1;
                if(robette.charAt(idx) != malachi.charAt(idx-1))
                    break;
                lcsLen++;
            }
            
            //The number of characters that can be removed is equal to:
            //      length of lcp + length of lcs - length of Malachi's string + 1
            //      (Inclusion - Exclusion Principle)
            int num = lcpLen + lcsLen - malachiLen + 1;
            int den = robetteLen;

            //If the numerator is negative, then it is impossible
            if(num <= 0){
                System.out.println("0/1");
                continue;
            }

            //Get gcd in order to reduce fraction
            int d = gcd(num, den);

            //print out reduced fraction
            System.out.println((num/d) + "/" + (den/d));
        }

        //close scanner
        in.close();
    }

    //returns gcd of a and b using the euclidean algorithm
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }
}
