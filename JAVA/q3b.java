// b.Write a Java program to fill the below pattern into a square matrix:
// The matrix has to be filled with numbers starting from 1. It has to start fill 
// first row last column,last row(reverse),first column(reverse)and so on.Please refer 
// the following example 
// input:5 
// output:
// 1 2 3 4 5
// 16 17 18 19 6
// 15 24 25 20 7
// 14 23 22 21 8
// 13 12 11 10 9
import java.util.*;
public class q3b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rb = 0, re = n - 1, cb = 0, ce = n - 1, k = 1;
        int[][] a = new int[n][n];
        while (rb <= re && cb <= ce) {
            for (int i = cb; i <= ce; i++) a[rb][i] = k++;
            rb++;
            for (int i = rb; i <= re; i++) a[i][ce] = k++;
            ce--;
            if (rb <= re)
                for (int i = ce; i >= cb; i--) a[re][i] = k++;
            re--;
            if (cb <= ce)
                for (int i = re; i >= rb; i--) a[i][cb] = k++;
            cb++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
