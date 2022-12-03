//find the maximum area rectangle in a binary matric. Video #45.
//uses HistogramArea
package StackImp;

import java.util.Arrays;

public class maximumRectangle {
    
    //collapses a 2d array into a 1d array by combining all rows into 1.
    public static Integer[] collapse(Integer[][] arr){
        Integer[] res=new Integer[arr[0].length];
        Arrays.fill(res, 0);

        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr.length;j++){
                res[i]=res[i]+arr[j][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[][] arr={{1,2,3},{4,5,6}};
        System.out.println(Arrays.toString(collapse(arr)));

    }
}
