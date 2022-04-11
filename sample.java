import java.util.*;

class LCP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String str[] = s.split(" ");
        String rstr = str[0];
        for (int i = 1; i < str.length; i++) {
            if (str[i].length() < rstr.length()) {
                rstr = str[i];
            }
        }
        String res = "";
        for (int i = 0; i < rstr.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (str[j].charAt(i) != rstr.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = res + rstr.charAt(i);
            } else {
                break;
            }
        }
        System.out.println(res);
    }
}