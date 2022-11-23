//program to find the median at any instant while the input is being provided in a stream.
//input number to put into stream, x to stop the program, any other character to find the median.

import java.util.*;

class StreamMedian {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());// maxHeap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();// minHeap

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())// if both have same size, return average of elements.
            return (maxHeap.peek() + minHeap.peek()) / 2;
        else// max heap has more elements return root element.
            return maxHeap.peek();
    }

    public void put(int a) {
        maxHeap.add(a);
        if (maxHeap.size() - minHeap.size() >= 2)// if max has 2 more elements than min then put one into min.
            minHeap.add(maxHeap.poll());
        if (maxHeap.size() != 0 && minHeap.size() != 0) {
            if (maxHeap.peek() > minHeap.peek()) {// if top element in max is greater than top element in min, swap.
                int temp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(temp);
            }
        }
    }

    public static void main(String[] args) {
        StreamMedian ob = new StreamMedian();
        Scanner sc = new Scanner(System.in);
        char ch;

        while (true) {
            ch = sc.next().charAt(0);
            if (Character.isDigit(ch))// if character is number call put().
                ob.put(Integer.valueOf(ch));
            else if (ch == 'x') {// if x is enter find the median then exit.
                System.out.println(ob.findMedian());
                break;
            } else// else find the current median.
                System.out.println(ob.findMedian());
        }
        sc.close();
    }
}