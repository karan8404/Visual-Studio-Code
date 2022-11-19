package Heaputils;

import java.util.ArrayList;
import java.util.Scanner;

public class Heap {
    ArrayList<Integer> heap;// The heap
    int size;

    public Heap(ArrayList<Integer> input,int size) {// constructor for heaps
        heap = input;
        this.size=size;
        heapify();
    }

    public void heapify(){

    }

    public void swap(int a,int b){//swaps value two indexes of the heap.
        int temp=heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    public int countChildren(int current){//returns number of children a given node has.
        if((current*2+1)>=size)
            return 2;
        else
            return 1;
    }
}
