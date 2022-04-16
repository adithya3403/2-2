import java.util.*;

public class sample {
    public static void goatLatin(String input) {
        String sarr[] = input.split(" ");
        for (int i = 0; i < sarr.length; i++) {
            char c = sarr[i].charAt(0);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O'
                    && c != 'U') {
                String sub = sarr[i].substring(1);
                sub = sub + sarr[i].charAt(0);
                sarr[i] = sub;
            }
            sarr[i] = sarr[i] + "ma" + "a".repeat(i + 1);
            System.out.print(sarr[i] + " ");
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        goatLatin(input);
        sc.close();
    }
}