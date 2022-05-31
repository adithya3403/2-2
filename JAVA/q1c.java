// 1c. Cricketer's Pension Continuing our journey in mastering the conditional statements
// & our interest with cricket. Let us help the Indian cricket'sgoverning body(BCCI) to automate its
// plan of allotting pensions to former players. The rules are given below : 
// If a player has played more than 10 test matches and 100 ODI's he receives Rs.50,000.
// If a player has played more than 10 test matches he receives Rs.25,000.
// If a player has played more than 100 ODI's he receives Rs.15,000. 
// If a player has played for India he receives Rs.10,000. The amount is incremented
// by 1/4 th for every 'man of the match' award. If a player has not played for India but played 
// IPL he receives an amount of Rs.8,000. If a player has not played for India nor IPL he receives an amount of Rs.7,000.

import java.util.*;

public class q1c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Has the player played for India[y/n]?:");
        String ch = sc.next();
        System.out.println("Enter the no. of test matches he has played:");
        int test_matches = sc.nextInt();
        System.out.println("Enter the no. of ODI matches he has played:");
        int ODI_matches = sc.nextInt();
        System.out.println("No. of man of the matches he has won:");
        int man_of_the_matches = sc.nextInt();
        float amount = 0.0f;
        if (test_matches > 10 && ODI_matches > 100) {
            amount += 50000;
        } else if (test_matches > 10) {
            amount += 25000;
        } else if (ODI_matches > 100) {
            amount += 15000;
        } else if (ch.equals("y")) {
            amount += 10000;
        }
        amount = amount + (amount * (man_of_the_matches * 0.25f));
        System.out.println(amount);
        sc.close();
    }
}

// EXPECTED OUTPUT:
// Has the player played for India[y/n]?:
// y
// Enter the no. of test matches he has played:
// 20
// Enter the no. of ODI matches he has played:
// 120
// No. of man of the matches he has won:
// 50
// 675000.0