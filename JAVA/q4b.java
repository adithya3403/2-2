// 4 b.Given two strings s1 and s2, your task is to merge those strings to form a new 
// merged string. A merge operation on two strings is described as follows: Append alternating 
// characters from s1 and s2,respectively,to mergedString. Once all of the characters in one 
// of the strings have been merged,append the remaining characters in the other string to mergedString.
import java.util.*;
public class q4b {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String w1 = sc.next();
        String w2 = sc.next();
        int n1 = w1.length(), n2 = w2.length();
        StringBuilder sb = new StringBuilder();
        int i1 = 0, i2 = 0;
        while (i1 < n1 && i2 < n2) {
            sb.append(w1.charAt(i1++));
            sb.append(w2.charAt(i2++));
        }
        while (i1 < w1.length()) {sb.append(w1.charAt(i1++));}
        while (i2 < w2.length()) {sb.append(w2.charAt(i2++));}
        System.out.println(sb.toString());
    }
}
// Sample Input: abc def 
// Sample Output: adbecf
