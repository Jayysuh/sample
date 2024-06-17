import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        //2. Find the Greatest Common Divisor
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two positive integers.");
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();

        int gcd = 1;

        for (int i = 1; (i <= n1) || (i <= n2); i++) {
            if ((n1 % i == 0) && (n2 % i == 0)){
                gcd = i;
            }
        }
        System.out.println("Greatest Common Divisor = " + gcd);
    }
}
