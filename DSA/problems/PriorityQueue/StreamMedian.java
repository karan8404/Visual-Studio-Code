package PriorityQueue;
//program to find the median at any instant while the input is being provided in a stream.
//input number to put into stream, x to stop the program, any other character to find the median.

import java.util.*;

class StreamMedian {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())// if both have same size, return average of elements.
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else// max heap has more elements return root element.
            return maxHeap.peek();
    }

    public void put(int a) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= a)
            maxHeap.add(a);
        else
            minHeap.add(a);
        //moving elements from one heap to another 
        if(maxHeap.size()-minHeap.size()>=2)//if maxheap has 2 more elements
            minHeap.add(maxHeap.poll());
        else if(minHeap.size()>maxHeap.size())//if minheap has more elements
            maxHeap.add(minHeap.poll());
    }

    public static void main(String[] args) {
        StreamMedian ob = new StreamMedian();
        Scanner sc = new Scanner(System.in);
        char ch;

        while (true) {
            ch = sc.next().charAt(0);
            if (Character.isDigit(ch))// if character is number call put().
                ob.put(Character.getNumericValue(ch));
            else if (ch == 'x') {// if x is enter find the median then exit.
                System.out.println(ob.findMedian());
                break;
            } else// else find the current median.
                System.out.println(ob.findMedian());
        }
        sc.close();
    }

    public StreamMedian() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
}