// 3. a.Given an array arr[]of N integers,the task is to find the maximum difference
// between any two elements of the array.
import java.util.*;
public class q3a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(a[i] - a[j]) > diff) diff = Math.abs(a[i] - a[j]);
            }
        }
        System.out.println(diff);
    }
}
// Sample Input:
// 5
// 10 20 30 40 50
// Sample Output:
// 40
