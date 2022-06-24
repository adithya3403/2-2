// 4a.Given two strings text1 and text2,return the length of their longest common 
// subsequence.A subsequence of a string is a new string generated from the original string 
// with some characters(can be none) deleted without changing the relative order of the 
// remaining characters.(eg,"ace"is a subsequence of"abcde"while"aec"is not). A common 
// subsequence of two strings is a subsequence that is common to both strins. If there is 
// no common subsequence, return 0.

import java.util.Scanner;

class q4a {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.next();
        String text2 = sc.next();
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n1][n2]);
        sc.close();
    }
}

// EXPECTED OUTPUT:
// Sample Input:
// abcdefghijk caeghiklp
// Sample Output:
// 6
