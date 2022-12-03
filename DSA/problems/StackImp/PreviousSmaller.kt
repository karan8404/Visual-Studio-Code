//find the previous/next NEAREST smaller/greater element in an array using a stack. Video #42
package StackImp

import java.util.ArrayList

object PreviousSmaller {
    //returns index of previous smaller element.
    fun previousSmaller(arr: Array<Integer>): ArrayList<Integer> {
        val res: ArrayList<Integer> = ArrayList(arr.size)
        val st: Stack<Integer> = Stack<Integer>()
        for (i in arr.indices) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop()
            }
            if (st.isEmpty()) res.add(-1) else res.add(st.peek())
            st.push(i)
        }
        return res
    }

    //returns index of next smaller element.
    fun nextSmaller(arr: Array<Integer>): ArrayList<Integer> {
        val res: ArrayList<Integer> = ArrayList(arr.size)
        val st: Stack<Integer> = Stack<Integer>()
        for (i in arr.indices.reversed()) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop()
            }
            if (st.isEmpty()) res.add(arr.size) else res.add(st.peek())
            st.push(i)
        }
        Collections.reverse(res)
        return res
    }

    fun main(args: Array<String?>?) {
        val arr: Array<Integer> = arrayOf(4, 10, 5, 8, 20, 15, 3, 12)
        // Logic below
        System.out.println(nextSmaller(arr))
    }
}