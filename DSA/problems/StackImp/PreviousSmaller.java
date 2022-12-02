//find the previous/next NEAREST smaller/greater element in an array using a stack. Video #42
package StackImp;

public class PreviousSmaller {
    public static void main(String[] args) {
        Integer[] arr = { 4, 10, 5, 8, 20, 15, 3, 12 };
        Stack<Integer> st = new Stack<>();
        // Logic below
        for (Integer num : arr) {
            while (!st.isEmpty() && num <= st.peek()){
                st.pop();
            }
            if (st.isEmpty())
                System.out.println(-1);
            else
                System.out.println(st.peek());
            st.push(num);
        }
    }
}
