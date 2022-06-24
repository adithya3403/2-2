// c.You are given a string S of alphabet characters and the task 
// is to find its matching decimal representation as on the shown 
// keypad. Output the decimal representation corresponding to the 
// string. For ex : if you are given "amazon" then its corresponding 
// decimal representation will be 262966.

import java.util.*;
class q4c {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        char[] ch = new char[n];
        String res = "";
        for (int i = 0; i < n; i++) {
            ch[i] = str.charAt(i);
            switch (ch[i]) {
                case 'a': case 'b': case 'c': 
                    res+=2;
                    break;
                case 'd': case 'e': case 'f':
                    res+=3;
                    break;
                case 'g': case 'h': case 'i':
                    res += 4;
                    break;
                case 'j': case 'k': case 'l':
                    res += 5;
                    break;
                case 'm': case 'n': case 'o':
                    res += 6;
                    break;
                case 'p': case 'q': case 'r': case 's':
                    res += 7;
                    break;
                case 't': case 'u': case 'v':
                    res += 8;
                    break;
                case 'w': case 'x': case 'y': case 'z':
                    res += 9;
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
        System.out.println(res);
        sc.close();
    }
}

// EXPECTED OUTPUT:
// Sample Input:
// amazon
// Sample Output:
// 262966
