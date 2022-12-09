//conversions between different types of expressions.Video #47.
package StackImp;

public class ConvertExpression {

    // converts infix to postfix.(expression must have parenthesis)
    public static String InToPost(String s) {
        Stack<String> st = new Stack<>();
        char c;
        String op1;
        String op2;
        String op;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c != ')') {
                st.push(c + "");
            } else {// if closing bracket encountered.
                op2 = st.pop();
                op = st.pop();
                op1 = st.pop();
                st.pop();
                st.push(op1 + op2 + op);
            }
        }
        return st.pop();
    }

    // Converts infix to postfix.(does not require parenthesis)
    public static String InToPost2(String s) {
        StringBuilder res = new StringBuilder(s.length());
        Stack<Character> st = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else if (isOperator(c)) {
                // while st is not empty and current operator does not have higher precedence.
                while (!st.isEmpty() && (compareOperators(c, st.peek()) <= 0)) {
                    res.append(st.pop());
                }
                st.push(c);
            } else if (c == ')') {
                while (compareOperators(c, st.peek()) != 0) {
                    res.append(st.pop());
                }
                st.pop();
            } else {
                res.append(c);
            }
        }
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String expression = "((a+(b/(c+(d*e))))-((f/g)*h))";
        //String expression2 = "a+b*c";
        System.out.println(InToPost2(expression));
    }

    // helper method for InToPost2.
    private static int compareOperators(char a, char b) {
        int aPrecedence;
        int bPrecedence;
        if (a == '+' || a == '-')
            aPrecedence = 1;
        else if (a == '(')
            aPrecedence = 0;
        else
            aPrecedence = 2;

        if (b == '+' || b == '-')
            bPrecedence = 1;
        else if (b == '(')
            bPrecedence = 0;
        else
            bPrecedence = 2;

        return aPrecedence - bPrecedence;
    }

    // helper method for InToPost2
    private static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }
}
