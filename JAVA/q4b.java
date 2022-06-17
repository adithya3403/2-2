// 4 b.Given two strings s1 and s2, your task is to merge those strings to form a new 
// merged string. A merge operation on two strings is described as follows: Append alternating 
// characters from s1 and s2,respectively,to mergedString. Once all of the characters in one 
// of the strings have been merged,append the remaining characters in the other string to 
// mergedString.

import java.util.*;
class q4b {
    public static String mergeAlternately(String w1, String w2) {
        StringBuilder sb = new StringBuilder();
        int i1 = 0, i2 = 0;
        while (i1 < w1.length() && i2 < w2.length()) {
            sb.append(w1.charAt(i1));
            sb.append(w2.charAt(i2));
            i1++;
            i2++;
        }
        while (i1 < w1.length()) {
            sb.append(w1.charAt(i1));
            i1++;
        }
        while (i2 < w2.length()) {
            sb.append(w2.charAt(i2));
            i2++;
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mergeAlternately(sc.next(), sc.next()));
        sc.close();
    }
}

// EXPECTED OUTPUT:
// Sample Input:
// abc def
// Sample Output:
// adbecf
