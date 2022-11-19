package Heaputils;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> heap;// The heap
    int size;

    public Heap(ArrayList<Integer> input, int len) {// constructor for heaps
        heap = input;
        size = len-1;
        heapify();
    }

    public void heapify() {
        int current = size/ 2;
        int lc = current * 2;
        int rc = current * 2 + 1;
        // corner case handling for only the very first node which has a chance of
        // having only one child.
        if (countChildren(current) == 1) {
            if (heap.get(lc) > heap.get(current))
                swap(current, lc);
            current--;
            lc -= 2;
            rc -= 2;
        }
        // after corner case is handled.
        int greater;
        while (current > 0) {
            greater = heap.get(lc) > heap.get(rc) ? lc : rc;
            if(heap.get(greater)>heap.get(current)){
                swap(greater, current);
            }

            current-=1;lc-=2;rc-=2;//updating index values for next node.
        }

    }

    public void swap(int a, int b) {// swaps value two indexes of the heap.
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    public int countChildren(int current) {// returns number of children a given node has.
        if ((current * 2 + 1) > size)
            return 1;
        else
            return 2;

    }
}
