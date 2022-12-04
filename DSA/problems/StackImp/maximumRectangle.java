//find the maximum area rectangle in a binary matric. Video #45.
//uses HistogramArea
package StackImp;

import java.util.Arrays;

public class maximumRectangle {
    
    //finds the maximum rectangular area .
    public static int maxRectangle(Integer[][] Array){
        int area=Integer.MIN_VALUE;
        //current array made by combination of previous rows.
        Integer[] currentArr=new Integer[Array[0].length];
        Arrays.fill(currentArr, 0);

        for(Integer[] arr:Array){
            currentArr=combine(currentArr,arr);
            int currArea=HistogramArea.maxArea(currentArr);
            if(area<currArea)area=currArea;
        }
        return area;
    }

    //combines next row of the 2d matrix into the 1d array
    public static Integer[] combine(Integer[] arr1,Integer[] arr2){
        for(int i=0;i<arr1.length;i++){
            if(arr2[i]==0){
                arr1[i]=0;
            }
            else{
                arr1[i]=arr1[i]+arr2[i];
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        Integer[][] arr={{0,1,1,1,1,0},{1,1,1,1,0,1},{1,1,0,1,1,1},{1,1,1,1,1,0}};
        System.out.println(maxRectangle(arr));
    }
}
