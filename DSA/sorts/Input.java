package sorts;

import java.util.*;

public class Input {
    public static ArrayList<Integer> input(Scanner sc) {
        System.out.println("Enter numbers to insert them into the array and any other type of characters to finalize the array.");
        ArrayList<Integer> a = new ArrayList<>();
        while (true) {
            try{
                a.add(sc.nextInt());
            }
            catch (Exception e) {
                break;
            }
        }
        return a;
    }
}