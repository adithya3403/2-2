// 4a.Given two strings text1 and text2,return the length of their longest common 
// subsequence.A subsequence of a string is a new string generated from the original string 
// with some characters(can be none) deleted without changing the relative order of the 
// remaining characters.(eg,"ace"is a subsequence of"abcde"while"aec"is not). A common 
// subsequence of two strings is a subsequence that is common to both strins. If there is 
// no common subsequence, return 0.
import java.util.*;
public class q4a {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.next(), text2 = sc.next();
        int n1 = text1.length(), n2 = text2.length();
        int[][] str = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) str[i][j] = str[i - 1][j - 1] + 1;
                else str[i][j] = Math.max(str[i - 1][j], str[i][j - 1]);
            }
        }
        System.out.println(str[n1][n2]);
    }
}
// input: abcdefghijk caeghiklp
// output: 6
