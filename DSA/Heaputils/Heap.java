package Heaputils;

import java.util.ArrayList;

public class Heap {
    static ArrayList<Integer> heap;// The heap

    public Heap(ArrayList<Integer> input) {// constructor for heaps
        heapify(input);
        heap = input;
    }

    public void heapify(ArrayList<Integer> input) {// heapify method
        int current = (input.size() - 1) / 2;
        int currValue;
        int lc;
        int rc;
        int greater;
        while (current > 0) {
            lc = current * 2;
            rc = current * 2 + 1;
            try {
                currValue = input.get(current);
                greater = Math.max(input.get(lc), input.get(rc));

                if (greater > input.get(current)) {// swapping if one of the child nodes is bigger than parent node.
                    input.set(current, input.get(greater));
                    input.set(greater, currValue);
                }
            } catch (IndexOutOfBoundsException e) {
                if (lc >= input.size()) {

                }
            }
        }

    }
}
