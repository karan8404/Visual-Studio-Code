package utils;

import java.util.*;

public class Input {
    public static ArrayList<Integer> inputAlist(Scanner sc) {
        System.out.println(
                "Enter numbers to insert them into the array and any other type of characters to finalize the array.");
        ArrayList<Integer> a = new ArrayList<>();
        while (true) {
            try {
                a.add(sc.nextInt());
            } catch (Exception e) {
                sc.next();// to input the letter signifying end of the arraylist but not store it.
                break;
            }
        }
        return a;
    }
    
    public static int[] toIntArray(ArrayList<Integer> arr){
        int[] a=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            a[i]=arr.get(i);
        }
        return a;
    }
}