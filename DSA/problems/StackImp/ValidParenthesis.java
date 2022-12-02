//checking if an array of characters has valid parenthesis.Video #43
//can have other types of characters in it.
package StackImp;

public class ValidParenthesis {

    public static boolean check(char[] arr) {
        Stack<Character> st = new Stack<>();
        for (char c : arr) {
            if (isParenthesis(c) == 1) {
                st.push(c);
            } else if (isParenthesis(c) == 2) {
                if (matches(st.peek(), c))
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }

    // 0 if not parenthesis,1 if opening,2 if closing.
    public static int isParenthesis(char c) {
        if (c == '(' || c == '[' || c == '{')
            return 1;
        if (c == ')' || c == ']' || c == '}')
            return 2;
        return 0;
    }

    // checks matching parenthesis
    public static boolean matches(char c, char d) {
        if (c == '(' && d == ')')
            return true;
        if (c == '{' && d == '}')
            return true;
        if (c == '[' && d == ']')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(check(s.toCharArray()));
    }
}
