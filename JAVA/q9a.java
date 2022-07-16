// 9a. Write a java Program to write a method fCount which takes a string as a
// parameter. The Method fCount should return the Map which has the frequency
// count of the given word. For example if the string passed is "hello" the map
// should return {h-1,e-1,l-2,o-1}. The order of the characters should be same
// as in the string.

import java.util.*;

public class q9a {
    static void fCount(String str) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            System.out.print(m.getKey() + "-" + m.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        fCount(str);
        sc.close();
    }
}

// EXPECTED OUTPUT

// Run 1:
// Enter a string:
// hello h-1 e-1 l-2 o-1

// Run 2:
// Enter a string:kmit
// k-1 m-1 i-1 t-1