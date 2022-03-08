// sleep.java by Jacob Steinebronn
import java.util.Scanner;

public class sleep{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int nt = s.nextInt();
        s.nextLine();
        while(nt-- > 0){
            String line = s.nextLine();
            int numZs = 0;
            for(char c : line.toCharArray())
                if(c == 'z' || c == 'Z') numZs++;
            if(numZs < 3) System.out.println("Perry saves the day!");
            else System.out.println("Time to take a nap.");

        }
        s.close();
    }
}