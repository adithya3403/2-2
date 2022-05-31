// 4a.Given two strings text1 and text2,return the length of their longest common 
// subsequence.A subsequence of a string is a new string generated from the original string 
// with some characters(can be none) deleted without changing the relative order of the 
// remaining characters.(eg,"ace"is a subsequence of"abcde"while"aec"is not). A common 
// subsequence of two strings is a subsequence that is common to both strins. If there is 
// no common subsequence, return 0.

import java.util.Scanner;

class q4a {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(longestCommonSubsequence(sc.next(), sc.next()));
        sc.close();
    }
}

// EXPECTED OUTPUT:
// Sample Input:
// abcdefghijk caeghiklp
// Sample Output:
// 6
