// b. Write a program to find the most common words in the list of words given
// in sorted order based on occurrence from largest to smallest. If any of words
// are having same occurrence then consider the smallest character order comes
// first.
// Input format: First line contains the list of words and next line contains a
// number (k) which represent the top most words to display.
// Output format: display the k top most words.

import java.util.*;

public class q8b {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String arr[] = s.split(" ");
        Map<String, Integer> ch = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            String x = arr[i];
            if (ch.containsKey(x)) {
                int c = ch.get(x);
                c++;
                ch.put(x, c);
            } else {
                ch.put(x, 1);
            }
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        Set<String> ss = ch.keySet();
        for (String i : ss) {
            if (al.contains(ch.get(i))) {
            } else {
                al.add(ch.get(i));
            }
        }
        Collections.sort(al);
        for (int i = al.size() - 1; i >= 0; i--) {
            int temp = al.get(i);
            ArrayList<String> tal = new ArrayList<>();
            for (Map.Entry<String, Integer> l1 : ch.entrySet()) {
                if (l1.getValue() == temp)
                    tal.add(l1.getKey());
            }
            Collections.sort(tal);
            for (String s1 : tal)
                System.out.print(s1 + " ");
        }
        sc.close();
    }
}

// EXPECTED OUTPUT :
// Sample Input:
// lets do one to do how to do
// Sample Output:
// do to how lets one