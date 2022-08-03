// b.You have created a web-based survey of favorite programming languages and
// are capturing the results into a text file named "logfile". The structure of
// the text file is:
// The logfile is ordered by increasing timestamp. You are concerned that some
// people are voting multiple times for the same item. To somewhat address this
// problem, throw out any new votes for the same item that come from the same IP
// address within 20 seconds.
// In the above example, the second and last votes for PHP would be thrown out
// because they are for the same item from the same IP address and occur within
// 20 seconds of other PHP votes from the same IP address. However, the PHP vote
// from 128.120.56.214 would be retained since there is not another PHP vote
// from this IP address.
// Write a Java program to count the votes from the logfile, throwing out
// duplicate votes using the rules above. Display the votes in a table, as shown
// below for the example:
// PHP 2
// C# 1
// Prolog 1
import java.util.*;
import java.io.*;
class Data {
    String lang, ip, ts;
    void setData(String lang, String ip, String ts) {
        this.lang = lang;
        this.ip = ip;
        this.ts = ts;
    }
}
public class q6b {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileReader fr = new FileReader("logfile.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<Data> al = new ArrayList<Data>();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("\\s+");
            Data d = new Data();
            d.setData(arr[0], arr[1], arr[2]);
            al.add(d);
        }
        for (int i = 0; i < al.size(); i++) {
            for (int j = i + 1; j < al.size(); j++) {
                if ((al.get(i).ip).equals(al.get(j).ip)) al.remove(j);
                else if (Math.abs(Long.parseLong(al.get(i).ts) - Long.parseLong(al.get(j).ts)) > 20000) al.remove(j);
            }
        }
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < al.size(); i++) {
            String lang = al.get(i).lang;
            if (map.containsKey(lang)) map.put(lang, map.get(lang) + 1);
            else map.put(lang, 1);
        }
        for (String key : map.keySet()) System.out.println(key + " " + map.get(key));
    }
}
// PHP 2
// C# 1
// Prolog 1
