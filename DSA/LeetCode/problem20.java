import java.util.Stack;
public class problem20 {
    //Valid Parenthesis problem.
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr=s.charAt(i);
            if(curr==')' && !st.empty() && st)
        }
    }
}