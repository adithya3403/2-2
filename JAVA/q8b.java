// b. Write a program to find the most common words in the list of words given
// in sorted order based on occurrence from largest to smallest. If any of words
// are having same occurrence then consider the smallest character order comes first.
// Input format: First line contains the list of words and next line contains a
// number (k) which represent the top most words to display.
// Output format: display the k top most words.
import java.util.*;
public class q8b {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String arr[] = s.split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String x = arr[i];
            if (map.containsKey(x)) map.put(x, map.get(x) + 1);
            else map.put(x, 1);
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                else return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> i : list) System.out.print(i.getKey() + " ");
        System.out.println();
    }
}
// Sample Input: lets do one to do how to do
// Sample Output: do to how lets one
