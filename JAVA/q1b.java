// 1b. Write a java program to check whether the given number
// is gupful or not. A number is gupful if it is at least 3
// digits long and is divisible by the number formed by
// stringing the first and last numbers together.The smallest
// number that fits this description is 100. First digit is 1,
// last digit is 0,forming 10,which is a factor of 100. Therefore, 100 is gupful.
import java.util.*;
public class q1b {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        if (n>=100 && n%(n/10+n%10)==0) System.out.println(true);
        else System.out.println(false);
    }
}
// input: 103 output: false
// input: 105 output: true
