// b. When working with HashMaps, sometimes cases arise where we wish to
// determine if two HashMaps have any key/value pairs in common. For example, we
// might have the following two Hashmaps (named hashmap1 and hashmap2,
// respectively) that map from String to String (i.e., their type is HashMap)
// and we want to count how many key/value pairs they have in common.

// In the example above, these two HashMaps have two key/value pairs in common,
// namely: "Mary"/"Ecstatic" and "Bob"/"Happy". Note that although the key
// "Felix" is in both HashMaps, the associated value with this key is different
// in the two maps (hence this does not count as a key/value pair that is common
// to both HashMaps). Similarly, just having the same value without the same key
// (such as the value "Fine" which is mapped to by different keys in the two
// different HashMaps) would also not count as a common key/value pair between
// the two HashMaps.

import java.util.*;

public class q9b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many pairs in HashMap 1 : ");
        int n1 = sc.nextInt();
        HashMap<String, String> hm1 = new HashMap<String, String>();
        for (int i = 0; i < n1; i++)
            hm1.put(sc.next(), sc.next());
        System.out.print("Enter how many pairs in HashMap 2 : ");
        int n2 = sc.nextInt();
        HashMap<String, String> hm2 = new HashMap<String, String>();
        for (int i = 0; i < n2; i++)
            hm2.put(sc.next(), sc.next());
        int c = 0;
        for (Map.Entry<String, String> m : hm1.entrySet())
            if (hm2.containsKey(m.getKey()))
                if (hm2.get(m.getKey()).equals(m.getValue()))
                    c++;
        System.out.println("The number of key/value pairs are : " + c);
        sc.close();
    }
}

// EXPECTED OUTPUT
// Enter how many pairs in HashMap 1 : 5
// Enter your 5 pair of String
// Alice Healthy
// Mary Ecstatic
// Bob Happy
// Chunck Fine
// Felix Sick
// Enter how many pairs in HashMap 2 : 5
// Enter your 5 pair of String
// Mary Ecstatic
// Felix Healthy
// Ricardo Superb
// Tam Fine
// Bob Happy
// The number of key/value pairs are : 2