import java.util.*;
public class picasso {
    public static void main(String[] args) {
        /*
        In economics, there is the idea of marginal benefit and marginal cost.
        Marginal benefit represents the maximum amount a customer is willing to pay for an additional product
        Marginal cost represents the cost added by producing one additional unit of a product

        In the context of this problem, the marginal benefit for each product is the amount of money
        we get by selling Maxie the product.
        The marginal cost is the amount of money that Tess would have paid for that same product,
        because we are essentially losing out on the profit from Tess by selling to Maxie instead.

        Given that our hand is forced in selling EXACTLY x paintings to Maxie, we want to maximize
        the marginal net benefit, given by marginal benefit - marginal cost, of those x paintings

        The remaining (n - x) paintings MUST be sold to Tess. This will be the optimal solution.
         */

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0) {
            int n = scan.nextInt();
            int x = scan.nextInt();
            paint[] arr = new paint[n];
            int[] one = new int[n];
            int[] two = new int[n];
            for (int i = 0; i < n; i++) {
                one[i] = scan.nextInt();
            }
            for (int i = 0; i < n; i++) {
                two[i] = scan.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr[i] = new paint(one[i], two[i]);
            }
            // Sort the paintings in decreasing order of marginal net benefit
            Arrays.sort(arr);
            long sum = 0;
            for (int i = 0; i < n; i++) {
                // Sell the first x paintings of the sorted array to Maxie
                if (i < x) {
                    sum += arr[i].b;
                }
                // Sell the remaining paintings to Tess
                else
                    sum += arr[i].a;
            }
            System.out.println(sum);
        }
    }
    static class paint implements Comparable<paint>{
        int a, b;
        public paint(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(paint o) {
            return (o.b-o.a) - (b-a);
        }
    }
}
