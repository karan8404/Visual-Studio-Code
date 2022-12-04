//conversions between different types of expressions.Video #47.
package StackImp;

public class ConvertExpression {
    
    //converts infix to postfix.(expression must have parenthesis)
    public static String InToPost(String s){
        Stack<String> st=new Stack<>();
        char c;
        String op1;
        String op2;
        String op;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(c!=')'){
                st.push(c+"");
            }
            else{//if closing bracket encountered.
                op2=st.pop();
                op=st.pop();
                op1=st.pop();
                st.pop();
                st.push(op1+op2+op);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String expression="((a+(b/(c+(d*e))))-((f/g)*h))";
        System.out.println(InToPost(expression));
    }
}
