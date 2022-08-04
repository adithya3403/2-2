// 6 a.Write a java program that loads names and phone numbers from the text
// file into Hash Table where data is organized as one line per record and each
// field in record are separated by a tab(\t).It takes a name or phone number as
// input and prints the corresponding other value from hash table.
import java.util.*;
import java.io.*;
public class q6a {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileReader fr = new FileReader("phone.txt");
        BufferedReader br = new BufferedReader(fr);
        Hashtable<String, String> ht = new Hashtable<>();
        String line;
        while ((line = br.readLine()) != null) {
            String s[] = line.split("\\s+");
            ht.put(s[0], s[1]);
        }
        System.out.println(ht);
        System.out.print("Enter name: ");
        String name = sc.next();
        if (ht.containsKey(name)) System.out.println("Mobile number is " + ht.get(name));
        else System.out.println("Not Found");
        System.out.print("Enter mobile number: ");
        String mobile = sc.next();
        if (ht.containsValue(mobile)) {
            Set<String> s1 = ht.keySet();
            for (String s : s1) if (mobile.equals(ht.get(s))) System.out.println("Name is " + s);
        } else System.out.println("Not Found");
    }
}
// {Suresh=9876543210, Tej=9393320400, Ramesh=0123456789}
// Enter name: Suresh 
// Mobile number is 9876543210
// Enter mobile number: 0123456789
// Name is Ramesh
