// b.You have created a web-based survey of favorite programming languages and
// are capturing the results into a text file named "logfile". The structure of
// the text file is:

// For example, here is a sample logfile of six entries:

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
import java.util.concurrent.CopyOnWriteArrayList;

class Data {
    String plang, ip, timestamp;
    void setData(String plang, String ip, String timestamp) {
        this.plang = plang;
        this.ip = ip;
        this.timestamp = timestamp;
    }
    String getPlang() { return this.plang; }
    String getIP() { return this.ip; }
    String getTimestamp() { return this.timestamp; }
}

public class q6b {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileReader fr = new FileReader("logfile.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] data;
        List<Data> al = new CopyOnWriteArrayList<Data>();
        while ((line = br.readLine()) != null) {
            data = line.split("\t");
            Data d = new Data();
            d.setData(data[0], data[1], data[2]);
            al.add(d);
        }
        for (Data i : al) {
            System.out.println(i.getPlang() + "," + i.getIP() + "," + i.getTimestamp());
        }
        for (Data d : al) {
            if (d.getPlang().equals(d.plang)) {
                if (d.getIP().equals(d.ip)) {
                    al.remove(d);
                }
            }
        }
        for (Data i : al) {
            System.out.println(i.getPlang() + "," + i.getIP() + "," + i.getTimestamp());
        }
        sc.close();
        br.close();
    }
}

// EXPECTED OUTPUT:
// PHP 2 C# 1 Prolog 1