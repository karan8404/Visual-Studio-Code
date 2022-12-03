//find the previous/next NEAREST smaller/greater element in an array using a stack. Video #42
package StackImp;

import java.util.ArrayList;
import java.util.Collections;

class PreviousSmaller {
    //returns index of previous smaller element.
    public static ArrayList<Integer> previousSmaller(Integer[] arr) {
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<arr.length;i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                res.add(-1);
            else
                res.add(st.peek());
            st.push(i);
        }
        return res;
    }

    //returns index of next smaller element.
    public static ArrayList<Integer> nextSmaller(Integer[] arr) {
        ArrayList<Integer> res= new ArrayList<>();
        Stack<Integer> st= new Stack<>();
        for (int i=arr.length-1;i>=0;i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                res.add(arr.length);
            else
                res.add(st.peek());
            st.push(i);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String args) {
        Integer[] arr= {4, 10, 5, 8, 20, 15, 3, 12};
        // Logic below
        System.out.println(nextSmaller(arr));
    }
}