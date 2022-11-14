package playground;
import java.util.*;
//to detect if an array contains a duplicate element or not in constant time.
public class detectDuplicate {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int arr[]=new int[sc.nextInt()];
        System.out.println("Enter the elements of the array");

        //taking input for the array
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        sc.close();

        HashMap<Integer,Integer> hash= new HashMap<Integer,Integer>();
        boolean duplicate=false;
        int i;
        for (i = 0; i < arr.length; i++) {
            if(hash.containsValue(arr[i])){
                duplicate=true;
                break;
            }
            hash.put(i,arr[i]);
        }
        if (duplicate) {
            System.out.println("The array contains a duplicate item "+arr[i]+".");
        }
        else
            System.out.println("The array does not contain a duplicate item");
            sc.close();
            
    }
}