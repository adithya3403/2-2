import java.util.*;
class validParen {
    public static boolean validParenthesis(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty())
                    return false;
                char top = st.peek();
                if (c == ')' && top != '(')
                    return false;
                if (c == ']' && top != '[')
                    return false;
                if (c == '}' && top != '{')
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}

public class sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        System.out.println(validParen.validParenthesis(exp));
        sc.close();
    }
}
