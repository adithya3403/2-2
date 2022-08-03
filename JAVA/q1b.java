// 1b. Write a java program to check whether the given number
// is gupful or not. A number is gupful if it is at least 3
// digits long and is divisible by the number formed by
// stringing the first and last numbers together.The smallest
// number that fits this description is 100. First digit is 1,
// last digit is 0,forming 10,which is a factor of 100.
// Therefore,100 is gupful.
import java.util.*;
public class q1b {
    private static boolean isGupful(int n) {
        String s = "" + n;
        int div = Integer.parseInt("" + s.charAt(0) + s.charAt(s.length() - 1));
        return n % div == 0;
    }
    public static int gupful(int n) {
        for (int i = 0; n - i > 100; i++) {
            boolean low = isGupful(n - i);
            boolean high = isGupful(n + i);
            if (low || high) return low ? n - i : n + i;
        }
        return 100;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(gupful(sc.nextInt()));
    }
}
// input=25
// output=100
// input=103
// output=105
