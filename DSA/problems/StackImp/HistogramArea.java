//gives the maximum area of an histogram.Video #44.
//uses PreviousSmaller
package StackImp;

import java.util.ArrayList;

public class HistogramArea {
    
    public static int maxArea(Integer[] arr){
        int max=Integer.MIN_VALUE;
        ArrayList<Integer> previous=PreviousSmaller.previousSmaller(arr);
        ArrayList<Integer> next=PreviousSmaller.nextSmaller(arr);
        int current;
        for(int i=0;i<arr.length;i++){
            current=(next.get(i)-previous.get(i)-1)*arr[i];
            if(current>max) max=current;
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] arr={4,10,5,8,20,15,3,12};
        System.out.println(maxArea(arr));
    }
}
