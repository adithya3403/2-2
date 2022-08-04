// c. Given n non-negative integers representing an elevation map where the width
// of each bar is 1,compute how much water it is able to trap after raining.
// Examples:
// Input : arr[] = {3, 0, 0, 2, 0, 4}
// Output : 10
// We can trap"3*2 units"of water between 3 an 2,"1 unit"on top of bar 2 and"3 units"between 2 and 4.
import java.util.*;
public class q3c {
    public static int maxWater(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            int left = arr[i];
            for (int j = 0; j < i; j++) left = Math.max(left, arr[j]);
            int right = arr[i];
            for (int j = i + 1; j < n; j++) right = Math.max(right, arr[j]);
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0; i<n; i++) arr[i]=sc.nextInt();
        System.out.print(maxWater(arr));
    }
}
