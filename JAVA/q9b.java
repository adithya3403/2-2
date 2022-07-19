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
// You job is to write a method:
// public int commonKeyValuePairs(HashMap<String, String> map1, HashMap<String, String> map2)
// that is passed two objects of type HashMap<String, String> and returns the number of common
// key/value pairs between the two HashMaps.

import java.util.*;

public class q9b {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map1 = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();
        System.out.print("Enter how many pairs in HashMap 1 : ");
        int m1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your " + m1 + " pairs of String ");
        for (int i = 0; i < m1; i++) {
            String pairs[] = sc.nextLine().split(" ");
            map1.put(pairs[0], pairs[1]);
        }
        System.out.print("Enter how many pairs in HashMap 2 : ");
        int m2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your " + m2 + " pairs of String ");
        for (int i = 0; i < m2; i++) {
            String pairs[] = sc.nextLine().split(" ");
            map2.put(pairs[0], pairs[1]);
        }
        int result = commonKeyValuePairs(map1, map2);
        System.out.println("The number of key/value pairs are : " + result);
        sc.close();
    }

    public static int commonKeyValuePairs(HashMap<String, String> map1, HashMap<String, String> map2) {
        int c = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    c++;
                }
            }
        }
        return c;
    }
}

/*
EXPECTED OUTPUT
Enter how many pairs in HashMap 1 : 5
Enter your 5 pairs of String 
Alice Healthy
Mary Ecstatic
Bob Happy
Chunck Fine
Felix Sick
Enter how many pairs in HashMap 2 : 5
Enter your 5 pairs of String 
Mary Ecstatic
Felix Healthy
Ricardo Superb
Tam Fine
Bob Happy
The number of key/value pairs are : 2
*/